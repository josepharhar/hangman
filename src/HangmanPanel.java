import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class HangmanPanel extends JPanel {

    private Word theWord;

    private final int WIDTH;
    private final int HEIGHT;

    public HangmanPanel(Word theWord) {
        this.theWord = theWord;
        setPreferredSize(new Dimension(HangmanFrame.SCREEN_WIDTH,
                HangmanFrame.SCREEN_HEIGHT));
        WIDTH = HangmanFrame.SCREEN_WIDTH;
        HEIGHT = HangmanFrame.SCREEN_HEIGHT;
    }

    public void paintComponent(Graphics g) {
        // draw hangman here
        g.setColor(Color.BLACK);
        
        //draw background
        g.drawLine(3 * WIDTH / 4, 20, 3 * WIDTH / 4, HEIGHT);
        g.drawLine(WIDTH / 2, 20, 3 * WIDTH / 4, 20);
        g.drawLine(WIDTH / 2, 20, WIDTH / 2, 40);

        int numFails = theWord.getNumFails();
        
        if (numFails > 0) {
            // head
            g.drawOval(WIDTH / 2 - 20, 40, 40, 40);
        }
        if (numFails > 1) {
            // body
            g.drawLine(WIDTH / 2, 80, WIDTH / 2, 80 + 100);
        }
        if (numFails > 2) {
            // left arm
            g.drawLine(WIDTH / 2, 100, WIDTH / 2 - 60, 100 + 40);
        }
        if (numFails > 3) {
            // right arm
            g.drawLine(WIDTH / 2, 100, WIDTH / 2 + 60, 100 + 40);
        }
        if (numFails > 4) {
            // left leg
            g.drawLine(WIDTH / 2, 80 + 100, WIDTH / 2 - 60, 80 + 100 + 40);
        }
        if (numFails > 5) {
            // right leg
            g.drawLine(WIDTH / 2, 80 + 100, WIDTH / 2 + 60, 80 + 100 + 40);
        }
    }

    public void set() {
        paintComponent(getGraphics());
    }

}
