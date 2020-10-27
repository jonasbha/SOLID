import java.io.IOException;

public class CalculatorProgram {

    private final ExpressionParser expressionParser;
    private final BinaryOperator aggregationOperator;
    private final Reporter asciiReporter;

    public CalculatorProgram(ExpressionParser expressionParser, BinaryOperator aggregationOperator, Reporter reporter) {
        this.expressionParser = expressionParser;
        this.aggregationOperator = aggregationOperator;
        asciiReporter = reporter;
    }

    public StringBuilder readParseCalculateAndFormat() throws IOException {
        BinaryExpression[] operations = expressionParser.parseExpressions();
        Aggregation aggregation = new Aggregation(aggregationOperator, operations);
        aggregation.calculate();
        return asciiReporter.formatReport(aggregation);
    }
}