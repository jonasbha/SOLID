import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException {
        FileSystemExpressionReader reader = new FileSystemExpressionReader();
        AsciiFormatter formatter = new AsciiFormatter();

        CalculatorProgram program =
            shouldUseSubtraction(args)
            ? new CalculatorProgram(new ExpressionParser(reader, a -> b -> new BinaryExpression(a, '-', b)), new SubtractiveTotal(), formatter)
            : new CalculatorProgram(new ExpressionParser(reader, a -> b -> new BinaryExpression(a, '+', b)), new AdditiveTotal(), formatter);

        StringBuilder resultBuilder = program.readParseCalculateAndFormat();

        System.out.print(resultBuilder.toString());
    }

    private static boolean shouldUseSubtraction(String[] args) {
        return args.length > 0 && "sub".equals(args[0]);
    }

}
