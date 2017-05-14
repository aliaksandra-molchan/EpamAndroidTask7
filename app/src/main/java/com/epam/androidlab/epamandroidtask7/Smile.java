package com.epam.androidlab.epamandroidtask7;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

public class Smile extends View {
    private static final int STROKE_WIDTH = 10;

    private float radius;
    private float centerX;
    private float centerY;

    private Paint bodyPaint;
    private Paint smilePaint;
    private Paint eyePaint;
    private Paint sheenPaint;
    private RectF smileOval;

    public Smile(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        bodyPaint = new Paint();
        bodyPaint.setColor(ContextCompat.getColor(this.getContext(), R.color.yellow));
        smilePaint = new Paint();
        smilePaint.setColor(ContextCompat.getColor(this.getContext(), R.color.yellowDark));
        smilePaint.setStyle(Paint.Style.STROKE);
        smilePaint.setStrokeWidth(STROKE_WIDTH);
        smileOval = new RectF();
        eyePaint = new Paint();
        eyePaint.setColor(ContextCompat.getColor(this.getContext(), R.color.white));
        sheenPaint = new Paint();
        sheenPaint.setColor(ContextCompat.getColor(this.getContext(), R.color.grey));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        centerX = getWidth() / 2;
        centerY = getHeight() / 2;
        radius = centerX / 6;

        float eyeRadius = radius / 5;
        float eyeCenter = radius / 4;
        float sheenRadius = eyeRadius / 2;
        float smileRadius = radius / 2;

        canvas.drawCircle(centerX, centerY, radius, bodyPaint);
        canvas.drawCircle(centerX - eyeCenter, centerY - eyeCenter, eyeRadius, eyePaint);
        canvas.drawCircle(centerX + eyeCenter, centerY - eyeCenter, eyeRadius, eyePaint);
        canvas.drawCircle(centerX - eyeCenter, centerY - eyeCenter, sheenRadius, sheenPaint);
        canvas.drawCircle(centerX + eyeCenter, centerY - eyeCenter, sheenRadius, sheenPaint);
        smileOval.set(centerX - smileRadius, centerY + smileRadius / 2, centerX + smileRadius, (float) (centerY + 1.5 * smileRadius));
        canvas.drawArc(smileOval, 180, 180, false, smilePaint);
    }

}