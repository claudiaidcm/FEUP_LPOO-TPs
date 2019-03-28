public class User {
    String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null) return false;

        if (getClass() != o.getClass()) return false;

        User o1 = (User) o;

        return o1.getName() == getName();
    }
}
