package application;

public class Words 
{
	public String shuffleword(String word) // to shuffle the words
	{
	    char[] characters = word.toCharArray();
	    for (int i = 0; i < characters.length; i++) 
	    {
	        int randomIndex = (int)(Math.random() * characters.length);
	        char temp = characters[i];
	        characters[i] = characters[randomIndex];
	        characters[randomIndex] = temp;
	    }
	    return new String(characters);
	}
}
