/**
* @author Wen Yao Zhang, Nicolas Chan, Henderson Harper
* Date: January 13th, 2024
* File Name: SettingsGUI.java
* Description: SettingsGUI is a class that holds the GUI for the settings menu.
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SettingsGUI extends TemplateGUI{
	/**
	 * The display method creates and displays the screen to the window
	 */
    public static void display() { //The display method is what is called when we want the screen to be displayed
        Constants.HomeGUI.isHomeGUI = false;
        HomeGUI.frame.getContentPane().removeAll();

        JPanel settingsPanel = new JPanel();
        settingsPanel.setOpaque(false);
        settingsPanel.setLayout(new GridLayout(3,3,30,50));//we use gridLayout to format the menu
        settingsPanel.setBounds(100,160,600,480);//set the boundaries

		// add in the new images for the textfields
		JPanel textFieldImages1 = new JPanel();
		textFieldImages1.setOpaque(false);
		textFieldImages1.setBounds(260,175,260,90);
		JLabel textFieldImagesHolder1 = new JLabel();
		textFieldImagesHolder1.setIcon(Constants.Images.RESIZED_STEAMPUNK_TEXT_FIELD);
		textFieldImages1.add(textFieldImagesHolder1);
		
		// Create a tint panel
        JPanel coloredPanel1 = new JPanel();
		coloredPanel1.setPreferredSize(new Dimension(800,800));
        coloredPanel1.setBackground(Constants.Colors.DARK_BROWN_2);
		coloredPanel1.setOpaque(true);
		coloredPanel1.setBounds(0,100,800,700);

		// create new images for the textfield
		JPanel textFieldImages2 = new JPanel();
		textFieldImages2.setOpaque(false);
		textFieldImages2.setBounds(260,350,260,90);
		JLabel textFieldImagesHolder2 = new JLabel();
		textFieldImagesHolder2.setIcon(Constants.Images.RESIZED_STEAMPUNK_TEXT_FIELD);
		textFieldImages2.add(textFieldImagesHolder2);

        //player 1 name setting
        JLabel p1Label = new JLabel("<html><b>Player 1 Name:</b> <br>(Plays against AI)<br>Current name: <b>"+Game.getSettingVal("Player1Name")+"</html>");
        p1Label.setForeground(Color.white);
        p1Label.setFont(Constants.Fonts.SILVER_FONT);
		p1Label.setHorizontalTextPosition(SwingConstants.LEFT);
        JTextField p1TextField = new JTextField(Game.getSettingVal("Player1Name"));
		p1TextField.setOpaque(false);
        p1TextField.setFont(Constants.Fonts.SILVER_FONT);
		p1TextField.setForeground(Color.white);
		p1TextField.setPreferredSize(new Dimension(230,80));;
		p1TextField.setBorder(null);
        JButton p1Button = new JButton();
        p1Button.setOpaque(false);
		p1Button.setFocusPainted(false);
		p1Button.setContentAreaFilled(false);
		p1Button.setBorderPainted(false);
        p1Button.setIcon(Constants.Images.RESIZED_SUBMIT_BUTTON_2);
        p1Button.setFont(Constants.Fonts.SILVER_FONT);
		p1Button.setToolTipText("Left click to set name");
        p1Button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
				//Change the sprite/image of the button to change to the hover version of the image (Image 1. Button is lowered a little)
				Constants.Images.confirmMouseHover18 = true;
				p1Button.setIcon(Constants.Images.RESIZED_SUBMIT_BUTTON_1);
			} //end of mouseEntered
		
			public void mouseExited(MouseEvent e) {
				//Change the sprite/image of the button to change to the neutral/non pressed version of the image (Image 2. No change to button.)
				Constants.Images.confirmMouseHover18 = false;
				p1Button.setIcon(Constants.Images.RESIZED_SUBMIT_BUTTON_2);
			} //end of mouse Exited
		
			public void mousePressed(MouseEvent e) {
				//Change the sprite/image of the button to change to the pressed version of the image (Image 23. Button is all the way down and is darker.)
				p1Button.setIcon(Constants.Images.RESIZED_SUBMIT_BUTTON_3);
			} //end of mousePressed method
		
			public void mouseReleased(MouseEvent e) {
				//Executes the code after the mouse is released on the button.
				if(Constants.Images.confirmMouseHover18){
					Game.setSetting("Player1Name",p1TextField.getText());
                    p1Label.setText("<html><b>Player 1 Name:<br>Current name: "+Game.getSettingVal("Player1Name")+"</html>");
				}//end of if statement
			} //end of mouseReleased method
		}); //end of actionlistener adding thing

        //player 2 name setting
        JLabel p2Label = new JLabel("<html><b>Player 2 Name:<br></b>Current name: <b>"+Game.getSettingVal("Player2Name")+"</html>");
        p2Label.setForeground(Color.white);
        p2Label.setFont(Constants.Fonts.SILVER_FONT);
        JTextField p2TextField = new JTextField(Game.getSettingVal("Player2Name"));
		p2TextField.setOpaque(false);
		p2TextField.setBorder(null);
        p2TextField.setFont(Constants.Fonts.SILVER_FONT);
		p2TextField.setForeground(Color.white);
        JButton p2Button = new JButton();
        p2Button.setOpaque(false);
		p2Button.setFocusPainted(false);
		p2Button.setContentAreaFilled(false);
		p2Button.setBorderPainted(false);
        p2Button.setIcon(Constants.Images.RESIZED_SUBMIT_BUTTON_2);
        p2Button.setFont(Constants.Fonts.SILVER_FONT);
		p2Button.setToolTipText("Left click to set name");
        p2Button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
				//Change the sprite/image of the button to change to the hover version of the image (Image 1. Button is lowered a little)
				Constants.Images.confirmMouseHover18 = true;
				p2Button.setIcon(Constants.Images.RESIZED_SUBMIT_BUTTON_1);
			} //end of mouseEntered
		
			public void mouseExited(MouseEvent e) {
				//Change the sprite/image of the button to change to the neutral/non pressed version of the image (Image 2. No change to button.)
				Constants.Images.confirmMouseHover18 = false;
				p2Button.setIcon(Constants.Images.RESIZED_SUBMIT_BUTTON_2);
			} //end of mouse Exited
		
			public void mousePressed(MouseEvent e) {
				//Change the sprite/image of the button to change to the pressed version of the image (Image 23. Button is all the way down and is darker.)
				p2Button.setIcon(Constants.Images.RESIZED_SUBMIT_BUTTON_3);
			} //end of mousePressed method
		
			public void mouseReleased(MouseEvent e) {
				//Executes the code after the mouse is released on the button.
				if(Constants.Images.confirmMouseHover18){
					Game.setSetting("Player2Name",p2TextField.getText());
                	p2Label.setText("<html><b>Player 2 Name:<br>Current name: "+Game.getSettingVal("Player2Name")+"</html>");
				}//end of if statement
			} //end of mouseReleased method
		}); //end of actionlistener adding thing

        //difficulty settings
        JLabel diffLabel = new JLabel("<html><center><b>Difficulty (1-10):<br>Current Difficulty: "+Game.getSettingVal("Difficulty")+"</b><br>Difficulty does not change once the game is started!</html>");
        diffLabel.setForeground(Color.white);
        diffLabel.setFont(Constants.Fonts.SILVER_FONT);
		diffLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JButton diffButtonDown = new JButton();
		diffButtonDown.setOpaque(false);
		diffButtonDown.setFocusPainted(false);
		diffButtonDown.setContentAreaFilled(false);
		diffButtonDown.setBorderPainted(false);
		diffButtonDown.setIcon(Constants.Images.RESIZED_DEC_BUTTON_2);
        diffButtonDown.setFont(Constants.Fonts.SILVER_FONT);
		diffButtonDown.setHorizontalAlignment(SwingConstants.RIGHT);
		diffButtonDown.setToolTipText("Left click to decrease difficult");
		diffButtonDown.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
				//Change the sprite/image of the button to change to the hover version of the image (Image 1. Button is lowered a little)
				Constants.Images.confirmMouseHover19 = true;
				diffButtonDown.setIcon(Constants.Images.RESIZED_DEC_BUTTON_1);
			} //end of mouseEntered
		
			public void mouseExited(MouseEvent e) {
				//Change the sprite/image of the button to change to the neutral/non pressed version of the image (Image 2. No change to button.)
				Constants.Images.confirmMouseHover19 = false;
				diffButtonDown.setIcon(Constants.Images.RESIZED_DEC_BUTTON_2);
			} //end of mouse Exited
		
			public void mousePressed(MouseEvent e) {
				//Change the sprite/image of the button to change to the pressed version of the image (Image 23. Button is all the way down and is darker.)
				diffButtonDown.setIcon(Constants.Images.RESIZED_DEC_BUTTON_3);
			} //end of mousePressed method
		
			public void mouseReleased(MouseEvent e) {
				//Executes the code after the mouse is released on the button.
				if(Constants.Images.confirmMouseHover19){
					Game.setSetting("Difficulty",Integer.toString(Math.max(Integer.parseInt(Game.getSettingVal("Difficulty"))-1,1)));//difficulty decreases by 1 unless difficulty is already at 1
               		diffLabel.setText("<html><center><b>Difficulty (1-10):<br>Current Difficulty: "+Game.getSettingVal("Difficulty")+"</html>");//update text
				}//end of if statement
			} //end of mouseReleased method
		}); //end of actionlistener adding thing
        JButton diffButtonUp = new JButton();
		diffButtonUp.setOpaque(false);
		diffButtonUp.setFocusPainted(false);
		diffButtonUp.setContentAreaFilled(false);
		diffButtonUp.setBorderPainted(false);
		diffButtonUp.setIcon(Constants.Images.RESIZED_ADD_BUTTON_2);
        diffButtonUp.setFont(Constants.Fonts.SILVER_FONT);
		diffButtonUp.setHorizontalAlignment(SwingConstants.LEFT);
		diffButtonUp.setToolTipText("Left click to increase difficulty");
		diffButtonUp.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
				//Change the sprite/image of the button to change to the hover version of the image (Image 1. Button is lowered a little)
				Constants.Images.confirmMouseHover20 = true;
				diffButtonUp.setIcon(Constants.Images.RESIZED_ADD_BUTTON_1);
			} //end of mouseEntered
		
			public void mouseExited(MouseEvent e) {
				//Change the sprite/image of the button to change to the neutral/non pressed version of the image (Image 2. No change to button.)
				Constants.Images.confirmMouseHover20 = false;
				diffButtonUp.setIcon(Constants.Images.RESIZED_ADD_BUTTON_2);
			} //end of mouse Exited
		
			public void mousePressed(MouseEvent e) {
				//Change the sprite/image of the button to change to the pressed version of the image (Image 23. Button is all the way down and is darker.)
				diffButtonUp.setIcon(Constants.Images.RESIZED_ADD_BUTTON_3);
			} //end of mousePressed method
		
			public void mouseReleased(MouseEvent e) {
				//Executes the code after the mouse is released on the button.
				if(Constants.Images.confirmMouseHover20){
					Game.setSetting("Difficulty",Integer.toString(Math.min(Integer.parseInt(Game.getSettingVal("Difficulty"))+1,10)));//difficulty increases by 1 unless difficulty is already at 10
               		diffLabel.setText("<html><center><b>Difficulty (1-10):<br>Current Difficulty: "+Game.getSettingVal("Difficulty")+"</html>");//update text
				}//end of if statement
			} //end of mouseReleased method
		}); //end of actionlistener adding thing

        //add our items to the panel in order 

        //add player 1 name
        settingsPanel.add(p1Label);
        settingsPanel.add(p1TextField);
        settingsPanel.add(p1Button);

        //add player 2 name
        settingsPanel.add(p2Label);
        settingsPanel.add(p2TextField);
        settingsPanel.add(p2Button);

        //add difficulty
        settingsPanel.add(diffButtonDown);
        settingsPanel.add(diffLabel);
        settingsPanel.add(diffButtonUp);

        
        /*
		// instructions
		// create a panel to store the intructions
		JPanel infoPanel = new JPanel();
		infoPanel.setOpaque(false);
		JLabel instructions = new JLabel();
		instructions.setText("<html>Guess Who? is a two player game where players use differential yes or no questions to isolate a hidden character. The first player to guess the other player's hidden character wins.<br><br>Each player looks at their game board of 24 faces and thinks of a mystery character. The mystery character is the character your opponent has to guess and the character you have to answer questions about.<br><br>The youngest player goes first, beginning by asking the other player a characteristic found on one of their 24 visible characters (both players have the same 24 tiles). Example: “Does your character have long hair?”<br><br>If they say, “yes,” the asking player flips over all of the characters without long hair. If they say, “no,” the asking player flips over the characters that have long hair. Through the process of elimination, players will eventually be able to “guess” the name of the opponent's character.<br><br>Each player gets one yes or no question per turn and may only guess (to win the game) once per game. If a player successfully guesses their opponent's hidden character then they win; if their guess is wrong then they lose.<br><br>This version of Guess Who supports local Player-vs-Player and Player-vs-AI modes.</html>");
		instructions.setPreferredSize(new Dimension(550, 630)); 
		//instructions.setHorizontalAlignment(JLabel.TOP);
		infoPanel.add(instructions);
		infoPanel.setBounds(0, 100, 800, 800);
        */

		// title
		// create a panel to store the title
		JPanel titlePanel = new JPanel();
		titlePanel.setOpaque(false);
		titlePanel.setBounds(325,0,300,100);
		JLabel settingsTitle = new JLabel();
		settingsTitle.setText("Settings");
		settingsTitle.setPreferredSize(new Dimension(300, 100));
		settingsTitle.setFont(Constants.Fonts.TF_FONT_TITLE);
        settingsTitle.setForeground(Color.white);
		titlePanel.add(settingsTitle);

        // add the sound button
		TemplateGUI.addSoundButton();

		// display panels on HomeGUI frame
        addBackButton();
		HomeGUI.frame.add(settingsPanel);
		HomeGUI.frame.add(titlePanel);
		HomeGUI.frame.add(textFieldImages1);
		HomeGUI.frame.add(textFieldImages2);
		HomeGUI.frame.add(coloredPanel1);
		//Reload the and allow it to display the new screen
		HomeGUI.frame.repaint();
		HomeGUI.frame.revalidate();
    }//end of display method

}//end of settingsGUI class