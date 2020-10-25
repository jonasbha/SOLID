import formatting.AsciiFormatter;
import model.Aggregation;
import model.BinaryExpression;
import model.BinaryOperator;
import parsing.ExpressionParser;

import static java.util.Arrays.stream;

public class AggregationReport {

    private final ExpressionParser expressionParser;
    private final BinaryOperator aggregationOperator;
    private final AsciiFormatter formatter;

    public AggregationReport(ExpressionParser expressionParser, BinaryOperator aggregationOperator, AsciiFormatter formatter) {
        this.expressionParser = expressionParser;
        this.aggregationOperator = aggregationOperator;
        this.formatter = formatter;
    }

    public StringBuilder buildReport() throws Exception {
        BinaryExpression[] operations = expressionParser.parseOperations();

        Aggregation aggregation = new Aggregation(aggregationOperator, operations);
        aggregation.calculate();

        return formatter.formatReport(aggregation);
    }
}