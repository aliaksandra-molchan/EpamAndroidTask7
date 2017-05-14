package com.epam.androidlab.epamandroidtask7;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

public class Smile extends View {

    public Smile(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(ContextCompat.getColor(this.getContext(), R.color.yellow));
        canvas.drawCircle(550, 600, 100, p);
        p.setColor(ContextCompat.getColor(this.getContext(), R.color.white));
        canvas.drawCircle(510, 570, 25, p);
        canvas.drawCircle(590, 570, 25, p);
        p.setColor(ContextCompat.getColor(this.getContext(), R.color.black));
        canvas.drawCircle(510, 570, 10, p);
        canvas.drawCircle(590, 570, 10, p);
        p.setColor(ContextCompat.getColor(this.getContext(), R.color.yellowDark));
        RectF oval = new RectF();
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(10);
        oval.set(500, 620, 600, 690);
        canvas.drawArc(oval, 180, 180, false, p);
    }
}