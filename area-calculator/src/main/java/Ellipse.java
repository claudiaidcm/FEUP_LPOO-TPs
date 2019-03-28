public class Ellipse extends Shape {
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
}
