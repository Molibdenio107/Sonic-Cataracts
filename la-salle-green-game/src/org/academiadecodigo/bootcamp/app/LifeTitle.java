package org.academiadecodigo.bootcamp.app;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

import javax.swing.*;

public class LifeTitle extends Text {

    private Color color;
    public static double LifeX = 620;
    public static double LifeY = 25;
    private JLabel label;

    public LifeTitle(double v, double v1, String s) {
        super(v, v1, s);
    }
}
