package UZ.Grzesiek.Lab7_P;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class CSV {
    public static void main(String[] args) {
        CSV test = new CSV();
        try {
            //crate sample data
            List<List<String>> data = new ArrayList<>();
            data.add(Arrays.asList("1", "2", "3"));
            data.add(Arrays.asList("4", "5", "6"));
//            test.writeCSV(data , "src/main/java/UZ/Grzesiek/Lab7_P/data2.csv");
            test.readCSV("src/main/java/UZ/Grzesiek/Lab7_P/data2.csv").forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(STR."Error: \{e.getMessage()}");
        }
    }
    public List<List<String>> readCSV(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        try (Stream<String> lines = Files.lines(path)) {
            return lines.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());
        }
    }

    public void writeCSV(List<List<String>> data, String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        for (List<String> row : data) {
            lines.add(String.join(",", row));
        }
        writeFile(lines, filePath);
    }

    void writeFile(List<String> lines, String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Files.write(path, lines, StandardCharsets.UTF_8);
    }
}
