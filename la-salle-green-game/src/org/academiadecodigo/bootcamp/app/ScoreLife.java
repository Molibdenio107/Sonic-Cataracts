package org.academiadecodigo.bootcamp.app;

import org.academiadecodigo.bootcamp.interfaces.Listenable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

public class ScoreLife extends Component implements Listenable {

    private KeyboardListener keyboardListener;
    private boolean spaceBar;

    public ScoreLife(int x, int y, int width, int height, String s) {
        super(x, y, width, height, s);
    }

    public void displayEnd() {
        super.picture.draw();
    }

    @Override
    public void setKey(int key, boolean state) {
        if(key == KeyboardEvent.KEY_SPACE) {
            spaceBar = state;
        }
    }

    public void deleteEnd() {
        super.picture.delete();
    }

    public boolean getSpaceBar() {
        return spaceBar;
    }
}
