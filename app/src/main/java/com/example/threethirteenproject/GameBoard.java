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

    /*
    We should create an object array for the deck and another object array to hold all the used cards/ discard
    cards in the game since we can't have two of the same card if we are only using one deck
     */
    Card tenClubsCard = new Card(1,'s',10);
    Card tenHeartsCard = new Card(1,'h',10);
    Card tenSpadesCard = new Card(1,'s',10);
    Card tenDiamondsCard = new Card(1,'d',10);
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

    /**
     * This function draws the specified card object to a given x and y on a given canvas
     * Works for both front and back showing cards
     */
    /** External Citation:
     * Date: 9/18/20
     * Problem: Didn't know how to create Bitmap image
     * Resource: Professor Nuxoll
     * Solution: used his code
     */
    public void drawCard(Canvas canvas, float x, float y, Card card){


        Bitmap tempObj = BitmapFactory.decodeResource(getResources(), card.cardId);
        Bitmap cardObj = Bitmap.createScaledBitmap(tempObj,card.getWidth(),card.getHeight(),true);

        canvas.drawBitmap(cardObj, x, y, null);
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
         */
        //rotate.postRotate(90);


        drawCard(canvas, discardWidth, midHeight, tenClubsCard);
        drawCard(canvas, stockWidth, midHeight, backCard);
        drawCard(canvas, 300, topY, backCard);
        drawCard(canvas,400,topY,backCard);
        drawCard(canvas,500,topY,backCard);
        drawCard(canvas, 300, botY, tenSpadesCard);
        drawCard(canvas,400,botY,tenHeartsCard);
        drawCard(canvas,500,botY,tenDiamondsCard);

    }







}
