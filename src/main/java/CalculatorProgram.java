import java.io.IOException;

public class CalculatorProgram {

    private final ExpressionParser expressionParser;
    private int total;
    private int[] subtotals;
    private BinaryExpression[] operations;

    public CalculatorProgram(ExpressionParser expressionParser) {
        this.expressionParser = expressionParser;
    }

    public StringBuilder readParseCalculateAndFormat() throws IOException {
        operations = expressionParser.parseExpressions();
        calculate();
        return formatReport();
    }

    private final void calculate() {
        total = 0;
        subtotals = new int[operations.length];
        for (int i = 0; i < operations.length; i++) {
            subtotals[i] = operations[i].calculate();
            total = aggregateTotal(total, subtotals[i]);
        }
    }

    protected int aggregateTotal(int total, int subtotal) {
        return total + subtotal;
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

    protected String formatItem(BinaryExpression operation) {
        return operation.left + " " + operation.operator.symbol + " " + operation.right;
    }
}