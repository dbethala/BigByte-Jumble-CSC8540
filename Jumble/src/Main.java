
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("TEST");
		
		/*
		 * Tests for the Word and FinalWord classes
		 */
		Word newWord = new Word("bread", "easy");
		System.out.println(newWord.getWordLength());
		System.out.println(newWord.getDifficulty());
		
		FinalWord fWord = new FinalWord("minestrone", "hard", "Something you eat");
		System.out.println(fWord.getWordLength());
	}

}
