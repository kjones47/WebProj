package com.example.android.webproj;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PixelFormat;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

public class Surface extends SurfaceView implements SurfaceHolder.Callback  {

    private SurfaceHolder surfaceHolder = null;
    private Paint paint = null;
    private float circleX = 0;
    private float circleY = 0;

    public Surface(Context context) {
        super(context);

        surfaceHolder = getHolder();

        paint = new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        drawBall();
    }
    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        paint = null;

    }
    public void drawBall()
    {
        surfaceHolder = getHolder();

        // Get and lock canvas object from surfaceHolder.
        Canvas canvas = surfaceHolder.lockCanvas();

        Paint surfaceBackground = new Paint();
        // Set the surfaceview background color.
        surfaceBackground.setColor(Color.BLACK);
        // Draw the surfaceview background color.
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);

        // Draw the circle.
        paint.setColor(Color.RED);
        canvas.drawCircle(circleX, circleY, 100, paint);

        canvas.drawCircle(50, 50, 200, paint);

        // Unlock the canvas object and post the new draw.
        surfaceHolder.unlockCanvasAndPost(canvas);
    }
}