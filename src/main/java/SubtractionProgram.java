public class SubtractionProgram extends CalculatorProgram {
    public SubtractionProgram(ExpressionParser expressionParser, BinaryOperator operator) {
        super(expressionParser, operator);
    }

    @Override
    protected int aggregateTotal(int total, int subtotal) {
        return total - subtotal;
    }
}