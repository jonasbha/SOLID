import java.io.IOException;

import static java.util.Arrays.stream;

public class CalculatorProgram {

    private final ExpressionReader expressionReader;
    private final ExpressionParser expressionParser;
    private final AggregateExpression aggregateExpression;
    private BinaryExpression[] operations;

    public CalculatorProgram(ExpressionReader expressionReader, ExpressionParser expressionParser, AggregateExpression aggregateExpression) {
        this.expressionReader = expressionReader;
        this.expressionParser = expressionParser;
        this.aggregateExpression = aggregateExpression;
    }

    public StringBuilder readParseCalculateAndFormat() throws IOException {
        String data = expressionReader.readData();
        operations = expressionParser.parseOperations(data);

        aggregateExpression.calculate(this::aggregateTotal, operations);
        return formatReport();
    }

    StringBuilder formatReport() {
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < operations.length; i++) {
            resultBuilder.append(operations[i].toString());
            resultBuilder.append(" = " + operations[i].calculateItem() + "\n");
        }
        resultBuilder.append("Total: " + aggregateExpression.total + "\n");
        return resultBuilder;
    }

    protected int aggregateTotal(int total, int subtotal) {
        return total + subtotal;
    }

}