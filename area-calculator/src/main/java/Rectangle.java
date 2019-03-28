public class Rectangle implements AreaShape {
    Integer width;
    Integer height;

    public Rectangle(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public double getArea() {
        return  getHeight() * getWidth();
    }

    @Override
    public void draw() {
        System.out.println("RECTANGLE");
    }
}
