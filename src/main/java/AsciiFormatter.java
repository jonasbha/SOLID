public class AsciiFormatter {
    public AsciiFormatter() {
    }

    StringBuilder formatReport(Aggregation aggregation) {
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < aggregation.operations.length; i++) {
            resultBuilder.append(aggregation.operations[i].toString());
            resultBuilder.append(" = " + aggregation.operations[i].calculate() + "\n");
        }
        resultBuilder.append("Total: " + aggregation.total + "\n");
        return resultBuilder;
    }
}