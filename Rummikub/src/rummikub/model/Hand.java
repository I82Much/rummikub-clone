package rummikub.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains the tiles that a given player has
 * @author Nick
 */
public class Hand {
    private static final int INITIAL_NUM_TILES = 14;
    private List<Tile> tiles = new ArrayList<Tile>();

    public Hand(List<Tile> tiles) {
        if (tiles.size() != INITIAL_NUM_TILES) {
            throw new IllegalArgumentException("Expected " + INITIAL_NUM_TILES + " tiles.");
        }
        this.tiles.addAll(tiles);
    }

    public void removeTile(Tile t) {
        tiles.remove(t);
    }

    public void addTile(Tile t) {
        tiles.add(t);
    }

}