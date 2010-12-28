package rummikub.view;


import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;

/**
 * This class exists to
 */
public class TextPlacementUtils {

    /** Prevent instantiation */
    private TextPlacementUtils() {
    }

    /**
     * Represents a position relative to a string of text.  For instance,
     * if we want to position a string such that its center is at a given
     * (x,y) coordinate, then we would use the CENTER enumerated value.
     */
    public enum AnchorPoint {

        UPPER_LEFT,
        TOP_CENTER,
        UPPER_RIGHT,
        RIGHT_CENTER,
        LOWER_RIGHT,
        BOTTOM_CENTER,
        LOWER_LEFT,
        LEFT_CENTER,
        CENTER
    };

    public static void drawText(String text, AnchorPoint point, Graphics2D g2, float x, float y) {
        Font currentFont = g2.getFont();
        drawText(text, currentFont, point, g2, x, y);
    }

    /**
     * Draws the given text to the graphics context <code>g2</code>, positioning
     * the text such that the text's AnchorPoint <code>point</code> is located at
     * position x, y.
     *
     * For instance, to place text such that it's upper right corner is at (40, 40),
     * the <code>point</code> variable should be set to <code>AnchorPoint.UPPER_RIGHT</code>,
     * with x and y = 40.
     */
    public static void drawText(String text, Font font, AnchorPoint point, Graphics2D g2, float x, float y) {
        FontRenderContext frc = g2.getFontRenderContext();
        TextLayout layout = new TextLayout(text, font, frc);
        drawText(layout, point, g2, x, y);
    }

    public static void drawText(TextLayout text, AnchorPoint point, Graphics2D g2, float x, float y) {
        float translationX = 0.0f;
        float translationY = 0.0f;

        Rectangle2D bounds = text.getBounds();
        float midYOffset = (float) bounds.getHeight() / 2;
        float midXOffset = (float) -bounds.getWidth() / 2;

        float topYOffset = (float) bounds.getHeight();
        float bottomYOffset = 0.0f;

        float leftXOffset = 0.0f;
        float rightXOffset = (float) -bounds.getWidth();

        // Adjust x values
        switch (point) {
            // Left
            case UPPER_LEFT:
            case LOWER_LEFT:
            case LEFT_CENTER:
                translationX = leftXOffset;
                break;
            // Mid
            case TOP_CENTER:
            case BOTTOM_CENTER:
            case CENTER:
                translationX = midXOffset;
                break;
            // Right
            case UPPER_RIGHT:
            case RIGHT_CENTER:
            case LOWER_RIGHT:
                translationX = rightXOffset;
        }

        // Adjust y values
        switch (point) {
            // Top
            case UPPER_LEFT:
            case UPPER_RIGHT:
            case TOP_CENTER:
                translationY = topYOffset;
                break;
            // Mid
            case LEFT_CENTER:
            case CENTER:
            case RIGHT_CENTER:
                translationY = midYOffset;
                break;
            // Bottom
            case LOWER_LEFT:
            case BOTTOM_CENTER:
            case LOWER_RIGHT:
                translationY = bottomYOffset;
        }
        text.draw(g2, x + translationX, y + translationY);
    }
}
