import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException {
        ExpressionReader reader = new ExpressionReader();
        AsciiFormatter formatter = new AsciiFormatter();

        CalculatorProgram program =
            shouldUseSubtraction(args)
            ? new CalculatorProgram(reader, new ExpressionParser('-'), new SubtractiveTotal(), formatter)
            : new CalculatorProgram(reader, new ExpressionParser('+'), new AdditiveTotal(), formatter);

        StringBuilder resultBuilder = program.readParseCalculateAndFormat();

        System.out.print(resultBuilder.toString());
    }

    private static boolean shouldUseSubtraction(String[] args) {
        return args.length > 0 && "sub".equals(args[0]);
    }

}
