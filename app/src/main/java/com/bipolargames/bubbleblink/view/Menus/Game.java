package com.bipolargames.bubbleblink.view.Menus;

import android.graphics.*;

import com.bipolargames.bubbleblink.view.GameView;

public class Game {
    private GameView gameView;
    private Bitmap HUDspriteSheet;
    private boolean GameOver;

    public Game(GameView gameView) {
        this.gameView = gameView;
    }

    public void start() {
        this.GameOver = false;
    }

    public void gameOver() {
        this.GameOver = true;
    }

    public void gameFinish() {
        this.GameOver = true;
    }
}
