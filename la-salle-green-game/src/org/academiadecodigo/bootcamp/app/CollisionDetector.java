package org.academiadecodigo.bootcamp.app;

import java.util.LinkedList;

public class CollisionDetector {


    // this method received PLAYER position and direction
    public static boolean canMove(Position position, Direction direction, Ground ground) {

        int x = position.getX();
        int y = position.getY();
        int height = position.getHeight();
        int width = position.getWidth();

        //for (Component component : components) {

            //if (component instanceof Ground) {
                int groundX = ground.getPosition().getX();
                int groundY = ground.getPosition().getY();
                int groundHeight = ground.getPosition().getHeight();
                int groundWidth = ground.getPosition().getWidth();

                switch (direction) {
                    case RIGHT:
                        if (x < groundX + groundWidth && x + width + 1 >= groundX && y < groundY + groundHeight && y + height > groundY) {
                            return false;
                        }
                        break;

                    case LEFT:
                        if (x - 1 <= groundX + groundWidth && x + width > groundX && y < groundY + groundHeight && y + height > groundY) {
                            return false;
                        }
                        break;
                }
            //}
        //}

        return true;
    }

    public static Component hasGoodObjectsCollision(Position position, LinkedList<Component> components) {

        for (Component component : components) {

            if(component instanceof GoodObjects) {

                if(checkCollision(component, position)) {
                    return component;
                }

            }

        }

        return null;
    }

    public static Component hasBadObjectsCollision(Position position, LinkedList<Component> components) {

        for (Component component : components) {

            if (component instanceof BadObjects) {

                if(checkCollision(component, position)) {
                    return component;
                }

            }

        }

        return null;
    }

    private static boolean checkCollision(Component entity, Position position) {
        int x = position.getX();
        int y = position.getY();
        int height = position.getHeight();
        int width = position.getWidth();

        int entityX = entity.getPosition().getX();
        int entityY = entity.getPosition().getY();
        int entityWidth = entity.getPosition().getWidth();
        int entityHeight = entity.getPosition().getHeight();

        return x < entityX + entityWidth && x + width > entityX && y < entityY + entityHeight && y + height > entityY;
    }

}
