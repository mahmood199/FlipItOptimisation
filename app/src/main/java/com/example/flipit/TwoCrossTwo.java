package com.example.flipit;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clock.Chronometer;
import com.example.clock.Chronometer2;

public class TwoCrossTwo extends AppCompatActivity {

    private long BackPressedTime;
    private Toast backToast;
    private Button row1iv1,row1iv2,row2iv1,row2iv2,start;
    private long co=0;
    private TextView timer,text_below;

    private Chronometer2 mChronometer;
    private Thread mThreadChrono;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_two_cross_two);

        timer=(TextView) findViewById(R.id.two_cross_two_top_text);
        text_below=(TextView) findViewById(R.id.two_cross_two_bottom_text);
        start=(Button) findViewById(R.id.start);
        mContext=this;

        row1iv1=(Button) findViewById(R.id.first_row_first);    row1iv1.setText("FRONT");
        row1iv2=(Button) findViewById(R.id.first_row_second);   row1iv2.setText("FRONT");
        row2iv1=(Button) findViewById(R.id.second_row_first);   row2iv1.setText("FRONT");
        row2iv2=(Button) findViewById(R.id.second_row_second);  row2iv2.setText("FRONT");


        row1iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                startAnimation(row1iv1);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row1iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                startAnimation(row1iv2);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });
        row2iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                startAnimation(row2iv1);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });
        row2iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                startAnimation(row2iv2);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mChronometer == null)
                {
                    mChronometer = new Chronometer2(mContext);
                    mThreadChrono=new Thread(mChronometer);
                    mThreadChrono.start();
                    mChronometer.start();
                }
            }
        });

    }


    void startAnimation(final Button XYZ) {
        ObjectAnimator anime1=ObjectAnimator.ofFloat(XYZ,"scaleX",1f,0f);
        final ObjectAnimator anime2=ObjectAnimator.ofFloat(XYZ,"scaleX",0f,1f);

        anime1.setInterpolator(new DecelerateInterpolator());
        anime1.setDuration(100);

        anime2.setInterpolator(new AccelerateInterpolator());
        anime2.setDuration(100);

        anime1.start();
        anime1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                if(XYZ.getText().toString()=="BACK")
                    XYZ.setText("FRONT");
                else if(XYZ.getText().toString()=="FRONT")
                    XYZ.setText("BACK");
                anime2.start();
            }
        });
    }

    @Override
    public void onBackPressed() {

        if(BackPressedTime+2000>System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        }
        else
        {
            backToast= Toast.makeText(getBaseContext(),"Press again to leave level",Toast.LENGTH_SHORT);
            backToast.show();
        }
        BackPressedTime=System.currentTimeMillis();
    }

    public void updateTimerText(final String format) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                timer.setText(format);
            }
        });
    }
}