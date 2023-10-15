package JunitTesting;

public class User {
    private String name;
    private String surname;
    private int age;
    private String email;

    public User(String name, String surname, int age, String email) {
        this.name = "Monika";
        this.surname = surname;
        this.age = age;
        this.email = email +"asdasd";
    }

    public User getUser() {
        return this;
    }

    public String getName() {
        return name;
    }
    public void setUser(String name) {
        this.name = name;
    }
}
