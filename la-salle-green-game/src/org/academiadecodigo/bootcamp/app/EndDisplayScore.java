package org.academiadecodigo.bootcamp.app;

import org.academiadecodigo.simplegraphics.graphics.Text;

public class EndDisplayScore {

    private int score = 0;
    private String scoreStr;
    private Text currentScore;

    public EndDisplayScore() {
        scoreInit();
    }

    public void scoreInit() {
        currentScore = new Text(480, 390, "");
        setCurrentScore(score);
        currentScore.grow(25,25);
        currentScore.draw();
    }

    public void setCurrentScore(int score) {
        this.score += score;
        intToString();
        currentScore.setText(scoreStr);
    }

    public void setScreenCurrentScore(int score) {
        this.score = score;
        intToString();
        currentScore.setText(scoreStr);
        currentScore.grow(25,25);
        currentScore.draw();
    }

    public void intToString() {
        scoreStr = String.valueOf(score);
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++;
    }

}
