package com.example.flipit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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

    private boolean timeAvailable;
    private Button row1iv1,row1iv2,row2iv1,row2iv2,start;
    private long co=0;
    private TextView timer,text_below;

    private Chronometer2 mChronometer;
    private Thread mThreadChrono;
    private Context mContext;

    private Button previousFlipped=null,currentFlipped=null;
    private int newCardsFlipped=0,previousInt=0,currentInt=0,total=0;
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
        timer.setText("00:000");

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
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=row1iv1))
                    flip(row1iv1,a[0]);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row1iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=row1iv2))
                    flip(row1iv2,a[1]);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });
        row2iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=row2iv1))
                    flip(row2iv1,a[2]);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });


        row2iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=row2iv2))
                    flip(row2iv2,a[3]);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row1iv1.setEnabled(false);
        row1iv2.setEnabled(false);
        row2iv1.setEnabled(false);
        row2iv2.setEnabled(false);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {

                if(mChronometer==null) {

                    previousFlipped = null;
                    currentFlipped = null;
                    previousInt = 0;
                    currentInt = 0;

                    newCardsFlipped = 0;
                    total = 0;
                    co = 0;

                    int i, j, n = 4, temp;
                    Random rand = new Random();
                    for (i = n - 1 ; i > 0 ; i--)      //Fisher Yates Algorithm
                    {
                        j = rand.nextInt(i);
                        temp = a[j];
                        a[j] = a[i];
                        a[i] = temp;
                    }

                    animateBack(row1iv1, true);
                    animateBack(row1iv2, true);
                    animateBack(row2iv1, true);
                    animateBack(row2iv2, true);

                    mChronometer = new Chronometer2(mContext);
                    mThreadChrono = new Thread(mChronometer);
                    mThreadChrono.start();
                    mChronometer.start();
                }
            }
        });
    }



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
                        total+=2;
                        if(total==4)
                        {
                            if(mChronometer.mIsRunning)
                            {
                                total=0;
                                co=0;
                                mChronometer.stop();
                                mThreadChrono.interrupt();
                                mChronometer=null;

                                final Dialog d=new Dialog(TwoCrossTwo.this);
                                d.setContentView(R.layout.level_completed_yes);

                                d.setCancelable(false);
                                Button play_again=(Button) d.findViewById(R.id.play_again);
                                Button next_level=(Button) d.findViewById(R.id.next_level);
                                Button last_level=(Button) d.findViewById(R.id.last_level);
                                last_level.setText("Back to menu");

                                last_level.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i=new Intent(TwoCrossTwo.this,Menu.class);
                                        startActivity(i);
                                        finish();
                                    }
                                });

                                d.show();
                                play_again.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        previousFlipped = null;
                                        timer.setText("00:000");
                                        currentFlipped = null;
                                        previousInt = 0;
                                        currentInt = 0;

                                        newCardsFlipped = 0;
                                        total = 0;
                                        co = 0;

                                        animateBack(row1iv1, !true);
                                        animateBack(row1iv2, !true);
                                        animateBack(row2iv1, !true);
                                        animateBack(row2iv2, !true);

                                        start.setEnabled(true);
                                        d.dismiss();
                                    }
                                });

                                next_level.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i=new Intent(getApplicationContext(),FourCrossFour.class);
                                        startActivity(i);
                                        finish();
                                    }
                                });


                            }

                        }
                    }
                }
            },350);

            newCardsFlipped=0;

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


        final AlertDialog.Builder options= new AlertDialog.Builder(TwoCrossTwo.this);
        options.setTitle("Warning");
        options.setMessage("If you leave this level,you will lose your progress");


        options.setPositiveButton("Leave", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if(mChronometer!=null) {
                    mThreadChrono.interrupt();
                    mChronometer.stop();
                }

                TwoCrossTwo.super.onBackPressed();
                return;
            }
        });

        options.setNegativeButton("Stay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                options.setCancelable(true);
            }
        });

        options.show();

    }


    public void updateTimerText(final String format) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                timer.setText(format);
            }
        });
    }

    public void stopped()
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AlertDialog.Builder adb=new AlertDialog.Builder(TwoCrossTwo.this);
                adb.setCancelable(false);
                adb.setTitle("You ran out of time");

                row1iv1.setEnabled(false);      row1iv2.setEnabled(false);      row2iv1.setEnabled(false);      row2iv2.setEnabled(false);

                mChronometer=null;
                mThreadChrono.interrupt();
                total=0;
                co=0;

                adb.setPositiveButton("Retry this level", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        animateBack(row1iv1,false);     animateBack(row1iv2,false);     animateBack(row2iv1,false);     animateBack(row2iv2,false);

                        text_below.setText("Number of times button pressed=0");
                    }
                });
                adb.show();
            }
        });
    }

    void animateBack(final Button btn,boolean enable)
    {
        btn.setEnabled(enable);
        if(!btn.getText().toString().equals("FRONT"))
        {
            ObjectAnimator X = ObjectAnimator.ofFloat(btn, "alpha", 0f, 1f);
            X.setInterpolator(new AccelerateInterpolator());
            X.setDuration(10);
            X.start();

            X.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);

                    btn.setText("FRONT");
                }
            });
        }
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
                if (since > 8000)
                {
                    timeAvailable=false;
                    stop();
                    ((TwoCrossTwo)mContext).stopped();
                    break;
                }

                long seconds = (int) since / x;
                long milliseconds = (int) (since) % x;

                ((TwoCrossTwo) mContext).updateTimerText(String.format("%02d:%03d", seconds, milliseconds));
            }
            mIsRunning = false;
        }
    }
}