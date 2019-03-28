import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;


public class Monster extends Element {
    public Monster(int x, int y) {
        super(x, y);
    }

    public Position getPosition () {return position;}

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#663300"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "§");
    }

    public Position move()
    {
        Random random = new Random();
        Position next;

        switch (random.nextInt(4))
        {
            case 1:
                next = new Position(getX() + 1, getY());
                break;
            case 2:
                next = new Position(getX() - 1, getY());
                break;
            case 3:
                next = new Position(getX(), getY() + 1);
                break;
            default:
                next = new Position(getX(), getY() - 1);
                break;
        }

        return next;
    }
}
