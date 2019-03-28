import java.util.ArrayList;
import java.util.List;

public class Event {
    String title;
    String date = "";
    String description = "";
    int audience = 0;
    List<Person> persons = new ArrayList<>();

    public Event(Event e) {

        this.title = e.title;
        this.date = e.date;
        this.description = e.description;

    }

    public Event(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public Event(String title, String date) {
        this.title = title;
        this.date = date;
    }

    public Event(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addPerson (Person p) {
        int n = 0;
        for (Person person : persons) {
            if (person.getName().equals(p.getName())){
                n++;
            }
        }

        if (n==0) {
            persons.add(p);
            audience++;
        }
    }

    public int getAudienceCount() {return audience;}

    @Override
    public String toString() {
        return title + " is a " + description + " and will be held at " + date + ".";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
        return false;

        if(obj.getClass() != this.getClass())
            return false;

        Event tmp = (Event) obj;

        return (tmp.getTitle() == this.title) && (tmp.getDate() == this.date) && (tmp.getDescription() == this.description);
    }

}

