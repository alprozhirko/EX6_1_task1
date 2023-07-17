import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String city;
    protected PersonBuilder personBuilder = new PersonBuilder();

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getCity() {
        return city;
    }

    public boolean hasAge() {
        return OptionalInt.of(age).isPresent();
    }

    public boolean hasAddress() {
        return city != null;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    public PersonBuilder newChildBuilder() {
        personBuilder
                .setName(name)
                .setSurname(this.surname)
                .setAge(0)
                .setAddress(this.city)
                .build();
        return personBuilder;
    }
}