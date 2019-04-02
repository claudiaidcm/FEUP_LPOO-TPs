package com.aor.refactoring.example5;

/* CODE SMELLS:
    -> SWITCH STATEMENTS
 */

public class Turtle {
    private int row;
    private int column;
    private char direction;

    public Turtle(int row, int column, char direction) {
        this.row = row;
        this.column = column;
        this.direction = direction;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getDirection() {
        return direction;
    }

    public void rotateLeft() {
        if (direction == 'N') direction = 'W';
        else if (direction == 'W') direction = 'S';
        else if (direction == 'S') direction = 'E';
        else if (direction == 'E') direction = 'N';
    }

    public void rotateRight() {
        if (direction == 'N') direction = 'E';
        else if (direction == 'E') direction = 'S';
        else if (direction == 'S') direction = 'W';
        else if (direction == 'W') direction = 'N';
    }

    public void moveForward () {
        if (direction == 'N') row--;
        if (direction == 'S') row++;
        if (direction == 'W') column--;
        if (direction == 'E') column++;
    }

    public void execute(char command) {
        if (command == 'L')
            rotateLeft();
        else if (command == 'R')
            rotateRight();
        else if (command == 'F')
            moveForward();
    }
}
