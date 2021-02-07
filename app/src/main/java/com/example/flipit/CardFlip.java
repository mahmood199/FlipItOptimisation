package com.example.flipit;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class CardFlip extends AppCompatActivity {

    private Button TV;

    @Override
    protected void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_flip);

        TV=(Button) findViewById(R.id.redView);
        TV.setText("FRONT");

        TV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ObjectAnimator anime1 = ObjectAnimator.ofFloat(TV,"scaleX",1f,0f);
                final ObjectAnimator anime2 = ObjectAnimator.ofFloat(TV,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(TV.getText().toString()=="BACK")
                            TV.setText("FRONT");
                        else if(TV.getText().toString()=="FRONT")
                            TV.setText("BACK");
                        anime2.start();
                    }
                });
            }
        });

    }
}