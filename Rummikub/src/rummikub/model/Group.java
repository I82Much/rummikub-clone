package rummikub.model;

import java.util.ArrayList;
import java.util.List;



/**
 * From http://www.rummikub.com/info/Rules.aspx
 * "At least three of the same figure tile, in different colors
 * @author Nick
 */
public class Group implements TileCombo {

    private static final int MINIMUM_NUM_TILES = 3;

    private int value;
    private ArrayList<Tile> theTiles;

    public Group(List<Tile> tiles) {
        if (tiles.size() < MINIMUM_NUM_TILES) {
            throw new IllegalArgumentException("Expected at least " + MINIMUM_NUM_TILES + " tiles");
        }
        this.value = tiles.get(0).getValue();
        for (Tile t : tiles) {
            if (t.getValue() != this.value) {
                throw new IllegalArgumentException("All values must match; expected " +
                        this.value + "; found " + t.getValue() + " for tile " + t);
            }
        }
    }

    public int getPoints() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean addTile(Tile t, int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}