import java.io.IOException;

public class CalculatorProgram {

    private final ExpressionParser expressionParser;
    private final Reporter asciiReporter;

    public CalculatorProgram(ExpressionParser expressionParser, Reporter reporter) {
        this.expressionParser = expressionParser;
        asciiReporter = reporter;
    }

    public StringBuilder readParseCalculateAndFormat() throws IOException {
        Expression aggregation = expressionParser.parseExpressions();
        aggregation.calculate();
        return asciiReporter.formatReport((Aggregation)aggregation);
    }
}