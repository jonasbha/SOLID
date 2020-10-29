import java.io.IOException;

public class ExpressionParser {
    private final ExpressionReader expressionReader;
    private final BinaryOperator operator;
    private final BinaryOperator aggregationOperator;

    public ExpressionParser(
        ExpressionReader expressionReader,
        BinaryOperator operator,
        BinaryOperator aggregationOperator
    ) {
        this.expressionReader = expressionReader;
        this.operator = operator;
        this.aggregationOperator = aggregationOperator;
    }

    Expression parseExpressions() throws IOException {
        String data = expressionReader.readData();
        String[] lines = data.split("\n");
        BinaryExpression[] operations;
        int i = 0;
        int sub = 0;
        if (lines[i].startsWith("X")) {
            sub++;
            i++;
        }
        operations = new BinaryExpression[lines.length - sub];
        for (; i < lines.length; i++) {
            String[] columns = lines[i].split(",");
            int x = Integer.valueOf(columns[0]);
            int y = Integer.valueOf(columns[1]);

            operations[i - sub] = new BinaryExpression(x, operator, y);
        }
        return new Aggregation(aggregationOperator, operations);
    }
}