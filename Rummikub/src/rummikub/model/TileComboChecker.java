package rummikub.model;

import java.util.EnumMap;
import java.util.List;
import rummikub.model.Tile.TileColor;



public class TileComboChecker {

    private static final int MINIMUM_LENGTH = 3;

    public boolean isValid(List<Tile> tiles) {
        if (tiles.size() < MINIMUM_LENGTH) {
            return false;
        }
        // Check for a run
        if (isRun(tiles)) {
            return true;
        }
        // Check for *n* of a kind
        else if (isSet(tiles)) {
            return true;
        }
        return false;
    }

    public int getScore(List<Tile> tiles) {
        int sum = 0;
        for (Tile t : tiles) {
            sum += t.getValue();
        }
        return sum;
    }

    // TODO: Handle joker
    /**
     *
     * @param tiles
     * @return true if the set is completely consecutive, e.g. 1,2,3,4, as well as the same color
     */
    public boolean isRun(List<Tile> tiles) {
        return allSameColor(tiles) && consecutiveIntegers(tiles);
    }



    // TODO: handle joker
    /**
     *
     * @param tiles
     * @return true if all the tiles are of the same value and different colors
     */
    public boolean isSet(List<Tile> tiles) {
        return allSameValue(tiles) && allDifferentColors(tiles);
    }
    
    private boolean allSameValue(List<Tile> tiles) {
        int value = tiles.get(0).getValue();
        for (Tile theTile : tiles) {
            if (theTile.getValue() != value) {
                return false;
            }
        }
        return true;
    }

    private boolean allDifferentColors(List<Tile> tiles) {
        EnumMap<TileColor, Boolean> colorsSeenMap = new EnumMap<TileColor, Boolean>(TileColor.class);
        for (TileColor color : TileColor.values()) {
            colorsSeenMap.put(color, false);
        }
        for (Tile theTile : tiles) {
            boolean colorSeen = colorsSeenMap.get(theTile.getColor());
            if (colorSeen) {
                return false;
            }
            colorsSeenMap.put(theTile.getColor(), true);
        }
        return true;
    }

    private boolean allSameColor(List<Tile> tiles) {
        TileColor targetColor = tiles.get(0).getColor();
        for (Tile theTile : tiles.subList(1, tiles.size())) {
            if (theTile.getColor() != targetColor) {
                return false;
            }
        }
        return true;
    }

    private boolean consecutiveIntegers(List<Tile> tiles) {
        int targetValue = tiles.get(0).getValue() + 1;
        for (Tile theTile : tiles.subList(1, tiles.size())) {
            if (theTile.getValue() != targetValue) {
                return false;
            }
            targetValue++;
        }
        return true;
    }


}