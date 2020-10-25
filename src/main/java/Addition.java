public class Addition extends BinaryOperator {
    public Addition() {
        super('+');
    }

    @Override
    public int calculate(int left, int right) {
        return left + right;
    }
}
