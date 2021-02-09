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


import java.util.Random;

public class TwoCrossTwo extends AppCompatActivity {

    private long BackPressedTime;
    private Toast backToast;
    private Button row1iv1,row1iv2,row2iv1,row2iv2,start;
    private long co=0;
    private TextView timer,text_below;

    private Chronometer2 mChronometer;
    private Thread mThreadChrono;
    private Context mContext;

    final int a[]={1,1,2,2};
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                             WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_two_cross_two);

        timer=(TextView) findViewById(R.id.two_cross_two_top_text);
        text_below=(TextView) findViewById(R.id.two_cross_two_bottom_text);
        start=(Button) findViewById(R.id.start);
        mContext=this;

        row1iv1=(Button) findViewById(R.id.first_row_first);    row1iv1.setText("FRONT");
        row1iv2=(Button) findViewById(R.id.first_row_second);   row1iv2.setText("FRONT");
        row2iv1=(Button) findViewById(R.id.second_row_first);   row2iv1.setText("FRONT");
        row2iv2=(Button) findViewById(R.id.second_row_second);  row2iv2.setText("FRONT");


        int i,j,n=4,temp;
        Random rand=new Random();

        for(i=n-1;i>0;i--)      //Fisher Yates Algorithm
        {
            j=rand.nextInt(i);
            temp=a[j];
            a[j]=a[i];
            a[i]=temp;
        }


        row1iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                startAnimation(row1iv1,a[0]);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row1iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                startAnimation(row1iv2,a[1]);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });
        row2iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                startAnimation(row2iv1,a[2]);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });
        row2iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                startAnimation(row2iv2,a[3]);
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
                else
                {
                    //Destroying previous instances
                    mThreadChrono.interrupt();
                    mChronometer.stop();

                    //Creating new ones :)
                    mChronometer = new Chronometer2(mContext);
                    mThreadChrono=new Thread(mChronometer);
                    mThreadChrono.start();
                    mChronometer.start();
                }
            }
        });

    }


    void startAnimation(final Button XYZ, final int num) {
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

                if(XYZ.getText().toString() == Integer.toString(num))
                    XYZ.setText("FRONT");
                else if(XYZ.getText().toString()=="FRONT")
                    XYZ.setText(Integer.toString(num));
                anime2.start();
            }
        });
    }


    @Override
    public void onBackPressed() {

        if(BackPressedTime+2000>System.currentTimeMillis()) {
            backToast.cancel();
            if(mChronometer!=null)
            {
                mThreadChrono.interrupt();
                mChronometer.stop();
            }
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


    public class Chronometer2 implements Runnable {

        private Context mContext;
        private long mStartTime;
        boolean mIsRunning;
        private long x = 1000;

        public Chronometer2(Context context) {
            mContext = context;
        }

        public void start() {
            mStartTime = System.currentTimeMillis();
            mIsRunning = true;
        }

        public void stop() {
            mIsRunning = false;
        }

        @Override
        public void run() {
            while (mIsRunning) {
                long since = System.currentTimeMillis() - mStartTime;
                if (since > 5000)
                {
                    stop();
                    break;
                }
                    since = (5000 - since);
                long seconds = (int) since / x;
                long milliseconds = (int) (since) % x;

                ((TwoCrossTwo) mContext).updateTimerText(String.format("%02d:%03d", seconds, milliseconds));
            }
        }
    }
}