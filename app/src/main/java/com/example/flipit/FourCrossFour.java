package com.example.flipit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
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

public class FourCrossFour extends AppCompatActivity {


    private String TAG;
    private Button    start_timer, row1iv1 ,row1iv2 ,row1iv3 ,row1iv4 ,
                                   row2iv1 ,row2iv2 ,row2iv3 ,row2iv4 ,
                                   row3iv1 ,row3iv2 ,row3iv3 ,row3iv4 ,
                                   row4iv1 ,row4iv2 ,row4iv3 ,row4iv4 ;
    private long BackPressedTime;
    private Toast backToast;
    private TextView text_below,text_top;
    private int co=0;

    private Button previousFlipped=null,currentFlipped=null;
    private int newCardsFlipped=0,previousInt=0,currentInt=0,total=0;
    private boolean isAnimationRunning;

    private Chronometer mChronometer;
    private Thread mThreadChrono;
    private Context mContext;

    final int a[]={1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4};
    private boolean timeAvailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_cross_four);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                             WindowManager.LayoutParams.FLAG_FULLSCREEN);

        text_below=(TextView) findViewById(R.id.four_cross_four_bottom_text);
        start_timer=(Button) findViewById(R.id.start_timer);
        text_top=(TextView) findViewById(R.id.four_cross_four_top_text);
        text_top.setText("00:000");
        mContext=this;


        row1iv1=(Button) findViewById(R.id.first_row_first_image);      row1iv1.setText("FRONT");
        row1iv2=(Button) findViewById(R.id.first_row_second_image);     row1iv2.setText("FRONT");
        row1iv3=(Button) findViewById(R.id.first_row_third_image);      row1iv3.setText("FRONT");
        row1iv4=(Button) findViewById(R.id.first_row_fourth_image);     row1iv4.setText("FRONT");


        row2iv1=(Button) findViewById(R.id.second_row_first_image);     row2iv1.setText("FRONT");
        row2iv2=(Button) findViewById(R.id.second_row_second_image);    row2iv2.setText("FRONT");
        row2iv3=(Button) findViewById(R.id.second_row_third_image);     row2iv3.setText("FRONT");
        row2iv4=(Button) findViewById(R.id.second_row_fourth_image);    row2iv4.setText("FRONT");


        row3iv1=(Button) findViewById(R.id.third_row_first_image);      row3iv1.setText("FRONT");
        row3iv2=(Button) findViewById(R.id.third_row_second_image);     row3iv2.setText("FRONT");
        row3iv3=(Button) findViewById(R.id.third_row_third_image);      row3iv3.setText("FRONT");
        row3iv4=(Button) findViewById(R.id.third_row_fourth_image);     row3iv4.setText("FRONT");


        row4iv1=(Button) findViewById(R.id.fourth_row_first_image);     row4iv1.setText("FRONT");
        row4iv2=(Button) findViewById(R.id.fourth_row_second_image);    row4iv2.setText("FRONT");
        row4iv3=(Button) findViewById(R.id.fourth_row_third_image);     row4iv3.setText("FRONT");
        row4iv4=(Button) findViewById(R.id.fourth_row_fourth_image);    row4iv4.setText("FRONT");



        row1iv1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=row1iv1))
                    flip(row1iv1,a[0]);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row1iv2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=row1iv2))
                    flip(row1iv2,a[1]);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row1iv3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=row1iv3))
                    flip(row1iv3,a[2]);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row1iv4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=row1iv4))
                    flip(row1iv4,a[3]);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row2iv1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=row2iv1))
                    flip(row2iv1,a[4]);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row2iv2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=row2iv2))
                    flip(row2iv2,a[5]);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row2iv3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=row2iv3))
                    flip(row2iv3,a[6]);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row2iv4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=row2iv4))
                    flip(row2iv4,a[7]);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row3iv1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=row3iv1))
                    flip(row3iv1,a[8]);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row3iv2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=row3iv2))
                    flip(row3iv2,a[9]);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row3iv3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=row3iv3))
                    flip(row3iv3,a[10]);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row3iv4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=row3iv4))
                    flip(row3iv4,a[11]);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row4iv1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=row4iv1))
                    flip(row4iv1,a[12]);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row4iv2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=row4iv2))
                    flip(row4iv2,a[13]);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row4iv3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=row4iv3))
                    flip(row4iv3,a[14]);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row4iv4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=row4iv4))
                    flip(row4iv4,a[15]);
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });


        enableAll(false);


        start_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mChronometer == null) {

                    int i, j, n = 16, temp;
                    for (i = n - 1 ; i > 0 ; i--)      //Fisher Yates Algorithm
                    {
                        Random rand = new Random();
                        j=rand.nextInt(i);
                        temp=a[j];
                        a[j]=a[i];
                        a[i]=temp;
                    }

                    resetAllValues();
                    animateBackAll(true);
                    enableAll(true);

                    mChronometer = new Chronometer(mContext);
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
                        newCardsFlipped=0;
                    }
                    else
                    {
                        disappear(previousFlipped);
                        disappear(currentFlipped);
                        total+=2;
                        if(total==16)
                        {
                            if(mChronometer.mIsRunning)
                            {
                                resetAllValues();
                                mChronometer.stop();
                                mThreadChrono.interrupt();
                                mChronometer=null;

                                final Dialog d=new Dialog(FourCrossFour.this);
                                d.setContentView(R.layout.level_completed_yes);

                                d.setCancelable(false);
                                Button play_again=(Button) d.findViewById(R.id.play_again);
                                Button next_level=(Button) d.findViewById(R.id.next_level);
                                Button last_level=(Button) d.findViewById(R.id.last_level);
                                last_level.setText("Last Level");

                                last_level.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i=new Intent(FourCrossFour.this,TwoCrossTwo.class);
                                        startActivity(i);
                                        finish();
                                    }
                                });

                                d.show();
                                play_again.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        animateBackAll(false);
                                        resetAllValues();
                                        start_timer.setEnabled(true);
                                        d.dismiss();
                                    }
                                });

                                next_level.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i=new Intent(getApplicationContext(),SixCrossSix.class);
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

    void enableAll(boolean b)
    {
        row1iv1.setEnabled(b);      row1iv2.setEnabled(b);      row1iv3.setEnabled(b);      row1iv4.setEnabled(b);
        row2iv1.setEnabled(b);      row2iv2.setEnabled(b);      row2iv3.setEnabled(b);      row2iv4.setEnabled(b);
        row3iv1.setEnabled(b);      row3iv2.setEnabled(b);      row3iv3.setEnabled(b);      row3iv4.setEnabled(b);
        row4iv1.setEnabled(b);      row4iv2.setEnabled(b);      row4iv3.setEnabled(b);      row4iv4.setEnabled(b);
    }

    void animateBackAll(boolean b)
    {
        animateBack(row1iv1, b);    animateBack(row1iv2, b);    animateBack(row1iv3, b);    animateBack(row1iv4, b);
        animateBack(row2iv1, b);    animateBack(row2iv2, b);    animateBack(row2iv3, b);    animateBack(row2iv4, b);
        animateBack(row3iv1, b);    animateBack(row3iv2, b);    animateBack(row3iv3, b);    animateBack(row3iv4, b);
        animateBack(row4iv1, b);    animateBack(row4iv2, b);    animateBack(row4iv3, b);    animateBack(row4iv4, b);
    }

    void resetAllValues()
    {
        previousFlipped = null;
        currentFlipped = null;
        previousInt = 0;
        currentInt = 0;

        newCardsFlipped = 0;
        total = 0;
        co = 0;

        text_below.setText("Press start to begin level");
        text_top.setText("00:000");
    }

    public void disappear(Button btn)
    {
        final ObjectAnimator animex=ObjectAnimator.ofFloat(btn,"alpha",1f,0f);
        animex.setInterpolator(new DecelerateInterpolator());
        animex.setDuration(100);
        animex.start();
        btn.setEnabled(false);
    }

    public void onBackPressed() {
        final Dialog d=new Dialog(FourCrossFour.this);
        d.setContentView(R.layout.back_pressed);
        d.show();
        Button YES= (Button) d.findViewById(R.id.yes);
        Button NO=  (Button) d.findViewById(R.id.no);
        YES.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(mChronometer!=null)
                {
                    mThreadChrono.interrupt();
                    mChronometer.stop();
                    mChronometer=null;
                }
                FourCrossFour.super.onBackPressed();
            }
        });
        NO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });
    }


    public void updateTimerText(final String time) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text_top.setText(time);
            }
        });
    }

    private void stopped()
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                final Dialog d=new Dialog(FourCrossFour.this);
                d.setContentView(R.layout.retry);
                d.show();
                d.setCancelable(false);
                Button YES= (Button) d.findViewById(R.id.menu);
                Button NO=  (Button) d.findViewById(R.id.retry_this_level);
                YES.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) { FourCrossFour.super.onBackPressed(); }});
                NO.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        animateBackAll(false);
                        resetAllValues();
                        mChronometer.stop();
                        mChronometer=null;
                        mThreadChrono.interrupt();
                        d.dismiss();
                    }
                });

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


    public class Chronometer implements Runnable{

        private Context mContext;
        private long mStartTime;
        boolean mIsRunning;
        private long x=1000;


        public Chronometer(Context context)
        {
            mContext = context;
        }

        public void start() {
            mStartTime = System.currentTimeMillis();
            mIsRunning = true;
        }

        public void stop() { mIsRunning = false; }

        @Override
        public void run() {
            while (mIsRunning) {
                long since = System.currentTimeMillis() - mStartTime;
                if (since > 32000)
                {
                    timeAvailable=false;
                    stop();
                    ((FourCrossFour)mContext).stopped();
                    break;
                }

                long seconds = (int) since / x;
                long milliseconds = (int) (since) % x;

                ((FourCrossFour) mContext).updateTimerText(String.format("%02d:%03d", seconds, milliseconds));
            }
            mIsRunning = false;
        }
    }
}

