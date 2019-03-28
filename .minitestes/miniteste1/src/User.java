public class User extends Person {
    public User(String name, int age) {
        super(name, age);
    }

    public User(String name) {
        super(name);
    }

    public String getUsername() {
        return name+age;
    }
}
