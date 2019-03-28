import java.util.ArrayList;
import java.util.List;

public class Party extends Event {
    List<Event> events = new ArrayList<>();
    public Party(String title, String date, String description) {
        super(title, date, description);
    }

    public void addEvent(Event e) {
        events.add(e);

        this.audience = this.audience + e.audience;
    }

}
