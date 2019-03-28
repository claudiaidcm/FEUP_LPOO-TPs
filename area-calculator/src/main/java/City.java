import java.util.ArrayList;
import java.util.List;

public class City  implements SumProvider{
    List<House> houses = new ArrayList<>();

    public City(List<House> houses) {
        this.houses = houses;
    }

    public List<House> getHouses() {
        return houses;
    }

    public void addHouse(House house) {
        houses.add(house);
    }

    @Override
    public double sum() {
        double sum = 0;

        for (House house : houses)
            sum += house.getArea();

        return sum;
    }
}
