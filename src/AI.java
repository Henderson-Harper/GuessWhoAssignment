
/**
 * @author Wen Yao Zhang, Nicolas Chan, Henderson Harper
 * Date: January 13th, 2024
 * File Name: AI.java
 * Description: The AI class, which is a child class of Player. Used for the AI in the game.
 */
public class AI extends Player{
    private BoardCharacter mysteryCharacter;//the mystery character chosen by the AI
    private int difficulty;//the difficulty of the AI
    private Question[] questionArray = new Question[19];//the array of questions they can ask
    /**
     * the number of characters that can say "yes" to a question. Corresponds with questionArray.
     * For example, if 5 characters had white hair, and "does your character have white hair" was index 3 of questionArray, numLinkedChars[3] is equal to 5.
     */
    private int[] numLinkedChars = new int[19];

    public AI(BoardCharacter theMysteryCharacter, int theDifficulty, BoardCharacter[] theGuessingArray,Question[] theQuestionArray, int[] theLinkedNumArray) {
        mysteryCharacter = theMysteryCharacter;
        difficulty = theDifficulty;
        guessingArray = theGuessingArray;
        questionArray = theQuestionArray;
        numLinkedChars = theLinkedNumArray;
    }//end of constructor

    /**
     * A function that returns the AI's response to the player's question
     * @param attr the attribute the player is asking about
     * @param val the value of the attribute the player is asking about
     * @return boolean - Returns true if the AI's charater has the features of the question the player asked
     */
    public boolean getAIResponse(String attr, String val){
        return mysteryCharacter.getValueOfAttributeFromString(attr).equals(val);
    }//end of isMysteryCharacter

    /**
     * A function that returns the name of the AI's mystery character.
     * @return String - the name of the AI's mystery character
     */
    public String getMCName(){
        return mysteryCharacter.getName();
    }//end of getMCName method

    /**
     * Method that the AI uses to rank how good every question is in the current situation, by using Improved Bubble Sort.
     * It then returns a question from the ranking based on the difficulty.
     * @return Question - returns a question. The lower the difficulty, the worse ranked the question is. However, the question will never be one that eliminates 0 people.
     */
    public Question getBestQuestion(){
        boolean swapped = true;
        int count = 1;
        int half = charsRemaining/2;
        Question tempQ; 
        int tempNum;
        if (charsRemaining == 1){//guess the character if 1 character remaining
            BoardCharacter tempBC;
            tempNum = 0;
            do{
                tempBC = guessingArray[tempNum];
                tempNum++;
            } while (tempBC.isEliminated());
            return new Question("Is your character's name "+tempBC.getName()+"?","name",tempBC.getName());
        }//end of if statement

        while (swapped){//improved bubblesort
            swapped = false;
            for (int i = 0; i < questionArray.length-count; i++){
                /**
                 * if the ith index is farther from half than the i+1th index
                 * Since we want to eliminate half the people, and easy equation we can use to 
                 * find how close the question is to eliminating half the people is 
                 * "|number of chars that will be eliminated - half the total charc remaining| = how close to half"
                 * Example:
                 *  Say we have 12 people. We would want to eliminate 6 people.
                 *  One question will eliminate 6, another will eliminate 4, and the third will eliminate 12
                 *  The rankings would be 6, 4, 12 as 6 will eliminate half and then 4 and 12 would be the better choice respectively
                 * Instead of marking a seprate array, we would calculate the equation in the if statement and compare both there
                 *  
                 * 
                 */
                if (Math.abs(((int) numLinkedChars[i]) - half) > Math.abs(((int) numLinkedChars[i+1]) - half)){ 
                    swapped = true;
                    //switch the values in the question array
                    tempQ = questionArray[i];
                    questionArray[i] = questionArray[i+1];
                    questionArray[i+1] = tempQ;

                    //switch the values in the numLinkedChars array
                    tempNum = numLinkedChars[i];
                    numLinkedChars[i] = numLinkedChars[i+1];
                    numLinkedChars[i+1] = tempNum;
                }//end of if statement
            }//end of for loop
            count++;//increment
        }//end of while loop

        //submitting the guess

        //we reuse the tempNum variable since we don't need it anymore
        tempNum = 10-difficulty; //lower difficulty = lower ranked question. ex. difficulty 10 = select best question. difficulty 1 = select 10th best question
        while (numLinkedChars[tempNum] == 0 && ((int) Math.random()*10) < difficulty){//while the question selected is applicable to 0 people and its lucky (so AI at level 1 has a chance to win eventually)
            tempNum--;//go to the next best question and check again
        }//end of while loop
        //we have made sure that our question will not eliminate 0 people so now we can return it
        return questionArray[tempNum]; //return random guess based on difficulty. 
    }//end of getBestQuestion method
    
    /**
     * A method that eliminates the chracters by the attribute that was guessed.
     * @param q the Question that was asked
     * @param wasRight the user's response the the question (yes = true, no = false)
     * @return void
     */
    public void eliminateByAttribute(Question q, boolean wasRight) {
		String charVal = "";
		for (int i = 0; i < this.guessingArray.length; i++){ //Loops through all characters
			if (!this.guessingArray[i].isEliminated()){//not eliminated. Only runs if the charater is not eliminated
				charVal = this.guessingArray[i].getValueOfAttributeFromString(q.getAttribute()); //Assign the specific attribute of that charater to the variable
				if (charVal.equals(q.getValueToCheck()) != wasRight){//if the character's value of the attribute does not align with the response
                //ex. if the question asked for black hair and the BoardCharacter has black hair, but the response was no, the character would be eliminated
					this.guessingArray[i].setIsEliminated(true);//eliminate the character
					charsRemaining-=1;//there is 1 less character now
                    for (int j = 0; j < questionArray.length; j++){//loop through every question
                        if (questionArray[j].getValueToCheck().equals(this.guessingArray[i].getValueOfAttributeFromString(questionArray[j].getAttribute()))){//if the value the current question is looking for is the same value the newly eliminated character has
                            numLinkedChars[j]--;//reduce the number of characters who can say yes to that question by 1 (because they are now eliminated)
                        }//end of if statement
                    }//end of for loop
				}//end of inner if
			}//end of outer if
		}//end of for loop
        //calcRemainingChars();
        //System.out.println("AI has characters remaining:"+charsRemaining);
	}//end of eliminateByAttribute method
}//end of the AI class