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
    private double backScale = 1.25;
    private final int BACKWIDTH = 223;
    private final int BACKHEIGHT = 307;
    private int finalBackWidth;
    private int finalBackHeight;

    public int cardId = R.drawable.back_vert;

    /**
     * constructor sets the types of card and scales the card
     * @param cType
     * @param suit
     * @param value
     */
    public Card(int cType, char suit, int value){
        this.cardType = cType;
        scaleCard(this.cardType);
        if(cType == 1) {
            cardId = getId(suit, value);
        }
    }

    //base constructor for the card object
    public Card(int cType){
        this.cardType = cType;
        scaleCard(this.cardType);
    }

    /**
     * scales the card and accounts for the different orientations of each cars
     * sets the height and width with respect to its orientation in the screen
     * @param cType
     */
    public void scaleCard(int cType){
        if(cType == 1){
            finalCardWidth = (int) (CARDWIDTH * scale);
            finalCardHeight = (int) (CARDHEIGHT * scale);
        }
        else{
            finalBackWidth = (int) (BACKWIDTH * backScale);
            finalBackHeight = (int) (BACKHEIGHT * backScale);
        }
    }

    /**
     * returns the vertical height of the card depending on its type
     * @return
     */
    public int getHeight(){
        if(cardType == 1) {
            return this.finalCardHeight;
        }
        else{
            return this.finalBackHeight;
        }

    }

    /**
     * returns the horizontal width of the card depending on its type
     * @return
     */
    public int getWidth(){
        if(cardType == 1) {
            return this.finalCardWidth;
        }
        else{
            return this.finalBackWidth;
        }

    }

    /**
     * returns the card's ID depending on the suit and value
     * used for drawing the Bitmaps of the cards
     * @param suit
     * @param value
     * @return
     */
    private int getId(char suit, int value){
        int cardId = 3;

        switch(suit){
            case 's':
                switch(value){
                    case 1:
                        cardId = R.drawable.ace_of_spades;
                        break;
                    case 2:
                        cardId = R.drawable.two_of_spades;
                        break;
                    case 3:
                        cardId = R.drawable.three_of_spades;
                        break;
                    case 4:
                        cardId = R.drawable.four_of_spades;
                        break;
                    case 5:
                        cardId = R.drawable.five_of_spades;
                        break;
                    case 6:
                        cardId = R.drawable.six_of_spades;
                        break;
                    case 7:
                        cardId = R.drawable.seven_of_spades;
                        break;
                    case 8:
                        cardId = R.drawable.eight_of_spades;
                        break;
                    case 9:
                        cardId = R.drawable.nine_of_spades;
                        break;
                    case 10:
                        cardId = R.drawable.ten_of_spades;
                        break;
                    case 11:
                        cardId = R.drawable.jack_of_spades;
                        break;
                    case 12:
                        cardId = R.drawable.queen_of_spades;
                        break;
                    case 13:
                        cardId = R.drawable.king_of_spades;
                        break;
                }
                break;
            case 'h':
                switch(value){
                    case 1:
                        cardId = R.drawable.ace_of_hearts;
                        break;
                    case 2:
                        cardId = R.drawable.two_of_hearts;
                        break;
                    case 3:
                        cardId = R.drawable.three_of_hearts;
                        break;
                    case 4:
                        cardId = R.drawable.four_of_hearts;
                        break;
                    case 5:
                        cardId = R.drawable.five_of_hearts;
                        break;
                    case 6:
                        cardId = R.drawable.six_of_hearts;
                        break;
                    case 7:
                        cardId = R.drawable.seven_of_hearts;
                        break;
                    case 8:
                        cardId = R.drawable.eight_of_hearts;
                        break;
                    case 9:
                        cardId = R.drawable.nine_of_hearts;
                        break;
                    case 10:
                        cardId = R.drawable.ten_of_hearts;
                        break;
                    case 11:
                        cardId = R.drawable.jack_of_hearts;
                        break;
                    case 12:
                        cardId = R.drawable.queen_of_hearts;
                        break;
                    case 13:
                        cardId = R.drawable.king_of_hearts;
                        break;

            }
                break;
            case 'c':
                switch(value){
                    case 1:
                        cardId = R.drawable.ace_of_clubs;
                        break;
                    case 2:
                        cardId = R.drawable.two_of_clubs;
                        break;
                    case 3:
                        cardId = R.drawable.three_of_clubs;
                        break;
                    case 4:
                        cardId = R.drawable.four_of_clubs;
                        break;
                    case 5:
                        cardId = R.drawable.five_of_clubs;
                        break;
                    case 6:
                        cardId = R.drawable.six_of_clubs;
                        break;
                    case 7:
                        cardId = R.drawable.seven_of_clubs;
                        break;
                    case 8:
                        cardId = R.drawable.eight_of_clubs;
                        break;
                    case 9:
                        cardId = R.drawable.nine_of_clubs;
                        break;
                    case 10:
                        cardId = R.drawable.ten_of_clubs;
                        break;
                    case 11:
                        cardId = R.drawable.jack_of_clubs;
                        break;
                    case 12:
                        cardId = R.drawable.queen_of_clubs;
                        break;
                    case 13:
                        cardId = R.drawable.king_of_clubs;
                        break;
                }
                break;
            case 'd':
                switch(value){
                    case 1:
                        cardId = R.drawable.ace_of_diamonds;
                        break;
                    case 2:
                        cardId = R.drawable.two_of_diamonds;
                        break;
                    case 3:
                        cardId = R.drawable.three_of_diamonds;
                        break;
                    case 4:
                        cardId = R.drawable.four_of_diamonds;
                        break;
                    case 5:
                        cardId = R.drawable.five_of_diamonds;
                        break;
                    case 6:
                        cardId = R.drawable.six_of_diamonds;
                        break;
                    case 7:
                        cardId = R.drawable.seven_of_diamonds;
                        break;
                    case 8:
                        cardId = R.drawable.eight_of_diamonds;
                        break;
                    case 9:
                        cardId = R.drawable.nine_of_diamonds;
                        break;
                    case 10:
                        cardId = R.drawable.ten_of_diamonds;
                        break;
                    case 11:
                        cardId = R.drawable.jack_of_diamonds;
                        break;
                    case 12:
                        cardId = R.drawable.queen_of_diamonds;
                        break;
                    case 13:
                        cardId = R.drawable.king_of_diamonds;
                        break;
                }
                break;

        }


        return cardId;
    }


}
