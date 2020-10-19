import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CalculatorProgram {

    static StringBuilder formatReport(int[][] operations, int[] subtotals, int total) {
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < operations.length; i++) {
            // Print first part of calculation
            resultBuilder.append(operations[i][0] + " + " + operations[i][1]);
            // Print total
            resultBuilder.append(" = " + subtotals[i] + "\n");
        }
        // Print grand total
        resultBuilder.append("Total: " + total + "\n");
        return resultBuilder;
    }

    static int[][] parseOperations(String data) {
        // Split data at unix line specifier
        String[] lines = data.split("\n");

        int[][] operations = new int[lines.length - 1][];

        // Iterate lines
        for (int i = 0; i < lines.length; i++) {
            // Skip first line
            if (lines[i].startsWith("X")) {
                continue;
            }
            // Split line on comma delimiter
            String[] columns = lines[i].split(",");
            // Parse integers
            int x = Integer.valueOf(columns[0]);
            int y = Integer.valueOf(columns[1]);

            operations[i - 1] = new int[]{x, y};
        }
        return operations;
    }

    static String readData() throws IOException {
        // Read data from file at user.dir/data/additions.csv
        Path path = Paths.get(System.getProperty("user.dir"), "data", "additions.csv");
        byte[] encoded = Files.readAllBytes(path);
        String data = new String(encoded, "UTF-8");
        return data;
    }

    public StringBuilder readParseCalculateAndFormat() throws IOException {
        String data = readData();
        int[][] operations = parseOperations(data);

        // Prepare total
        int total = 0;
        int[] subtotals = new int[operations.length];
        for (int i = 0; i < operations.length; i++) {
            subtotals[i] = operations[i][0] + operations[i][1];
            // Aggregate grand total
            total += subtotals[i];
        }

        return formatReport(operations, subtotals, total);
    }
}