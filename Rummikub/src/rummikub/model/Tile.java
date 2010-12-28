package rummikub.model;

public class Tile {

    private int value;

    public enum TileColor {
        BLACK,
        BLUE,
        ORANGE,
        RED
    };

    private TileColor color;

    public Tile(int value, TileColor color) {
        this.value = value;
        this.color = color;
    }

    public TileColor getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }

    /**
     * @return how many points to be penalized if the player is left with this
     * tile in his hand
     */
    public int getPenaltyValue() {
        return value;
    }

    @Override
    public String toString() {
        return color + " " + value;
    }

    // TODO: Add joker
}