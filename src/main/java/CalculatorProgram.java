import java.io.IOException;

public class CalculatorProgram {

    private final ExpressionParser expressionParser;
    private final BinaryOperator aggregationOperator;
    private Aggregation aggregation;
    private int total;
    private BinaryExpression[] operations;

    public CalculatorProgram(ExpressionParser expressionParser, BinaryOperator aggregationOperator) {
        this.expressionParser = expressionParser;
        this.aggregationOperator = aggregationOperator;
    }

    public StringBuilder readParseCalculateAndFormat() throws IOException {
        operations = expressionParser.parseExpressions();
        aggregation = new Aggregation(aggregationOperator, operations);
        aggregation.calculate();
        return formatReport();
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