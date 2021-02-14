package com.example.flipit;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import static android.view.WindowManager.*;

public class Menu extends AppCompatActivity {

    private Button play,scores,feedback,quit_game;

    private String level="2x2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_menu);

        play= (Button) findViewById(R.id.content_menu_play);
        scores=(Button) findViewById(R.id.content_menu_your_scores);
        feedback=(Button) findViewById(R.id.content_menu_feedback);
        quit_game=(Button) findViewById(R.id.content_menu_quitgame);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog d=new Dialog(Menu.this);
                d.setContentView(R.layout.levels);

                d.setCancelable(true);
                Button four_cross_four=(Button) d.findViewById(R.id.four_cross_four);
                Button six_cross_six=(Button) d.findViewById(R.id.six_cross_six);
                Button two_cross_two=(Button) d.findViewById(R.id.two_cross_two);

                d.show();
                two_cross_two.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(getApplicationContext(),TwoCrossTwo.class);
                        startActivity(i);
                    }
                });

                four_cross_four.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(getApplicationContext(),FourCrossFour.class);
                        startActivity(i);
                    }
                });

                six_cross_six.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(getApplicationContext(),SixCrossSix.class);
                        startActivity(i);
                    }
                });

            }
        });


        /*feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this,CardFlip.class));
            }
        });
        */

    }

}