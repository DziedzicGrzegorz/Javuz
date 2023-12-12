package UZ.Grzesiek.Lab7_P.Services;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@AllArgsConstructor
@Data
public class Writer {
    private static final String CHARSET = "UTF-8";

    public static void main(String[] args) {
        String fileName = "/Users/grzegorzdziedzic/DevContainer/IdeaProjects/Javuz/src/main/java/UZ/Grzesiek/Lab7_P/data.txt";
        String content = "akl123123";
        writeUsingBufferedWriter(fileName, content);
        writeUsingFileWriter(fileName, content);
        writeUsingFiles(fileName, content);
        writeUsingApacheCommonsIO(fileName, content);
        writeUsingFileOutputStream(fileName, content);
    }

    private static void writeUsingBufferedWriter(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(fileName))) {
            writer.write(content);
            System.out.println("Write File to String Using BufferedWriter");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeUsingFileWriter(String fileName, String content) {
        try (java.io.FileWriter writer = new java.io.FileWriter(fileName)) {
            writer.write(content);
            System.out.println("Write File to String Using FileWriter");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeUsingFiles(String fileName, @NotNull String content) {
        try {
            Files.write(Paths.get(fileName), content.getBytes(CHARSET), StandardOpenOption.CREATE);
            System.out.println("Write File to String Using Files class");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeUsingApacheCommonsIO(String fileName, String content) {
        try {
            FileUtils.writeStringToFile(new java.io.File(fileName), content, CHARSET);
            System.out.println("Write File to String Using Apache Commons IO FileUtils");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeUsingFileOutputStream(String fileName, @NotNull String content) {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(content.getBytes(CHARSET));
            System.out.println("Write File to String Using FileOutputStream");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}