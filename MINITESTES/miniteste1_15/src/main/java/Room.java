import java.util.ArrayList;
import java.util.List;

public class Room implements Facility{

    Building building;
    String number;
    int floor;
    int capacity;
    private List<User> authorize = new ArrayList();

    public Room(Building building, String number, int floor) throws DuplicateRoomException {
        this.building = building;
        this.number = number;

        if (floor > building.getMaxFloor()) {
            throw new IllegalArgumentException();
        }

        this.floor = floor;

        building.addRoom(this);
    }

    public void authorize(User u) {
        authorize.add(u);
    }

    @Override
    public boolean canEnter(User u) {
        for (User user : authorize) {
            if (user.equals(u))
                return true;
        }

        return false;
    }

    public Room (Building building, String number, int floor, int capacity) throws DuplicateRoomException{
        this.building = building;
        this.number = number;

        if (floor > building.getMaxFloor()) {
            throw new IllegalArgumentException();
        }

        this.floor = floor;
        this.capacity=capacity;

        building.addRoom(this);
    }

    public int getCapacity() {
        return capacity;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getName() {
        String s = building.getName() + number;

        return s;
    }

    @Override
    public String toString() {
        return "Room(" + getBuilding().getName() + "," + getNumber() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        if (getClass() != o.getClass()) return false;

        Room o1 = (Room) o;

        return o1.getName().equals(getName());
    }


}
