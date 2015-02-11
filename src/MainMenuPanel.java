import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainMenuPanel extends JPanel {

    private JButton startOnePlayer;
    private JButton startTwoPlayer;
    
    private JLabel title;

    private HangmanFrame mainFrame;

    public MainMenuPanel(HangmanFrame newMainFrame) {
        mainFrame = newMainFrame;
        
        title = new JLabel("<html><center><font size=+4>Hangman</font><br /><br />by Joey Arhar,<br />Victoria Miguel,<br />and Aaron Parisi</center></html>");

        startOnePlayer = new JButton("One Player");
        startTwoPlayer = new JButton("Two Player");

        startOnePlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // get random word, set it to the secret word, and start the
                // game
                mainFrame.start(getRandomWord());
            }
        });

        startTwoPlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ask for a word from the user, and start the game
                String secretWord = JOptionPane.showInputDialog("Enter the secret word: ");
                if (secretWord != null) {
                    mainFrame.start(secretWord);
                }
            }
        });

        setLayout(new BorderLayout());

        add(startOnePlayer, BorderLayout.EAST);
        add(startTwoPlayer, BorderLayout.WEST);
        add(title, BorderLayout.CENTER);
    }

    private String getRandomWord() {

        String[] presetWords = { "bird", "cat", "dog", "computer", "Java",
                "programming", "lollapalooza" };

        // randomly select a word from the array
        String secretWord = presetWords[(int) (Math.random() * presetWords.length)];

        return secretWord;
    }
}
