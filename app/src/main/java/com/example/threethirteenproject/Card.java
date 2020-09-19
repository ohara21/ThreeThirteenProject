package com.example.threethirteenproject;

public class Card {

    // cardType designates if the card if:
    // front(1), back (2)
    private int cardType;
    private double scale = 1.25;
    private final int CARDWIDTH = 222;
    private final int CARDHEIGHT = 323;
    private int finalCardWidth;
    private int finalCardHeight;
    private double backScale = 1.32;
    private final int BACKWIDTH = 223;
    private final int BACKHEIGHT = 307;
    private int finalBackWidth;
    private int finalBackHeight;

    // constructor sets the type of card and scales the card
    public Card(int cType){
        this.cardType = cType;
        scaleCard(this.cardType);
    }

    //scales the card and accounts for the different orientations of each card
    //sets the height and width with respect to its orientation in the screen
    public void scaleCard(int cType){
        if(cType == 1){
            finalCardWidth = (int) (CARDWIDTH * scale);
            finalCardHeight = (int) (CARDHEIGHT * scale);
            return;
        }
        else{
            finalBackWidth = (int) (BACKWIDTH * backScale);
            finalBackHeight = (int) (BACKHEIGHT * backScale);
            return;
        }
    }

    //returns the vertical height of the card depending on its type
    public int getHeight(){
        if(cardType == 1) {
            return this.finalCardHeight;
        }
        else{
            return this.finalBackHeight;
        }

    }

    //returns the horizontal width of the card depending on its type
    public int getWidth(){
        if(cardType == 1) {
            return this.finalCardWidth;
        }
        else{
            return this.finalBackWidth;
        }

    }
}
