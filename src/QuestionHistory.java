/**
 * @author Wen Yao Zhang, Nicolas Chan, Henderson Harper
 * Date: January 13th, 2024
 * File Name: QuestionHistory.java
 * Description: The QuestionHistory class is a template class for QuestionHistory objects.
 *              QuestionHistory objects store the history of a question-response pair.
 *              It is used in the GameGUI for the History portion. It is also used for logging.
 */
public class QuestionHistory {
    private String player; //the player who asked the question
    private Question question; //the question that was asked
    private boolean response; //the other player's response

/**
 * A constructor for the QuestionHistory class. For some reason it doesn't work when we don't use 'this.' .
 * @param thePlayer  the player who asked the question
 * @param theQuestion  the question that was asked
 * @param theResponse  the response given by the other player
 */
    public QuestionHistory(String thePlayer, Question theQuestion, boolean theResponse) { 
        this.player = thePlayer;
        this.question = theQuestion;
        this.response = theResponse;
    }//end of constructor

/** 
 * Gets the name of the player who asked the question.
 * @return the name of the player
 */
    public String getPlayer() { 
        return this.player;
    }//end of getPlayer method


/** 
 * Gets the Question object of the question asked.
 * @return the Question object of the question asked
 */
    public Question getQuestion() { 
        return this.question;
    }//end of getQuestion method

/** 
 * Gets the response to the question.
 * @return the response
 */
    public boolean getResponse() { 
        return this.response;
    }//end of getResponse method
}//end of QuestionHistory class