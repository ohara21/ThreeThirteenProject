package com.example.threethirteenproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class GameBoard extends SurfaceView {

    private Paint bluePaint = new Paint();
    public GameBoard(Context context) {
        super(context);
    }

    public GameBoard(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GameBoard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onDraw(Canvas canvas){
        Bitmap tenOfClubs = BitmapFactory.decodeResource(getResources(), R.drawable.ten_of_clubs);
        Bitmap scaledTenOfClubs = Bitmap.createScaledBitmap(tenOfClubs,148, 215,true);
        canvas.drawColor(Color.GREEN);
        canvas.drawBitmap(scaledTenOfClubs, 100, 100, null);
    }


}
