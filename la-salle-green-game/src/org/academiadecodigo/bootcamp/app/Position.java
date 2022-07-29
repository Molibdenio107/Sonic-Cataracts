package org.academiadecodigo.bootcamp.app;

public class Position {
    private int x;
    private int y;
    private int width;
    private int height;

    public Position(int x, int y, int width, int height){
        this.x = x;
        this.y =y;
        this.width = width;
        this.height = height;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setCoordinatesX(int moveX) {
        int nextX = x + moveX;

        if(nextX < 20) {
            nextX = 20;
        }

        if(nextX + width > Constants.GAME_WIDTH) {
            nextX = Constants.GAME_WIDTH - width;
        }


        setX(nextX);
    }

    public void setCoordinatesY(int moveY) {
        int nextY = y + moveY;

        if(nextY >= 560) {
            nextY = 560;
        }

        setY(nextY);
    }
}
