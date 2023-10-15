package JunitTesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @BeforeEach
    void setUp() {
        System.out.println("Starting");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Ended");
    }

    @Test
    void getUser() {
       var tmp = new User("Jan", "Kowalski", 20, "example@gmail.com");
        assertSame(tmp, tmp.getUser(),"User is not the same");
    }


    @Test
    void getName() {
        var user = new User("Kacper","Borucha",12,"esa@gmail.com");
        assertSame("Monika",user.getName());
    }

    @Test
    void setUser() {
    }
}