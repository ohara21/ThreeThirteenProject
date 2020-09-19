package com.example.threethirteenproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;

public class GameBoard extends SurfaceView {

    float viewWidth;
    float viewHeight;
    float midWidth;
    float midHeight;
    float discardWidth;
    float stockWidth;
    float topY;
    float botY;

    //Matrix rotate = new Matrix();

    Card tenClubsCard = new Card(1);
    Card backCard = new Card(2);

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

        //initialize coordinates based on the GameBoard's dimensions
        viewWidth = this.getWidth();
        viewHeight = this.getHeight();
        midWidth = viewWidth/2;
        midHeight = viewHeight/2 - tenClubsCard.getWidth()/2;
        discardWidth = midWidth - tenClubsCard.getWidth() - 50;
        stockWidth = midWidth + 50;
        topY = midHeight - tenClubsCard.getHeight() - 75;
        botY = midHeight + tenClubsCard.getHeight() + 75;

        /**
         * External Citation:
         * Date: 9/18/20
         * Problem: Didn't know how to rotate Bitmap image
         * Resource: https://stackoverflow.com/questions/9015372/how-to-rotate-a-bitmap-90-degrees
         * Solution: used the method suggested
         *
         * External Citation:
         * Date: 9/18/20
         * Problem: Didn't know how to create Bitmap image
         * Resource: Professor Nuxoll
         * Solution: used his code
         */
        //rotate.postRotate(90);
        Bitmap tenClubs = BitmapFactory.decodeResource(getResources(), R.drawable.ten_of_clubs);
        Bitmap tenOfClubs = Bitmap.createScaledBitmap(tenClubs,tenClubsCard.getWidth(), tenClubsCard.getHeight(),true);
        //Bitmap tenOfClubsHor = Bitmap.createBitmap(tenOfClubs, 0, 0, tenClubsCard.getWidth(), tenClubsCard.getHeight(), rotate, true);
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.back_vert);
        Bitmap back = Bitmap.createScaledBitmap(b,backCard.getWidth(), backCard.getHeight(),true);
        //Bitmap backHor = Bitmap.createBitmap(back, 0, 0, backCard.getWidth(), backCard.getHeight(), rotate, true);

        canvas.drawBitmap(tenOfClubs, discardWidth, midHeight, null);
        canvas.drawBitmap(back, stockWidth, midHeight, null);
        canvas.drawBitmap(back, 100, topY, null);
        canvas.drawBitmap(tenOfClubs, 100, botY, null);
    }


}
