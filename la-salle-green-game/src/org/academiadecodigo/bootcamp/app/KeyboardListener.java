package org.academiadecodigo.bootcamp.app;

import org.academiadecodigo.bootcamp.interfaces.Listenable;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardListener implements KeyboardHandler {

    private Listenable entity;

    public KeyboardListener() {
        startListening();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        entity.setKey(keyboardEvent.getKey(), true);
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        entity.setKey(keyboardEvent.getKey(), false);
    }

    public void setEntity(Listenable entity) {
        this.entity = entity;
    }

    private void startListening() {
        Keyboard keyboard = new Keyboard(this);

        //PRESSED IMPLEMENTATION
        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);

        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);

        keyboard.addEventListener(right);

        KeyboardEvent space = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);

        keyboard.addEventListener(space);


        //RELEASE IMPLEMENTATION
        KeyboardEvent leftRelease = new KeyboardEvent();
        leftRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        leftRelease.setKey(KeyboardEvent.KEY_LEFT);

        keyboard.addEventListener(leftRelease);

        KeyboardEvent rightRelease = new KeyboardEvent();
        rightRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        rightRelease.setKey(KeyboardEvent.KEY_RIGHT);

        keyboard.addEventListener(rightRelease);

        KeyboardEvent spaceRelease = new KeyboardEvent();
        spaceRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        spaceRelease.setKey(KeyboardEvent.KEY_SPACE);

        keyboard.addEventListener(spaceRelease);

    }
}
