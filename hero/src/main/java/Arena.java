import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Arena {
    public int width;
    public int height;
    public Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        hero = new Hero(10, 10);
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#009900"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        hero.draw(graphics);

        for (Wall wall : walls)
            wall.draw(graphics);

        for (Coin coin : coins)
            coin.draw(graphics);

        for (Monster monster : monsters)
            monster.draw(graphics);

        verifyMonsterCollisions();
    }

    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
        }

        for (Monster monster : monsters)
        {
            Position next = monster.move();
            if(canMonsterMove(next))
                monster.setPosition(next);
        }
    }

    public void moveHero(Position position) {
        if (canHeroMove(position)) {
            hero.setPosition(position);
            retrieveCoins();
        }
    }

    private boolean canHeroMove(Position position) {

        if (position.getX() >= width || position.getX() < 0)
            return false;
        else if (position.getY() >= height || position.getY() < 0)
            return false;

        for (Wall wall : walls)
        {
            if (wall.getPosition().equals(position))
                return false;
        }

        return true;
    }

    private boolean canMonsterMove(Position position)
    {
        if(!canHeroMove(position))
            return false;

        for (Coin coin : coins)
        {
            if (coin.getPosition().equals(position))
                return false;
        }

        for (Monster monster: monsters)
        {
            if(monster.getPosition().equals(position))
                return false;
        }

        return true;
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();

        for (int i = 0; i < 5; i++)
        {
            Coin tmp = new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            boolean valid = true;

            for (Wall wall : walls) {
                if (wall.getPosition().equals(tmp.getPosition())) {
                    valid = false;
                    break;
                }
            }

            if (!valid)
                continue;

            for (Coin coin : coins)
            {
                if(tmp.getPosition().equals(coin.getPosition()))
                {
                    valid = false;
                    break;
                }
            }

            if (!valid)
                continue;

            if (tmp.getPosition().equals(hero.getPosition()))
                valid = false;


            if (valid)
                coins.add(tmp);
            else
                i--;

        }

        return coins;
    }

    private void retrieveCoins()
    {
        for (Iterator<Coin> iter = coins.listIterator(); iter.hasNext(); ) {
            Coin tmp = iter.next();

            if (tmp.getPosition().equals(hero.getPosition())) {
                iter.remove();
                break;
            }
        }
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();

        for (int i = 0; i < 5; i++)
        {
            Monster tmp = new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            boolean valid = true;

            for (Wall wall : walls) {
                if (wall.getPosition().equals(tmp.getPosition())) {
                    valid = false;
                    break;
                }
            }

            if (!valid)
                continue;

            for (Coin coin : coins)
            {
                if(tmp.getPosition().equals(coin.getPosition()))
                {
                    valid = false;
                    break;
                }
            }

            if (!valid)
                continue;

            for (Monster monster : monsters)
            {
                if(tmp.getPosition().equals(monster.getPosition()))
                {
                    valid = false;
                    break;
                }
            }

            if (!valid)
                continue;

            if (tmp.getPosition().equals(hero.getPosition()))
                valid = false;


            if (valid)
                monsters.add(tmp);
            else
                i--;

        }

        return monsters;
    }

    private void verifyMonsterCollisions() {
        for (Monster monster : monsters) {
            if (monster.getPosition().equals(hero.getPosition())) {
                System.out.println("GAME OVER");
                System.exit(0);
                break;
            }
        }
    }


}