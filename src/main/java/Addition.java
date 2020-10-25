public class Addition extends BinaryExpression {
    public Addition(Integer x, Integer y) {
        super(x, '+', y);
    }

    @Override
    public int calculateItem() {
        return left + right;
    }
}
