public class Speaker extends User{
    int fee = 0;

    public Speaker(String name, int age) {
        super(name, age);
    }

    public Speaker(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getFee() {
        return fee;
    }

    @Override
    public String toString() {
        return "Speaker " + name + " as a fee value of " + fee + ".";
    }
}
