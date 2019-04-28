package com.aor.refactoring.example5;

/* CODE SMELLS:
    -> LONG METHOD: (REFACTORING) extract method;
    -> PRIMITIVE OBSESSION: (REFACTORING) replace data type with object;
*/

public class Turtle {
    enum COMMAND {L, R, F}
    enum DIRECTION {N, W, S, E}

    private int row;
    private int column;
    private DIRECTION direction;

    public Turtle(int row, int column, DIRECTION direction) {
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

    public DIRECTION getDirection() {
        return direction;
    }

    public void rotateLeft() {
        switch (direction) {
            case N:
                direction = DIRECTION.W;
                break;
            case W:
                direction = DIRECTION.S;
                break;
            case S:
                direction = DIRECTION.E;
                break;
            case E:
                direction = DIRECTION.N;
                break;
        }
    }

    public void rotateRight() {
        switch (direction) {
            case N:
                direction = DIRECTION.E;
                break;
            case W:
                direction = DIRECTION.N;
                break;
            case S:
                direction = DIRECTION.W;
                break;
            case E:
                direction = DIRECTION.S;
                break;
        }
    }

    public void moveForward () {
        switch (direction) {
            case N:
                row--;
                break;
            case W:
                row++;
                break;
            case S:
                column--;
                break;
            case E:
                column++;
                break;
        }
    }

    public void execute(COMMAND command) {
        switch (command) {
            case L:
                rotateLeft();
                break;
            case R:
                rotateRight();
                break;
            case F:
                moveForward();
                break;
        }
    }
}
