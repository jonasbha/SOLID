import java.io.IOException;

public class CalculatorProgram {

    private final ExpressionParser expressionParser;
    private int total;
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
        for (int i = 0; i < operations.length; i++) {
            total = aggregateTotal(total, operations[i].calculate());
        }
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