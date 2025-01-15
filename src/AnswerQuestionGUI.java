/**
 * @author Wen Yao Zhang, Nicolas Chan, Henderson Harper
 * Date: January 13th, 2024
 * File Name: AnswerQuestionGUI.java
 * Description: The screen that appears when the current Human Player is asked a question by their opponent.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AnswerQuestionGUI extends TemplateGUI{
	
	/*
	 * Displays a Question on screen
	 * Answer by pressing the "Yes" or "No" button
	 */
    public static void display() {
        HomeGUI.frame.getContentPane().removeAll(); // Remove everything from the frame

		// Displays the person who is asking the question and who that is directed to
		JPanel titlePanel = new JPanel(); // create new panel
		titlePanel.setOpaque(false); // make it transparent
		titlePanel.setBounds(100, 60, 600, 90); // set location and size
		JLabel titleLabel = new JLabel(); // create a label
        titleLabel.setText("<html><center>"+Game.getPlayerNameFromIndex(Game.getCurTurn())+", "+Game.getPlayerNameFromIndex(Game.getOtherTurn())+"<br>asks you a question: </html>");// changes the text and when you receive a question it is your turn
		titleLabel.setPreferredSize(new Dimension(600, 90)); // change the size of the label
		titleLabel.setFont(Constants.Fonts.TF_FONT_TITLE); // change the font
		titleLabel.setForeground(Color.white); // change the colour of the font
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlePanel.add(titleLabel); // add the label to the panel

		// Displays question asked by player
		JPanel questionPanel = new JPanel();
		questionPanel.setOpaque(false);
		JLabel question = new JLabel();
		question.setText("<html><center>"+Game.getCurrentQuestion().getPhrasing()+"</html>");
		question.setPreferredSize(new Dimension(600, 150)); 
		question.setFont(Constants.Fonts.TF_FONT_TITLE);
		question.setForeground(Color.white);
		question.setHorizontalAlignment(SwingConstants.CENTER);
		questionPanel.add(question);
		questionPanel.setBounds(100, 200, 600, 300);


        // create panel to store the yes panel
		JPanel yesPanel = new JPanel();
		yesPanel.setOpaque(false);
		yesPanel.setBounds(50,550,300,120);
		JButton YES_BUTTON_ = new JButton();
		YES_BUTTON_.setOpaque(false);
		YES_BUTTON_.setFocusPainted(false);
		YES_BUTTON_.setContentAreaFilled(false);
		YES_BUTTON_.setBorderPainted(false);
		YES_BUTTON_.setPreferredSize(new Dimension(300,120)); 
		YES_BUTTON_.setIcon(Constants.Images.RESIZED_YES_CHOICE_BUTTON_2);
		YES_BUTTON_.setToolTipText("Left Click to answer yes");
		YES_BUTTON_.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
				//Change the sprite/image of the button to change to the hover version of the image (Image 1. Button is lowered a little)
				Constants.Images.confirmMouseHover15 = true;
				YES_BUTTON_.setIcon(Constants.Images.RESIZED_YES_CHOICE_BUTTON1);
                
			} //end of mouseEntered
		
			public void mouseExited(MouseEvent e) {
				//Change the sprite/image of the button to change to the neutral/non pressed version of the image (Image 2. No change to button.)
				Constants.Images.confirmMouseHover15 = false; 
				YES_BUTTON_.setIcon(Constants.Images.RESIZED_YES_CHOICE_BUTTON_2);
			} //end of mouse Exited
		
			public void mousePressed(MouseEvent e) {
				//Change the sprite/image of the button to change to the pressed version of the image (Image 23. Button is all the way down and is darker.)
				YES_BUTTON_.setIcon(Constants.Images.RESIZED_YES_CHOICE_BUTTON_3);
			} //end of mousePressed method
		
			public void mouseReleased(MouseEvent e) {
				//Executes the code after the mouse is released on the button.
				if(Constants.Images.confirmMouseHover15){
					Game.onQuestionAnswered(true);
				}
			} //end of mouseReleased method
		}); //end of actionlistener adding thing
		yesPanel.add(YES_BUTTON_);

        // create panel to store the no panel
		JPanel noPanel = new JPanel();
		noPanel.setOpaque(false);
		noPanel.setBounds(450,550,300,120);
		JButton noButton = new JButton();
		noButton.setOpaque(false);
		noButton.setFocusPainted(false);
		noButton.setContentAreaFilled(false);
		noButton.setBorderPainted(false);
		noButton.setPreferredSize(new Dimension(300,120));
		noButton.setIcon(Constants.Images.RESIZED_NO_CHOICE_BUTTON_2);
		noButton.setToolTipText("Left Click to answer no");
		noButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
				//Change the sprite/image of the button to change to the hover version of the image (Image 1. Button is lowered a little)
				Constants.Images.confirmMouseHover16 = true;
				noButton.setIcon(Constants.Images.RESIZED_NO_CHOICE_BUTTON_1);
			} //end of mouseEntered
		
			public void mouseExited(MouseEvent e) {
				//Change the sprite/image of the button to change to the neutral/non pressed version of the image (Image 2. No change to button.)
				Constants.Images.confirmMouseHover16 = false;
				noButton.setIcon(Constants.Images.RESIZED_NO_CHOICE_BUTTON_2);
			} //end of mouse Exited
		
			public void mousePressed(MouseEvent e) {
				//Change the sprite/image of the button to change to the pressed version of the image (Image 23. Button is all the way down and is darker.)
				noButton.setIcon(Constants.Images.RESIZED_NO_CHOICE_BUTTON_3);
			} //end of mousePressed method
		
			public void mouseReleased(MouseEvent e) {
				//Executes the code after the mouse is released on the button.
				if(Constants.Images.confirmMouseHover16){
					Game.onQuestionAnswered(false);
				}
			} //end of mouseReleased method
		}); //end of actionlistener adding thing
		noPanel.add(noButton);

		// add the sound button
		TemplateGUI.addSoundButton();
		// display panels on HomeGUI frame
        HomeGUI.frame.add(yesPanel);
        HomeGUI.frame.add(noPanel);
		HomeGUI.frame.add(questionPanel);
		HomeGUI.frame.add(titlePanel);
		
		//Reload the and allow it to display the new screen
		HomeGUI.frame.repaint();
		HomeGUI.frame.revalidate();
    }//end of display method
}//end of InfoGUI class