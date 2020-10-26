public class SubtractionProgram extends CalculatorProgram {
    public SubtractionProgram(ExpressionParser expressionParser) {
        super(expressionParser);
    }

    @Override
    protected int aggregateTotal(int total, int subtotal) {
        return total - subtotal;
    }
}