public class BinaryExpression {
    private final int left;
    private final BinaryOperator operator;
    private final int right;

    public BinaryExpression(int left, BinaryOperator operator, int right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public int calculate() {
        return 0;
    }
}
