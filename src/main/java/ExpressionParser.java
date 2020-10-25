public class ExpressionParser {
    public ExpressionParser() {
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
}