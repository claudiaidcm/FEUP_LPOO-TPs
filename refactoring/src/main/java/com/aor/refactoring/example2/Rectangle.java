package com.aor.refactoring.example2;

public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height) {
        this.x=x;
        this.y=y;
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() throws Exception {
        return width * height;
    }

    @Override
    public double getPerimeter() throws Exception {
        return 2 * (width + height);
    }

    @Override
    public void draw(GraphicFramework graphics) {
        graphics.drawLine(x, y, x + width, y);
        graphics.drawLine(x + width, y, x + width, y + height);
        graphics.drawLine(x + width, y + height, x, y + height);
        graphics.drawLine(x, y + height, x, y);
    }
}
