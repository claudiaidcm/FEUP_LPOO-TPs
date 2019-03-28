import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Coin extends Element {
    public Coin(int x, int y) {
        super(x, y);
    }

    public Position getPosition () {return position;}

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFCC00"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "$");
    }
}
