import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private Arena arena;
    private KeyStroke key;

    public Game() {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            arena = new Arena(70, 20);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            do {
                screen.setCursorPosition(null);   // we don't need a cursor
                screen.startScreen();             // screens must be started
                screen.doResizeIfNecessary();     // resize screen if necessary

                draw();

                key = screen.readInput();

                if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
                    screen.close();

                processKey(key);


            } while (key.getKeyType() != KeyType.EOF);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void draw() throws IOException {
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

    private void processKey(KeyStroke key) {
        arena.processKey(key);
    }
}

