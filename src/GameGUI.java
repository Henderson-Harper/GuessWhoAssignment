/**
 * @author Wen Yao Zhang, Nicolas Chan, Henderson Harper
 * Date: January 13th, 2024
 * File Name: 
 * Description: A large GUI class that displays the game/playing screen. There are buttons to:
 * 				- Go back to home and abandon the match (HomeGUI.java)
 * 				- Enter the settings screen (SettingsGUI.java)
 * 				- Enter the Information screen (InfoGUI.java)
 * 				- Ask a question (ChooseQuestionGUI.java)
 * 				- Guess the opponents character (GuessCharacterGUI.java)
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameGUI extends TemplateGUI {
    private static final int CHAR_ROWS = Constants.GameGUI.CHAR_ROWS;
    private static final int CHAR_COLS = Constants.GameGUI.CHAR_COLS;
    private static final int SELECT_ROWS = Constants.GameGUI.SELECTION_ROWS;
    private static final int SELECT_COLS = Constants.GameGUI.SELECTION_COLS;

    /**
	 * The display method creates and displays the GameGUI screen to the window so the user can see it.
	 */
    public static void display() {
        HomeGUI.frame.getContentPane().removeAll();//clear everything that existed previously
        
		// create  a panel to store the background gif
		JPanel background = new JPanel();
		background.setOpaque(false);
		ImageIcon backgroundIcon = new ImageIcon(HomeGUI.class.getResource("images/assets/images/Background2.png"));
      	JLabel backgroundIconHolder = new JLabel();
		backgroundIconHolder.setIcon(backgroundIcon);
		backgroundIcon.setImageObserver(backgroundIconHolder);
		background.add(backgroundIconHolder);
		background.setBounds(0, -5, 800, 800);

        BoardCharacter[] bcArr = (Game.getPlayerArray()[Game.getCurTurn()]).getGuessingArray();//array of boardCharacters of the current player

        //add a label to display the current player
		JPanel currentPlayerBackgroundPanel = new JPanel();
		JLabel backgroundImageHolder = new JLabel();
		backgroundImageHolder.setIcon(Constants.Images.RESIZED_CURRENT_PLAYER_LABEL_ICON);
		currentPlayerBackgroundPanel.add(backgroundImageHolder);
		currentPlayerBackgroundPanel.setOpaque(false);
		currentPlayerBackgroundPanel.setPreferredSize(new Dimension(600,100));
		currentPlayerBackgroundPanel.setBounds(10,0,600,100);
        JLabel currTurnLabel = new JLabel("<html>Current Player:"+"</html>");//display the name of the current player
		JLabel currPlayerLabel = new JLabel("<html>"+Game.getPlayerNameFromIndex(Game.getCurTurn())+"</html>");
		currPlayerLabel.setFont(Constants.Fonts.SILVER_FONT_LARGE);
		if (Game.getCurTurn() == 0){
			currPlayerLabel.setForeground(Color.RED);
		}
		else{
			currPlayerLabel.setForeground(Color.BLUE);
		}
        JPanel turnPanel = new JPanel();
		JPanel turnPlayerPanel = new JPanel();
		turnPlayerPanel.add(currPlayerLabel);
		turnPlayerPanel.setOpaque(false);
		turnPlayerPanel.setPreferredSize(new Dimension(600,50));
		turnPlayerPanel.setBounds(0,45,600,100);
		currTurnLabel.setFont(Constants.Fonts.TF_FONT_TITLE_2);
		currTurnLabel.setForeground(Color.white);
		turnPanel.add(currTurnLabel);
        turnPanel.setOpaque(false);
        turnPanel.setPreferredSize(new Dimension(600, 50));
        turnPanel.setBounds(10, 10, 600, 100);

        // create panel to store the home button
		JPanel homePanel = new JPanel();
		homePanel.setOpaque(false);
		homePanel.setBounds(10,10,75,75);
		// create the home button
		JButton homeButton = new JButton();
        homeButton.setOpaque(false);
		homeButton.setContentAreaFilled(false);
		homeButton.setBorderPainted(false);
		homeButton.setToolTipText("Left click to return to the home screen");
        homeButton.setPreferredSize(new Dimension(70, 70));
        homeButton.setIcon(Constants.Images.RESIZED_HOME_LOGO_2);
        homeButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
				//Change the sprite/image of the button to change to the hover version of the image (Image 1. Button is lowered a little)
				Constants.Images.confirmMouseHover7 = true;
				homeButton.setIcon(Constants.Images.RESIZED_HOME_LOGO_1);
                
			} //end of mouseEntered
		
			public void mouseExited(MouseEvent e) {
				//Change the sprite/image of the button to change to the neutral/non pressed version of the image (Image 2. No change to button.)
				Constants.Images.confirmMouseHover7 = false;
				homeButton.setIcon(Constants.Images.RESIZED_HOME_LOGO_2);
			} //end of mouse Exited
		
			public void mousePressed(MouseEvent e) {
				//Change the sprite/image of the button to change to the pressed version of the image (Image 23. Button is all the way down and is darker.)
				homeButton.setIcon(Constants.Images.RESIZED_HOME_LOGO_3);
			} //end of mousePressed method
		
			public void mouseReleased(MouseEvent e) {
				//Executes the code after the mouse is released on the button.
				if(Constants.Images.confirmMouseHover7){
					Game.setIsUndergoingGame(false);//end game
                    Game.setGameType(Constants.GameTypes.NONE);
                    Game.writeLine(Game.getPlayerNameFromIndex(Game.getCurTurn())+ " abandoned the match vs "+ Game.getPlayerNameFromIndex(Game.getOtherTurn())+"\n");
                    HomeGUI.display();
				}
			} //end of mouseReleased method
		}); //end of actionlistener adding thing
		homePanel.add(homeButton);

		//add the panel for displaying the BoardCharacters the Player sees
        JPanel charBoardPanel = new JPanel(new GridLayout(CHAR_ROWS, CHAR_COLS,10,10));
        for (int i = 0; i < CHAR_ROWS*CHAR_COLS; i++) {
            ImageIcon character;
            if(!bcArr[i].isEliminated()) {//if the character is not eliminated...
                character = new ImageIcon(HomeGUI.class.getResource(bcArr[i].getImgAddress()));//... show their image
            } else {//if they are eliminated...
                character = new ImageIcon(HomeGUI.class.getResource("images/characters/Blank.jpg"));//... show a blank (flipped down)
            }//end of if/else
            charBoardPanel.add(new JLabel(character));
        }//end of for loop
        charBoardPanel.setBounds(25, 100, 500, 542); 
        charBoardPanel.setOpaque(false);

		//question button (goes to ChooseQuestionGUI screen when pressed)
        JButton question = new JButton();
        question.setOpaque(false);
		question.setContentAreaFilled(false);
		question.setBorderPainted(false);
        question.setFocusPainted(false);
        question.setIcon(Constants.Images.RESIZED_QUESTION_BUTTON_2);
		question.setToolTipText("Left Click to choose a question to ask");

		//instructions button (goes to InfoGUI screen when pressed)
        JButton instructions = new JButton();
        instructions.setOpaque(false);
		instructions.setContentAreaFilled(false);
		instructions.setBorderPainted(false);
        instructions.setFocusPainted(false);
        instructions.setIcon(Constants.Images.RESIZED_INSTRUCTIONS_BUTTON_2);
		instructions.setToolTipText("Left Click to see the instructions");

		//guess character button (goes to GuessCharacterGUI when pressed)
        JButton guessChar = new JButton();
        guessChar.setOpaque(false);
		guessChar.setContentAreaFilled(false);
		guessChar.setBorderPainted(false);
        guessChar.setFocusPainted(false);
        guessChar.setIcon(Constants.Images.RESIZED_GUESS_BUTTON_2);
		guessChar.setToolTipText("Left Click to choose a character to guess");

		//settings button (goes to SettingsGUI when pressed)
        JButton settings = new JButton();
        settings.setOpaque(false);
		settings.setContentAreaFilled(false);
		settings.setBorderPainted(false);
        settings.setFocusPainted(false);
        settings.setIcon(Constants.Images.RESIZED_SETTINGS_CHOICE_BUTTON_1);
		settings.setToolTipText("Left Click to go to the settings menu");

		//The panel that holds the 4 buttons
        JPanel selectionPanel = new JPanel(new GridLayout(SELECT_ROWS, SELECT_COLS,0,0));
        selectionPanel.setOpaque(false);
        selectionPanel.setBounds(25, 650, 500, 100);
		//add the buttons to the panel
        selectionPanel.add(question);
        selectionPanel.add(instructions);
        selectionPanel.add(guessChar);
        selectionPanel.add(settings);

		//the mouseListener parts (button functionality)

		//Question button
        question.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Constants.Images.confirmMouseHover11 = true;
				question.setIcon(Constants.Images.RESIZED_QUESTION_BUTTON_1);
			} //end of mouseEntered
		
			public void mouseExited(MouseEvent e) {
				//Change the sprite/image of the button to change to the neutral/non pressed version of the image (Image 2. No change to button.)
				Constants.Images.confirmMouseHover11 = false;
				question.setIcon(Constants.Images.RESIZED_QUESTION_BUTTON_2);
			} //end of mouse Exited
		
			public void mousePressed(MouseEvent e) {
				//Change the sprite/image of the button to change to the pressed version of the image (Image 23. Button is all the way down and is darker.)
				question.setIcon(Constants.Images.RESIZED_QUESTION_BUTTON_3);
			} //end of mousePressed method
		
			public void mouseReleased(MouseEvent e) {
				//Executes the code after the mouse is released on the button.
				if(Constants.Images.confirmMouseHover11){
					ChooseQuestionGUI.display();
				}
			} //end of mouseReleased method
		}); //end of actionlistener adding thing
        
		//instructions button
        instructions.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Constants.Images.confirmMouseHover12 = true;
				instructions.setIcon(Constants.Images.RESIZED_INSTRUCTIONS_BUTTON_1);
			} //end of mouseEntered
		
			public void mouseExited(MouseEvent e) {
				//Change the sprite/image of the button to change to the neutral/non pressed version of the image (Image 2. No change to button.)
				Constants.Images.confirmMouseHover12 = false;
				instructions.setIcon(Constants.Images.RESIZED_INSTRUCTIONS_BUTTON_2);
			} //end of mouse Exited
		
			public void mousePressed(MouseEvent e) {
				//Change the sprite/image of the button to change to the pressed version of the image (Image 23. Button is all the way down and is darker.)
				instructions.setIcon(Constants.Images.RESIZED_INSTRUCTIONS_BUTTON_3);
			} //end of mousePressed method
		
			public void mouseReleased(MouseEvent e) {
				//Executes the code after the mouse is released on the button.
				if(Constants.Images.confirmMouseHover12){
					InfoGUI.display();
				}
			} //end of mouseReleased method
		}); //end of actionlistener adding thing


		//Guess Character button
		/*
        guessChar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuessCharacterGUI.display();
			}
		});
		*/
        guessChar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Constants.Images.confirmMouseHover13 = true;
				guessChar.setIcon(Constants.Images.RESIZED_GUESS_BUTTON_1);
			} //end of mouseEntered
		
			public void mouseExited(MouseEvent e) {
				//Change the sprite/image of the button to change to the neutral/non pressed version of the image (Image 2. No change to button.)
				Constants.Images.confirmMouseHover13 = false;
				guessChar.setIcon(Constants.Images.RESIZED_GUESS_BUTTON_2);
			} //end of mouse Exited
		
			public void mousePressed(MouseEvent e) {
				//Change the sprite/image of the button to change to the pressed version of the image (Image 23. Button is all the way down and is darker.)
				guessChar.setIcon(Constants.Images.RESIZED_GUESS_BUTTON_3);
			} //end of mousePressed method
		
			public void mouseReleased(MouseEvent e) {
				//Executes the code after the mouse is released on the button.
				if(Constants.Images.confirmMouseHover13){
					GuessCharacterGUI.display();
				}
			} //end of mouseReleased method
		}); //end of actionlistener adding thing

		//setting button
        settings.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Constants.Images.confirmMouseHover14 = true;
				settings.setIcon(Constants.Images.RESIZED_SETTINGS_CHOICE_BUTTON_1);
			} //end of mouseEntered
		
			public void mouseExited(MouseEvent e) {
				//Change the sprite/image of the button to change to the neutral/non pressed version of the image (Image 2. No change to button.)
				Constants.Images.confirmMouseHover14 = false;
				settings.setIcon(Constants.Images.RESIZED_SETTINGS_CHOICE_BUTTON_2);
			} //end of mouse Exited
		
			public void mousePressed(MouseEvent e) {
				//Change the sprite/image of the button to change to the pressed version of the image (Image 23. Button is all the way down and is darker.)
				settings.setIcon(Constants.Images.RESIZED_SETTINGS_CHOICE_BUTTON_3);
			} //end of mousePressed method
		
			public void mouseReleased(MouseEvent e) {
				//Executes the code after the mouse is released on the button.
				if(Constants.Images.confirmMouseHover14){
					SettingsGUI.display();
				}
			} //end of mouseReleased method
		}); //end of actionlistener adding thing



        //Question history panel
        JPanel historyPanel = new JPanel(new GridLayout(4, 1));
        for (int i = 0; i < Math.min(Game.getHistory().size(),4); i++) {//if there are >4 questions asked, loop through the 4 most recent questions. If not, loop through all questions
			//create a JLabel that displays the question history in a formatted way
            JLabel logLabel = new JLabel("<html>" + Game.getHistoryPlayer(i)+" asked: "+Game.getHistoryQuestionAsked(i)+"<br>Answer: "+Game.convertBoolToYesOrNo(Game.getHistoryResponse(i)));
            logLabel.setFont(Constants.Fonts.SILVER_FONT);
            logLabel.setForeground(Constants.Colors.SILVER);
			logLabel.setPreferredSize(new Dimension(200, 130));
            historyPanel.add(logLabel);//add the label to the panel
        }//end of for loop

		//add the background image that goes under the text of the history
        JLabel historyImageLabel = new JLabel(Constants.Images.RESIZED_HISTORY_IMAGE_ICON);
        historyImageLabel.setBounds(510, 30, 303, 800);
        historyPanel.setOpaque(false);
        historyPanel.setBounds(587, 140, 166, 480);        

		//Panel that tells you how many characters the opponent has remaining
        JPanel oppRemainingPanel = new JPanel();
        oppRemainingPanel.setOpaque(false);
        oppRemainingPanel.setBounds(615,660,240,80);
		//This label tells you how many characters your opponent has remaining
        JLabel oppRemainingLabel = new JLabel("<html><center>"+Game.getPlayerNameFromIndex(Game.getOtherTurn())+" has <b>"+Game.getPlayerArray()[Game.getOtherTurn()].getCharsRemaining()+"</b><br>characters<br>remaining</html>");
		oppRemainingLabel.setPreferredSize(new Dimension(230,80));
        oppRemainingLabel.setFont(Constants.Fonts.SILVER_FONT_MEDIUM);
        oppRemainingLabel.setForeground(Color.white);
        oppRemainingPanel.add(oppRemainingLabel);
        
		//add everything to the frame and display it
		TemplateGUI.addSoundButton();
        HomeGUI.frame.add(turnPanel);
		HomeGUI.frame.add(turnPlayerPanel);
        HomeGUI.frame.add(homePanel);
		HomeGUI.frame.add(oppRemainingPanel);
        HomeGUI.frame.add(charBoardPanel);
        HomeGUI.frame.add(selectionPanel);
        HomeGUI.frame.add(historyPanel);
        HomeGUI.frame.add(historyImageLabel);
		HomeGUI.frame.add(currentPlayerBackgroundPanel);
        HomeGUI.frame.add(background);
        HomeGUI.frame.repaint();
		HomeGUI.frame.revalidate();
    }//end of display method
}