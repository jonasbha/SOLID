public class AdditiveTotal extends AggregateExpression {
    @Override
    protected int aggregateTotal(int total, int subtotal) {
        return total + subtotal;
    }
}
