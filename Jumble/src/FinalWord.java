
public class FinalWord extends Word {
	
	private String clue;
	
	public FinalWord(String wordToStore, String wordDifficulty, String wordClue) {
		super(wordToStore, wordDifficulty);
		// TODO Auto-generated constructor stub
		this.gameWord = wordToStore;
		this.clue = wordClue;
		this.difficulty = wordDifficulty;
	}

}
