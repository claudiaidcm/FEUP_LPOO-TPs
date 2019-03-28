public class Attendee extends User {
    boolean hasPaid = false;

    public Attendee(String name) {
        super(name);
    }

    public Attendee(String name, int age) {
        super(name, age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean hasPaid() {
        return hasPaid;
    }

    @Override
    public String toString() {
        String a;
        if (hasPaid == false)
           a = " hasn't ";
        else
            a = " has ";

        return "Attendee " + name + a + "paid its registration.";
    }

}
