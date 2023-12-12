package UZ.Grzesiek.Lab7_P;
import java.io.*;
import java.nio.file.*;

public class TXT {
    public static void main(String[] args) {
        try {
            String filename = "src/main/java/UZ/Grzesiek/Lab7_P/data.txt";
            String contents = "Hello World!";
            writeToFile(filename, contents);
            System.out.println(readFromFile(filename));
        } catch (IOException e) {
            System.out.println(STR."Error: \{e.getMessage()}");
        }
    }

    // Method to read from a text file
    public static String readFromFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }

    // Method to write to a text file
    public static void writeToFile(String filename, String contents) throws IOException {
        Files.write(Paths.get(filename), contents.getBytes());
    }
}