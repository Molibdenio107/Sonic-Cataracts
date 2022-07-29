package org.academiadecodigo.bootcamp.app;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

import javax.swing.*;

public class ScoreTitle extends Text {

    private Color color;
    public static double ScoreX = 90;
    public static double ScoreY = 40;
    private JLabel label;

    public ScoreTitle(double v, double v1, String s) {
        super(v, v1, s);
    }
}
