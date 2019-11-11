package com.example.android.coloring;

import android.content.Intent;
import android.os.Bundle;

import com.example.android.proj5.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class Main2Activity extends AppCompatActivity implements View.OnTouchListener{

    private LinearLayout canvasLayout = null;

    Surface customSurfaceView = null;
    private int [][] colors = new int [16][16];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button one = findViewById(R.id.button);
        Button two = findViewById(R.id.button2);
        Button three = findViewById(R.id.button3);

        setTitle("SurfaceView");

        initControls();
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        customSurfaceView = new Surface(getApplicationContext());
        customSurfaceView.setOnTouchListener(this);
        canvasLayout.addView(customSurfaceView);


    }

    private void initControls()
    {
        // This layout is used to contain custom surfaceview object.
        if(canvasLayout == null)
        {
            canvasLayout = (LinearLayout)findViewById(R.id.customViewLayout);
        }
    }

    public int[][] getArr(){
        return colors;
    }


    /* If user finger touch the surfaceview object. */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        // If user touch the custom SurfaceView object.
        if(view instanceof SurfaceView) {
            view.invalidate();

            float x = motionEvent.getX();

            float y = motionEvent.getY();

            customSurfaceView.setCircleX(x);

            customSurfaceView.setCircleY(y);

            customSurfaceView.editArray(customSurfaceView.getArray(), (int)x/68, (int)y/68, 2);


            // Create and set a red paint to custom surfaceview.
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            customSurfaceView.setPaint(paint);
            customSurfaceView.drawPuzzle();

            // Tell android os the onTouch event has been processed.
            return true;
        }else
        {
            // Tell android os the onTouch event has not been processed.
            return false;
        }
    }
}
