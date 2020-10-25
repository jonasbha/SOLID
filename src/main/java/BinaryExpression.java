public class BinaryExpression {
    public final int left;
    public final int right;

    public BinaryExpression(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return this.left + " (op) " + this.right;
    }
}
