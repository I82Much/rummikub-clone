package rummikub.model;


/**
 * Encapsulates a valid combination of tiles
 * @author Nick
 */
public interface TileCombo {

    public int getPoints();

    public boolean addTile(Tile t, int index);

}