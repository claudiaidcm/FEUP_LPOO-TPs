import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {

    public Position position;

    public Element(int x, int y) {
        position = new Position(x, y);
    }

    public Position getPosition()
    {
        return position;
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }

    public int getX()
    {
        return position.getX();
    }

    public int getY()
    {
        return position.getY();
    }

    public abstract void draw(TextGraphics graphics);

}
