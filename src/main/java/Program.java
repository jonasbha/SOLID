import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException {
        CalculatorProgram program =
            shouldUseSubtraction(args)
            ? new SubtractionProgram(new ExpressionParser(new ExpressionReader(), new Addition()), new Addition())
            : new CalculatorProgram(new ExpressionParser(new ExpressionReader(), new Addition()), new Addition());

        StringBuilder resultBuilder = program.readParseCalculateAndFormat();

        System.out.print(resultBuilder.toString());
    }

    private static boolean shouldUseSubtraction(String[] args) {
        return args.length > 0 && "sub".equals(args[0]);
    }

}
