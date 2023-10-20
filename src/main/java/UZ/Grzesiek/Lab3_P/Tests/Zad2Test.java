import UZ.Grzesiek.Lab3_P.Zad2;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class Zad2Test {
    Gson gson = new Gson();
    String path = FileSystems.getDefault()
            .getPath("src/main/java/UZ/Grzesiek/Lab3_P/Tests/Config.json")
            .toAbsolutePath()
            .toString();

    Type typeOfMap = new TypeToken<Map<String, List<Integer>>>() {
    }.getType();
    Map<String, List<Integer>> allDivider;

    @BeforeEach
    public void readJSON() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(path)));
            JsonObject jsonObject = gson.fromJson(content, JsonObject.class);

            allDivider = gson.fromJson(jsonObject.get("allDivider"), typeOfMap);


        } catch (IOException e) {
            System.out.println("Error while reading JSON file");
            e.printStackTrace();
        }

    }

    @Test
    public void allDivider() throws NoSuchMethodException{
        Zad2 zad2 = new Zad2();
        //makes public method accessible
        Method getAllDividerTest = Zad2.class.getDeclaredMethod("getAllDivider", int.class);
        getAllDividerTest.setAccessible(true);

        allDivider.forEach((key, value) -> {
            try {
                List<Integer> dividersToTest = (List<Integer>) getAllDividerTest.invoke(zad2, Integer.parseInt(key));
                System.out.println(dividersToTest.toString());
                assertEquals(value, dividersToTest);
                zad2.clearAllDivider();

            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
