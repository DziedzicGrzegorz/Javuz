import UZ.Grzesiek.Lab3_P.Zad3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Zad3Test  {
@Test
void lowerIsLower(){
        Zad3 test1 = new Zad3(20,100);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Zad3(1120, 120);
        });

}
}
