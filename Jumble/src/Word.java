/*
 * The basic word class. This class will contain the word to be shown,
 * represented with blanks when the game displays. There will also be a
 * "clue" field. This class also contains methods that return the length
 * of the word and will return the clue for a final word
 */
public class Word {
	protected String gameWord;
	protected String difficulty;
	
	public Word (String wordToStore, String wordDifficulty) {
		this.gameWord = wordToStore;
		this.difficulty = wordDifficulty;
	}
	
	public int getWordLength() {
		return gameWord.length();
	}
	
	public String getDifficulty() {
		return difficulty;
	}
	
	public String getWord() {
		return gameWord;
	}
 }
