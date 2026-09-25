public class Main {
    public static void main(String[] args) {

        Wrapper w = new Wrapper();

        System.out.println("======================================");
        System.out.println("      RICERCA DEI NUMERI PRIMI");
        System.out.println("======================================");

        int primoNumero;
        int secondoNumero;

        // ==============================
        // INPUT PRIMO NUMERO
        // ==============================
        do {
            System.out.print("\nInserisci il primo numero: ");
            primoNumero = w.nextInt();

            if (w.error()) {
                System.out.println("Errore: devi inserire un numero intero.");
            }

        } while (w.error());

        // ==============================
        // INPUT SECONDO NUMERO
        // ==============================
        do {
            System.out.print("Inserisci il secondo numero: ");
            secondoNumero = w.nextInt();

            if (w.error()) {
                System.out.println("Errore: devi inserire un numero intero.");
            }

        } while (w.error());

        // Se il primo numero è maggiore del secondo, li scambiamo
        if (primoNumero > secondoNumero) {
            int temp = primoNumero;
            primoNumero = secondoNumero;
            secondoNumero = temp;
        }

        // Creo l'oggetto Esercizio con i due estremi
        Esercizio esercizio = new Esercizio(primoNumero, secondoNumero);

        // Svuoto il file all'avvio del programma
        ScriviFile.svuotaFile();

        boolean continua = true;

        // ==============================
        // MENU
        // ==============================
        while (continua) {

            System.out.println("\n======================================");
            System.out.println("MENU");
            System.out.println("1. Metodo 1 - divisori fino al numero");
            System.out.println("2. Metodo 2 - divisori fino al numero + break");
            System.out.println("3. Metodo 3 - divisori fino al numero/2 + break");
            System.out.println("4. Metodo 4 - divisori dispari fino al numero/2 + break");
            System.out.println("5. Metodo 5 - divisori dispari fino alla radice + break");
            System.out.println("6. Fermat (non implementato)");
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
                    chiediAltriMetodi(w, esercizio, 1);
                    break;

                case 2:
                    esercizio.metodo2();
                    chiediAltriMetodi(w, esercizio, 2);
                    break;

                case 3:
                    esercizio.metodo3();
                    chiediAltriMetodi(w, esercizio, 3);
                    break;

                case 4:
                    esercizio.metodo4();
                    chiediAltriMetodi(w, esercizio, 4);
                    break;

                case 5:
                    esercizio.metodo5();
                    chiediAltriMetodi(w, esercizio, 5);
                    break;

                case 6:
                    System.out.println("\nIl metodo di Fermat non è stato implementato.");
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

    /**
     * Dopo aver eseguito il metodo scelto,
     * chiede se si vogliono eseguire anche tutti gli altri metodi.
     */
    public static void chiediAltriMetodi(
            Wrapper w,
            Esercizio esercizio,
            int metodoGiaEseguito) {

        int risposta;

        do {
            System.out.print(
                    "\nVuoi simulare anche tutti gli altri metodi? " +
                    "(1 = si, 0 = no): "
            );

            risposta = w.nextInt();

            if (w.error()) {
                System.out.println("Errore: inserisci 1 oppure 0.");
            }

        } while (w.error() || (risposta != 0 && risposta != 1));

        if (risposta == 1) {

            System.out.println("\nEseguo tutti gli altri metodi...\n");

            if (metodoGiaEseguito != 1) {
                esercizio.metodo1();
            }

            if (metodoGiaEseguito != 2) {
                esercizio.metodo2();
            }

            if (metodoGiaEseguito != 3) {
                esercizio.metodo3();
            }

            if (metodoGiaEseguito != 4) {
                esercizio.metodo4();
            }

            if (metodoGiaEseguito != 5) {
                esercizio.metodo5();
            }

            System.out.println("\nTutti i metodi disponibili sono stati eseguiti.");
        }
    }
}