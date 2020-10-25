package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class BinaryOperator {
    public final static BinaryOperator Add = new Addition();
    public final static BinaryOperator Subtract = new Subtraction();

    private final static Map<Character, BinaryOperator> factories = new HashMap<Character, BinaryOperator>() {{
        put('+', Add);
        put('-', Subtract);
    }};


    private final char symbol;

    protected BinaryOperator(char symbol) {
        this.symbol = symbol;
    }

    public static BinaryOperator create(char operator) throws Exception {
        return factories.get(operator);
    }

    public abstract int calculate(int left, int right);

    @Override
    public String toString() {
        return String.valueOf(symbol);
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
