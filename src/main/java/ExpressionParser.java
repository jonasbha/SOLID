public class ExpressionParser {
    private final char operator;

    public ExpressionParser(char operator) {
        this.operator = operator;
    }

    BinaryExpression[] parseOperations(String data) {
        // Split data at unix line specifier
        String[] lines = data.split("\n");

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