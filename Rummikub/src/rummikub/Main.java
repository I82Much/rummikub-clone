
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import rummikub.model.TileBag;
import rummikub.view.TileView;

public class Main {


    public static void main(String[] args) {
        JFrame frame = new JFrame("");
        JPanel panel = new JPanel();


        TileBag bag = new TileBag();
        for (int i = 0; i < 10; i++) {
            TileView view = new TileView(bag.drawTile());
            panel.add(view);
        }

        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}