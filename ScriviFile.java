import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ScriviFile {

    // ==========================================================
    // SCRIVE I RISULTATI SUL FILE
    // ==========================================================

    public static void scrivi(
            String nomeMetodo,
            int primoNumero,
            int secondoNumero,
            ArrayList<Integer> numeriPrimi,
            long tempo) {

        try (
                BufferedWriter writer =
                        new BufferedWriter(new FileWriter("output.txt", true))
        ) {

            writer.write("========================================\n");
            writer.write(nomeMetodo + "\n");
            writer.write("Intervallo: " + primoNumero + " - " + secondoNumero + "\n");
            writer.write("========================================\n");

            writer.write("Numeri primi:\n");

            for (int numero : numeriPrimi) {
                writer.write(numero + "\n");
            }

            writer.write("Totale numeri primi: " + numeriPrimi.size() + "\n");
            writer.write("Tempo di calcolo: " + tempo + " ms\n");

            writer.write("\n\n");

        } catch (IOException e) {
            System.out.println(
                    "Errore durante la scrittura del file: "
                            + e.getMessage()
            );
        }
    }

    // ==========================================================
    // SVUOTA IL FILE ALL'AVVIO
    // ==========================================================

    public static void svuotaFile() {

        try (
                BufferedWriter writer =
                        new BufferedWriter(new FileWriter("output.txt"))
        ) {

            writer.write("");

        } catch (IOException e) {
            System.out.println(
                    "Errore durante la pulizia del file: "
                            + e.getMessage()
            );
        }
    }
}