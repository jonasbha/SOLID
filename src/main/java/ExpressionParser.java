public class ExpressionParser {
    public ExpressionParser() {
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
}