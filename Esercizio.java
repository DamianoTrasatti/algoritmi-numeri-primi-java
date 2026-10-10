import java.math.BigInteger;
import java.util.ArrayList;

public class Esercizio {

    // ATTRIBUTI: primo e secondo numero sono in ordine crescente sicuramente perche
    // sono stati sistemati nel main
    private BigInteger primoNumero;
    private BigInteger secondoNumero;

    // COSTRUTTORE
    public Esercizio(BigInteger primoNumero, BigInteger secondoNumero) {
        this.primoNumero = primoNumero;
        this.secondoNumero = secondoNumero;
    }

    // ########################################
    /*
     * come funziona compare to a.compareto(b)?
     * restituisce:
     * -1 se a < b
     * 0 se a = b
     * 1 se a > b
     */
    // ########################################

    // ########################################
    // METODO 1
    // Divisori fino al numero
    // ########################################
    public void metodo1() {

        System.out.println("####################");
        System.out.println("METODO 1");
        System.out.println("####################");

        // ArrayList di numeri interi per tenere i numeri primi
        ArrayList<BigInteger> numeriPrimi = new ArrayList<>();

        // INIZIO CRONOMETRO
        long startTime = System.currentTimeMillis();

        // per i = primoNumero; i<=secondonumero; i++
        for (BigInteger i = primoNumero; i.compareTo(secondoNumero) <= 0; i = i.add(BigInteger.ONE)) {
            // I numeri <= 1 non sono primi
            if (i.compareTo(BigInteger.ONE) <= 0) {
                continue; // salta iterazione ( 1 NON T' UN NUMERO PRIMO!! )
            }

            boolean isPrimo = true;

            // Controlliamo tutti i possibili divisori da 2 fino al numero stesso-1
            for (BigInteger div = BigInteger.TWO; div.compareTo(i) < 0; div = div.add(BigInteger.ONE)) {
                // Se il numero è divisibile (la divisione porta resto 0) allora non è primo
                if (getMod(i, div).equals(BigInteger.ZERO)) {
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

    // ########################################
    // METODO 2
    // Divisori fino al numero + uscita appena possibile
    // ########################################
    public void metodo2() {

        System.out.println("####################");
        System.out.println("METODO 2");
        System.out.println("####################");

        ArrayList<BigInteger> numeriPrimi = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        for (BigInteger i = primoNumero; i.compareTo(secondoNumero) <= 0; i = i.add(BigInteger.ONE)) {

            if (i.compareTo(BigInteger.ONE) <= 0) {
                continue;
            }

            boolean isPrimo = true;

            for (BigInteger div = BigInteger.TWO; div.compareTo(i) < 0; div = div.add(BigInteger.ONE)) {

                if (getMod(i, div).equals(BigInteger.ZERO)) {
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

    // ########################################
    // METODO 3
    // Divisori fino al numero/2 + uscita appena possibile
    // ########################################
    public void metodo3() {

        System.out.println("####################");
        System.out.println("METODO 3");
        System.out.println("####################");

        ArrayList<BigInteger> numeriPrimi = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        for (BigInteger i = primoNumero; i.compareTo(secondoNumero) <= 0; i = i.add(BigInteger.ONE)) {

            if (i.compareTo(BigInteger.ONE) <= 0) {
                continue;
            }

            boolean isPrimo = true;

            // Controlliamo i divisori fino a numero/2
            BigInteger meta = i.divide(BigInteger.TWO);
            for (BigInteger div = BigInteger.TWO; div.compareTo(meta) <= 0; div = div.add(BigInteger.ONE)) {

                if (getMod(i, div).equals(BigInteger.ZERO)) {
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

    // ########################################
    // METODO 4
    // Divisori fino al numero/2
    // usando solo divisori dispari
    // ########################################
    public void metodo4() {

        System.out.println("####################");
        System.out.println("METODO 4");
        System.out.println("####################");

        ArrayList<BigInteger> numeriPrimi = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        for (BigInteger i = primoNumero; i.compareTo(secondoNumero) <= 0; i = i.add(BigInteger.ONE)) {

            if (i.compareTo(BigInteger.ONE) <= 0) {
                continue;
            }

            // DEVO TOGLIERE I NUMERI PARI PERCHE' AD ESEMPIO 8 E' DIVISIBILE SOLO PER 2 E
            // PER 4 NON HA DIVISORI DISPARI MANNAGGIA
            // 2 è primo
            if (i.equals(BigInteger.TWO)) {
                numeriPrimi.add(i);
                continue;
            }

            // I numeri pari maggiori di 2 non sono primi
            if (getMod(i, BigInteger.TWO).equals(BigInteger.ZERO)) {
                continue;
            }

            boolean isPrimo = true;

            // Salto tutti i divisori pari
            for (BigInteger div = BigInteger.valueOf(3); div.compareTo(i.divide(BigInteger.TWO)) <= 0; div = div
                    .add(BigInteger.TWO)) {

                if (getMod(i, div).equals(BigInteger.ZERO)) {
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

    // ########################################
    // METODO 5
    // Divisori fino alla radice quadrata
    // usando solo divisori dispari
    // + uscita appena possibile
    // ########################################
    public void metodo5() {

        System.out.println("####################");
        System.out.println("METODO 5");
        System.out.println("####################");

        ArrayList<BigInteger> numeriPrimi = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        for (BigInteger i = primoNumero; i.compareTo(secondoNumero) <= 0; i = i.add(BigInteger.ONE)) {

            if (i.compareTo(BigInteger.ONE) <= 0) {
                continue;
            }

            // DEVO TOGLIERE I NUMERI PARI PERCHE' AD ESEMPIO 8 E' DIVISIBILE SOLO PER 2 E
            // PER 4 NON HA DIVISORI DISPARI MANNAGGIA
            // 2 è primo
            if (i.equals(BigInteger.TWO)) {
                numeriPrimi.add(i);
                continue;
            }

            // I numeri pari maggiori di 2 non sono primi
            if (getMod(i, BigInteger.TWO).equals(BigInteger.ZERO)) {
                continue;
            }

            boolean isPrimo = true;

            // Calcoliamo la radice quadrata
            BigInteger limite = i.sqrt();

            // Salto tutti i divisori pari
            for (BigInteger div = BigInteger.valueOf(3); div.compareTo(limite) <= 0; div = div.add(BigInteger.TWO)) {

                if (getMod(i, div).equals(BigInteger.ZERO)) {
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

    // ########################################
    // METODO 6
    // Fermat
    // ########################################
    public void metodo6() {

        System.out.println("####################");
        System.out.println("METODO 6 - FERMAT");
        System.out.println("####################");

        ArrayList<BigInteger> numeriPrimi = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        for (BigInteger i = primoNumero; i.compareTo(secondoNumero) <= 0; i = i.add(BigInteger.ONE)) {

            // I numeri minori o uguali a 1 non sono primi
            if (i.compareTo(BigInteger.ONE) <= 0) {
                continue;
            }

            // I numeri 2 e 3 sono primi
            if (i.equals(BigInteger.TWO) || i.equals(BigInteger.valueOf(3))) {
                numeriPrimi.add(i);
                continue;
            }

            // Usiamo il Piccolo Teorema di Fermat con base a = 2
            BigInteger n = i;
            BigInteger base = BigInteger.TWO;
            BigInteger esponente = n.subtract(BigInteger.ONE); // n - 1

            // Calcola (base^(n-1)) % n in modo efficiente ed evita il crash della memoria
            // BigInteger resto = getMod((getPow(base, esponente)), i);
            BigInteger resto = getModPow(base, esponente, i);

            // Se il resto è 1, il numero supera il test di Fermat (probabile primo)
            if (resto.equals(BigInteger.ONE)) {
                numeriPrimi.add(i);
            }
        }

        long endTime = System.currentTimeMillis();

        long tempoImpiegato = endTime - startTime;

        System.out.println("Numeri primi trovati: " + numeriPrimi.size());
        System.out.println("Tempo: " + tempoImpiegato + " ms");

        ScriviFile.scrivi(
                "METODO 6, FERMAT",
                primoNumero,
                secondoNumero,
                numeriPrimi,
                tempoImpiegato);
    }


    // non gestisce i negativi ma non è un problema perche non possono arrivarci
    public BigInteger getMod(BigInteger numero, BigInteger divisore) {
        BigInteger temp = numero.divide(divisore);
        BigInteger resto = numero.subtract(temp.multiply(divisore));
        return resto;
    }

    // Cosa fa questa funzione?
    /**
    equivalente di fare 2^esp-1 mod esp ma senza far crasciare il programma
    ad ogni iterazione facciamo mod della base e del risultato (inizialemnte anche, il risultato non serve fare il mod perche è gia 1)
    */

    public BigInteger getModPow(BigInteger base, BigInteger esponente, BigInteger mod) {
        BigInteger result = BigInteger.ONE;
        base = getMod(base, mod); // riduco subito la base cosi non supero mai esponente^2

        // il risultato viene modificato solo se l'epsonente è disparo perche 
        /*
         se esp pari = b^2 mod n, esp/2 --> base^esp = (base^esp/2)^2
         se esp disp = b^2 mod n, esp/2, result=result*base mod n --> base^esp = base * (base^2)^((esp-1)/2)
        */
        while (esponente.compareTo(BigInteger.ZERO) > 0) { // finche l'esponente è maggiore di 0
            if (!getMod(esponente, BigInteger.TWO).equals(BigInteger.ZERO)) { // esponente dispari
                result = getMod(result.multiply(base), mod);
            }
            base = getMod(base.multiply(base), mod); // base = base^2 mod n
            esponente = esponente.divide(BigInteger.TWO); // esponente = esponente / 2
        }
        return result;
    }

    public void setPrimoNumero (BigInteger primoNumero) {
        this.primoNumero = primoNumero;
    }

    public void setSecondoNumero (BigInteger secondoNumero) {
        this.secondoNumero = secondoNumero;
    }
}
