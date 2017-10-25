package com.fengan.audiocolumnview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by fengan on 2017/10/25/025.
 */

public class AudioColumnView extends View {
    private int columnNum = 5;
    private int random;
    private boolean isStart = true;
    private Random mRandom;
    private int mRect_t1;
    private int mRect_t2;
    private int mRect_t3;
    private int mRect_t4;
    private int mRect_t5;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x1234) {
                invalidate();
            }
        }
    };
    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    private double mRect_w;
    private RectF r1;
    private RectF r2;
    private RectF r3;
    private RectF r4;
    private RectF r5;
    public AudioColumnView(Context context) {
        this(context, null);
    }

    public AudioColumnView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public AudioColumnView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mRandom = new Random();
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL);
        r1 = new RectF();
        r2 = new RectF();
        r3 = new RectF();
        r4 = new RectF();
        r5 = new RectF();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
        mRect_w = mWidth/(2*columnNum+1);
        random =mHeight / 5;
    }

    public void start(){
        isStart = true;
        invalidate();
    }

    public void stop(){
        isStart = false;
        invalidate();
    }

    public boolean isStart(){
        return isStart;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isStart) {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    mRect_t1 = mRandom.nextInt(random);
                    mRect_t2 = mRandom.nextInt(random);
                    mRect_t3 = mRandom.nextInt(random);
                    mRect_t4 = mRandom.nextInt(random);
                    mRect_t5 = mRandom.nextInt(random);
                    mHandler.sendEmptyMessage(0x1234);
                }
            },300);
        }
        //画柱状；动态图，就要改变柱状的top值
        r1.set((float) (mRect_w),mRect_t1*5,(float)( mRect_w*2),(float) (mHeight*0.9));
        r2.set((float) (mRect_w*3),mRect_t2*5,(float)(mRect_w*4),(float) (mHeight*0.9));
        r3.set((float) (mRect_w*5),mRect_t3*5,(float)(mRect_w*6),(float) (mHeight*0.9));
        r4.set((float) (mRect_w*7),mRect_t4*5,(float)( mRect_w*8),(float) (mHeight*0.9));
        r5.set((float) (mRect_w*9),mRect_t5*5,(float)(mRect_w*10),(float) (mHeight*0.9));
        canvas.drawRect(r1,mPaint);
        canvas.drawRect(r2,mPaint);
        canvas.drawRect(r3,mPaint);
        canvas.drawRect(r4,mPaint);
        canvas.drawRect(r5,mPaint);
    }
}
