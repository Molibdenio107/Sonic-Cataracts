package org.academiadecodigo.bootcamp.app;

import org.academiadecodigo.bootcamp.interfaces.Listenable;
import org.academiadecodigo.bootcamp.interfaces.Movable;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import sun.nio.ch.sctp.PeerAddrChange;

public class Player extends Component implements Listenable, Movable {

    private static final int HEIGHT = 100;
    private static final int WIDTH = 50;
    private boolean left;
    private boolean right;
    private int speed = 2;
    private int score = 0;
    private int life = 3;
    private Ground ground;
    private boolean dead = false;




//    public Player(int x, int y, int width, int height, String filePath) {
//        super(x, y, width, height, filePath);
//    }

    public Player() {
        //Prestar atenção no WIDTH a depender da imagem!!
        super(375, 510, WIDTH + 25, HEIGHT, "sonic_standing_right.png");
        picture.draw();
    }


    @Override
    public void setKey(int key, boolean state) {
        switch (key) {
            case KeyboardEvent.KEY_LEFT:
                left = state;
                break;
            case KeyboardEvent.KEY_RIGHT:
                right = state;
                break;
        }
    }

    @Override
    public void move() {
        int initialX = getPosition().getX();
        int moveX = 0;

        if (left) {
            if (CollisionDetector.canMove(getPosition(), Direction.LEFT, ground)) {
                moveX = Direction.LEFT.x * speed;
            }
        }

        if (right) {
            if (CollisionDetector.canMove(getPosition(), Direction.RIGHT, ground)) {
                moveX = Direction.RIGHT.x * speed;
            }
        }

        verifyMove(moveX, initialX);
    }

    private void verifyMove(int moveX, int initialX) {

        getPosition().setCoordinatesX(moveX);

        // Y is static!
        picture.translate(getPosition().getX() - initialX, 0);


    }

    public int getScore() {
        return score;
    }

    public int getLife() {
        return life;
    }

    public void setGround(Ground ground) {
        this.ground = ground;
    }

    public void decrementLife() {
        life--;
    }

    public void incrementScore() {
        score++;
    }

    public boolean isDead() {
        return dead;
    }
}
