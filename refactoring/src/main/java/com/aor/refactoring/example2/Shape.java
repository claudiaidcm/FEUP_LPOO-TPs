package com.aor.refactoring.example2;

/* CODE SMELLS:
   -> SWITCH: replace conditional with polymorphism;
*/

public abstract class Shape {
    protected double x;
    protected double y;

    public abstract double getArea() throws Exception;

    public abstract double getPerimeter() throws Exception;

    public abstract void draw(GraphicFramework graphics);
}
