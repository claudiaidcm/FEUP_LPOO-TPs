import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Hero extends Element{

    public Hero(int x, int y) {
      super(x, y);
    }

    public Position moveUp() {
        return position.moveUp();
    }

    public Position moveDown() {
        return position.moveDown();
    }

    public Position moveLeft() {
        return position.moveLeft();
    }

    public Position moveRight() {
        return position.moveRight();
    }


   public void setPosition (Position position) {
        this.position = new Position(position.getX(), position.getY());
   }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#00CCFF"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
    }
}