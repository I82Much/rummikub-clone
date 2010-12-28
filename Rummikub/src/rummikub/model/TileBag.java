package rummikub.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import rummikub.model.Tile.TileColor;

public class TileBag {

    // Two sets of 13 per color, (2*13*4 = 104) + 2 jokers
    public static final int NUM_TILES = 106;
    public static final int NUM_SETS = 2;
    public static final int NUM_JOKERS = 2;
    private List<Tile> tiles;
    private Random random;
    public TileBag(Random random) {
        this.tiles = initializeTiles(random);
    }

    public TileBag() {
        this(new Random());
    }

    private List<Tile> initializeTiles(Random random) {
        ArrayList<Tile> theTiles = new ArrayList<Tile>();
        for (TileColor color : TileColor.values()) {
            for (int i = 0; i < NUM_SETS; i++) {
                for (int j = Tile.MIN_VALUE; j <= Tile.MAX_VALUE; j++) {
                    Tile tile = new Tile(j, color);
                    theTiles.add(tile);
                }
            }
        }
        Collections.shuffle(theTiles, random);
        // TODO: add jokers
        return theTiles;
    }

    public Tile drawTile() {
        if (tiles.size() == 0) {
            return null;
        }
        else {
            return tiles.remove(0);
        }
    }

    public int numTilesRemaining() {
        return tiles.size();
    }

    public String toString() {
        return numTilesRemaining() + " : " + tiles;
    }
}