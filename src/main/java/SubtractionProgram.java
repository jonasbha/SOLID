public class SubtractionProgram extends CalculatorProgram {
    public SubtractionProgram(ExpressionReader expressionReader, ExpressionParser expressionParser) {
        super(expressionReader, expressionParser);
    }

    @Override
    protected int aggregateTotal(int total, int subtotal) {
        return total - subtotal;
    }

    @Override
    protected int calculateItem(BinaryExpression operation) {
        return operation.left - operation.right;
    }

    @Override
    protected String formatItem(BinaryExpression operation) {
        return operation.left + " - " + operation.right;
    }
}
