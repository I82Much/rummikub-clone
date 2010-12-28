package rummikub.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.EnumMap;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import rummikub.model.Tile;
import rummikub.model.Tile.TileColor;

public class TileView extends JComponent {
    private Tile tile;

    private static final EnumMap<TileColor, Color> tileColorMap = new EnumMap<TileColor, Color>(TileColor.class);
    static {
        tileColorMap.put(TileColor.RED, Color.RED);
        tileColorMap.put(TileColor.BLACK, Color.BLACK);
        tileColorMap.put(TileColor.ORANGE, Color.ORANGE);
        tileColorMap.put(TileColor.BLUE, Color.BLUE.brighter());
    }

    public TileView(Tile t) {
        this.tile = t;
        setBorder(BorderFactory.createLineBorder(getTileColor()));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(20, 40);
    }

    private Color getTileColor() {
        return tileColorMap.get(this.tile.getColor());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getTileColor());
        String number = String.valueOf(this.tile.getValue());
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        TextPlacementUtils.drawText(number, TextPlacementUtils.AnchorPoint.CENTER, (Graphics2D) g, centerX, centerY);
    }


}