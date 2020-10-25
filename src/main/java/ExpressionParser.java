import java.io.IOException;

public class ExpressionParser {
    private final char operator;
    private final String input;

    public ExpressionParser(char operator, ExpressionReader reader) throws IOException {
        this.operator = operator;
        this.input = reader.readData();
    }

    BinaryExpression[] parseOperations() {
        // Split data at unix line specifier
        String[] lines = input.split("\n");

        BinaryExpression[] operations = new BinaryExpression[lines.length - 1];

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

            operations[i - 1] = new BinaryExpression(x, operator, y);
        }
        return operations;
    }
}