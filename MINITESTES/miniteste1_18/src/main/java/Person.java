public abstract class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == null)
            return false;

        if(obj.getClass() == Person.class)
            return false;

        Person p = (Person) obj;
        return (p.getName().equals(this.name));
    }

    @Override
    public int compareTo(Person o) {

        return this.name.compareTo(o.getName());
    }
}
