package com.example.flipit;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
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

import com.example.clock.Chronometer2;
import com.example.clock.Chronometer3;

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


    private Chronometer3 mChronometer;
    private Thread mThreadChrono;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_six_cross_six);

        mContext=this;
        text_top=(TextView) findViewById(R.id.six_cross_six_top_text);
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

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r1iv1,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r1iv1,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r1iv1.getText().toString()=="BACK")
                            r1iv1.setText("FRONT");
                        else if(r1iv1.getText().toString()=="FRONT")
                            r1iv1.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r1iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r1iv2,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r1iv2,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r1iv2.getText().toString()=="BACK")
                            r1iv2.setText("FRONT");
                        else if(r1iv2.getText().toString()=="FRONT")
                            r1iv2.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r1iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r1iv3,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r1iv3,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r1iv3.getText().toString()=="BACK")
                            r1iv3.setText("FRONT");
                        else if(r1iv3.getText().toString()=="FRONT")
                            r1iv3.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r1iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r1iv4,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r1iv4,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r1iv4.getText().toString()=="BACK")
                            r1iv4.setText("FRONT");
                        else if(r1iv4.getText().toString()=="FRONT")
                            r1iv4.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r1iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r1iv5,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r1iv5,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r1iv5.getText().toString()=="BACK")
                            r1iv5.setText("FRONT");
                        else if(r1iv5.getText().toString()=="FRONT")
                            r1iv5.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r1iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r1iv6,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r1iv6,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r1iv6.getText().toString()=="BACK")
                            r1iv6.setText("FRONT");
                        else if(r1iv6.getText().toString()=="FRONT")
                            r1iv6.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });


        r2iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r2iv1,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r2iv1,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r2iv1.getText().toString()=="BACK")
                            r2iv1.setText("FRONT");
                        else if(r2iv1.getText().toString()=="FRONT")
                            r2iv1.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r2iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r2iv2,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r2iv2,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r2iv2.getText().toString()=="BACK")
                            r2iv2.setText("FRONT");
                        else if(r2iv2.getText().toString()=="FRONT")
                            r2iv2.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r2iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r2iv3,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r2iv3,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r2iv3.getText().toString()=="BACK")
                            r2iv3.setText("FRONT");
                        else if(r2iv3.getText().toString()=="FRONT")
                            r2iv3.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r2iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r2iv4,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r2iv4,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r2iv4.getText().toString()=="BACK")
                            r2iv4.setText("FRONT");
                        else if(r2iv4.getText().toString()=="FRONT")
                            r2iv4.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r2iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r2iv5,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r2iv5,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r2iv5.getText().toString()=="BACK")
                            r2iv5.setText("FRONT");
                        else if(r2iv5.getText().toString()=="FRONT")
                            r2iv5.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r2iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r2iv6,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r2iv6,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r2iv6.getText().toString()=="BACK")
                            r2iv6.setText("FRONT");
                        else if(r2iv6.getText().toString()=="FRONT")
                            r2iv6.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });


        r3iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r3iv1,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r3iv1,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r3iv1.getText().toString()=="BACK")
                            r3iv1.setText("FRONT");
                        else if(r3iv1.getText().toString()=="FRONT")
                            r3iv1.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r3iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r3iv2,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r3iv2,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r3iv2.getText().toString()=="BACK")
                            r3iv2.setText("FRONT");
                        else if(r3iv2.getText().toString()=="FRONT")
                            r3iv2.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r3iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r3iv3,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r3iv3,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r3iv3.getText().toString()=="BACK")
                            r3iv3.setText("FRONT");
                        else if(r3iv3.getText().toString()=="FRONT")
                            r3iv3.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r3iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r3iv4,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r3iv4,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r3iv4.getText().toString()=="BACK")
                            r3iv4.setText("FRONT");
                        else if(r3iv4.getText().toString()=="FRONT")
                            r3iv4.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r3iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r3iv5,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r3iv5,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r3iv5.getText().toString()=="BACK")
                            r3iv5.setText("FRONT");
                        else if(r3iv5.getText().toString()=="FRONT")
                            r3iv5.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r3iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r3iv6,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r3iv6,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r3iv6.getText().toString()=="BACK")
                            r3iv6.setText("FRONT");
                        else if(r3iv6.getText().toString()=="FRONT")
                            r3iv6.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });



        r4iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r4iv1,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r4iv1,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r4iv1.getText().toString()=="BACK")
                            r4iv1.setText("FRONT");
                        else if(r4iv1.getText().toString()=="FRONT")
                            r4iv1.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r4iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r4iv2,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r4iv2,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r4iv2.getText().toString()=="BACK")
                            r4iv2.setText("FRONT");
                        else if(r4iv2.getText().toString()=="FRONT")
                            r4iv2.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r4iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r4iv3,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r4iv3,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r4iv3.getText().toString()=="BACK")
                            r4iv3.setText("FRONT");
                        else if(r4iv3.getText().toString()=="FRONT")
                            r4iv3.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r4iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r4iv4,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r4iv4,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r4iv4.getText().toString()=="BACK")
                            r4iv4.setText("FRONT");
                        else if(r4iv4.getText().toString()=="FRONT")
                            r4iv4.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r4iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r4iv5,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r4iv5,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r4iv5.getText().toString()=="BACK")
                            r4iv5.setText("FRONT");
                        else if(r4iv5.getText().toString()=="FRONT")
                            r4iv5.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r4iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r4iv6,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r4iv6,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r4iv6.getText().toString()=="BACK")
                            r4iv6.setText("FRONT");
                        else if(r4iv6.getText().toString()=="FRONT")
                            r4iv6.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });



        r5iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r5iv1,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r5iv1,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r5iv1.getText().toString()=="BACK")
                            r5iv1.setText("FRONT");
                        else if(r5iv1.getText().toString()=="FRONT")
                            r5iv1.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r5iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r5iv2,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r5iv2,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r5iv2.getText().toString()=="BACK")
                            r5iv2.setText("FRONT");
                        else if(r5iv2.getText().toString()=="FRONT")
                            r5iv2.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r5iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r5iv3,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r5iv3,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r5iv3.getText().toString()=="BACK")
                            r5iv3.setText("FRONT");
                        else if(r5iv3.getText().toString()=="FRONT")
                            r5iv3.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r5iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r5iv4,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r5iv4,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r5iv4.getText().toString()=="BACK")
                            r5iv4.setText("FRONT");
                        else if(r5iv4.getText().toString()=="FRONT")
                            r5iv4.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r5iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r5iv5,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r5iv5,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r5iv5.getText().toString()=="BACK")
                            r5iv5.setText("FRONT");
                        else if(r5iv5.getText().toString()=="FRONT")
                            r5iv5.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r5iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r5iv6,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r5iv6,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r5iv6.getText().toString()=="BACK")
                            r5iv6.setText("FRONT");
                        else if(r5iv6.getText().toString()=="FRONT")
                            r5iv6.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });




        r6iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r6iv1,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r6iv1,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r6iv1.getText().toString()=="BACK")
                            r6iv1.setText("FRONT");
                        else if(r6iv1.getText().toString()=="FRONT")
                            r6iv1.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r6iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r6iv2,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r6iv2,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r6iv2.getText().toString()=="BACK")
                            r6iv2.setText("FRONT");
                        else if(r6iv2.getText().toString()=="FRONT")
                            r6iv2.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r6iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r6iv3,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r6iv3,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r6iv3.getText().toString()=="BACK")
                            r6iv3.setText("FRONT");
                        else if(r6iv3.getText().toString()=="FRONT")
                            r6iv3.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r6iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r6iv4,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r6iv4,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r6iv4.getText().toString()=="BACK")
                            r6iv4.setText("FRONT");
                        else if(r6iv4.getText().toString()=="FRONT")
                            r6iv4.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r6iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r6iv5,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r6iv5,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r6iv5.getText().toString()=="BACK")
                            r6iv5.setText("FRONT");
                        else if(r6iv5.getText().toString()=="FRONT")
                            r6iv5.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r6iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;

                ObjectAnimator anime1=ObjectAnimator.ofFloat(r6iv6,"scaleX",1f,0f);
                final ObjectAnimator anime2=ObjectAnimator.ofFloat(r6iv6,"scaleX",0f,1f);

                anime1.setInterpolator(new DecelerateInterpolator());
                anime1.setDuration(100);

                anime2.setInterpolator(new AccelerateInterpolator());
                anime2.setDuration(100);

                anime1.start();
                anime1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        if(r6iv6.getText().toString()=="BACK")
                            r6iv6.setText("FRONT");
                        else if(r6iv6.getText().toString()=="FRONT")
                            r6iv6.setText("BACK");
                        anime2.start();
                    }
                });

                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });




        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mChronometer == null)
                {
                    mChronometer = new Chronometer3(mContext);
                    mThreadChrono=new Thread(mChronometer);
                    mThreadChrono.start();
                    mChronometer.start();
                }
            }
        });

    }

    public void onBackPressed(){


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

    public void updateTimerText(final String time) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text_top.setText(time);
            }
        });
    }
}