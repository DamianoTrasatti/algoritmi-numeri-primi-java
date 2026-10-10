import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.math.BigInteger;

public class ScriviFile {

    // ########################################
    // SCRIVE I RISULTATI SUL FILE
    // ########################################

    public static void scrivi(
            String nomeMetodo,
            BigInteger primoNumero,
            BigInteger secondoNumero,
            ArrayList<BigInteger> numeriPrimi,
            long tempo) {

                // alla fine del try viene chiuso in automatico
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true))) {

            writer.write("========================================\n");
            writer.write(nomeMetodo + "\n");
            writer.write("Intervallo: " + primoNumero + " - " + secondoNumero + "\n");
            writer.write("========================================\n");

            // se nome metodo == "METODO 6" allora scrivi che possono esserci falsi positivi
            if (nomeMetodo.equals("METODO 6, FERMAT")) {
                writer.write("\n\nATTENZIONE: il test di Fermat non è infallibile, "
                        + "quindi tra i numeri trovati possono esserci falsi positivi "
                        + "\n(numeri composti dichiarati primi ma funzionanti comunque per RSA).\n\n");
            }

            writer.write("\n\nNumeri primi:\n");

            for (BigInteger numero : numeriPrimi) {
                writer.write(numero + ", ");
            }

            writer.write("\n\nTotale numeri primi: " + numeriPrimi.size() + "\n");
            writer.write("Tempo di calcolo: " + tempo + " ms, " + tempo/1000 + "s\n");

            writer.write("\n\n");

        } catch (IOException e) {
            System.out.println(
                    "Errore durante la scrittura del file: "
                            + e.getMessage());
        }
    }

    // ########################################
    // SVUOTA IL FILE ALL'AVVIO
    // ########################################

    public static void svuotaFile() {

        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {

            writer.write("");

        } catch (IOException e) {
            System.out.println(
                    "Errore durante la pulizia del file: "
                            + e.getMessage());
        }
    }
}
