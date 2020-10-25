public class SubtractiveTotal extends Aggregation {
    @Override
    protected int aggregateTotal(int total, int subtotal) {
        return total - subtotal;
    }
}
