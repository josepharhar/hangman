import java.util.ArrayList;

public class Word {
    // this is the "secret" word being guessed
    private String word;

    // this represents the letters that the user has guessed
    private ArrayList<Character> guessedLetters;

    private int numFails;

    public Word(String word) {
        this.word = word;
        numFails = 0;

        guessedLetters = new ArrayList<Character>();
    }

    /**
     * @param letter
     *            the letter to guess
     * @return false if the letter has already been guessed true if the letter
     *         has NOT been guessed already
     */
    public boolean guessLetter(char letter) {
        if (guessedLetters.contains(letter)) {
            // the letter has already been guessed
            return false;
        } else if (word.indexOf(letter) != -1) {
            // the letter hasnt been guessed and is in the secret word
            guessedLetters.add(letter);
            return true;
        } else {
            // the letter hasnt been guessed and is NOT in the secret word
            guessedLetters.add(letter);
            numFails++;
            return false;
        }
    }

    public int getNumFails() {
        return numFails;
    }

    // Returns the secret word to be displayed to the user with guessed letters
    // ex: A _ _ l e
    public String getFormattedWord() {
        String output = "";
        for (int i = 0; i < word.length(); i++) {
            if (guessedLetters.contains(word.charAt(i))) {
                output += word.charAt(i) + " ";
            } else {
                output += "_ ";
            }
        }
        return output;
    }

    public boolean isWin() {
        for (int i = 0; i < word.length(); i++) {
            char checkChar = word.charAt(i);
            if (!guessedLetters.contains(checkChar)) {
                return false;
            }
        }
        return true;
    }

    public String getFormattedGuesses() {
        String output = "";

        for (char c : guessedLetters) {
            output += c + " ";
        }

        return output;
    }
    
    public String getSecretWord() {
        return word;
    }
}
