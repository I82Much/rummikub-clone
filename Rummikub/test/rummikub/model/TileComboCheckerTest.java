package rummikub.model;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class TileComboCheckerTest {

    private TileComboChecker checker = new TileComboChecker();

    private Tile redOne = new Tile(1, Tile.TileColor.RED);
    private Tile redTwo = new Tile(2, Tile.TileColor.RED);
    private Tile redThree = new Tile(3, Tile.TileColor.RED);
    private Tile orangeThree = new Tile(3, Tile.TileColor.ORANGE);
    private Tile blackThree = new Tile(3, Tile.TileColor.BLACK);


    @Test
    public void testTooSmall() {
        assertFalse(checker.isValid(Arrays.asList(redOne, redTwo)));
    }

    @Test
    public void testScoreCalculationSet() {
        List<Tile> validSet = Arrays.asList(redThree, orangeThree, blackThree);
        assertEquals(checker.getScore(validSet), 9);
    }

    @Test
    public void testScoreCalculationRun() {
        List<Tile> validRun = Arrays.asList(redOne, redTwo, redThree);
        assertEquals(checker.getScore(validRun), 6);
    }

    @Test
    public void testValidSet() {
        List<Tile> validSet = Arrays.asList(redThree, orangeThree, blackThree);
        assertTrue(checker.isSet(validSet));
    }

    @Test
    public void testInvalidSet() {
        assertFalse(checker.isSet(Arrays.asList(redThree, redTwo, blackThree)));
    }

    @Test
    public void testSetWithJoker() {
        fail();
    }


    @Test
    public void testValidRun() {
        assertTrue(checker.isRun(Arrays.asList(redOne, redTwo, redThree)));
    }

    @Test
    public void testInvalidRunColor() {
        assertFalse(checker.isRun(Arrays.asList(redOne, redTwo, blackThree)));
    }

    @Test
    public void testInvalidRunOrder() {
        assertFalse(checker.isRun(Arrays.asList(redOne, redThree, redTwo)));
    }

    @Test
    public void testRunWithJoker() {
        fail();
    }


}