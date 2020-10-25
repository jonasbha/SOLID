import java.io.IOException;

public class CalculatorProgram {

    private final ExpressionReader expressionReader;
    private final ExpressionParser expressionParser;
    private int total;
    private int[] subtotals;
    private int[][] operations;

    public CalculatorProgram(ExpressionReader expressionReader, ExpressionParser expressionParser) {
        this.expressionReader = expressionReader;
        this.expressionParser = expressionParser;
    }

    public StringBuilder readParseCalculateAndFormat() throws IOException {
        String data = expressionReader.readData();
        operations = expressionParser.parseExpressions(data);
        calculate();
        return formatReport();
    }

    private final void calculate() {
        total = 0;
        subtotals = new int[operations.length];
        for (int i = 0; i < operations.length; i++) {
            subtotals[i] = calculateItem(operations[i]);
            total = aggregateTotal(total, subtotals[i]);
        }
    }

    protected int aggregateTotal(int total, int subtotal) {
        return total + subtotal;
    }

    protected int calculateItem(int[] operation) {
        return operation[0] + operation[1];
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

    protected String formatItem(int[] operation) {
        return operation[0] + " + " + operation[1];
    }
}