import java.util.ArrayList;
import java.util.List;

public class Building implements Facility{
    String name;
    int minFloor;
    int maxFloor;
    int capacity;
    private List<Room> rooms = new ArrayList<>();

    public Building(String name, int minFloor, int maxFloor) {
        this.name = name;

        if (minFloor > maxFloor)
            throw new IllegalArgumentException();

        this.minFloor = minFloor;
        this.maxFloor = maxFloor;

        capacity = 0;
    }

    @Override
    public boolean canEnter(User u) {
        for (Room room : rooms) {
            if (room.canEnter(u))
                return true;
        }

        return false;
    }

    public void addRoom(Room room) throws DuplicateRoomException
    {
        for(Room room1 : rooms) {

            if (room1.equals(room))
                throw new DuplicateRoomException();
        }

        rooms.add(room);
        this.capacity += room.getCapacity();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinFloor() {
        return minFloor;
    }

    public void setMinFloor(int minFloor) {
        this.minFloor = minFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(int maxFloor) {
        this.maxFloor = maxFloor;
    }

    @Override
    public String toString() {
        return "Building(" + getName() + ")";
    }
}
