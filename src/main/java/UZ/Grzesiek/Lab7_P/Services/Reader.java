package UZ.Grzesiek.Lab7_P.Services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@AllArgsConstructor
@Data
public class  Reader {


    public static void main(String[] args) {
        String fileName = "/Users/grzegorzdziedzic/DevContainer/IdeaProjects/Javuz/src/main/java/UZ/Grzesiek/Lab7_P/data.txt";

        String contents = readUsingScanner(fileName);
        System.out.println(STR."*****Read File to String Using Scanner*****\n\{contents}");

        contents = readUsingApacheCommonsIO(fileName);
        System.out.println(STR."*****Read File to String Using Apache Commons IO FileUtils*****\n\{contents}");

        contents = readUsingFiles(fileName);
        System.out.println(STR."*****Read File to String Using Files Class*****\n\{contents}");

        contents = readUsingBufferedReader(fileName);
        System.out.println(STR."*****Read File to String Using BufferedReader*****\n\{contents}");

        contents = readUsingBufferedReaderCharArray(fileName);
        System.out.println(STR."*****Read File to String Using BufferedReader and char array*****\n\{contents}");

        contents = readUsingFileInputStream(fileName);
        System.out.println(STR."*****Read File to String Using FileInputStream*****\n\{contents}");

    }
    Reader(String path, String content){}

    private static @NotNull String readUsingBufferedReaderCharArray(String fileName) {
        BufferedReader reader = null;
        StringBuilder stringBuilder = new StringBuilder();
        char[] buffer = new char[10];
        try {
            reader = new BufferedReader(new FileReader(fileName));
            while (reader.read(buffer) != -1) {
                stringBuilder.append(new String(buffer));
                buffer = new char[10];
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        return stringBuilder.toString();
    }

    private static @NotNull String readUsingFileInputStream(String fileName) {
        FileInputStream fis = null;
        byte[] buffer = new byte[10];
        StringBuilder sb = new StringBuilder();
        try {
            fis = new FileInputStream(fileName);

            while (fis.read(buffer) != -1) {
                sb.append(new String(buffer));
                buffer = new byte[10];
            }
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return sb.toString();
    }

    private static @NotNull String readUsingBufferedReader(String fileName) {
        BufferedReader reader = null;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = null;
            String ls = System.lineSeparator();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            // delete the last ls
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        return stringBuilder.toString();
    }

    private static @Nullable String readUsingFiles(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static @Nullable String readUsingApacheCommonsIO(String fileName) {
        try {
            return FileUtils.readFileToString(new File(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static @Nullable String readUsingScanner(String fileName) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8);
            // we can use Delimiter regex as "\\A", "\\Z" or "\\z"
            String data = scanner.useDelimiter("\\A").next();
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (scanner != null)
                scanner.close();
        }
    }
}