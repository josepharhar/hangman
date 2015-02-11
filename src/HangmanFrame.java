import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HangmanFrame extends JFrame {

    public static final int SCREEN_WIDTH = 400;
    public static final int SCREEN_HEIGHT = 400;
    private final static int MAX_FAILS = 6;

    // the panel to currently use
    private JPanel currentPanel;

    // gamePanel holds the hangmanPanel and the controlPanel
    private JPanel gamePanel;
    // Holds the labels and the textbox
    private JPanel controlPanel;
    // draws the hangman
    private HangmanPanel hangmanPanel;

    private MainMenuPanel mainMenuPanel;

    // input textbox
    private JTextField textbox;

    private JLabel guessedLabel;
    private JLabel wordLabel;

    private Word theWord;

    public HangmanFrame() {
        mainMenuPanel = new MainMenuPanel(this);

        add(mainMenuPanel);
    }

    public void start(String secretWord) {
        theWord = new Word(secretWord);

        // Set up the gamePanel and add it to the frame
        gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout());

        controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3, 1));

        // add labels
        guessedLabel = new JLabel("");
        controlPanel.add(guessedLabel);
        wordLabel = new JLabel();
        controlPanel.add(wordLabel);

        // add textbox
        textbox = new JTextField();
        textbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guess();
            }
        });
        controlPanel.add(textbox);

        // add drawing
        hangmanPanel = new HangmanPanel(this.theWord);
        gamePanel.add(hangmanPanel, BorderLayout.CENTER);

        // add controlpanel
        gamePanel.add(controlPanel, BorderLayout.SOUTH);

        // remove the main menu
        remove(mainMenuPanel);

        // set the frame to the new panel
        add(gamePanel);

        update();
    }

    private void update() {
        if (theWord.isWin()) {
            JOptionPane.showMessageDialog(this, "You Won!");
        }

        if (theWord.getNumFails() >= MAX_FAILS) {
            // LOSE THE GAME!!!
            System.out.println("you lost!");
            JOptionPane.showMessageDialog(this, "You Lost!");
        } else {
            // clear the textbox
            textbox.setText("");

            // update labels
            wordLabel.setText(theWord.getFormattedWord());
            guessedLabel.setText(theWord.getFormattedGuesses());

            hangmanPanel.set();
        }
    }

    // Called when the user presses enter
    private void guess() {
        Character guess = checkInput(textbox.getText());

        if (guess != null) {
            // now we know that the input is valid, so we can try to put it in
            // the word
            if (theWord.guessLetter(guess)) {
                // letter gets added
            } else {
                // the user made a wrong (but valid) guess
            }
        } else {
            // bad input
            // JOptionPane.showMessage(, "Bad Input");
            System.out.println("bad input");
        }

        update();
    }

    // Checks to see if the user entered valid input
    private Character checkInput(String word) {
        if (word.length() != 1) {
            return null;
        }
        char guess = word.charAt(0);
        if (!Character.isAlphabetic(guess)) {
            return null;
        }
        return guess;
    }

}