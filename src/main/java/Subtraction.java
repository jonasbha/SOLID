public class Subtraction extends BinaryExpression {
    public Subtraction(Integer left, Integer right) {
        super(left, '-', right);
    }

    @Override
    public int calculateItem() {
        return left - right;
    }
}
