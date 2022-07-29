package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.app.*;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    //private ScoreLife scoreLife;
    private MenuInitial menuInitial;
    private AreaGame areaGame;
    private KeyboardListener keyboardListener;
    private Rectangle segaMenu;
    private Sound segaSound;
    private Sound introSound;


    public void init() throws InterruptedException {

        /*segaMenu = new Rectangle(Constants.PADDING, Constants.PADDING, Constants.MENU_WIDTH, Constants.MENU_HEIGHT);
        segaMenu.draw();
        segaMenu.fill();
        segaMenu.setColor(Color.BLUE);

        segaSound = new Sound("/resources/intro.wav");
        segaSound.play(true);
        Thread.sleep(7500);

        segaMenu.delete();*/
        introSound = new Sound("/resources/initialMenu.wav");
        introSound.play(true);
        keyboardListener = new KeyboardListener();
        menuInitial = new MenuInitial(Constants.PADDING, Constants.PADDING, Constants.MENU_WIDTH, Constants.MENU_HEIGHT, "initialMenu.png");
        menuInitial.displayMenu();

        keyboardListener.setEntity(menuInitial);

        while (true) {
            try {
                Thread.sleep(Constants.GAME_DELAY);
            } catch (InterruptedException e) {
                e.getMessage();
            }

            if (menuInitial.getSpaceBar()) {
                menuInitial.deleteMenu();
                introSound.stop();
                areaGame = new AreaGame();
                areaGame.setKeyboardListener(keyboardListener);
                return;
            }
        }
        /*areaGame = new AreaGame();
        areaGame.init();*/
    }

    public void start() throws InterruptedException {
        areaGame.init();

    }
}
