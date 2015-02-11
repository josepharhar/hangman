
public class Main {
	public static void main(String[] args) {

//		HangmanFrame gui = new HangmanFrame(theWord);
		HangmanFrame gui = new HangmanFrame();
		
		gui.setSize(HangmanFrame.SCREEN_WIDTH, HangmanFrame.SCREEN_HEIGHT);
		gui.setLocationRelativeTo(null);
		gui.setVisible(true);
	}
}
