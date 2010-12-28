package rummikub.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class TileBagTest {

    @Test
    public void testNumberOfTiles() {
        TileBag bag = new TileBag();
        assertEquals(bag.numTilesRemaining(), TileBag.NUM_TILES);
    }

    @Test
    public void testDrawDiminishesNumberRemaining() {
        TileBag bag = new TileBag();
        int numRemaining = bag.numTilesRemaining();
        bag.drawTile();
        assertEquals(numRemaining - 1, bag.numTilesRemaining());
    }

    @Test
    public void testNumberOfJokers() {
        TileBag bag = new TileBag();
        int numberOfJokers = 0;
        while (bag.numTilesRemaining() > 0) {
            Tile t = bag.drawTile();
            // TODO: check if it's a joker

        }
        assertEquals(numberOfJokers, TileBag.NUM_JOKERS);
    }

    @Test
    public void testEmptyBag() {
        TileBag bag = new TileBag();
        System.out.println(bag);
        while (bag.numTilesRemaining() > 0) {
            Tile t = bag.drawTile();
            // TODO: check if it's a joker
        }
        assertEquals(null, bag.drawTile());
    }

}