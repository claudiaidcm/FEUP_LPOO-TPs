public class Ellipse implements AreaShape {
    Integer xRadius;
    Integer yRadius;

    public Ellipse(Integer xRadius, Integer yRadius) {
        this.xRadius = xRadius;
        this.yRadius = yRadius;
    }

    public Integer getxRadius() {
        return xRadius;
    }

    public Integer getyRadius() {
        return yRadius;
    }

    public double getArea() {
        return  Math.PI * getxRadius() * getyRadius();
    }

    @Override
    public void draw() {
        System.out.println("ELLIPSE");
    }
}

