package org.academiadecodigo.bootcamp.app;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.bootcamp.interfaces.Movable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class AreaGame extends Component {

    private ScoreMessage scoreMessage;
    private EndDisplayScore endDisplayScore;
    private DisplayScore displayScore1;
    private DisplayScore displayScore;
    private Picture background;
    private Picture life1;
    private Picture life2;
    private Picture life3;
    private Picture loseBackground;
    private Sound sound;
    private Sound soundBadObject;
    private Sound soundGoodObject;
    private Sound soundGameOver;
    private Sound endSound;
    private ScoreLife scoreLife;
    private ScoreTitle scoreTitle;
    private LifeTitle lifeTitle;
    private KeyboardListener keyboardListener;
    private Ground ground;
    private Player player;
    private LinkedList<Component> components;

    public AreaGame() {
        super(Constants.PADDING, Constants.PADDING, Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        this.components = new LinkedList<>();
    }

    public void init() throws InterruptedException {
        sound = new Sound("/resources/SonicSong.wav");
        sound.setLoop(50);
        sound.play(true);

        background = new Picture(10.35,50, "background.png");
        background.grow(0.5,40);
        background.draw();

        displayScore = new DisplayScore();

        life3 = new Picture(600, -10, "3hearts.png");
        life3.grow(-30,-20);
        life3.draw();

        keyboardListener = new KeyboardListener();
        ground = new Ground(Constants.GROUND_X, Constants.GROUND_Y, Constants.GROUND_WIDTH, Constants.GROUND_HEIGHT);
        ground.picture = new Picture(10, 610, "floor.png");
        ground.picture.draw();

        scoreTitle = new ScoreTitle(ScoreTitle.ScoreX, ScoreTitle.ScoreY, "SCORE:");
        scoreTitle.grow(60, 30);
        scoreTitle.draw();
        scoreTitle.setColor(Color.BLACK);


        //All components should be created in StageGame class
        components.add(ground);

        player = new Player();
        keyboardListener.setEntity(player);
        player.setGround(ground);

        Component objectGenerated = FactoryFallingObject.generateNew(this);
        components.add(objectGenerated);


        while (true) {
            Thread.sleep(Constants.GAME_DELAY);
            player.move();
            if (player.getLife() > 0) {
                if (displayScore.getScore() >= 60) {
                    if (objectGenerated.getPosition().getY() == 100) {
                        objectGenerated = FactoryFallingObject.generateNew(this);
                        components.add(objectGenerated);
                    }
                }
                if (displayScore.getScore() >= 52) {
                    if (objectGenerated.getPosition().getY() == 110) {
                        objectGenerated = FactoryFallingObject.generateNew(this);
                        components.add(objectGenerated);
                    }
                }
                if (displayScore.getScore() >= 46) {
                    if (objectGenerated.getPosition().getY() == 120) {
                        objectGenerated = FactoryFallingObject.generateNew(this);
                        components.add(objectGenerated);
                    }
                }
                if (displayScore.getScore() >= 38) {
                    if (objectGenerated.getPosition().getY() == 130) {
                        objectGenerated = FactoryFallingObject.generateNew(this);
                        components.add(objectGenerated);
                    }
                }
                if (displayScore.getScore() >= 30) {
                    if (objectGenerated.getPosition().getY() == 140) {
                        objectGenerated = FactoryFallingObject.generateNew(this);
                        components.add(objectGenerated);
                    }
                }
                if (displayScore.getScore() >= 22) {
                    if (objectGenerated.getPosition().getY() == 150) {
                        objectGenerated = FactoryFallingObject.generateNew(this);
                        components.add(objectGenerated);
                    }
                }
                if (displayScore.getScore() >= 16) {
                    if (objectGenerated.getPosition().getY() == 160) {
                        objectGenerated = FactoryFallingObject.generateNew(this);
                        components.add(objectGenerated);
                    }
                }
                if (displayScore.getScore() >= 8) {
                    if (objectGenerated.getPosition().getY() == 170) {
                        objectGenerated = FactoryFallingObject.generateNew(this);
                        components.add(objectGenerated);
                    }
                }
                if (displayScore.getScore() < 8) {
                    if (objectGenerated.getPosition().getY() == 180) {
                        objectGenerated = FactoryFallingObject.generateNew(this);
                        components.add(objectGenerated);
                    }
                }

                LinkedList<Component> linkedList = new LinkedList<>(components);
                for (Component component : linkedList) {
                    if (component instanceof Movable) {
                        ((Movable) component).move();
                    }
                }
                Component component = CollisionDetector.hasBadObjectsCollision(player.getPosition(), components);
                if (component != null) {
                    ((BadObjects) component).delete();
                    soundBadObject = new Sound("/resources/sonicHit1.wav");
                    soundBadObject.play(true);
                    player.decrementLife();

                    if(player.getLife() == 2) {
                    life3.delete();
                    life2 = new Picture(600, -10, "2hearts.png");
                    life2.grow(-30,-20);
                    life2.draw();
                    }

                    if(player.getLife() == 1) {
                        life2.delete();
                        life1 = new Picture(600, -10, "1heart.png");
                        life1.grow(-30,-20);
                        life1.draw();
                    }
                }
                component = CollisionDetector.hasGoodObjectsCollision(player.getPosition(), components);
                if (component != null) {
                    ((GoodObjects) component).delete();
                    soundGoodObject = new Sound("/resources/ringSound.wav");
                    soundGoodObject.play(true);
                    displayScore.setCurrentScore(1);
                }
            }

            if (player.getLife() <= 0) {
                sound.stop();
                soundGameOver = new Sound("/resources/gameOver.wav");
                soundGameOver.play(true);
                loseBackground = new Picture(Constants.PADDING, Constants.PADDING, "gameover.png");
                loseBackground.draw();

                Thread.sleep(7500);

                loseBackground.delete();
                scoreScreen();
                break;
            }
        }

    }

    public void scoreScreen() throws InterruptedException {

        sound = new Sound("/resources/scoreSound.wav");
        sound.play(true);
        keyboardListener = new KeyboardListener();
        scoreLife = new ScoreLife(Constants.PADDING, Constants.PADDING, Constants.GAME_WIDTH, Constants.GAME_HEIGHT, "scoreBackground.png");
        scoreLife.displayEnd();

        endDisplayScore = new EndDisplayScore();
        endDisplayScore.setCurrentScore(displayScore.getScore());

        keyboardListener.setEntity(scoreLife);

        while (true) {
            try {
                Thread.sleep(Constants.GAME_DELAY);
            } catch (InterruptedException e) {
                e.getMessage();
            }

            if (scoreLife.getSpaceBar()) {
                scoreLife.deleteEnd();
                sound.stop();
                this.setKeyboardListener(keyboardListener);
                init();
                return;
            }
        }

    }

    public void removeComponent(Component component) {
        components.remove(component);
    }

    public void setKeyboardListener(KeyboardListener keyboardListener) {
        this.keyboardListener = keyboardListener;
    }
}