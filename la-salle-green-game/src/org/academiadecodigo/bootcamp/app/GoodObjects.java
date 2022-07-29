package org.academiadecodigo.bootcamp.app;

import org.academiadecodigo.bootcamp.interfaces.Movable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GoodObjects extends Component implements Movable {

    private AreaGame areaGame;

    public GoodObjects() {
        super((int) Math.ceil(Math.random() * (750)), 70, 50, 50, "toiletPaper_reduced.png");
        super.picture.draw();
    }


    @Override
    public void move() {
        if(super.getPosition().getY() >= 560) {
            delete();
        }

        int initialY = super.getPosition().getY();
        int moveY = 1;

        super.getPosition().setCoordinatesY(moveY);

        super.picture.translate(0, super.getPosition().getY() - initialY);

    }

    public void delete() {
        super.picture.delete();
        areaGame.removeComponent(this);
    }

    public void setAreaGame(AreaGame areaGame) {
        this.areaGame = areaGame;
    }
}

