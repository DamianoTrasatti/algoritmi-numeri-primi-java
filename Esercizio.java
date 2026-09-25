import java.util.ArrayList;

public class Esercizio {

    // ==============================
    // ATTRIBUTI
    // ==============================

    private int primoNumero;
    private int secondoNumero;

    // ==============================
    // COSTRUTTORE
    // ==============================

    public Esercizio(int primoNumero, int secondoNumero) {
        this.primoNumero = primoNumero;
        this.secondoNumero = secondoNumero;
    }

    // ==========================================================
    // METODO 1
    // Divisori fino al numero
    // ==========================================================

    public void metodo1() {

        System.out.println("======================================");
        System.out.println("METODO 1");
        System.out.println("======================================");

        // ArrayList per tenere i numeri primi
        ArrayList<Integer> numeriPrimi = new ArrayList<>();

        // INIZIO CRONOMETRO
        long startTime = System.currentTimeMillis();

        // Ciclo che passa tutti i numeri dell'intervallo
        for (int i = primoNumero; i <= secondoNumero; i++) {

            // I numeri <= 1 non sono primi
            if (i <= 1) {
                continue;
            }

            boolean isPrimo = true;

            // Controlliamo tutti i possibili divisori
            for (int div = 2; div < i; div++) {

                if (i % div == 0) {
                    isPrimo = false;
                }
            }

            if (isPrimo) {
                numeriPrimi.add(i);
            }
        }

        // FINE CRONOMETRO
        long endTime = System.currentTimeMillis();

        long elapsedTime = endTime - startTime;

        System.out.println("Numeri primi trovati: " + numeriPrimi.size());
        System.out.println("Tempo: " + elapsedTime + " ms");

        // Scrittura su file
        ScriviFile.scrivi(
                "METODO 1",
                primoNumero,
                secondoNumero,
                numeriPrimi,
                elapsedTime
        );
    }

    // ==========================================================
    // METODO 2
    // Divisori fino al numero + uscita appena possibile
    // ==========================================================

    public void metodo2() {

        System.out.println("======================================");
        System.out.println("METODO 2");
        System.out.println("======================================");

        ArrayList<Integer> numeriPrimi = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        for (int i = primoNumero; i <= secondoNumero; i++) {

            if (i <= 1) {
                continue;
            }

            boolean isPrimo = true;

            for (int div = 2; div < i; div++) {

                if (i % div == 0) {
                    isPrimo = false;

                    // Esco appena trovo un divisore
                    break;
                }
            }

            if (isPrimo) {
                numeriPrimi.add(i);
            }
        }

        long endTime = System.currentTimeMillis();

        long elapsedTime = endTime - startTime;

        System.out.println("Numeri primi trovati: " + numeriPrimi.size());
        System.out.println("Tempo: " + elapsedTime + " ms");

        ScriviFile.scrivi(
                "METODO 2",
                primoNumero,
                secondoNumero,
                numeriPrimi,
                elapsedTime
        );
    }

    // ==========================================================
    // METODO 3
    // Divisori fino al numero/2 + uscita appena possibile
    // ==========================================================

    public void metodo3() {

        System.out.println("======================================");
        System.out.println("METODO 3");
        System.out.println("======================================");

        ArrayList<Integer> numeriPrimi = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        for (int i = primoNumero; i <= secondoNumero; i++) {

            if (i <= 1) {
                continue;
            }

            boolean isPrimo = true;

            // Controlliamo i divisori solo fino a i/2
            for (int div = 2; div <= i / 2; div++) {

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

        long elapsedTime = endTime - startTime;

        System.out.println("Numeri primi trovati: " + numeriPrimi.size());
        System.out.println("Tempo: " + elapsedTime + " ms");

        ScriviFile.scrivi(
                "METODO 3",
                primoNumero,
                secondoNumero,
                numeriPrimi,
                elapsedTime
        );
    }

    // ==========================================================
    // METODO 4
    // Divisori fino al numero/2
    // usando solo divisori dispari
    // + uscita appena possibile
    // ==========================================================

    public void metodo4() {

        System.out.println("======================================");
        System.out.println("METODO 4");
        System.out.println("======================================");

        ArrayList<Integer> numeriPrimi = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        for (int i = primoNumero; i <= secondoNumero; i++) {

            if (i <= 1) {
                continue;
            }

            // 2 è primo
            if (i == 2) {
                numeriPrimi.add(i);
                continue;
            }

            // Tutti gli altri numeri pari non sono primi
            if (i % 2 == 0) {
                continue;
            }

            boolean isPrimo = true;

            for (int div = 2; div <= i / 2; div++) {

                // Se il divisore è pari lo salto
                if (div % 2 == 0) {
                    continue;
                }

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

        long elapsedTime = endTime - startTime;

        System.out.println("Numeri primi trovati: " + numeriPrimi.size());
        System.out.println("Tempo: " + elapsedTime + " ms");

        ScriviFile.scrivi(
                "METODO 4",
                primoNumero,
                secondoNumero,
                numeriPrimi,
                elapsedTime
        );
    }

    // ==========================================================
    // METODO 5
    // Divisori fino alla radice quadrata
    // usando solo divisori dispari
    // + uscita appena possibile
    // ==========================================================

    public void metodo5() {

        System.out.println("======================================");
        System.out.println("METODO 5");
        System.out.println("======================================");

        ArrayList<Integer> numeriPrimi = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        for (int i = primoNumero; i <= secondoNumero; i++) {

            if (i <= 1) {
                continue;
            }

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

            // Controlliamo solamente i divisori dispari
            for (int div = 3; div <= limite; div += 2) {

                if (i % div == 0) {
                    isPrimo = false;

                    // Esco appena trovo un divisore
                    break;
                }
            }

            if (isPrimo) {
                numeriPrimi.add(i);
            }
        }

        long endTime = System.currentTimeMillis();

        long elapsedTime = endTime - startTime;

        System.out.println("Numeri primi trovati: " + numeriPrimi.size());
        System.out.println("Tempo: " + elapsedTime + " ms");

        ScriviFile.scrivi(
                "METODO 5",
                primoNumero,
                secondoNumero,
                numeriPrimi,
                elapsedTime
        );
    }
}