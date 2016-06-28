package com.bipolargames.bubbleblink;

/**
 * La única Activity del juego, aqui se cargará la vista GameView.
 */

import com.bipolargames.bubbleblink.view.GameView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameView(this));
        getActionBar().hide();
    }
}
