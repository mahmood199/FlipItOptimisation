package com.example.flipit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
//import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clock.Chronometer;

public class FourCrossFour extends AppCompatActivity {


    private Button    start_timer, row1iv1 ,row1iv2 ,row1iv3 ,row1iv4 ,
                                   row2iv1 ,row2iv2 ,row2iv3 ,row2iv4 ,
                                   row3iv1 ,row3iv2 ,row3iv3 ,row3iv4 ,
                                   row4iv1 ,row4iv2 ,row4iv3 ,row4iv4 ;
    private long BackPressedTime;
    private Toast backToast;
    private TextView text_below,text_top;
    private int co=0;

    private Chronometer mChronometer;
    private Thread mThreadChrono;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_four_cross_four);

        text_below=(TextView) findViewById(R.id.four_cross_four_bottom_text);
        start_timer=(Button) findViewById(R.id.start_timer);
        text_top=(TextView) findViewById(R.id.four_cross_four_top_text);
        mContext=this;


        row1iv1=(Button) findViewById(R.id.first_row_first_image);
        row1iv2=(Button) findViewById(R.id.first_row_second_image);
        row1iv3=(Button) findViewById(R.id.first_row_third_image);
        row1iv4=(Button) findViewById(R.id.first_row_fourth_image);

        row2iv1=(Button) findViewById(R.id.second_row_first_image);
        row2iv2=(Button) findViewById(R.id.second_row_second_image);
        row2iv3=(Button) findViewById(R.id.second_row_third_image);
        row2iv4=(Button) findViewById(R.id.second_row_fourth_image);

        row3iv1=(Button) findViewById(R.id.third_row_first_image);
        row3iv2=(Button) findViewById(R.id.third_row_second_image);
        row3iv3=(Button) findViewById(R.id.third_row_third_image);
        row3iv4=(Button) findViewById(R.id.third_row_fourth_image);

        row4iv1=(Button) findViewById(R.id.fourth_row_first_image);
        row4iv2=(Button) findViewById(R.id.fourth_row_second_image);
        row4iv3=(Button) findViewById(R.id.fourth_row_third_image);
        row4iv4=(Button) findViewById(R.id.fourth_row_fourth_image);

        row1iv1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row1iv2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row1iv3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row1iv4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row2iv1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row2iv2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row2iv3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row2iv4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row3iv1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row3iv2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row3iv3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row3iv4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row4iv1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row4iv2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row4iv3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });

        row4iv4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed:"+co+"\n");
            }
        });


        start_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mChronometer == null)
                {
                    mChronometer = new Chronometer(mContext);
                    mThreadChrono=new Thread(mChronometer);
                    mThreadChrono.start();
                    mChronometer.start();
                }
            }
        });
    }


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

    public void updateTimerText(final String time) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text_top.setText(time);
            }
        });
    }
}

