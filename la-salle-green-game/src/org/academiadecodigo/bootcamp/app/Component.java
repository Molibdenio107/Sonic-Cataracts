package org.academiadecodigo.bootcamp.app;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public  abstract class Component {

    private Position position;
    public Rectangle rectangle;

    public Picture picture;

    public Component(int x,int  y,int width, int height, String filePath){
        this.position = new Position(x, y, width, height);
         picture = new Picture(x,y,filePath);
         picture.draw();

    }

    public Component(int x, int y, int width, int height) {
        this.position = new Position(x, y, width, height);
        rectangle = new Rectangle(x, y, width, height);
        rectangle.draw();
    }

    public Position getPosition() {
        return position;
    }
}
