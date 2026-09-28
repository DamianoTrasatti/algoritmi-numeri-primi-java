import java.util.ArrayList;

public class Esercizio {

    // ATTRIBUTI: primo e secondo numero sono in ordine crescente sicuramente perche
    // sono stati sistemati nel main
    private int primoNumero;
    private int secondoNumero;

    // COSTRUTTORE
    public Esercizio(int primoNumero, int secondoNumero) {
        this.primoNumero = primoNumero;
        this.secondoNumero = secondoNumero;
    }

    // ==========================================================
    // METODO 1
    // Divisori fino al numero
    // ==========================================================
    public void metodo1() {

        System.out.println("####################");
        System.out.println("METODO 1");
        System.out.println("####################");

        // ArrayList di numeri interi per tenere i numeri primi
        ArrayList<Integer> numeriPrimi = new ArrayList<>();

        // INIZIO CRONOMETRO
        long startTime = System.currentTimeMillis();

        // Ciclo che passa tutti i numeri dal primo numero al secondo numero
        int i;
        for (i = primoNumero; i <= secondoNumero; i++) {

            // I numeri <= 1 non sono primi
            if (i <= 1) {
                continue; // salta iterazione ( 1 NON T' UN NUMERO PRIMO!! )
            }

            boolean isPrimo = true;

            // Controlliamo tutti i possibili divisori da 2 fino al numero stesso-1
            int div;
            for (div = 2; div < i; div++) {
                // Se il numero è divisibile (la divisione porta resto 0) allora non è primo
                if (i % div == 0) {
                    isPrimo = false;
                }
            }

            // Aggiungo il numero all'array dei numeri primi
            if (isPrimo) {
                numeriPrimi.add(i);
            }
        }

        // FINE CRONOMETRO
        long endTime = System.currentTimeMillis();

        long tempoImpiegato = endTime - startTime;

        System.out.println("Numeri primi trovati: " + numeriPrimi.size());
        System.out.println("Tempo: " + tempoImpiegato + " ms");

        // Scrittura su file
        ScriviFile.scrivi(
                "METODO 1",
                primoNumero,
                secondoNumero,
                numeriPrimi,
                tempoImpiegato);
    }

    // ==========================================================
    // METODO 2
    // Divisori fino al numero + uscita appena possibile
    // ==========================================================
    public void metodo2() {

        System.out.println("####################");
        System.out.println("METODO 2");
        System.out.println("####################");

        ArrayList<Integer> numeriPrimi = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        int i;
        for (i = primoNumero; i <= secondoNumero; i++) {

            if (i <= 1) {
                continue;
            }

            boolean isPrimo = true;

            int div;
            for (div = 2; div < i; div++) {

                if (i % div == 0) {
                    isPrimo = false;
                    // Esco appena trovo un divisore, il ciclo si interrompe. i numeri primi hanno
                    // come divisore uno e se stessi
                    break;
                }
            }

            if (isPrimo) {
                numeriPrimi.add(i);
            }
        }

        long endTime = System.currentTimeMillis();

        long tempoImpiegato = endTime - startTime;

        System.out.println("Numeri primi trovati: " + numeriPrimi.size());
        System.out.println("Tempo: " + tempoImpiegato + " ms");

        ScriviFile.scrivi(
                "METODO 2",
                primoNumero,
                secondoNumero,
                numeriPrimi,
                tempoImpiegato);
    }

    // ==========================================================
    // METODO 3
    // Divisori fino al numero/2 + uscita appena possibile
    // ==========================================================
    public void metodo3() {

        System.out.println("####################");
        System.out.println("METODO 3");
        System.out.println("####################");

        ArrayList<Integer> numeriPrimi = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        int i;
        for (i = primoNumero; i <= secondoNumero; i++) {

            if (i <= 1) {
                continue;
            }

            boolean isPrimo = true;

            // Controlliamo i divisori fino a numero/2
            int div;
            for (div = 2; div <= i / 2; div++) {

                if (i % div == 0) {
                    isPrimo = false;

                    // Esco appena possibile
                    break;
                }
            }

            if (isPrimo) {
                numeriPrimi.add(i);
            }
        }

        long endTime = System.currentTimeMillis();

        long tempoImpiegato = endTime - startTime;

        System.out.println("Numeri primi trovati: " + numeriPrimi.size());
        System.out.println("Tempo: " + tempoImpiegato + " ms");

        ScriviFile.scrivi(
                "METODO 3",
                primoNumero,
                secondoNumero,
                numeriPrimi,
                tempoImpiegato);
    }

    // ==========================================================
    // METODO 4
    // Divisori fino al numero/2
    // usando solo divisori dispari
    // ==========================================================
    public void metodo4() {

        System.out.println("####################");
        System.out.println("METODO 4");
        System.out.println("####################");

        ArrayList<Integer> numeriPrimi = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        int i;
        for (i = primoNumero; i <= secondoNumero; i++) {

            if (i <= 1) {
                continue;
            }

            // DEVO TOGLIERE I NUMERI PARI PERCHE' AD ESEMPIO 8 E' DIVISIBILE SOLO PER 2 E PER 4 NON HA DIVISORI DISPARI MANNAGGIA
            // 2 è primo
            if (i == 2) {
                numeriPrimi.add(i);
                continue;
            }

            // I numeri pari maggiori di 2 non sono primi
            if (i % 2 == 0) {
                continue;
            }

            boolean isPrimo = true;

            // Salto tutti i divisori pari
            int div;
            for (div = 3; div <= i / 2; div += 2) {

                if (i % div == 0) {
                    isPrimo = false;
                    // Non esco appena possibile !!
                    // break;
                }
            }

            if (isPrimo) {
                numeriPrimi.add(i);
            }
        }

        long endTime = System.currentTimeMillis();

        long tempoImpiegato = endTime - startTime;

        System.out.println("Numeri primi trovati: " + numeriPrimi.size());
        System.out.println("Tempo: " + tempoImpiegato + " ms");

        ScriviFile.scrivi(
                "METODO 4",
                primoNumero,
                secondoNumero,
                numeriPrimi,
                tempoImpiegato);
    }

    // ==========================================================
    // METODO 5
    // Divisori fino alla radice quadrata
    // usando solo divisori dispari
    // + uscita appena possibile
    // ==========================================================
    public void metodo5() {

        System.out.println("####################");
        System.out.println("METODO 5");
        System.out.println("####################");

        ArrayList<Integer> numeriPrimi = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        int i;
        for (i = primoNumero; i <= secondoNumero; i++) {

            if (i <= 1) {
                continue;
            }

            // DEVO TOGLIERE I NUMERI PARI PERCHE' AD ESEMPIO 8 E' DIVISIBILE SOLO PER 2 E
            // PER 4 NON HA DIVISORI DISPARI MANNAGGIA
            // 2 è primo
            if (i == 2) {
                numeriPrimi.add(i);
                continue;
            }

            // I numeri pari maggiori di 2 non sono primi
            if (i % 2 == 0) {
                continue;
            }

            boolean isPrimo = true;

            // Calcoliamo la radice quadrata
            int limite = (int) Math.sqrt(i);

            // Salto tutti i divisori pari
            int div;
            for (div = 3; div <= limite; div += 2) {

                if (i % div == 0) {
                    isPrimo = false;

                    // Esco appena possibile!!
                    break;
                }
            }

            if (isPrimo) {
                numeriPrimi.add(i);
            }
        }

        long endTime = System.currentTimeMillis();

        long tempoImpiegato = endTime - startTime;

        System.out.println("Numeri primi trovati: " + numeriPrimi.size());
        System.out.println("Tempo: " + tempoImpiegato + " ms");

        ScriviFile.scrivi(
                "METODO 5",
                primoNumero,
                secondoNumero,
                numeriPrimi,
                tempoImpiegato);
    }
}