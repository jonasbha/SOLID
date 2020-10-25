import java.io.IOException;

import static java.util.Arrays.stream;

public class CalculatorProgram {

    private final ExpressionParser expressionParser;
    private final Aggregation aggregateExpression;
    private final AsciiFormatter formatter;
    private BinaryExpression[] operations;

    public CalculatorProgram(ExpressionParser expressionParser, Aggregation aggregateExpression, AsciiFormatter formatter) {
        this.expressionParser = expressionParser;
        this.aggregateExpression = aggregateExpression;
        this.formatter = formatter;
    }

    public StringBuilder readParseCalculateAndFormat() throws Exception {
        operations = expressionParser.parseOperations();
        aggregateExpression.calculate(operations);
        return formatter.formatReport(aggregateExpression);
    }
}