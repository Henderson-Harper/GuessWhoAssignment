/**
 * @author Wen Yao Zhang, Nicolas Chan, Henderson Harper
 * Date: January 13th, 2024
 * File Name: AIResponseGUI.java
 * Description: A screen that displays the AI's response to a question the user asks
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AIReponseGUI extends TemplateGUI{
	
	/**
	 * Displays AI's reponse to the question on screen
	 * Continue by pressing "Ok"
	 * @return void
	 */
    public static void display() {
        HomeGUI.frame.getContentPane().removeAll(); // Remove everything from the frame

		// Displays the text that tells you the AI is responding
		JPanel titlePanel = new JPanel(); 
		titlePanel.setOpaque(false); 
		titlePanel.setBounds(100, 60, 600, 100); 
		JLabel titleLabel = new JLabel(); 
        titleLabel.setText("<html><center>"+Game.getPlayerNameFromIndex(Game.getOtherTurn())+", "+Game.getPlayerNameFromIndex(Game.getCurTurn())+"<br>responded with: </html>");// changes the player based on whose turn it is
		titleLabel.setFont(Constants.Fonts.TF_FONT_TITLE);
		titleLabel.setForeground(Color.white); 
		titlePanel.add(titleLabel); 

		// Displays what the AI is reponding with
		JPanel AIReponsePanel = new JPanel();
		AIReponsePanel.setOpaque(false);
		JLabel AIReponse = new JLabel();
		AIReponse.setText("<html><center>"+Game.convertBoolToYesOrNo(Game.getHistoryResponse(0))+"</html>"); // tells you the reponse of the AI
		AIReponse.setFont(Constants.Fonts.TF_FONT_TITLE);
		AIReponse.setForeground(Color.white);
		AIReponsePanel.add(AIReponse);
		AIReponsePanel.setBounds(100, 200, 600, 200);


        // create a panel to store the reponse
		JPanel okPanel = new JPanel(new GridLayout(1,1));
		okPanel.setOpaque(false);
		okPanel.setBounds(250,550,300,120);
		JButton okButton = new JButton();
		okButton.setOpaque(false);
		okButton.setFocusPainted(false);
		okButton.setContentAreaFilled(false);
		okButton.setBorderPainted(false);
		okButton.setPreferredSize(new Dimension(300,120));
		okButton.setIcon(Constants.Images.RESIZED_CONTINUE_BUTTON_2);
		okButton.setToolTipText("Left Click to continue");
		okButton.addMouseListener(new MouseAdapter() { //Mouse listener to detect when the ok button is pressed
            public void mouseEntered(MouseEvent e) {
				//Change the sprite/image of the button to change to the hover version of the image (Image 1. Button is lowered a little)
				Constants.Images.confirmMouseHover15 = true;
				okButton.setIcon(Constants.Images.RESIZED_CONTINUE_BUTTON_1);
			} //end of mouseEntered
		
			public void mouseExited(MouseEvent e) {
				//Change the sprite/image of the button to change to the neutral/non pressed version of the image (Image 2. No change to button.)
				Constants.Images.confirmMouseHover15 = false;
				okButton.setIcon(Constants.Images.RESIZED_CONTINUE_BUTTON_2);
			} //end of mouse Exited
		
			public void mousePressed(MouseEvent e) {
				//Change the sprite/image of the button to change to the pressed version of the image (Image 23. Button is all the way down and is darker.)
				okButton.setIcon(Constants.Images.RESIZED_CONTINUE_BUTTON_3);
			} //end of mousePressed method
		
			public void mouseReleased(MouseEvent e) {
				//Executes the code after the mouse is released on the button.
				if(Constants.Images.confirmMouseHover15){
					Game.onAnswerAccepted();
				}//end of if statement
			} //end of mouseReleased method
		}); //end of actionlistener adding thing
		okPanel.add(okButton);

		// add the sound button
		TemplateGUI.addSoundButton();
		// display panels on HomeGUI frame
        HomeGUI.frame.add(okPanel);
		HomeGUI.frame.add(AIReponsePanel);
		HomeGUI.frame.add(titlePanel);

		//Reload the and allow it to display the new screen
		HomeGUI.frame.repaint();
		HomeGUI.frame.revalidate();
    }//end of display method

}//end of InfoGUI class
