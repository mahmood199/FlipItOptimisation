package com.example.clock;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.flipit.SixCrossSix;


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
            if(since>37000)
                break;
            since=(37000-since);
            long seconds=(int) since/x;
            long milliseconds=(int) (since)%x;

            ((SixCrossSix)mContext).updateTimerText(String.format("%02d:%03d",seconds,milliseconds));
        }

        mIsRunning=false;
    }
}
