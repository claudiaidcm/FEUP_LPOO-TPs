import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

import org.junit.Test;

public class TestEvents {
    // auxiliary methods
    private void fieldsArentPublic(Class<?> ... classes) {
        for (Class<?> c: classes)
            for (Field f : c.getDeclaredFields())
                assertFalse(Modifier.isPublic(f.getModifiers()));
    }
    private void isAbstract(Class<?> c) {
        assertTrue(Modifier.isAbstract(c.getModifiers()));
    }
    private String generateRandomString() {
        String alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuffer sb = new StringBuffer();
        Random r = new Random();
        int l = 0;
        do {
            l = r.nextInt(20);
        } while (l < 3);
        for (int i = 0; i < l; i++) {
            sb.append(alfabet.charAt(r.nextInt(alfabet.length())));
        }
        return sb.toString();
    }
    private int generateRandomInteger() {
        Random r = new Random();
        return r.nextInt(256);
    }
    // test constructors

    @Test
    public void testEvent() {
        Event e = new Event("ENEI");
        assertEquals("ENEI",e.getTitle());
        assertEquals("",e.getDate());
        assertEquals("",e.getDescription());
        e = new Event("ENEI", "23 to 26 of March");
        assertEquals("ENEI",e.getTitle());
        assertEquals("23 to 26 of March",e.getDate());
        assertEquals("",e.getDescription());
        e = new Event("ENEI", "23 to 26 of March", "Encontro Nacional de Estudantes de Informatica");
        assertEquals("ENEI",e.getTitle());
        assertEquals("23 to 26 of March",e.getDate());
        assertEquals("Encontro Nacional de Estudantes de Informatica",e.getDescription());
        fieldsArentPublic(Event.class);
    }


   @Test
    public void testEventCopyConstructor() {
        Event e = new Event("A", "B", "C");
        Event e1 = new Event(e);
        assertEquals("A",e1.getTitle());
        assertEquals("B",e1.getDate());
        assertEquals("C",e1.getDescription());
        assertNotSame(e,e1);
    }

    @Test
    public void testEventAccessors() {
        Event e = new Event("TalkABit", "January 20th, 2017", "non-profit tech conference");
        e.setTitle("TalkALot");
        assertEquals("TalkALot",e.getTitle());
        e.setDate("January 20th, 2018");
        assertEquals("January 20th, 2018",e.getDate());
        e.setDescription("We take your money tech conference");
        assertEquals("We take your money tech conference",e.getDescription());
    }

    @Test
    public void testEventPrintOut() {
        Event e = new Event("WebSummit", "Next year again", "world-wide tech event");
        assertEquals("WebSummit is a world-wide tech event and will be held at Next year again.",""+e);
        e = new Event("TalkABit", "January 20th, 2017", "non-profit tech conference");
        assertEquals("TalkABit is a non-profit tech conference and will be held at January 20th, 2017.",""+e);
        String a = generateRandomString();
        String b = generateRandomString();
        String c = generateRandomString();
        e = new Event(a,b,c);
        assertEquals(a+" is a "+c+" and will be held at "+b+".",""+e);
    }

    @Test
    public void testSameEvent() {
        Event e = new Event(generateRandomString(), generateRandomString(), generateRandomString());
        Event e1 = new Event(e);
        Event e2 = new Event(e);
        Event e3 = new Event(e);
        assertTrue(e.equals(e1));
        assertTrue(e.equals((Object)e1));
        assertTrue(e.equals(e2));
        assertTrue(e.equals((Object)e2));
        assertTrue(e.equals(e3));
        assertTrue(e.equals((Object)e3));
        assertNotSame(e,e1);
        assertNotSame(e,e2);
        assertNotSame(e,e3);
        e1.setTitle(generateRandomString());
        assertFalse(e.equals(e1));
        assertFalse(e.equals((Object)e1));
        e2.setDate(generateRandomString());
        assertFalse(e.equals(e2));
        assertFalse(e.equals((Object)e2));
        e3.setTitle(generateRandomString());
        assertFalse(e.equals(e3));
        assertFalse(e.equals((Object)e3));
    }

    @Test
    public void testParticipants() {
        String name = generateRandomString();
        Person p = new Attendee(name); {
            assertEquals(name, p.getName());
            assertEquals(0, p.getAge());

            name = generateRandomString();
            int age = generateRandomInteger();
            Person p1 = new Attendee(name, age);
            assertEquals(name, p1.getName());
            assertEquals(age, p1.getAge());

            name = generateRandomString();
            age = generateRandomInteger();
            Person p2 = new Speaker(name, age);
            assertEquals(name, p2.getName());
            assertEquals(age, p2.getAge());

            Attendee a = (Attendee)p1;
            assertFalse(a.hasPaid());

            Speaker s = (Speaker)p2;
            assertEquals(0, s.getFee());

            assertEquals("Speaker "+s.getName()+" as a fee value of "+s.getFee()+".",""+p2);
            assertEquals("Attendee "+a.getName()+(a.hasPaid() ? " has":" hasn't")+" paid its registration.",""+p1);

            fieldsArentPublic(Person.class, Attendee.class, Speaker.class);
            isAbstract(Person.class);
        }
    }

    @Test
    public void testAudience() {
        Event e = new Event("E1","Whenever","Whatever");
        e.addPerson(new Attendee("Nuno",21));
        e.addPerson(new Attendee("Flores",31));
        e.addPerson(new Speaker("Bill Gates",51));
        assertEquals(3,e.getAudienceCount());
        e.addPerson(new Attendee(generateRandomString(),generateRandomInteger()));
        assertEquals(4,e.getAudienceCount());
        e.addPerson(new Attendee("Flores",33));
        assertEquals(4,e.getAudienceCount());
        e.addPerson(new Attendee("Bill Gates",15));
        assertEquals(4,e.getAudienceCount());
        e.addPerson(new Attendee("Donald Trump",15));
        assertEquals(5,e.getAudienceCount());
        e.addPerson(new Speaker("Donald Trump",60));
        assertEquals(5,e.getAudienceCount());
    }

    @Test
    public void testNoDuplicatePerson() {
        TreeSet<Person> people = new TreeSet<Person>();
        String name = generateRandomString();
        Person p = new Speaker(name);
        people.add(p);
        assertEquals(1,people.size());
        p = new Attendee(name);
        people.add(p);
        assertEquals(1,people.size());
    }

    @Test
    public void testParty() {
        Party p = new Party("FEUP Caffe", "Tonight!","Party on!");
        p.addPerson(new Attendee(generateRandomString()));
        p.addPerson(new Artist(generateRandomString()));
        assertEquals(2, p.getAudienceCount());
        assertEquals(2, ((Event)p).getAudienceCount());
        Event e = new Event(generateRandomString());
        e.addPerson(new Attendee(generateRandomString()));
        e.addPerson(new Attendee(generateRandomString()));
        p.addEvent(e);
        assertEquals(4, p.getAudienceCount());
        assertEquals(4, ((Event)p).getAudienceCount());
        assertEquals(2, e.getAudienceCount());
        e = new Event(generateRandomString());
        e.addPerson(new Attendee(generateRandomString()));
        e.addPerson(new Attendee(generateRandomString()));
        e.addPerson(new Attendee(generateRandomString()));
        p.addEvent(e);
        assertEquals(7, p.getAudienceCount());
        assertEquals(7, ((Event)p).getAudienceCount());
        assertEquals(3, e.getAudienceCount());
    }

    @Test
    public void testUsernames() {
        ArrayList<User> users = new ArrayList<User>();

        String name = generateRandomString();
        int age = generateRandomInteger();
        User u = new Attendee(name, age);
        assertEquals(name+age,u.getUsername());

        users.add(u);
        users.add(new Speaker("Speaker",12));
        users.add(new Artist("Artist", 20));

        Iterator<User> i = users.iterator();
        String s = "";
        while (i.hasNext()) {
            User user = i.next();
            s += ","+user.getUsername();
        }

        assertEquals(","+name+age+",Speaker12,Artist20",s);
    }
}
