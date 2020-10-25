import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException {
        ExpressionParser parser = new ExpressionParser('+');
        ExpressionReader reader = new ExpressionReader();
        CalculatorProgram program =
            shouldUseSubtraction(args)
            ? new SubtractionProgram(reader, parser)
            : new CalculatorProgram(reader, parser);

        StringBuilder resultBuilder = program.readParseCalculateAndFormat();

        System.out.print(resultBuilder.toString());
    }

    private static boolean shouldUseSubtraction(String[] args) {
        return args.length > 0 && "sub".equals(args[0]);
    }

}
