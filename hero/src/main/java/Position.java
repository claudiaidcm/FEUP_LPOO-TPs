public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x=x;
        this.y=y;
    }

    public int getX()
    {
        return this.x;
    }

    public void setX(int value)
    {
        this.x= value;
    }

    public int getY()
    {
        return this.y;
    }

    public void setY(int value)
    {
        this.y= value;
    }

    public Position moveUp() {
        return new Position(getX(), getY() - 1);
    }

    public Position moveDown() {
        return new Position(getX(), getY() + 1);
    }

    public Position moveLeft() {
        return new Position(getX()-1, getY());
    }

    public Position moveRight() {
        return new Position(getX()+1, getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null) return false;

        if (getClass() != o.getClass()) return false;

        Position p = (Position) o;
        return x == p.getX() && y == p.getY();
    }

}
