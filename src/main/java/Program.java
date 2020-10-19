import java.io.*;
import java.nio.file.*;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) throws IOException {
        StringBuilder resultBuilder = readParseCalculateAndFormat();

        System.out.println(resultBuilder.toString());
    }

    public static StringBuilder readParseCalculateAndFormat() throws IOException {
        String data = readData();
        // Split data at unix line specifier
        String[] lines = data.split("\n");

        int[][] operations = new int[lines.length - 1][];

        // Iterate lines
        for(int i = 0; i<lines.length; i++) {
            // Skip first line
            if (lines[i].startsWith("X")) {
                continue;
            }
            // Split line on comma delimiter
            String[] columns = lines[i].split(",");
            // Parse integers
            int x = Integer.valueOf(columns[0]);
            int y = Integer.valueOf(columns[1]);

            operations[i - 1] = new int[]{x, y};
        }

        StringBuilder resultBuilder = new StringBuilder();
        // Prepare total
        int total = 0;
        for(int i = 0; i<operations.length; i++) {
            // Aggregate grand total
            total += operations[i][0] + operations[i][1];
            // Print first part of calculation
            resultBuilder.append(operations[i][0] + " + " + operations[i][1]);
            // Print total
            resultBuilder.append(" = " + (operations[i][0] + operations[i][1]) + "\n");
        }
        // Print grand total
        resultBuilder.append("Total: " + total + "\n");
        return resultBuilder;
    }

    private static String readData() throws IOException {
        // Read data from file at user.dir/data/additions.csv
        Path path = Paths.get(System.getProperty("user.dir"), "data", "additions.csv");
        byte[] encoded = Files.readAllBytes(path);
        String data = new String(encoded, "UTF-8");
        return data;
    }
}
