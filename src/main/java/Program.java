import formatting.AsciiFormatter;
import io.FileSystemExpressionReader;
import model.Addition;
import model.BinaryOperator;
import model.Subtraction;
import parsing.ExpressionParser;

public class Program {

    public static void main(String[] args) throws Exception {
        FileSystemExpressionReader reader = new FileSystemExpressionReader();
        AsciiFormatter formatter = new AsciiFormatter();

        AggregationReport program =
            shouldUseSubtraction(args)
            ? new AggregationReport(new ExpressionParser(reader, Subtraction.class), BinaryOperator.Subtract, formatter)
            : new AggregationReport(new ExpressionParser(reader, Addition.class), BinaryOperator.Add, formatter);

        StringBuilder resultBuilder = program.buildReport();

        System.out.print(resultBuilder.toString());
    }

    private static boolean shouldUseSubtraction(String[] args) {
        return args.length > 0 && "sub".equals(args[0]);
    }

}
