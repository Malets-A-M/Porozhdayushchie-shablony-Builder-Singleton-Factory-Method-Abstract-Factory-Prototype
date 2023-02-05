import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    private OptionalInt age = OptionalInt.empty();
    private String address;

    public Person(String name, String secondName, int age, String address) {
        this.name = name;
        this.surname = secondName;
        this.age = OptionalInt.of(age);
        this.address = address;
    }

    public boolean hasAge() {
        return age == OptionalInt.empty();
    }

    public void happyBirthday() throws IllegalStateException {
        if (hasAge()) age = OptionalInt.of(age.orElseThrow() + 1);
        else throw new IllegalStateException("Возраст неизвестен");
    }

    public boolean hasAddress() {
        return address != null;
    }

    public void setAddress(String city) {
        address = city;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() throws IllegalStateException {
        if (!hasAge()) throw new IllegalStateException("Возраст неизвестен");
        else return age.orElseThrow();
    }

    public String getAddress() throws IllegalStateException {
        if (!hasAddress()) throw new IllegalStateException("Адресс неизвестен");
        return address;
    }

    @Override
    public String toString() {
        if (!hasAge() && !hasAddress()) {
            return "name='" + name + '\'' +
                    ", secondName='" + surname + '\'';
        } else if (!hasAge()) {
            return "name='" + name + '\'' +
                    ", secondName='" + surname + '\'' +
                    ", address='" + address + '\'';
        } else if (!hasAddress()) {
            return "name='" + name + '\'' +
                    ", secondName='" + surname + '\'' +
                    ", age=" + age;
        } else
            return "name='" + name + '\'' +
                    ", secondName='" + surname + '\'' +
                    ", age=" + age +
                    ", address='" + address + '\'';
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAge(0)
                .setAddress(address);
    }
}
