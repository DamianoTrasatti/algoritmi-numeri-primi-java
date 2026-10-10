import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {

        Wrapper w = new Wrapper();

        System.out.println("======================================");
        System.out.println("      RICERCA DEI NUMERI PRIMI");
        System.out.println("======================================");

        BigInteger primoNumero;
        BigInteger secondoNumero;

        // ########################################
        // INPUT INIZIALE INTERVALLO
        // ########################################
        do {
            System.out.print("\nInserisci il primo numero: ");
            primoNumero = w.nextBigInteger();

            if (w.error()) {
                System.out.println("Errore: devi inserire un numero intero.");
            }

        } while (w.error());

        do {
            System.out.print("Inserisci il secondo numero: ");
            secondoNumero = w.nextBigInteger();

            if (w.error()) {
                System.out.println("Errore: devi inserire un numero intero.");
            }

        } while (w.error());

        // Se il primo numero è maggiore del secondo, li scambiamo
        if (primoNumero.compareTo(secondoNumero) > 0) {
            BigInteger temp = primoNumero;
            primoNumero = secondoNumero;
            secondoNumero = temp;
        }

        // Creo l'oggetto Esercizio con i due estremi iniziali
        Esercizio esercizio = new Esercizio(primoNumero, secondoNumero);

        // Svuoto il file all'avvio del programma
        ScriviFile.svuotaFile();

        boolean continua = true;

        // ########################################
        // MENU
        // ########################################
        while (continua) {

            System.out.println("\n======================================");
            System.out.println("MENU");
            System.out.println("1. Metodo 1 - divisori fino al numero");
            System.out.println("2. Metodo 2 - divisori fino al numero + break");
            System.out.println("3. Metodo 3 - divisori fino al numero/2 + break");
            System.out.println("4. Metodo 4 - divisori dispari fino al numero/2 + break");
            System.out.println("5. Metodo 5 - divisori dispari fino alla radice + break");
            System.out.println("6. Metodo 6 - Fermat");
            System.out.println("7. Cambiare i numeri dell'intervallo");
            System.out.println("0. Chiudi applicazione");
            System.out.println("======================================");

            System.out.print("Scelta: ");
            int scelta = w.nextInt();

            if (w.error()) {
                System.out.println("Errore: devi inserire un numero intero.");
                continue;
            }

            switch (scelta) {

                case 1:
                    esercizio.metodo1();
                    break;

                case 2:
                    esercizio.metodo2();
                    break;

                case 3:
                    esercizio.metodo3();
                    break;

                case 4:
                    esercizio.metodo4();
                    break;

                case 5:
                    esercizio.metodo5();
                    break;

                case 6:
                    esercizio.metodo6();
                    break;

                case 7:
                    // Cambia i numeri dell'intervallo
                    do {
                        System.out.print("\nInserisci il nuovo primo numero: ");
                        primoNumero = w.nextBigInteger();

                        if (w.error()) {
                            System.out.println("Errore: devi inserire un numero intero.");
                        }

                    } while (w.error());

                    do {
                        System.out.print("Inserisci il nuovo secondo numero: ");
                        secondoNumero = w.nextBigInteger();

                        if (w.error()) {
                            System.out.println("Errore: devi inserire un numero intero.");
                        }

                    } while (w.error());

                    if (primoNumero.compareTo(secondoNumero) > 0) {
                        BigInteger temp = primoNumero;
                        primoNumero = secondoNumero;
                        secondoNumero = temp;
                    }

                    // Aggiorniamo l'oggetto con i nuovi estremi
                    esercizio.setPrimoNumero(primoNumero);
                    esercizio.setSecondoNumero(secondoNumero);
                    
                    System.out.println("\nIntervallo aggiornato con successo!");
                    break;

                case 0:
                    continua = false;
                    System.out.println("\nApplicazione chiusa.");
                    break;
                    
                default:
                    System.out.println("\nScelta non valida.");
                    break;
            }
        }
    }
}
