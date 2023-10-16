package UZ.Lab2_P.Tests;

import UZ.Lab2_P.Zad1;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;

import static java.lang.StringTemplate.STR;
import static org.junit.jupiter.api.Assertions.*;

class Zad1Test {
    Gson gson = new Gson();
    String path = FileSystems.getDefault()
            .getPath("src/UZ/Lab2_P/Tests/primeNumbers.json")
            .toAbsolutePath()
            .toString();

    Type type = new TypeToken<List<Integer>>(){}.getType();
    List<Integer> primeNumbers;
    List<Integer> notPrimeNumbers;
    @BeforeEach
    public void readJSON() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(path)));
            JsonObject jsonObject = gson.fromJson(content, JsonObject.class);

            primeNumbers = gson.fromJson(jsonObject.get("primeNumbers"), type);
            notPrimeNumbers = gson.fromJson(jsonObject.get("notPrimeNumbers"), type);

        } catch (IOException e) {
            System.out.println("Error while reading JSON file");
            e.printStackTrace();
        }

    }

    @Test
    void isPrimeNumber(){

        //test in loop
        for (Integer prime: primeNumbers) {
            assertTrue(Zad1.isPrimeNumber(prime),STR."\{prime} is not prime number");
        }
        for (Integer notPrime: notPrimeNumbers) {
            assertFalse(Zad1.isPrimeNumber(notPrime),STR."\{notPrime} is prime number");
        }


    }

}