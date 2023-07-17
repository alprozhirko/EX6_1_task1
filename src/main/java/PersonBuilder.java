import java.util.OptionalInt;

public class PersonBuilder {
    protected String name;
    protected String surname;
    private int age;
    protected String city;
    protected Person person;

    public PersonBuilder() {
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Недопустимое значение age");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String city) {
        this.city = city;
        return this;
    }

    public Person build() {
        if (name == null || surname == null || OptionalInt.of(age).isEmpty() || city == null) {
            throw new IllegalStateException("Необходимо заполнить все параметры класса");
        } else {
            person = new Person(name, surname, age, city);
        }
        return person;
    }
}
