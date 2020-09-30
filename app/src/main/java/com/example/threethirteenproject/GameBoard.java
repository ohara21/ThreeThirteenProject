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

    //instance variables that will define locations on the GameBoard
    float viewWidth;
    float viewHeight;
    float midWidth;
    float midHeight;
    float discardWidth;
    float stockWidth;
    float topY;
    float botY;

    //used to rotate the card images
    Matrix rotate = new Matrix();

    //create all 53 card objects
    Card backCard = new Card(2);
    Card aceClubsCard = new Card(1,'c',1);
    Card aceHeartsCard = new Card(1,'h',1);
    Card aceSpadesCard = new Card(1,'s',1);
    Card aceDiamondsCard = new Card(1,'d',1);
    Card twoClubsCard = new Card(1,'c',2);
    Card twoHeartsCard = new Card(1,'h',2);
    Card twoSpadesCard = new Card(1,'s',2);
    Card twoDiamondsCard = new Card(1,'d',2);
    Card threeClubsCard = new Card(1,'c',3);
    Card threeHeartsCard = new Card(1,'h',3);
    Card threeSpadesCard = new Card(1,'s',3);
    Card threeDiamondsCard = new Card(1,'d',3);
    Card fourClubsCard = new Card(1,'c',4);
    Card fourHeartsCard = new Card(1,'h',4);
    Card fourSpadesCard = new Card(1,'s',4);
    Card fourDiamondsCard = new Card(1,'d',4);
    Card fiveClubsCard = new Card(1,'c',5);
    Card fiveHeartsCard = new Card(1,'h',5);
    Card fiveSpadesCard = new Card(1,'s',5);
    Card fiveDiamondsCard = new Card(1,'d',5);
    Card sixClubsCard = new Card(1,'c',6);
    Card sixHeartsCard = new Card(1,'h',6);
    Card sixSpadesCard = new Card(1,'s',6);
    Card sixDiamondsCard = new Card(1,'d',6);
    Card sevenClubsCard = new Card(1,'c',7);
    Card sevenHeartsCard = new Card(1,'h',7);
    Card sevenSpadesCard = new Card(1,'s',7);
    Card sevenDiamondsCard = new Card(1,'d',7);
    Card eightClubsCard = new Card(1,'c',8);
    Card eightHeartsCard = new Card(1,'h',8);
    Card eightSpadesCard = new Card(1,'s',8);
    Card eightDiamondsCard = new Card(1,'d',8);
    Card nineClubsCard = new Card(1,'c',9);
    Card nineHeartsCard = new Card(1,'h',9);
    Card nineSpadesCard = new Card(1,'s',9);
    Card nineDiamondsCard = new Card(1,'d',9);
    Card tenClubsCard = new Card(1,'c',10);
    Card tenHeartsCard = new Card(1,'h',10);
    Card tenSpadesCard = new Card(1,'s',10);
    Card tenDiamondsCard = new Card(1,'d',10);
    Card jackClubsCard = new Card(1,'c',11);
    Card jackHeartsCard = new Card(1,'h',11);
    Card jackSpadesCard = new Card(1,'s',11);
    Card jackDiamondsCard = new Card(1,'d',11);
    Card queenClubsCard = new Card(1,'c',12);
    Card queenHeartsCard = new Card(1,'h',12);
    Card queenSpadesCard = new Card(1,'s',12);
    Card queenDiamondsCard = new Card(1,'d',12);
    Card kingClubsCard = new Card(1,'c',13);
    Card kingHeartsCard = new Card(1,'h',13);
    Card kingSpadesCard = new Card(1,'s',13);
    Card kingDiamondsCard = new Card(1,'d',13);

    /**
     * constructors that were inherited from SurfaceView class
     */
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

    /**
     * draws a rotated card, used for the discard and stock pile
     * @param canvas
     * @param x
     * @param y
     * @param card
     */
    /**
     * External Citation:
     * Date: 9/18/20
     * Problem: Didn't know how to rotate Bitmap image
     * Resource: https://stackoverflow.com/questions/9015372/how-to-rotate-a-bitmap-90-degrees
     * Solution: used the method suggested
     */
    public void drawRotCard(Canvas canvas, float x, float y, Card card){

        Bitmap tempObj = BitmapFactory.decodeResource(getResources(), card.cardId);
        Bitmap cardObj = Bitmap.createScaledBitmap(tempObj,card.getWidth(),card.getHeight(),true);
        Bitmap rotObj = Bitmap.createBitmap(cardObj, 0, 0, cardObj.getWidth(),cardObj.getHeight(), rotate, true);
        canvas.drawBitmap(rotObj, x , y,null);

    }

    @Override
    public void onDraw(Canvas canvas){

        //initialize coordinates based on the GameBoard's dimensions
        viewWidth = this.getWidth();
        viewHeight = this.getHeight();
        midWidth = viewWidth/2;
        midHeight = viewHeight/2 - tenClubsCard.getWidth()/2;
        discardWidth = midWidth - tenClubsCard.getHeight() - 50;
        stockWidth = midWidth + 50;
        topY = midHeight - tenClubsCard.getHeight() - 75;
        botY = midHeight + tenClubsCard.getHeight() + 75;

        //rotate the matrix 90 degrees
        rotate.setRotate(90);

        //draw the discard and stock piles
        drawRotCard(canvas,discardWidth,midHeight,tenClubsCard);
        drawRotCard(canvas, stockWidth, midHeight, backCard);

        //drawCard(canvas, discardWidth, midHeight, tenClubsCard);
        drawCard(canvas, 300, topY, backCard);
        drawCard(canvas,400,topY,backCard);
        drawCard(canvas,500,topY,backCard);
        drawCard(canvas, 300, botY, tenSpadesCard);
        drawCard(canvas,400,botY,tenHeartsCard);
        drawCard(canvas,500,botY,tenDiamondsCard);

    }







}
