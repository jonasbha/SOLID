import java.io.IOException;

public class CalculatorProgram {

    private final ExpressionParser expressionParser;
    private final BinaryOperator aggregationOperator;
    private final AsciiReporter asciiReporter = new AsciiReporter();

    public CalculatorProgram(ExpressionParser expressionParser, BinaryOperator aggregationOperator) {
        this.expressionParser = expressionParser;
        this.aggregationOperator = aggregationOperator;
    }

    public StringBuilder readParseCalculateAndFormat() throws IOException {
        BinaryExpression[] operations = expressionParser.parseExpressions();
        Aggregation aggregation = new Aggregation(aggregationOperator, operations);
        aggregation.calculate();
        return asciiReporter.formatReport(aggregation);
    }
}