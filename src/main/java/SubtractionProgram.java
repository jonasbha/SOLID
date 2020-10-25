public class SubtractionProgram extends CalculatorProgram {
    public SubtractionProgram(ExpressionReader expressionReader, ExpressionParser expressionParser) {
        super(expressionReader, expressionParser, new SubtractiveTotal());
    }
}
