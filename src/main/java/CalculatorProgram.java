import java.io.IOException;

public class CalculatorProgram {

    private final ExpressionParser expressionParser;
    private final BinaryOperator aggregationOperator;
    private int total;
    private BinaryExpression[] operations;

    public CalculatorProgram(ExpressionParser expressionParser, BinaryOperator aggregationOperator) {
        this.expressionParser = expressionParser;
        this.aggregationOperator = aggregationOperator;
    }

    public StringBuilder readParseCalculateAndFormat() throws IOException {
        operations = expressionParser.parseExpressions();
        total = calculate(new Aggregation(aggregationOperator), operations);
        return formatReport();
    }

    private final int calculate(Aggregation aggregation, BinaryExpression[] operations) {
        int total = 0;
        for (int i = 0; i < operations.length; i++) {
            total = aggregationOperator.calculate(total, operations[i].calculate());
        }
        return total;
    }

    protected int aggregateTotal(int total, int subtotal) {
        return total + subtotal;
    }

    final StringBuilder formatReport() {
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < operations.length; i++) {
            resultBuilder.append(operations[i].toString());
            resultBuilder.append(" = " + (operations[i].calculate()) + "\n");
        }
        resultBuilder.append("Total: " + total + "\n");
        return resultBuilder;
    }

}