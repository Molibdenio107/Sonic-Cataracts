package org.academiadecodigo.bootcamp.app;

public enum Direction {

    LEFT(-1),
    RIGHT(1);

    public final int x;

    Direction(int x) {
        this.x = x;
    }
}
