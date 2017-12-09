package was3.hw4;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private String name;
    private String surname;
    private long pesel; // tu mogłoby być też String ale dzięki typowi liczbowemu możemy rozszerzyć program o np. liczenie sumy kontrolnej
    private static List<User> users = new ArrayList<>();

    User(String name, String surname, long pesel) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
    }

    public String getFullName() { return name + " " + surname; }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public long getPesel() {
        return pesel;
    }

    public static List<User> getUsers() {
        return users;
    }
}
