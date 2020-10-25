public class Program {

    public static void main(String[] args) throws Exception {
        FileSystemExpressionReader reader = new FileSystemExpressionReader();
        AsciiFormatter formatter = new AsciiFormatter();

        CalculationReport program =
            shouldUseSubtraction(args)
            ? new CalculationReport(new ExpressionParser(reader, Subtraction.class), new SubtractiveTotal(), formatter)
            : new CalculationReport(new ExpressionParser(reader, Addition.class), new AdditiveTotal(), formatter);

        StringBuilder resultBuilder = program.buildReport();

        System.out.print(resultBuilder.toString());
    }

    private static boolean shouldUseSubtraction(String[] args) {
        return args.length > 0 && "sub".equals(args[0]);
    }

}
