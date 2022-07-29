package org.academiadecodigo.bootcamp.app;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Pictures {
    private Picture picture;

    public Pictures (String filepath) {
        picture = new Picture(10   , 10, filepath);
    }

    public void init(){
        picture.draw();
    }
}
