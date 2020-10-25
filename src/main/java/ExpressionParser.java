import java.io.IOException;

public class ExpressionParser {
    private final ExpressionReader expressionReader;

    public ExpressionParser(ExpressionReader expressionReader) {
        this.expressionReader = expressionReader;
    }

    int[][] parseExpressions() throws IOException {
        String data = expressionReader.readData();
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