public class Triangle implements AreaShape {
    Integer base;
    Integer height;

    public Triangle(Integer base, Integer height) {
        this.base = base;
        this.height = height;
    }

    public Integer getBase() {
        return base;
    }

    public Integer getHeight() {
        return height;
    }

    public double getArea() {
        return (getHeight() * getBase())/2;
    }

    @Override
    public void draw() {
        System.out.println("TRIANGLE");
    }
}
