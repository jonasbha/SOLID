import java.io.IOException;

import static java.util.Arrays.stream;

public class CalculatorProgram {

    private final ExpressionReader expressionReader;
    private final ExpressionParser expressionParser;
    private final Aggregation aggregateExpression;
    private final AsciiFormatter formatter;
    private BinaryExpression[] operations;

    public CalculatorProgram(ExpressionReader expressionReader, ExpressionParser expressionParser, Aggregation aggregateExpression, AsciiFormatter formatter) {
        this.expressionReader = expressionReader;
        this.expressionParser = expressionParser;
        this.aggregateExpression = aggregateExpression;
        this.formatter = formatter;
    }

    public StringBuilder readParseCalculateAndFormat() throws IOException {
        String data = expressionReader.readData();
        operations = expressionParser.parseOperations(data);

        aggregateExpression.calculate(operations);
        return formatter.formatReport(aggregateExpression);
    }
}