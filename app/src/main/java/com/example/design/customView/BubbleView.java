package com.example.design.customView;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BubbleView extends View {
    private int bubbleMaxRadius = 30;
    private int bubbleMinRadius = 5;
    private int bubbleMaxSize = 30;
    private int bubbleRefreshTime = 20;
    private int bubbleMaxSpeedY = 5;
    private int bubbleAlpha = 128;

    private float bottleWidth;
    private float bottleHeight;
    private float bottleRadius;
    private float bottleBorder;
    private float bottleCapRadius;
    private float waterHeight;

    private RectF contentRectF;
    private RectF waterRectF;

    private Path bottlePath;
    private Path waterPath;

    private Paint bottlePaint;
    private Paint waterPaint;
    private Paint bubblePaint;

    public BubbleView(Context context) {
        super(context);
    }

    public BubbleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.d("BubbleView", "constructor doing ");
        waterRectF = new RectF();

        bottleWidth = dp2px(130);
        bottleHeight = dp2px(260);
        bottleBorder = dp2px(8);
        bottleCapRadius = dp2px(5);
        bottleRadius = dp2px(15);

        waterHeight = dp2px(240);

        bottlePath = new Path();
        waterPath = new Path();

        bottlePaint = new Paint();
        bottlePaint.setAntiAlias(true);
        bottlePaint.setStyle(Paint.Style.STROKE);
        bottlePaint.setStrokeCap(Paint.Cap.ROUND);
        bottlePaint.setColor(Color.WHITE);
        bottlePaint.setStrokeWidth(bottleBorder);

        waterPaint = new Paint();
        waterPaint.setAntiAlias(true);

        initBubble();
    }

    public BubbleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

    public BubbleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr,
                      int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private float dp2px(float dpValue) {
        Log.d("BubbleView", "dp2px doing ");
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue,
                getResources().getDisplayMetrics());
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Log.d("BubbleView", "onSizeChanged doing ");
        super.onSizeChanged(w, h, oldw, oldh);
        contentRectF = new RectF(getPaddingLeft(), getPaddingTop(), w - getPaddingRight(),
                h - getPaddingBottom());


        float bl = contentRectF.centerX() - bottleWidth / 2;
        float bt = contentRectF.centerY() - bottleHeight / 2;
        float br = contentRectF.centerX() + bottleWidth / 2;
        float bb = contentRectF.centerY() + bottleHeight / 2;

        bottlePath.reset();
        bottlePath.moveTo(bl - bottleCapRadius, bt - bottleCapRadius);
        bottlePath.quadTo(bl, bt - bottleCapRadius, bl, bt);
        bottlePath.lineTo(bl, bb - bottleRadius);
        bottlePath.quadTo(bl, bb, bl + bottleRadius, bb);

        bottlePath.lineTo(br - bottleRadius, bb);
        bottlePath.quadTo(br, bb, br, bb - bottleRadius);
        bottlePath.lineTo(br, bt);
        bottlePath.quadTo(br, bt - bottleCapRadius, br + bottleCapRadius, bt - bottleCapRadius);


        waterPath.reset();
        waterPath.moveTo(bl, bb - waterHeight);
        waterPath.lineTo(bl, bb - bottleRadius);
        waterPath.quadTo(bl, bb, bl + bottleRadius, bb);
        waterPath.lineTo(br - bottleRadius, bb);
        waterPath.quadTo(br, bb, br, bb - bottleRadius);
        waterPath.lineTo(br, bb - waterHeight);
        waterPath.close();


        waterRectF.set(bl, bb - waterHeight, br, bb);

        LinearGradient linearGradient = new LinearGradient(waterRectF.centerX(), waterRectF.top,
                waterRectF.centerX(), waterRectF.bottom, 0xFF4286f4, 0xFF373B44,
                Shader.TileMode.CLAMP);
        waterPaint.setShader(linearGradient);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        Log.d("BubbleView", "onDraw doing ");
        super.onDraw(canvas);
        canvas.drawPath(waterPath, waterPaint);
        canvas.drawPath(bottlePath, bottlePaint);
        drawBubble(canvas);
    }

    @Override
    protected void onAttachedToWindow() {
        Log.d("BubbleView", "onAttachedToWindow doing ");
        super.onAttachedToWindow();
        startBubbleSync();
    }

    @Override
    protected void onDetachedFromWindow() {
        Log.d("BubbleView", "onDetachedFromWindow doing ");
        super.onDetachedFromWindow();
        stopBubbleSync();
    }


    private class Bubble {
        int radius;     // 气泡半径
        float speedY;   // 上升速度
        float speedX;   // 平移速度
        float x;        // 气泡x坐标
        float y;        // 气泡y坐标
    }

    private ArrayList<Bubble> bubbles = new ArrayList<>();
    private Random random = new Random();
    private Thread bubbleThread;

    private void drawBubble(Canvas canvas) {
        Log.d("BubbleView", "drawBubble doing ");
        List<Bubble> list = new ArrayList<>(bubbles);
        for (Bubble bubble : list) {
            canvas.drawCircle(bubble.x, bubble.y, bubble.radius, bubblePaint);
        }

    }

    private void startBubbleSync() {
        Log.d("BubbleView", "startBubbleSync doing ");
        stopBubbleSync();
        bubbleThread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(bubbleRefreshTime);
                        tryCreateBubble();
                        refreshBubbleView();
                        postInvalidate();
                    } catch (InterruptedException e) {
                        Log.d("BubbleView", "Bubble 线程结束");
                        e.printStackTrace();
                    }
                }

            }
        };

        bubbleThread.start();

    }

    private void tryCreateBubble() {
        Log.d("BubbleView", "tryCreateBubble doing ");
        if (null == contentRectF) return;
        if (bubbles.size() > bubbleMaxSize) return;
        if (random.nextFloat() < 0.95) return;

        Bubble bubble = new Bubble();
        int radius = random.nextInt(bubbleMaxRadius - bubbleMinRadius);
        radius += bubbleMinRadius;
        float speedY = random.nextFloat() * bubbleMaxSpeedY;
        while (speedY < 1) {
            speedY = random.nextFloat() * bubbleMaxSpeedY;
        }
        bubble.radius = radius;
        bubble.speedY = speedY;
        bubble.x = waterRectF.centerX();
        bubble.y = waterRectF.bottom - radius - bottleBorder / 2;

        float speedX = random.nextFloat() - 0.5f;
        while (speedX == 0) {
            speedX = random.nextFloat() - 0.5f;
        }
        bubble.speedX = speedX * 2;

        bubbles.add(bubble);
    }

    private void stopBubbleSync() {
        Log.d("BubbleView", "stopBubbleSync doing ");
        if (bubbleThread == null) {
            return;
        }
        bubbleThread.interrupt();
        bubbleThread = null;
    }

    private void initBubble() {
        Log.d("BubbleView", "initBubble doing ");
        bubblePaint = new Paint();
        bubblePaint.setColor(Color.WHITE);
        bubblePaint.setAlpha(bubbleAlpha);

    }

    private void refreshBubbleView() {
        Log.d("BubbleView", "refreshBubbleView doing ");
        List<Bubble> list = new ArrayList<>(bubbles);
        for (Bubble bubble : list) {
            if (bubble.y - bubble.speedY <= waterRectF.top + bubble.radius) {
                bubbles.remove(bubble);
            } else {
                int i = bubbles.indexOf(bubble);
                if (bubble.x + bubble.speedX < waterRectF.left + bubble.radius + bottleBorder / 2) {
                    bubble.x = waterRectF.left + bubble.radius + bottleBorder / 2;
                } else if (bubble.x + bubble.speedX >= waterRectF.right - bubble.radius - bottleBorder / 2) {
                    bubble.x = waterRectF.right - bubble.radius - bottleBorder / 2;
                } else {
                    bubble.x = bubble.x + bubble.speedX;
                }
                bubble.y = bubble.y - bubble.speedY;
                bubbles.set(i, bubble);
            }

        }

    }

}
