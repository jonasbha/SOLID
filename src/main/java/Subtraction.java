public class Subtraction extends BinaryOperator {
    public Subtraction() {
        super('-');
    }

    @Override
    public int calculate(int left, int right) {
        return left - right;
    }
}
