import java.util.Objects;

public abstract class BinaryOperator {
    public char symbol;
    public abstract int calculate(int left, int right);

    protected BinaryOperator(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BinaryOperator)) return false;
        BinaryOperator that = (BinaryOperator) o;
        return symbol == that.symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }
}
