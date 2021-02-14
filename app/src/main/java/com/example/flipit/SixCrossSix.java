package com.example.flipit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;

public class SixCrossSix extends AppCompatActivity {

    private long BackPressedTime;
    private Toast backToast;

    private int co=0;
    private TextView text_top,text_below;

    private Button  r1iv1,r1iv2,r1iv3,r1iv4,r1iv5,r1iv6,
                    r2iv1,r2iv2,r2iv3,r2iv4,r2iv5,r2iv6,
                    r3iv1,r3iv2,r3iv3,r3iv4,r3iv5,r3iv6,
                    r4iv1,r4iv2,r4iv3,r4iv4,r4iv5,r4iv6,
                    r5iv1,r5iv2,r5iv3,r5iv4,r5iv5,r5iv6,
                    r6iv1,r6iv2,r6iv3,r6iv4,r6iv5,r6iv6, start_button;

    private Button previousFlipped=null,currentFlipped=null;
    private int newCardsFlipped=0,previousInt=0,currentInt=0,total=0;
    private boolean isAnimationRunning;

    private Chronometer3 mChronometer;
    private Thread mThreadChrono;
    private Context mContext;

    final int a[]={1,1,1,1,1,1,2,2,2,2,2,2,3,3,3,3,3,3,4,4,4,4,4,4,5,5,5,5,5,5,6,6,6,6,6,6};
    private boolean timeAvailable=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six_cross_six);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        mContext=this;
        text_top=(TextView) findViewById(R.id.six_cross_six_top_text);
        text_top.setText("00:000");
        text_below=(TextView) findViewById(R.id.six_cross_six_bottom_text);
        start_button=(Button) findViewById(R.id.start_button);

        r1iv1=(Button) findViewById(R.id.sxs_first_row_first_image);    r1iv1.setText("FRONT");
        r1iv2=(Button) findViewById(R.id.sxs_first_row_second_image);   r1iv2.setText("FRONT");
        r1iv3=(Button) findViewById(R.id.sxs_first_row_third_image);    r1iv3.setText("FRONT");
        r1iv4=(Button) findViewById(R.id.sxs_first_row_fourth_image);   r1iv4.setText("FRONT");
        r1iv5=(Button) findViewById(R.id.sxs_first_row_fifth_image);    r1iv5.setText("FRONT");
        r1iv6=(Button) findViewById(R.id.sxs_first_row_sixth_image);    r1iv6.setText("FRONT");

        r2iv1=(Button) findViewById(R.id.sxs_second_row_first_image);   r2iv1.setText("FRONT");
        r2iv2=(Button) findViewById(R.id.sxs_second_row_second_image);  r2iv2.setText("FRONT");
        r2iv3=(Button) findViewById(R.id.sxs_second_row_third_image);   r2iv3.setText("FRONT");
        r2iv4=(Button) findViewById(R.id.sxs_second_row_fourth_image);  r2iv4.setText("FRONT");
        r2iv5=(Button) findViewById(R.id.sxs_second_row_fifth_image);   r2iv5.setText("FRONT");
        r2iv6=(Button) findViewById(R.id.sxs_second_row_sixth_image);   r2iv6.setText("FRONT");

        r3iv1=(Button) findViewById(R.id.sxs_third_row_first_image);    r3iv1.setText("FRONT");
        r3iv2=(Button) findViewById(R.id.sxs_third_row_second_image);   r3iv2.setText("FRONT");
        r3iv3=(Button) findViewById(R.id.sxs_third_row_third_image);    r3iv3.setText("FRONT");
        r3iv4=(Button) findViewById(R.id.sxs_third_row_fourth_image);   r3iv4.setText("FRONT");
        r3iv5=(Button) findViewById(R.id.sxs_third_row_fifth_image);    r3iv5.setText("FRONT");
        r3iv6=(Button) findViewById(R.id.sxs_third_row_sixth_image);    r3iv6.setText("FRONT");

        r4iv1=(Button) findViewById(R.id.sxs_fourth_row_first_image);   r4iv1.setText("FRONT");
        r4iv2=(Button) findViewById(R.id.sxs_fourth_row_second_image);  r4iv2.setText("FRONT");
        r4iv3=(Button) findViewById(R.id.sxs_fourth_row_third_image);   r4iv3.setText("FRONT");
        r4iv4=(Button) findViewById(R.id.sxs_fourth_row_fourth_image);  r4iv4.setText("FRONT");
        r4iv5=(Button) findViewById(R.id.sxs_fourth_row_fifth_image);   r4iv5.setText("FRONT");
        r4iv6=(Button) findViewById(R.id.sxs_fourth_row_sixth_image);   r4iv6.setText("FRONT");

        r5iv1=(Button) findViewById(R.id.sxs_fifth_row_first_image);    r5iv1.setText("FRONT");
        r5iv2=(Button) findViewById(R.id.sxs_fifth_row_second_image);   r5iv2.setText("FRONT");
        r5iv3=(Button) findViewById(R.id.sxs_fifth_row_third_image);    r5iv3.setText("FRONT");
        r5iv4=(Button) findViewById(R.id.sxs_fifth_row_fourth_image);   r5iv4.setText("FRONT");
        r5iv5=(Button) findViewById(R.id.sxs_fifth_row_fifth_image);    r5iv5.setText("FRONT");
        r5iv6=(Button) findViewById(R.id.sxs_fifth_row_sixth_image);    r5iv6.setText("FRONT");

        r6iv1=(Button) findViewById(R.id.sxs_sixth_row_first_image);    r6iv1.setText("FRONT");
        r6iv2=(Button) findViewById(R.id.sxs_sixth_row_second_image);   r6iv2.setText("FRONT");
        r6iv3=(Button) findViewById(R.id.sxs_sixth_row_third_image);    r6iv3.setText("FRONT");
        r6iv4=(Button) findViewById(R.id.sxs_sixth_row_fourth_image);   r6iv4.setText("FRONT");
        r6iv5=(Button) findViewById(R.id.sxs_sixth_row_fifth_image);    r6iv5.setText("FRONT");
        r6iv6=(Button) findViewById(R.id.sxs_sixth_row_sixth_image);    r6iv6.setText("FRONT");


        r1iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r1iv1))
                    flip(r1iv1,a[0]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r1iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r1iv2))
                    flip(r1iv2,a[1]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r1iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r1iv3))
                    flip(r1iv3,a[2]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r1iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r1iv4))
                    flip(r1iv4,a[3]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r1iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r1iv5))
                    flip(r1iv5,a[4]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r1iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r1iv6))
                    flip(r1iv6,a[5]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });


        r2iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r2iv1))
                    flip(r2iv1,a[6]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r2iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r2iv2))
                    flip(r2iv2,a[7]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r2iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r2iv3))
                    flip(r2iv3,a[8]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r2iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r2iv4))
                    flip(r2iv4,a[9]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r2iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r2iv5))
                    flip(r2iv5,a[10]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r2iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r2iv6))
                    flip(r2iv6,a[11]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });


        r3iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r3iv1))
                    flip(r3iv1,a[12]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r3iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r3iv2))
                    flip(r3iv2,a[13]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r3iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r3iv3))
                    flip(r3iv3,a[14]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r3iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r3iv4))
                    flip(r3iv4,a[15]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r3iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r3iv5))
                    flip(r3iv5,a[16]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });


        r3iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r3iv6))
                    flip(r3iv6,a[17]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });


        r4iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r4iv1))
                    flip(r4iv1,a[18]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r4iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r4iv2))
                    flip(r4iv2,a[19]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r4iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r4iv3))
                    flip(r4iv3,a[20]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r4iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r4iv4))
                    flip(r4iv4,a[21]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r4iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r4iv5))
                    flip(r4iv5,a[22]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r4iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r4iv6))
                    flip(r4iv6,a[23]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });



        r5iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r5iv1))
                    flip(r5iv1,a[24]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r5iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r5iv2))
                    flip(r5iv2,a[25]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r5iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r5iv3))
                    flip(r5iv3,a[26]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r5iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r5iv4))
                    flip(r5iv4,a[27]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r5iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r5iv5))
                    flip(r5iv5,a[28]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r5iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r5iv6))
                    flip(r5iv6,a[29]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });




        r6iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r6iv1))
                    flip(r6iv1,a[30]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r6iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r6iv2))
                    flip(r6iv2,a[31]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r6iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r6iv3))
                    flip(r6iv3,a[32]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r6iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r6iv4))
                    flip(r6iv4,a[33]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r6iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r6iv5))
                    flip(r6iv5,a[34]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r6iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                if((!isAnimationRunning) && (newCardsFlipped==0 || previousFlipped!=r6iv6))
                    flip(r6iv6,a[35]);
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r1iv1.setEnabled(false);      r1iv2.setEnabled(!false);      r1iv3.setEnabled(false);      r1iv4.setEnabled(false);      r1iv5.setEnabled(false);        r1iv6.setEnabled(false);
        r2iv1.setEnabled(false);      r2iv2.setEnabled(false);      r2iv3.setEnabled(false);      r2iv4.setEnabled(false);      r2iv5.setEnabled(false);        r2iv6.setEnabled(false);
        r3iv1.setEnabled(false);      r3iv2.setEnabled(false);      r3iv3.setEnabled(false);      r3iv4.setEnabled(false);      r3iv5.setEnabled(false);        r3iv6.setEnabled(false);
        r4iv1.setEnabled(false);      r4iv2.setEnabled(false);      r4iv3.setEnabled(false);      r4iv4.setEnabled(false);      r4iv5.setEnabled(false);        r4iv6.setEnabled(false);
        r5iv1.setEnabled(false);      r5iv2.setEnabled(false);      r5iv3.setEnabled(false);      r5iv4.setEnabled(false);      r5iv5.setEnabled(false);        r5iv6.setEnabled(false);
        r6iv1.setEnabled(false);      r6iv2.setEnabled(false);      r6iv3.setEnabled(false);      r6iv4.setEnabled(false);      r6iv5.setEnabled(false);        r6iv6.setEnabled(false);





        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mChronometer == null) {
                    text_top.setText("00:000");
                    previousFlipped = null;
                    currentFlipped = null;
                    previousInt = 0;
                    currentInt = 0;

                    newCardsFlipped = 0;
                    total = 0;
                    co = 0;


                    int i, j, n = 36, temp;
                    Random rand = new Random();
                    for (i = n - 1 ; i > 0 ; i--)      //Fisher Yates Algorithm
                    {
                        j=rand.nextInt(i);
                        temp=a[j];
                        a[j]=a[i];
                        a[i]=temp;
                    }

                    r1iv1.setEnabled(true);      r1iv2.setEnabled(true);      r1iv3.setEnabled(true);      r1iv4.setEnabled(true);      r1iv5.setEnabled(true);        r1iv6.setEnabled(true);
                    r2iv1.setEnabled(true);      r2iv2.setEnabled(true);      r2iv3.setEnabled(true);      r2iv4.setEnabled(true);      r2iv5.setEnabled(true);        r2iv6.setEnabled(true);
                    r3iv1.setEnabled(true);      r3iv2.setEnabled(true);      r3iv3.setEnabled(true);      r3iv4.setEnabled(true);      r3iv5.setEnabled(true);        r3iv6.setEnabled(true);
                    r4iv1.setEnabled(true);      r4iv2.setEnabled(true);      r4iv3.setEnabled(true);      r4iv4.setEnabled(true);      r4iv5.setEnabled(true);        r4iv6.setEnabled(true);
                    r5iv1.setEnabled(true);      r5iv2.setEnabled(true);      r5iv3.setEnabled(true);      r5iv4.setEnabled(true);      r5iv5.setEnabled(true);        r5iv6.setEnabled(true);
                    r6iv1.setEnabled(true);      r6iv2.setEnabled(true);      r6iv3.setEnabled(true);      r6iv4.setEnabled(true);      r6iv5.setEnabled(true);        r6iv6.setEnabled(true);

                    mChronometer = new Chronometer3(mContext);
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
                        total+=2;
                        if(total==36)
                        {
                            if (mChronometer.mIsRunning)
                            {
                                total=0;
                                co=0;
                                mChronometer.stop();
                                mThreadChrono.interrupt();
                                mChronometer=null;

                                final Dialog d=new Dialog(SixCrossSix.this);
                                d.setContentView(R.layout.level_completed_yes);

                                d.setCancelable(false);
                                Button play_again=(Button) d.findViewById(R.id.play_again);
                                Button next_level=(Button) d.findViewById(R.id.next_level);
                                Button last_level=(Button) d.findViewById(R.id.last_level);
                                last_level.setText("last level");
                                next_level.setText("soon...");

                                last_level.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i=new Intent(getApplicationContext(),FourCrossFour.class);
                                        startActivity(i);
                                        finish();
                                    }
                                });

                                d.show();
                                play_again.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        previousFlipped = null;
                                        currentFlipped = null;
                                        text_top.setText("00:000");

                                        mChronometer=null;
                                        previousInt = 0;
                                        currentInt = 0;

                                        newCardsFlipped = 0;
                                        total = 0;
                                        co = 0;

                                        animateBack(r1iv1, !true);animateBack(r1iv2, !true);animateBack(r1iv3, !true);animateBack(r1iv4, !true);animateBack(r1iv5, !true);animateBack(r1iv6, !true);
                                        animateBack(r2iv1, !true);animateBack(r2iv2, !true);animateBack(r2iv3, !true);animateBack(r2iv4, !true);animateBack(r2iv5, !true);animateBack(r2iv6, !true);
                                        animateBack(r3iv1, !true);animateBack(r3iv2, !true);animateBack(r3iv3, !true);animateBack(r3iv4, !true);animateBack(r3iv5, !true);animateBack(r3iv6, !true);
                                        animateBack(r4iv1, !true);animateBack(r4iv2, !true);animateBack(r4iv3, !true);animateBack(r4iv4, !true);animateBack(r4iv5, !true);animateBack(r4iv6, !true);
                                        animateBack(r5iv1, !true);animateBack(r5iv2, !true);animateBack(r5iv3, !true);animateBack(r5iv4, !true);animateBack(r5iv5, !true);animateBack(r5iv6, !true);
                                        animateBack(r6iv1, !true);animateBack(r6iv2, !true);animateBack(r6iv3, !true);animateBack(r6iv4, !true);animateBack(r6iv5, !true);animateBack(r6iv6, !true);

                                        start_button.setEnabled(true);
                                        d.dismiss();
                                    }
                                });




                            }
                        }
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


    public void onBackPressed(){

        final AlertDialog.Builder options= new AlertDialog.Builder(SixCrossSix.this);
        options.setTitle("Warning");
        options.setMessage("If you leave this level,you will lose your progress");


        options.setPositiveButton("Leave", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if(mChronometer!=null) {
                    mThreadChrono.interrupt();
                    mChronometer.stop();
                }

                SixCrossSix.super.onBackPressed();
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

    public void updateTimerText(final String time) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text_top.setText(time);
            }
        });
    }

    public void stopped()
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                AlertDialog.Builder adb=new AlertDialog.Builder(SixCrossSix.this);
                adb.setCancelable(false);
                adb.setTitle("You ran out of time");

                r1iv1.setEnabled(false);      r1iv2.setEnabled(false);      r1iv3.setEnabled(false);      r1iv4.setEnabled(false);      r1iv5.setEnabled(false);        r1iv6.setEnabled(false);
                r2iv1.setEnabled(false);      r2iv2.setEnabled(false);      r2iv3.setEnabled(false);      r2iv4.setEnabled(false);      r2iv5.setEnabled(false);        r2iv6.setEnabled(false);
                r3iv1.setEnabled(false);      r3iv2.setEnabled(false);      r3iv3.setEnabled(false);      r3iv4.setEnabled(false);      r3iv5.setEnabled(false);        r3iv6.setEnabled(false);
                r4iv1.setEnabled(false);      r4iv2.setEnabled(false);      r4iv3.setEnabled(false);      r4iv4.setEnabled(false);      r4iv5.setEnabled(false);        r4iv6.setEnabled(false);
                r5iv1.setEnabled(false);      r5iv2.setEnabled(false);      r5iv3.setEnabled(false);      r5iv4.setEnabled(false);      r5iv5.setEnabled(false);        r5iv6.setEnabled(false);
                r6iv1.setEnabled(false);      r6iv2.setEnabled(false);      r6iv3.setEnabled(false);      r6iv4.setEnabled(false);      r6iv5.setEnabled(false);        r6iv6.setEnabled(false);

                mChronometer=null;
                mThreadChrono.interrupt();
                total=0;
                co=0;

                adb.setPositiveButton("Retry Level", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        animateBack(r1iv1,false);     animateBack(r1iv2,false);     animateBack(r1iv3,false);     animateBack(r1iv4,false);     animateBack(r1iv5,false);     animateBack(r1iv6,false);
                        animateBack(r2iv1,false);     animateBack(r2iv2,false);     animateBack(r2iv3,false);     animateBack(r2iv4,false);     animateBack(r2iv5,false);     animateBack(r2iv6,false);
                        animateBack(r3iv1,false);     animateBack(r3iv2,false);     animateBack(r3iv3,false);     animateBack(r3iv4,false);     animateBack(r3iv5,false);     animateBack(r3iv6,false);
                        animateBack(r4iv1,false);     animateBack(r4iv2,false);     animateBack(r4iv3,false);     animateBack(r4iv4,false);     animateBack(r4iv5,false);     animateBack(r4iv6,false);
                        animateBack(r5iv1,false);     animateBack(r5iv2,false);     animateBack(r5iv3,false);     animateBack(r5iv4,false);     animateBack(r5iv5,false);     animateBack(r5iv6,false);
                        animateBack(r6iv1,false);     animateBack(r6iv2,false);     animateBack(r6iv3,false);     animateBack(r6iv4,false);     animateBack(r6iv5,false);     animateBack(r6iv6,false);

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


    public class Chronometer3 implements Runnable{

        private Context mContext;
        private long mStartTime;
        boolean mIsRunning;
        private long x=1000;

        public Chronometer3(Context context)
        {
            mContext=context;
        }

        public void start(){
            mStartTime=System.currentTimeMillis();
            mIsRunning=true;
        }

        public void stop() {
            mIsRunning=false;
        }

        @Override
        public void run() {
            while(mIsRunning)
            {
                long since=System.currentTimeMillis()-mStartTime;
                if(since>72000)
                {
                    timeAvailable=false;
                    ((SixCrossSix)mContext).stopped();
                    stop();
                    break;
                }

                long seconds=(int) since/x;
                long milliseconds=(int) (since)%x;

                ((SixCrossSix)mContext).updateTimerText(String.format("%02d:%03d",seconds,milliseconds));
            }
            mIsRunning=false;
        }

    }

}