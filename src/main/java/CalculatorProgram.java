import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CalculatorProgram {

    private int total;
    private int[] subtotals;
    private int[][] operations;

    public StringBuilder readParseCalculateAndFormat() throws IOException {
        String data = readData();
        operations = parseExpressions(data);
        calculate();
        return formatReport();
    }

    String readData() throws IOException {
        Path path = Paths.get(System.getProperty("user.dir"), "data", "additions.csv");
        byte[] encoded = Files.readAllBytes(path);
        String data = new String(encoded, "UTF-8");
        return data;
    }

    int[][] parseExpressions(String data) {
        String[] lines = data.split("\n");
        int[][] operations = new int[lines.length - 1][];
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].startsWith("X")) {
                continue;
            }
            String[] columns = lines[i].split(",");
            int x = Integer.valueOf(columns[0]);
            int y = Integer.valueOf(columns[1]);

            operations[i - 1] = new int[]{x, y};
        }
        return operations;
    }

    private final void calculate() {
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

    final StringBuilder formatReport() {
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < operations.length; i++) {
            resultBuilder.append(formatItem(operations[i]));
            resultBuilder.append(" = " + (subtotals[i]) + "\n");
        }
        resultBuilder.append("Total: " + total + "\n");
        return resultBuilder;
    }

    protected String formatItem(int[] operation) {
        return operation[0] + " + " + operation[1];
    }
}