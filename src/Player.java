/**
 * @author Wen Yao Zhang, Nicolas Chan, Henderson Harper
 * Date: January 13th, 2024
 * File Name: Player.java
 * Description: The player class is an abstract class that has two children: Human (the people playing the game) and AI (the artificial intelligence).
* 				It has a series of variables and methods which are used by its children.
 */
public abstract class Player {
	protected BoardCharacter[] guessingArray;//the array of characters the player sees (they flip them down to try to get closer to guessing the opponent's character)
	protected int charsRemaining = 24;//there are 24 characters in a guess who board, and 0 start flipped down
	
	/**
	 * eliminateByAttribute is the method to eliminate characters based on an answer to the question.
	 * Ex. When you ask "does your person have white hair?" and the opponent says "no" then you flip down people with white hair.
	 * @param q The question that the player asked
	 * @param wasRight the response to the question
	 */
	public abstract void eliminateByAttribute(Question q, boolean wasRight);
	
	/**
	 * A method that re-calculates the number of remaining Characters.
	 * The number of remaining characters is updated automatically in the children's eliminateByAttribute method, but this is just to make sure.
	 * @return the number of characters remaining (characters flipped up on the board they see)
	 */
	public int calcRemainingChars(){ //probably not needed
		int numChar = 0;
		for (BoardCharacter i : this.guessingArray){//loop through the entire array of characters (24)
			if (!i.isEliminated()){//if the character isn't eliminated
				numChar++;//increment count by 1
			}//end of if statement
		}//end of for loop
		return numChar;
	}//end of calcRemainingChars() method
	
	/**
	 * The getter for the guessing array.
	 * @return the array of board characters that the player sees
	 */
	public BoardCharacter[] getGuessingArray(){
		return guessingArray;
	}//end of guessingArray method


	/**
	 * The getter for the number of remaining characters
	 * @return the number of characters remaining
	 */
	public int getCharsRemaining(){
		return charsRemaining;
	}//end of getCharsRemaining method

}//end of Player class
