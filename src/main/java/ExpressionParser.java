import java.io.IOException;

public class ExpressionParser {
    private final ExpressionReader expressionReader;
    private final BinaryOperator operator;

    public ExpressionParser(ExpressionReader expressionReader, BinaryOperator operator) {
        this.expressionReader = expressionReader;
        this.operator = operator;
    }

    BinaryExpression[] parseExpressions() throws IOException {
        String data = expressionReader.readData();
        String[] lines = data.split("\n");
        BinaryExpression[] operations = new BinaryExpression[lines.length - 1];
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].startsWith("X")) {
                continue;
            }
            String[] columns = lines[i].split(",");
            int x = Integer.valueOf(columns[0]);
            int y = Integer.valueOf(columns[1]);

            operations[i - 1] = new BinaryExpression(x, operator, y);
        }
        return operations;
    }
}