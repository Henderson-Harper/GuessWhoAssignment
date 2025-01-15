/**
 * @author Wen Yao Zhang, Nicolas Chan, Henderson Harper
 * Date: January 13th, 2024
 * File Name: Human.java
 * Description: The Human subclass of Player. These objects represent human players. 
 *              See constructor for more details about its parameters.
 */

public class Human extends Player{
    /**
     * Constructor for the human class
     * @param theGuessingArray the guessing array assigned to the player
     */
    public Human(BoardCharacter[] theGuessingArray){
        guessingArray = theGuessingArray;
    }//end of the constructor

    /**
     * The implementation of the abstract method eliminateByAttribute from the parent class Player.
     * This version differs from the AI's implementation slightly because 
     * Human does not need to keep track how many players will be eliminated per question.
     * @param q the question that was asked to the player
     * @param wasRight whether the player responded yes (true) or no (false)
     */
    public void eliminateByAttribute(Question q, boolean wasRight){
		String charVal = "";
		for (int i = 0; i < guessingArray.length; i++){
			if (!guessingArray[i].isEliminated()){//not eliminated
				charVal = guessingArray[i].getValueOfAttributeFromString(q.getAttribute());
                if (charVal.equals(q.getValueToCheck()) != wasRight){
					guessingArray[i].setIsEliminated(true);
					charsRemaining-=1;
				}//end of inner if
			}//end of outer if
		}//end of for loop
        //calcRemainingChars();
        //System.out.println(Game.getPlayerNameFromIndex(playerNum)+" has characters remaining:"+charsRemaining);
	}//end of eliminateByAttribute method


}//end of Human class
