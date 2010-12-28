package rummikub.model;


public class Player {

    private Hand hand;

    /**
     * Has the player melded, i.e. played moves totaling 30 points on his first turn?
     */
    private boolean hasMelded = false;

    public Player(Hand hand) {
        this.hand = hand;
    }


    

}