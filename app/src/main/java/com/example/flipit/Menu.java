package com.example.flipit;

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
        getWindow().addFlags(LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);


        play= (Button) findViewById(R.id.content_menu_play);
        scores=(Button) findViewById(R.id.content_menu_your_scores);
        feedback=(Button) findViewById(R.id.content_menu_feedback);
        quit_game=(Button) findViewById(R.id.content_menu_quitgame);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLevels();
            }

            private void showLevels() {
                final String[] levels ={"2x2   Beginner","4x4   Intermediate","6x6   Advance"};

                AlertDialog.Builder options= new AlertDialog.Builder(Menu.this);
                options.setTitle("Choose a level");
                options.setSingleChoiceItems(levels, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        level = levels[which];

                        if(which==0)
                        {
                            Intent i=new Intent(Menu.this,TwoCrossTwo.class);
                            startActivity(i);
                        }
                        else if(which==1)
                        {
                            Intent i=new Intent(Menu.this,FourCrossFour.class);
                            startActivity(i);
                        }
                        else if(which==2)
                        {
                            Intent i=new Intent(Menu.this,SixCrossSix.class);
                            startActivity(i);
                        }
                        Toast.makeText(Menu.this, level +"   "+which, Toast.LENGTH_SHORT).show();
                    }
                });
                options.show();
            }
        });


    }

}