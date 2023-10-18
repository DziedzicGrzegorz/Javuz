package UZ.Lab2_P.Tests;

import UZ.Lab2_P.Zad1;
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
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import static java.lang.StringTemplate.STR;
import static org.junit.jupiter.api.Assertions.*;

class Zad1Test {
    Gson gson = new Gson();
    String path = FileSystems.getDefault()
            .getPath("src/UZ/Lab2_P/Tests/primeNumbers.json")
            .toAbsolutePath()
            .toString();

    Type typeOfList = new TypeToken<List<Integer>>() {
    }.getType();
    Type typeOfMap = new TypeToken<Map<String, Double>>() {
    }.getType();
    List<Integer> primeNumbers;
    List<Integer> notPrimeNumbers;
    Map<String, Double> oddToEvenRatio;

    JsonObject jsonObject;

    @BeforeEach
    public void readJSON() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(path)));
            jsonObject = gson.fromJson(content, JsonObject.class);

            primeNumbers = gson.fromJson(jsonObject.get("primeNumbers"), typeOfList);
            notPrimeNumbers = gson.fromJson(jsonObject.get("notPrimeNumbers"), typeOfList);
            oddToEvenRatio = gson.fromJson(jsonObject.get("oddToEvenRatio"), typeOfMap);

        } catch (IOException e) {
            System.out.println("Error while reading JSON file");
            e.printStackTrace();
        }

    }

    @Test
    void isPrimeNumber() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Zad1 zad1 = new Zad1();
        //makes private method accessible
        Method isPrimeNumberPublic = Zad1.class.getDeclaredMethod("isPrimeNumber", int.class);
        isPrimeNumberPublic.setAccessible(true);

        //test in loop
        for (Integer prime : primeNumbers) {
            assertTrue((Boolean) isPrimeNumberPublic.invoke(zad1, prime), STR."\{prime} is not prime number");
        }
        for (Integer notPrime : notPrimeNumbers) {
            assertFalse((Boolean) isPrimeNumberPublic.invoke(zad1, notPrime), STR."\{notPrime} is prime number");
        }
    }

    @Test
    void oddToEvenRatio() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int odd = 0;
        int even = 0;
        Zad1 zad1 = new Zad1();
        //makes private method accessible
        Method oddToEvenRatioTest = Zad1.class.getDeclaredMethod("oddToEvenRatio", int.class);
        oddToEvenRatioTest.setAccessible(true);


        for (Map.Entry<String, Double> entry : oddToEvenRatio.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            assertEquals(value, (Double) oddToEvenRatioTest.invoke(zad1, Integer.parseInt(key)), STR."\{key} is not equal to \{value}");


        }


    }

}