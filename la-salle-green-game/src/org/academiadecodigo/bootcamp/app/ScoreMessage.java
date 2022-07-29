package org.academiadecodigo.bootcamp.app;

import org.academiadecodigo.simplegraphics.graphics.Text;

import javax.swing.*;

public class ScoreMessage extends Text {

    public static double ScoreMessageX = 380;
    public static double ScoreMessageY = 220;
    private JLabel label;

    public ScoreMessage(double v, double v1, String s) {
        super(v, v1, s);
    }
}
