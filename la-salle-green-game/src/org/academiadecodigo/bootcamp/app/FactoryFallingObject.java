package org.academiadecodigo.bootcamp.app;

public class FactoryFallingObject {

    private static double accuracy = 0.7;
    public static Component generateNew(AreaGame areaGame) {
        double randomObject = Math.random();
        if(randomObject >= accuracy) {
            GoodObjects goodObject = new GoodObjects();
            goodObject.setAreaGame(areaGame);
            return goodObject;
        }
        BadObjects badObject = new BadObjects();
        badObject.setAreaGame(areaGame);
        return badObject;
    }
}
