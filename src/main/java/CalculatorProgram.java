import java.io.IOException;
import java.util.Arrays;
import java.util.function.BinaryOperator;

import static java.util.Arrays.stream;

public class CalculatorProgram {

    private final ExpressionReader expressionReader;
    private final ExpressionParser expressionParser;
    private BinaryExpression[] operations;
    private int total;

    public CalculatorProgram(ExpressionReader expressionReader, ExpressionParser expressionParser) {
        this.expressionReader = expressionReader;
        this.expressionParser = expressionParser;
    }

    public StringBuilder readParseCalculateAndFormat() throws IOException {
        String data = expressionReader.readData();
        operations = expressionParser.parseOperations(data);

        calculate();
        return formatReport();
    }

    StringBuilder formatReport() {
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < operations.length; i++) {
            resultBuilder.append(operations[i].toString());
            resultBuilder.append(" = " + operations[i].calculateItem() + "\n");
        }
        resultBuilder.append("Total: " + total + "\n");
        return resultBuilder;
    }

    final void calculate() {
        total = stream(operations)
                .map(x -> x.calculateItem())
                .reduce(0, this::aggregateTotal);
    }

    protected int aggregateTotal(int total, int subtotal) {
        return total + subtotal;
    }

}