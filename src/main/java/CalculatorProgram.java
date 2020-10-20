import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CalculatorProgram {

    private int[] subtotals;
    private int[][] operations;
    private int total;

    public StringBuilder readParseCalculateAndFormat() throws IOException {
        String data = readData();
        operations = parseOperations(data);

        calculate();
        return formatReport();
    }

    String readData() throws IOException {
        // Read data from file at user.dir/data/additions.csv
        Path path = Paths.get(System.getProperty("user.dir"), "data", "additions.csv");
        byte[] encoded = Files.readAllBytes(path);
        String data = new String(encoded, "UTF-8");
        return data;
    }

    int[][] parseOperations(String data) {
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

    StringBuilder formatReport() {
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < operations.length; i++) {
            resultBuilder.append(formatItem(operations[i]));
            resultBuilder.append(" = " + subtotals[i] + "\n");
        }
        resultBuilder.append("Total: " + total + "\n");
        return resultBuilder;
    }

    protected String formatItem(int[] operation) {
        return operation[0] + " + " + operation[1];
    }

    public final void calculate() {
        total = 0;
        subtotals = new int[operations.length];
        for (int i = 0; i < operations.length; i++) {
            subtotals[i] = calculateItem(operations[i]);
            total = aggregateTotal(total, subtotals[i]);
        }
    }

    protected int aggregateTotal(int total, int subtotal) {
        return total + subtotal;
    }

    protected int calculateItem(int[] operation) {
        return operation[0] + operation[1];
    }
}