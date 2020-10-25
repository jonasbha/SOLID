public class BinaryExpression {
    public final int left;
    private final BinaryOperator operator;
    public final int right;

    public BinaryExpression(int left, BinaryOperator operator, int right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public int calculate() {
        return operator.calculate(left, right);
    }
}
