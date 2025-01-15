/**
 * @author Wen Yao Zhang, Nicolas Chan, Henderson Harper
 * Date: January 13th, 2024
 * File Name: AskForRightCharacterGUI.java
 * Description: A GUI screen for when the Human player disputes the AI's (theoretically) correct guess of the Human's myster character
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AskForRightCharacterGUI extends TemplateGUI{
	
	/**
	 * The display method creates and displays the screen to the window
	 * @return void
	 */
    public static void display() {
        HomeGUI.frame.getContentPane().removeAll();

		// title
		// create a panel to store the title
		JPanel titlePanel = new JPanel();
		titlePanel.setOpaque(false);
		titlePanel.setBounds(100, 20, 800, 45);
		JLabel titleLabel = new JLabel();
        titleLabel.setText("ERROR RESOLUTION");//because
		titleLabel.setPreferredSize(new Dimension(600, 45));
		titleLabel.setFont(Constants.Fonts.TF_FONT_TITLE);
		titleLabel.setForeground(Color.white);
		titlePanel.add(titleLabel);
		

		// Question
		// create a panel to store asking part
		// 
		JPanel questionPanel = new JPanel();
		questionPanel.setOpaque(false);
		JLabel questionLabel = new JLabel();
		questionLabel.setText("<html>The AI had eliminated all character except "+Game.getCurrentQuestion().getValueToCheck()+".<br>Enter your mystery character:<br><br>By the way, " + Game.getPlayerNameFromIndex(1)+ "'s mystery character was "+ ((AI) Game.getPlayerArray()[1]).getMCName() +".</html>");
		questionLabel.setPreferredSize(new Dimension(600, 200)); 
		questionLabel.setFont(Constants.Fonts.SILVER_FONT);
		questionLabel.setForeground(Color.white);
		questionPanel.add(questionLabel);
		questionPanel.setBounds(100, 200, 600, 200);

		// Response
		// create a panel to store asking part
		JPanel responsePanel = new JPanel();
		responsePanel.setOpaque(false);
		JLabel responseLabel = new JLabel();
		responseLabel.setText("...");
		responseLabel.setPreferredSize(new Dimension(600, 180)); 
		responseLabel.setFont(Constants.Fonts.SILVER_FONT);
		responseLabel.setForeground(Color.white);
		responsePanel.add(responseLabel);
		responsePanel.setBounds(100, 400, 600, 180);

		// add in the new images for the textfields
		JPanel textFieldImages1 = new JPanel();
		textFieldImages1.setOpaque(false);
		textFieldImages1.setBounds(35,645,300,90);
		JLabel textFieldImagesHolder1 = new JLabel();
		textFieldImagesHolder1.setIcon(Constants.Images.RESIZED_STEAMPUNK_TEXT_FIELD);
		textFieldImages1.add(textFieldImagesHolder1);

        // create panel to store the submit panel
		JPanel submitPanel = new JPanel(new GridLayout(1,2));
		submitPanel.setOpaque(false);
		submitPanel.setBounds(100,630,400,120);
        JTextField submitTF = new JTextField("enter name here");
		submitTF.setForeground(Color.white);
		submitTF.setOpaque(false);
		submitTF.setBorder(null);
		JButton submitButton = new JButton("submit");
		submitButton.setToolTipText("Left Click to submit the name of your character");
        submitButton.setOpaque(false);
		submitButton.setFocusPainted(false);
		submitButton.setContentAreaFilled(false);
		submitButton.setBorderPainted(false);
        submitButton.setIcon(Constants.Images.RESIZED_SUBMIT_BUTTON_2);
        submitButton.setFont(Constants.Fonts.SILVER_FONT);
		submitButton.setToolTipText("Left click to set name");
        submitButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
				//Change the sprite/image of the button to change to the hover version of the image (Image 1. Button is lowered a little)
				Constants.Images.confirmMouseHover18 = true;
				submitButton.setIcon(Constants.Images.RESIZED_SUBMIT_BUTTON_1);
			} //end of mouseEntered
		
			public void mouseExited(MouseEvent e) {
				//Change the sprite/image of the button to change to the neutral/non pressed version of the image (Image 2. No change to button.)
				Constants.Images.confirmMouseHover18 = false;
				submitButton.setIcon(Constants.Images.RESIZED_SUBMIT_BUTTON_2);
			} //end of mouse Exited
		
			public void mousePressed(MouseEvent e) {
				//Change the sprite/image of the button to change to the pressed version of the image (Image 23. Button is all the way down and is darker.)
				submitButton.setIcon(Constants.Images.RESIZED_SUBMIT_BUTTON_3);
			} //end of mousePressed method
		
			public void mouseReleased(MouseEvent e) {
				//Executes the code after the mouse is released on the button.
				if(Constants.Images.confirmMouseHover18){
					String txt = ("<html>"+Game.onUserSubmitsTheirMysteryCharacter(submitTF.getText())+"</html>");
				responseLabel.setText(txt);//update the response label
				}//end of if statement
			} //end of mouseReleased method
		}); //end of actionlistener adding thing
		submitPanel.add(submitTF);
		submitPanel.add(submitButton);

		// display panels on HomeGUI frame
        addBackButton();
        HomeGUI.frame.add(submitPanel);
		HomeGUI.frame.add(questionPanel);
		HomeGUI.frame.add(responsePanel);
		HomeGUI.frame.add(textFieldImages1);
		HomeGUI.frame.add(titlePanel);

		//Reload the and allow it to display the new screen
		HomeGUI.frame.repaint();
		HomeGUI.frame.revalidate();
    }//end of display method
}//end of InfoGUI class