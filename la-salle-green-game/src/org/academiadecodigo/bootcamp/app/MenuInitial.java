package org.academiadecodigo.bootcamp.app;

import org.academiadecodigo.bootcamp.interfaces.Listenable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MenuInitial extends Component implements Listenable {

    private KeyboardListener keyboardListener;
    private boolean spaceBar;

    public MenuInitial(int x, int y, int width, int height, String filePath) {
        super(x, y, width, height, filePath);
    }

    public void displayMenu() {
        super.picture.draw();
    }

    @Override
    public void setKey(int key, boolean state) {
        if(key == KeyboardEvent.KEY_SPACE) {
            spaceBar = state;
        }
    }

    public void deleteMenu() {
        super.picture.delete();
    }

    public boolean getSpaceBar() {
        return spaceBar;
    }

    public void setKeyboardListener(KeyboardListener keyboardListener) {
        this.keyboardListener = keyboardListener;
    }
}


