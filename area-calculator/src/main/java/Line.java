public class Line implements Shape{
    Integer length;

    public Line(Integer length) {
        this.length = length;
    }

    @Override
    public void draw() {
        System.out.println("LINE");
    }
}
