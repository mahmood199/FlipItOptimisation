package com.example.flipit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
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

        r1iv1=(Button) findViewById(R.id.sxs_first_row_first_image);
        r1iv2=(Button) findViewById(R.id.sxs_first_row_second_image);
        r1iv3=(Button) findViewById(R.id.sxs_first_row_third_image);
        r1iv4=(Button) findViewById(R.id.sxs_first_row_fourth_image);
        r1iv5=(Button) findViewById(R.id.sxs_first_row_fifth_image);
        r1iv6=(Button) findViewById(R.id.sxs_first_row_sixth_image);

        r2iv1=(Button) findViewById(R.id.sxs_second_row_first_image);
        r2iv2=(Button) findViewById(R.id.sxs_second_row_second_image);
        r2iv3=(Button) findViewById(R.id.sxs_second_row_third_image);
        r2iv4=(Button) findViewById(R.id.sxs_second_row_fourth_image);
        r2iv5=(Button) findViewById(R.id.sxs_second_row_fifth_image);
        r2iv6=(Button) findViewById(R.id.sxs_second_row_sixth_image);

        r3iv1=(Button) findViewById(R.id.sxs_third_row_first_image);
        r3iv2=(Button) findViewById(R.id.sxs_third_row_second_image);
        r3iv3=(Button) findViewById(R.id.sxs_third_row_third_image);
        r3iv4=(Button) findViewById(R.id.sxs_third_row_fourth_image);
        r3iv5=(Button) findViewById(R.id.sxs_third_row_fifth_image);
        r3iv6=(Button) findViewById(R.id.sxs_third_row_sixth_image);

        r4iv1=(Button) findViewById(R.id.sxs_fourth_row_first_image);
        r4iv2=(Button) findViewById(R.id.sxs_fourth_row_second_image);
        r4iv3=(Button) findViewById(R.id.sxs_fourth_row_third_image);
        r4iv4=(Button) findViewById(R.id.sxs_fourth_row_fourth_image);
        r4iv5=(Button) findViewById(R.id.sxs_fourth_row_fifth_image);
        r4iv6=(Button) findViewById(R.id.sxs_fourth_row_sixth_image);

        r5iv1=(Button) findViewById(R.id.sxs_fifth_row_first_image);
        r5iv2=(Button) findViewById(R.id.sxs_fifth_row_second_image);
        r5iv3=(Button) findViewById(R.id.sxs_fifth_row_third_image);
        r5iv4=(Button) findViewById(R.id.sxs_fifth_row_fourth_image);
        r5iv5=(Button) findViewById(R.id.sxs_fifth_row_fifth_image);
        r5iv6=(Button) findViewById(R.id.sxs_fifth_row_sixth_image);

        r6iv1=(Button) findViewById(R.id.sxs_sixth_row_first_image);
        r6iv2=(Button) findViewById(R.id.sxs_sixth_row_second_image);
        r6iv3=(Button) findViewById(R.id.sxs_sixth_row_third_image);
        r6iv4=(Button) findViewById(R.id.sxs_sixth_row_fourth_image);
        r6iv5=(Button) findViewById(R.id.sxs_sixth_row_fifth_image);
        r6iv6=(Button) findViewById(R.id.sxs_sixth_row_sixth_image);



        r1iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r1iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r1iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r1iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r1iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r1iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });


        r2iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r2iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r2iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r2iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r2iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r2iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });


        r3iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r3iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r3iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r3iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r3iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r3iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });



        r4iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r4iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r4iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r4iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r4iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r4iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });



        r5iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r5iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r5iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r5iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r5iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r5iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });




        r6iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r6iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r6iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r6iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r6iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
                text_below.setText("Number of times button pressed: "+co+"\n");
            }
        });

        r6iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                co++;
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