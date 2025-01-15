/**
 * @author Wen Yao Zhang, Nicolas Chan, Henderson Harper
 * Date: January 13th, 2024
 * File Name: GameGUI.java
 * Description: Main program that runs all the code to construct and instantiate variables + tons of helper methods
*/

import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List; //Do not remove as list will break (we need to specify that List used by the font loader is the util.List)
import java.util.*;
import java.awt.*;
import java.time.*;
import java.time.format.*;
import javax.sound.sampled.*;
import java.net.URL;

public class Game {
	private static int winnerIndex; //the index of the winning player (index of playerArr, so it is 0 or 1)
	private static Player[] playerArr = new Player[2];//array that contains both player objects (human and other human/ai)
	private static int curTurn = 0;//the current turn, either 0 or 1 for the index of the current player
	private static HashMap<String, String> Settings = new HashMap <String, String>();//a HashMap to store the settings
	private static Constants.GameTypes gameType = Constants.GameTypes.NONE;//A variable to store the type of game. See the GameTypes enum in the constants class for details.
	private static boolean isUndergoingGame = false;//A variable that says whether a game is on or not. True = game is going on, false = no game is active
	private static Question currentQuestion = null;//A variable that stores the most recently asked question
	private static ArrayList<QuestionHistory> questionHistoryArrList = new ArrayList<QuestionHistory>(); //an array list that stores QuestionHistory objects. Used to document the history of the match.

    private static BoardCharacter[] charListToCopy = new BoardCharacter[Constants.GameGUI.NUM_CHAR];//the array of BoardCharacters to copy when Player objects are made
    private static Question[] questionListToCopy = new Question[Constants.GameGUI.NUM_QUESTIONS];//the array of questions to copy when AI objects are made
    private static int[] linkedNumCharsToCopy = new int[Constants.GameGUI.NUM_QUESTIONS];//the array of the # of people each question eliminates when AI objects are made
	private static FileWriter logWriter;//a fileWriter to write to the log.txt file.

	private static AudioInputStream audioStream;//the audio stream to play music
	private static Clip clip;//the audio clip for music

    public static void main(String args[]) throws FileNotFoundException, IOException, URISyntaxException {//the main method. This is the only main method in the program.
        // INSTANTIATION STUFF

		

		//instantiate the filewriter for logging matches to the log.txt file
		try {
			logWriter = new FileWriter(new File("src/Log.txt"), true);
			//Desktop.getDesktop().edit(new File(logFilePath.toURI()));
		} catch (Exception e){
			e.printStackTrace();
		}//end of try/catch
		

		//adding fonts (code is from baeldung.com)
		GraphicsEnvironment GE = GraphicsEnvironment.getLocalGraphicsEnvironment();
    	List<String> AVAILABLE_FONT_FAMILY_NAMES = Arrays.asList(GE.getAvailableFontFamilyNames());
		URL silverFilePath = Game.class.getResource("fonts/Silver.ttf");//we use silver font for plain text
		URL ThaleahFatFilePath = Game.class.getResource("fonts/ThaleahFat.ttf");//we use ThaleahFat for titles
		try {
			List<File> fontList = Arrays.asList(
			new File(silverFilePath.toURI()),
			new File (ThaleahFatFilePath.toURI())
			);//end of add to list
			for (File listItem : fontList) {
				if (listItem.exists()) {
					Font myNewFont = Font.createFont(Font.TRUETYPE_FONT, listItem);
					if (!AVAILABLE_FONT_FAMILY_NAMES.contains(myNewFont.getFontName())) {
						GE.registerFont(myNewFont);
					}//end of if statement
				}//end of other if statement
			}//end of for loop
		} catch (Exception e) {
			e.printStackTrace();
		}//end of catch

        //instantiate the settings hashmap
        setSetting("Player1Name","Player #1");
        setSetting("Player2Name","Player #2");
        setSetting("Music","On");
        setSetting("Difficulty","10");//ai is the hardest difficulty by default

		startMusic();//start the music

        //load the character attributes from a file
        String[] tempAttr =  new String[Constants.GameGUI.NUM_ATTR]; 
		URL listFilePath = Game.class.getResource("GuessWhoCharacterList.txt");
        File file = new File(listFilePath.toURI());
        Scanner fileScan = new Scanner(file);
        for(int i = 0; i < Constants.GameGUI.NUM_CHAR; i++){
            for(int j = 0; j < Constants.GameGUI.NUM_ATTR; j++){
                tempAttr[j] = fileScan.nextLine().split(": ")[1];
            }//end of smol for loop
            charListToCopy[i] = new BoardCharacter(tempAttr[0], "images/characters/" + (String) (tempAttr[0] + ".jpg"), tempAttr[1], tempAttr[2], tempAttr[3], tempAttr[4], tempAttr[5], tempAttr[6], tempAttr[7], tempAttr[8], tempAttr[9], tempAttr[10]);//instantiate the character using the attributes we read
            if (fileScan.hasNextLine()) {//we use a blank line to separate characters so we need to skip over it
                fileScan.nextLine();
            }//end of if statement
        }//end of for loop
        fileScan.close();//close fileScan to stop the memory leakage

		//load the questions from a file
        String[] tempQuestion = new String[3];//this takes more memory than reusing tempAttr but is better form
		URL questionsFilePath = Game.class.getResource("Questions.txt");
        file = new File(questionsFilePath.toURI());
        fileScan = new Scanner(file);
        for (int i = 0; i < Constants.GameGUI.NUM_QUESTIONS; i++){
            linkedNumCharsToCopy[i] = 0;//initialize with values
            for (int j = 0; j < 3; j++){
                tempQuestion[j] = fileScan.nextLine();
            }//end of smol for loop
            questionListToCopy[i] = new Question(tempQuestion[0], tempQuestion[1],tempQuestion[2]);
            for (int j = 0; j < Constants.GameGUI.NUM_CHAR; j++){//this is for the AI
                if (questionListToCopy[i].getValueToCheck().equals(charListToCopy[j].getValueOfAttributeFromString(questionListToCopy[i].getAttribute()))){
                    linkedNumCharsToCopy[i]++;//increase the number of characters that can say "yes" to the question by 1
                }//end of the if statement
            }//end of smol for loop #2
            if (fileScan.hasNextLine()) {//we use a blank line to separate questions so we need to skip over it
                fileScan.nextLine();
            }//end of if statement
        }//end of for loop
        fileScan.close();//close again to stop the memory leakage

		//START THE GAME BY DISPLAYING THE home window WINDOWWWW
		HomeGUI.display();
    }//end of main method

	//This is the third time writing these Javadocs because VSCode LiveShare is buggy. I apologize for the Javadocs being overly concise

	/**
	 * 
	 */
	public static String convertBoolToYesOrNo(Boolean response){
		String valueToReturn = null;
		if (response){
			valueToReturn = "yes";
		} else {
			valueToReturn = "no";
		}
		return valueToReturn;
	}//end of convertBoolToYesOrNo method

	/**
	 * A getter method that returns a copy of the array of all the Guess Who characters as BoardCharacters
	 * @return the array of all guess who characters as BoardCharacters
	 */
	public static BoardCharacter[] getCharListToCopy(){
		BoardCharacter[] newList = new BoardCharacter[Constants.GameGUI.NUM_CHAR];//we need to make a new array to stop pass by reference
		for (int i = 0; i < Constants.GameGUI.NUM_CHAR; i++){
			newList[i] = new BoardCharacter(charListToCopy[i]);//we need to make new boardcharacters to stop pass by reference
		}//end of for loop
		return newList;
	}//end of charListToCopy getter

	/**
	 * A getter method that returns a copy of the array of all the questions that can be asked
	 * @return the array of all questions, with a unique memory location for the array
	 */
	public static Question[] getQuestionListToCopy(){
		Question[] newList = new Question[Constants.GameGUI.NUM_QUESTIONS];
		for (int i = 0; i < Constants.GameGUI.NUM_QUESTIONS; i++){
			newList[i] = questionListToCopy[i];
		}//end of for loop
		return newList;//we only need to make a new array object because the question objects aren't being modifed, just the array order
	}//end of questionListToCopy getter

	/**
	 * A getter method that returns a copy of the array of how characters can say "yes" to each question. See AI.java for more details on how it works
	 * @return the copied array of linkedNumCharsToCopy with a unique memory address
	 */
	public static int[] getLinkedNumCharsToCopy(){
		int[] newList = new int[Constants.GameGUI.NUM_QUESTIONS];//we need to make a new list to stop pass by reference
		for (int i = 0; i < Constants.GameGUI.NUM_QUESTIONS; i++){
			newList[i] = linkedNumCharsToCopy[i];//integers are primitive so they are passed by value
		}//end of for loop
		return newList;
	}//end of linkedNumCharsToCopy getter


	/**
	 * Setter method to add/update the Settings HashMap.
	 * @param key the key for the hashmap
	 * @param value the value for the hashmap
	 */
	public static void setSetting(String key, String val){
		Settings.put(key, val);
	}//end of addSetting method
	
	/**
	 * Getter method to get the value from the Settings HashMap given a key.
	 * @param key the key of the value to get
	 * @return the value from the key
	 */
	public static String getSettingVal(String key){
		return Settings.get(key);
	}

	/**
	 * A function for setting up the player array when the game is restarted
	 * @param type the type of game to be played
	 */
	public static void setupPlayerArray(Constants.GameTypes type) throws IOException {
		playerArr = new Player[2];//this might be a fix idk
		if (type.equals(Constants.GameTypes.PVP)){//Player vs Player.
			playerArr[0] = new Human(getCharListToCopy());
			playerArr[1] = new Human(getCharListToCopy());
		}else if (type.equals(Constants.GameTypes.PVE)){//VS AI.
			playerArr[0] = new Human(getCharListToCopy());
			//instantiate the AI with a random mystery character
			playerArr[1] = new AI(getCharListToCopy()[(int) Math.floor(Math.random() * Constants.GameGUI.NUM_CHAR)],Integer.parseInt(Settings.get("Difficulty")),getCharListToCopy(),getQuestionListToCopy(),getLinkedNumCharsToCopy());
		}//end of if/else tree
	}//end of setupPlayerArray method

	/**
	 * Setter method for the curTurn variable
	 * @param turn the turn to set it to be
	 */
	public static void setCurTurn(int turn){
		curTurn = Math.min(Math.max(turn,0),1);//set the current turn to 0 or 1, even if the arguement is not within that range
	}//end of setCurTurn method

	/**
	 * Getter method for the current turn
	 * @return the current turn (either 0 or 1)
	 */
	public static int getCurTurn(){
		return curTurn;
	}//end of getCurTurn method

	/**
	 * A helper method that switches the current turn (0 <-> 1).
	 */
	public static void switchTurn(){
		if (curTurn == 0){
			curTurn = 1;
		} else {
			curTurn = 0;
		}//end of if/else statements
	}//end of switchTurn method

	/**
	 * Getter method for playerArr.
	 * @return the array of Players of the current game
	 */
	public static Player[] getPlayerArray() {
		return playerArr;
	}//end of getPlayerArray method

	/**
	 * Getter method for the isUndergoingGame variable
	 * @return whether the game is undergoing or not
	 */
	public static boolean getIsUndergoingGame(){
		return isUndergoingGame;
	}//end of getIsUndergoingGame method

	/**
	 * Setter method for the isUndergoingGame variable.
	 * @param newStatus the new status of whether a game is currently being played or not
	 */
	public static void setIsUndergoingGame(boolean newStatus){
		isUndergoingGame = newStatus;
	}//end of setIsUndergoingGame method

	/**
	 * Getter method for the gameType variable
	 * @return the game type that is currently ongoing
	 */
	public static Constants.GameTypes getGameType(){
		return gameType;
	}//end of getGameType method

	/**
	 * Setter method for the gameType variable
	 * @param newGameType the new game type that has just started
	 */
	public static void setGameType(Constants.GameTypes newGameType){
		gameType = newGameType;
	}//end of setGameType method

	/**
	 * A method that returns the name of the player given a turn value (0 or 1).
	 * @param index the turn of the name to get
	 * @return the name of the Player at that turn
	 */
	public static String getPlayerNameFromIndex(int index){
		if (playerArr[index] instanceof AI){
			return (Constants.GameGUI.AI_NAME);//if they are looking for the AI's name, use the AI's name
		} else {
			return getSettingVal("Player"+Integer.toString(index+1)+"Name");//get the name of the player
		}//end of if/else tree
	}//end of getPlayerNameFromIndex method

	/**
	 * Setter method for the winnerIndex variable.
	 * @param theIndex the index of the winner (0 or 1)
	 */
	public static void setWinnerIndex(int theIndex){
		winnerIndex = theIndex;
	}//end of setWinner method

	/**
	 * Getter method for the winnerIndex variable.
	 * @return the index of the winning Player
	 */
	public static int getWinnerIndex() {
		return winnerIndex;
	}//end of getWinner method

	/**
	 * Setter method for the currentQuestion variable.
	 * @param newQuestion the new current question (the question that was just asked)
	 */
	public static void setCurrentQuestion(Question newQuestion){
		currentQuestion = newQuestion;
	}//end of setCurrentQuestion method

	/**
	 * Getter method for the currentQuestion variable.
	 * @return the current question (the question that was just asked)
	 */
	public static Question getCurrentQuestion(){
		return currentQuestion;
	}//end of getCurrentQuestion method

	/**
	 * Gets the opposite turn of the current turn. 
	 * @return the turn that isn't the curTurn
	 */
	public static int getOtherTurn(){//this looks really stupid and probably is really stupid
		if (curTurn == 0){
			return 1;
		} else{
			return 0;
		}//end of if/else tree
	}//end of getOtherTurn method

	/**
	 * A helper method that removes HTML <br>s from a string, replacing them with spaces. 
	 * @return the new string with spaces instead of <br>s
	 */
	public static String removeBRs(String original){
		return original.replaceAll("<br>"," ");//removing breaklines to replace with space 
	}//end of removeBRs method
	
	//Question History methods

	/**
	 * Helper method to add a QuestionHistory object to the questionHistoryArrList (the array list of question history). It also writes it to the log file.
	 * @param in the QuestionHistory to input
	 */
	public static void addToHistory(QuestionHistory in) {
		writeLine("- "+in.getPlayer() + " asked the question: "+removeBRs(in.getQuestion().getPhrasing())+" | the answer was "+convertBoolToYesOrNo(in.getResponse()));
		questionHistoryArrList.add(0, in);
	}//end of addToHistory method

	/**
	 * 	Helper method to get the Player name of the person who asked a question previously in the game.
	 * @param i the index of questionHistoryArrList to get the Player name of
	 * @return the name of the person who asked that question
	 */
	public static String getHistoryPlayer(int i) {
		return questionHistoryArrList.get(i).getPlayer();
	}//end of getHistoryPlayer method
	
	/**
	 * 	Helper method to get the phrasing of a question asked previously in the game.
	 * @param i the index of questionHistoryArrList to get the question phrasing of
	 * @return the phrasing of the questionHistory searched for
	 */
	public static String getHistoryQuestionAsked(int i) {
		return questionHistoryArrList.get(i).getQuestion().getPhrasing();
	}//end of getHistoryQuestion method

	/**
	 * 	Helper method to get the response to a question asked previously in the game.
	 * @param i the index of questionHistoryArrList to get the Player name of
	 * @return the name of the person who asked that question
	 */
	public static boolean getHistoryResponse(int i) {
		return questionHistoryArrList.get(i).getResponse();
	}//end of getHistoryResponse method

	/**
	 * Helper method to reset the questionHistoryArrList to being empty. Called when a game ends.
	 */
	public static void resetHistory() {
		questionHistoryArrList.clear();
	}//end of resetHistory method

	/**
	 * Getter method for the questionHistoryArrList ArrayList.
	 * @return the array list of question history for the current game
	 */
	public static ArrayList<QuestionHistory> getHistory() {
		return questionHistoryArrList;
	}//end of getHistory method



	// --- game logic methods ---

	/**
	 * The method that is called when the user closes the window.
	 */
	public static void onWindowClose(){
		if (isUndergoingGame){
			 writeLine(getPlayerNameFromIndex(curTurn)+" closed the window while their game against "+getPlayerNameFromIndex(getOtherTurn())+" was ongoing!\n");
		}//end of if statement
		closeLogWriter();
		System.exit(0);
	}//end of onWindowClose() method

	/**
	 * The method that is called when the user starts a game by choosing who goes first.
	 * @param startIndex the index of whic
	 * h player starts
	 */
	public static void startGame(int startIndex){
		//date time formatting code is from w3schools (https://www.w3schools.com/java/java_date.asp)
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);
		//change variables we need to do
		setIsUndergoingGame(true);
		setCurTurn(startIndex);
		writeLine(getPlayerNameFromIndex(getCurTurn())+ " starts their match vs "+ getPlayerNameFromIndex(getOtherTurn())+" at " + formattedDate);
		if (startIndex == 1 && getGameType() == Constants.GameTypes.PVE){//if its a Player Vs AI game and the AI starts
			setCurrentQuestion(((AI) getPlayerArray()[getCurTurn()]).getBestQuestion());//set the current question to the AI's guess
			switchTurn();
			AnswerQuestionGUI.display();
		} else {//just start normall
			GameGUI.display();
		}//end of if/else tree
	}//end of startGame method

	/**
	 * The logic method that executes when a Human Player chooses a question to ask.
	 * @param q the question the player chose to ask
	 */
	public static void onQuestionChosen(Question q){
		setCurrentQuestion(q);
		switchTurn();//set it to opponent's turn
		if (gameType == Constants.GameTypes.PVP){
			AnswerQuestionGUI.display();
		} else { //playing it against ai
			boolean AIResponse = ((AI) playerArr[curTurn] ).getAIResponse(currentQuestion.getAttribute(),currentQuestion.getValueToCheck());
			playerArr[getOtherTurn()].eliminateByAttribute(currentQuestion,AIResponse);//characters on the player's board are eliminated according to the AI's response
			addToHistory(new QuestionHistory(getPlayerNameFromIndex(getOtherTurn()), q, AIResponse));//add to history the question chosen
			AIReponseGUI.display();//show the user the AI's response
		}//end of if/else tree
	}//end of onQuestionChosen method

	/**
	 * The logic method that executes when the player presses the continue button in the AIResponseGUI class in a Player vs AI game.
	 */
	public static void onAnswerAccepted(){
		setCurrentQuestion(((AI) playerArr[getCurTurn()]).getBestQuestion());//ai gets a question
		switchTurn();//set it back to player's turn
		AnswerQuestionGUI.display();//get the user to answer the AI's question
	}//end of onAnswerAccepted method

	/**
	 * The logic method that executes when a Human Player chooses to guess a character
	 * @param charGuessed the character the Human Player chose to guess
	 */
	public static void onCharacterGuessChosen(BoardCharacter charGuessed){
		setCurrentQuestion(new Question("Is the person's name "+charGuessed.getName()+"?","name", charGuessed.getName()));//create a new question
		if (gameType == Constants.GameTypes.PVP){//PLAYER VS PLAYER
			switchTurn();
			gameType = Constants.GameTypes.NONE;
			isUndergoingGame = false;
			AnswerQuestionGUI.display();
		} else if (gameType == Constants.GameTypes.PVE) {//VS AI
			if (((AI) getPlayerArray()[getOtherTurn()] ).getAIResponse(getCurrentQuestion().getAttribute(),getCurrentQuestion().getValueToCheck())){
				addToHistory(new QuestionHistory(getPlayerNameFromIndex(curTurn), currentQuestion, true));//add to question history. AI said yes
				setWinnerIndex(getCurTurn());
			} else {//guess was wrong
				addToHistory(new QuestionHistory(getPlayerNameFromIndex(curTurn), currentQuestion, false));//add to question history. AI said no
				setWinnerIndex(getOtherTurn());
			}//end of if/else tree for AI
			gameType = Constants.GameTypes.NONE;
			isUndergoingGame = false;
			GameResultGUI.display();//go to win/loss screen
		} else {
			System.out.println("game.onCharacterGuessChosen() is broken");
		}//end of if/else tree for game type
	}//end of onCharacterGuessChosen

	/**
	 * The logic method that executes when a Human Player answers a question
	 * @param wasYes whether they answered yes to the question (if they didn't answer yes they answered no)
	 */
	public static void onQuestionAnswered(boolean wasYes){
		addToHistory(new QuestionHistory(getPlayerNameFromIndex(getOtherTurn()), currentQuestion, wasYes));//add to question history
		if (currentQuestion.getAttribute().equals("name")){//if the guess is for a person
			//the game is now over
            if (wasYes){//the player said yes
                setWinnerIndex(getOtherTurn());//if they say yes to the other player's guess, than the other player wins
				writeLine(getPlayerNameFromIndex(getOtherTurn())+" correctly guessed "+getPlayerNameFromIndex(getCurTurn())+"'s mystery character ("+currentQuestion.getValueToCheck()+")!\n");
				setIsUndergoingGame(false);
       			setGameType(Constants.GameTypes.NONE);
				GameResultGUI.display();//show the end of game screen
            } else {//the player said no
				if (gameType == Constants.GameTypes.PVE && playerArr[getOtherTurn()].calcRemainingChars() == 1){//if the AI has 1 character remaining but the guess is still seen as wrong
					writeLine(getPlayerNameFromIndex(getCurTurn())+" says that "+getPlayerNameFromIndex(getOtherTurn())+"'s guess of "+ currentQuestion.getValueToCheck()+" was wrong!\n");
					setIsUndergoingGame(false);
       				setGameType(Constants.GameTypes.NONE);
					AskForRightCharacterGUI.display();//display the ask for right character screen
				} else {//if its a Player Vs. Player game or the AI did a random guess (which happens when their opponent is at 1 character)
                	setWinnerIndex(curTurn);//if they say no, then they win
					setIsUndergoingGame(false);
       				setGameType(Constants.GameTypes.NONE);
					writeLine(getPlayerNameFromIndex(getOtherTurn())+" incorrectly guessed "+getPlayerNameFromIndex(getCurTurn())+"'s mystery character (They guessed "+currentQuestion.getValueToCheck()+")!\n");
				 	GameResultGUI.display();//show the end of game screen
				}//end of inner if/else tree
            }//end of if/else tree
        } else {//guess is not for a person
			//System.out.println(Game.getCurrentQuestion().getPhrasing());
			//addToHistory(new QuestionHistory(getPlayerNameFromIndex(getOtherTurn()), currentQuestion, wasYes));
			playerArr[getOtherTurn()].eliminateByAttribute(currentQuestion,wasYes);//other player eliminates their characters
            GameGUI.display();//continue on with the game
        }//end of if/else tree
	}//end of onQuestionAnswered
	
	/**
	 * The logic method that executes after the Human Player says the AI guessed wrong and they submit whot their mystery character was
	 * @param charName the name of the character the user enters
	 * @return The text to display back to the user
	 */
	public static String onUserSubmitsTheirMysteryCharacter(String charName){
		BoardCharacter[] aiGuessingArray = playerArr[getOtherTurn()].getGuessingArray();//its ok to pass by reference since we aren't modifying anything
		BoardCharacter playerChosenMysteryCharacter = null;//the BoardCharacter the player chose
		boolean isCharNameReal = false;//if the character name the user inputs belongs to a real character or not
		
		for (int i = 0; i < Constants.GameGUI.NUM_CHAR; i++){//loop through all characters
			if (aiGuessingArray[i].getName().equalsIgnoreCase(charName)){//check to see if the user entered the name of a real character
				isCharNameReal = true;
				playerChosenMysteryCharacter = aiGuessingArray[i];//get the user's character as a BoardCharacter object
			}//end of if statement
		}//end of for loop

		if (charName.equalsIgnoreCase(currentQuestion.getValueToCheck())){//if the Character the user inputted is the same as the character the AI guessed
			return ("The character you entered ("+charName+")<br>is the same character the AI guessed.");
		} else if (!isCharNameReal){//if the character name doesn't correspond to any character
			return ("The character you entered ("+charName+")<br>does not exist.");
		} else {//they entered a legiminate character
			for(int i = 0; i < Game.getHistory().size(); i++){//search through game history
				QuestionHistory qHist = Game.getHistory().get(i);//we create a variable here to make it easier
				if (qHist.getPlayer().equals(Constants.GameGUI.AI_NAME) && (qHist.getQuestion().getValueToCheck() == playerChosenMysteryCharacter.getValueOfAttributeFromString(qHist.getQuestion().getAttribute())) != qHist.getResponse()){//if the question is asked by the AI and the actual answer to the question is different than how the player answered the question
					return("The AI asked this question: "+qHist.getQuestion().getPhrasing()+"<br>. You answered "+convertBoolToYesOrNo(qHist.getResponse())+", but in reality it is "+ convertBoolToYesOrNo(!qHist.getResponse())); //we corner the user with the truth
				}//end of if statement
			}//end of for loop
		}//end of if/elseif/else tree
		return null;//we need a return for all circumstances but this never executes
	}//end of onUserSubmitsTheirMysterCharacter method

	// --- logging methods --- 

	
	/**
	 * A method that writes a line to log.txt.
	 * @param line the line to write to the file
	 */
	public static void writeLine(String line){
		//System.out.println("logWriter wrote: "+line);
		try {
			logWriter.write(line + "\n");
			logWriter.flush();
		} catch (Exception e){
			e.printStackTrace();
		}//end of ttrycatch
	}//end of writeLine method

	/**
	 * A method that closes the log writer.
	 */
	public static void closeLogWriter(){
		//System.out.println("Closed");
		try {
			logWriter.write("\n");//add a new line
			logWriter.close();
		} catch (IOException e){
			e.printStackTrace();
		}//end of try/Catch
	}//end of closeLogWriter method


// --- music methods ---

	/**
	 * A method that starts playing music.
	 */
	public static void startMusic() throws URISyntaxException {
		try {//we use try catch because there are a lot of errors. The structure of the try/catch is totally normal dont worry about it
			URL musicFilePath = Game.class.getResource("music/Music.wav");
			File musicFile = new File(musicFilePath.toURI());
			try {
				audioStream = AudioSystem.getAudioInputStream(musicFile);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (UnsupportedAudioFileException e) {
				e.printStackTrace();
			}//end of try/catch #1

			try {
				clip = AudioSystem.getClip();
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			}//end of try/catch #2
				clip.open(audioStream);
			} catch (LineUnavailableException | IOException e) {
			e.printStackTrace();
			}//end of big try/catch 
		//play the music
		clip.start(); 
		clip.loop(Clip.LOOP_CONTINUOUSLY);//make it loop forever... :)
	}//end of startMusic method
	
	/**
	 * Method to end music.
	 */
	public static void endMusic() {
		clip.close();
	}//end of endMusic method

//commenting is pain
}//end of Game class
