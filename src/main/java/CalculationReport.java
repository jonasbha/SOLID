import java.io.IOException;

import static java.util.Arrays.stream;

public class CalculationReport {

    private final ExpressionParser expressionParser;
    private final Aggregation aggregateExpression;
    private final AsciiFormatter formatter;
    private BinaryExpression[] operations;

    public CalculationReport(ExpressionParser expressionParser, Aggregation aggregateExpression, AsciiFormatter formatter) {
        this.expressionParser = expressionParser;
        this.aggregateExpression = aggregateExpression;
        this.formatter = formatter;
    }

    public StringBuilder buildReport() throws Exception {
        operations = expressionParser.parseOperations();
        aggregateExpression.calculate(operations);
        return formatter.formatReport(aggregateExpression);
    }
}