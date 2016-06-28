package com.bipolargames.bubbleblink.view;

/**
 * SurfaceView dónde se dibujarán los gráficos.
 * Todo el juego se cargará en esta vista.
 */

import android.content.*;
import android.view.*;
import android.graphics.*;

import com.bipolargames.bubbleblink.controller.GameLoopThread;

public class GameView extends SurfaceView {

    private SurfaceHolder holder;
    private GameLoopThread gameLoopThread;
    //private Board board;
    //private Game game;
    private long lastClick;
    private long fps;
    private Paint paint;

    public Context context;

    public GameView(Context context) {
        super(context);
        this.context = context;
        this.gameLoopThread = new GameLoopThread(this);
        //this.game = new Game(this, 8, 10);
        //this.game.start();
        holder = getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                boolean retry = false;
                gameLoopThread.setRunning(false);
                while(retry) {
                    try {
                        gameLoopThread.join();
                        retry = false;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                gameLoopThread.setRunning(true);
                gameLoopThread.start();
            }
            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}
        });
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.YELLOW);
        //this.game.draw(canvas);
        //this.game.gameBoard.draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if((System.currentTimeMillis() - lastClick) > 500) {
            lastClick = System.currentTimeMillis();
            synchronized (getHolder()) {
                //this.game.registerTouch(event);
            }
        }
        return true;
    }

}
