/**
 * @author Wen Yao Zhang, Nicolas Chan, Henderson Harper
 * Date: January 13th, 2024
 * File Name: Question.java
 * Description: The Question class for question objects.
 * 				A question object contains all the necessary information about a question. See the constructor for details.
 * 				There are no setters because they do not need to be modified after being instantiated.
 */
public class Question {
	private String phrasing;//the phrasing of the question ("Does your person have brown eyes?")
	private String attribute;//the attribute the question is asking about ("eyeColour")
	private String valueToCheck;//the value the question is checking for ("brown")
	
	/**
	 * The constructor for Question objects.
	 * @param thePhrase is the phrasing of the question
	 * @param theAttr is the attribute the question is checking for
	 * @param theValue is the value of the attribute that the question is checking for
	 */
	public Question(String thePhrase, String theAttr, String theValue) { 
		phrasing = thePhrase;
		attribute = theAttr;
		valueToCheck = theValue;
	}//end of constructor
	
	/**
	 * A getter method for the phrasing of the question.
	 * @return the phrasing of the question (ex. does your character have blue eyes?)
	 */
	public String getPhrasing() {
		return phrasing;
	}//end of getPhrasing

	/**
	 * A getter method for the attribute the question is checking for.
	 * @return the attribute the question is checking for (ex. eye colour)
	 */
	public String getAttribute() {
		return attribute;
	}//end of getAttribute method

	/**
	 * A getter method for the value to check for.
	 * @return the value To Check for (ex. blue)
	 */
	public String getValueToCheck() {
		return valueToCheck;
	}	//end of getValueToCheck method
}//end of Question class
