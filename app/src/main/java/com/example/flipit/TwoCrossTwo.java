package com.example.flipit;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
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

    private Button previousFlipped=null,currentFlipped=null;
    private int newCardsFlipped=0,previousInt=0,currentInt=0;
    private boolean isAnimationRunning;

    public String TAG="TwoCrossTwo ";

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

        isAnimationRunning=false;

        row1iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=row1iv1))
                {
                    flip(row1iv1,a[0]);
                    Log.i(TAG, String.valueOf(R.id.first_row_first_image));
                }
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row1iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=row1iv2))
                {
                    flip(row1iv2,a[1]);
                    Log.i(TAG, String.valueOf(R.id.first_row_second_image));
                }
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });
        row2iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=row2iv1))
                {
                    flip(row2iv1,a[2]);
                    Log.i(TAG, String.valueOf(R.id.second_row_first_image));
                }
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });


        row2iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=row2iv2))
                {
                    flip(row2iv2,a[3]);
                    Log.i(TAG, String.valueOf(R.id.second_row_second_image));
                }
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



    //Function to increase co value
    void flip(Button Btn,int num)
    {
        if(newCardsFlipped==0)
        {
            previousFlipped=Btn;
            previousInt=num;

            final ObjectAnimator anime1=ObjectAnimator.ofFloat(previousFlipped,"scaleX",1f,0f);
            final ObjectAnimator anime2=ObjectAnimator.ofFloat(previousFlipped,"scaleX",0f,1f);

            anime1.setInterpolator(new DecelerateInterpolator());
            anime1.setDuration(100);

            anime2.setInterpolator(new AccelerateInterpolator());
            anime2.setDuration(100);

            isAnimationRunning=true;
            anime1.start();

            anime1.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);

                    if(previousFlipped.getText().toString()=="FRONT")
                        previousFlipped.setText(Integer.toString(previousInt));
                    anime2.start();
                }
            });
            newCardsFlipped++;
            //Toast.makeText(getApplicationContext(),Integer.toString(previousInt),Toast.LENGTH_SHORT).show();
            isAnimationRunning=false;
        }

        else if(newCardsFlipped==1)
        {
            currentFlipped=Btn;
            currentInt=num;

            final ObjectAnimator anime1=ObjectAnimator.ofFloat(currentFlipped,"scaleX",1f,0f);
            final ObjectAnimator anime2=ObjectAnimator.ofFloat(currentFlipped,"scaleX",0f,1f);

            anime1.setInterpolator(new DecelerateInterpolator());
            anime1.setDuration(100);

            anime2.setInterpolator(new AccelerateInterpolator());
            anime2.setDuration(100);

            isAnimationRunning=true;
            anime1.start();

            anime1.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);

                    if(currentFlipped.getText().toString()=="FRONT")
                        currentFlipped.setText(Integer.toString(currentInt));
                    anime2.start();
                }
            });
            //Toast.makeText(getApplicationContext(), Integer.toString(currentInt), Toast.LENGTH_SHORT).show();

            newCardsFlipped++;


            Handler handler=new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(currentInt!=previousInt)
                    {
                        //Toast.makeText(getApplicationContext(),"Not equal",Toast.LENGTH_SHORT).show();
                        final ObjectAnimator anime11=ObjectAnimator.ofFloat(currentFlipped,"scaleX",1f,0f);
                        final ObjectAnimator anime22=ObjectAnimator.ofFloat(currentFlipped,"scaleX",0f,1f);

                        anime11.setInterpolator(new DecelerateInterpolator());
                        anime11.setDuration(100);

                        anime22.setInterpolator(new AccelerateInterpolator());
                        anime22.setDuration(100);

                        anime11.start();

                        anime11.addListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);

                                currentFlipped.setText("FRONT");
                                anime22.start();
                            }
                        });

                        final ObjectAnimator anime33=ObjectAnimator.ofFloat(previousFlipped,"scaleX",1f,0f);
                        final ObjectAnimator anime44=ObjectAnimator.ofFloat(previousFlipped,"scaleX",0f,1f);

                        anime33.setInterpolator(new DecelerateInterpolator());
                        anime33.setDuration(100);

                        anime44.setInterpolator(new AccelerateInterpolator());
                        anime44.setDuration(100);

                        anime33.start();

                        anime33.addListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);

                                previousFlipped.setText("FRONT");
                                anime44.start();
                            }
                        });
                    }
                    else
                    {
                        disappear(previousFlipped);
                        disappear(currentFlipped);
                    }
                }
            },350);

            newCardsFlipped=0;
            isAnimationRunning=false;
        }
    }

    public void disappear(Button btn)
    {
        final ObjectAnimator animex=ObjectAnimator.ofFloat(btn,"alpha",1f,0f);
        animex.setInterpolator(new DecelerateInterpolator());
        animex.setDuration(100);

        animex.start();
        btn.setEnabled(false);
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