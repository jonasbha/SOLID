import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException {
        ExpressionReader reader = new ExpressionReader();
        ExpressionParser parser = new ExpressionParser();
        CalculatorProgram program =
            args.length > 0 && "sub".equals(args[0])
            ? new SubtractionProgram(reader, parser)
            : new CalculatorProgram(reader, parser);
        StringBuilder resultBuilder = program.readParseCalculateAndFormat();

        System.out.println(resultBuilder.toString());
    }
}
