/**
 * @author Wen Yao Zhang, Nicolas Chan, Henderson Harper
 * Date: January 13th, 2024
 * File Name: InfoGUI.java
 * Description: The GUI class for the information screen.
 * 				Its purpose is to inform users how to play the game of Guess Who.
 */
import java.awt.*;
import javax.swing.*;

public class InfoGUI extends TemplateGUI{
	
	/**
	 * The display method is called when the screen is to run. It displays the information screen on the frame.
	 */
    public static void display() {
		Constants.HomeGUI.isHomeGUI = false;
		HomeGUI.frame.getContentPane().removeAll();
		// title
		// create a panel to store the title
		JPanel titlePanel = new JPanel();
		titlePanel.setOpaque(false);
		titlePanel.setBounds(240, 0, 500, 100);
		JLabel instructionsTitle = new JLabel();
		instructionsTitle.setText("About the Game");
		instructionsTitle.setPreferredSize(new Dimension(500, 100));
		instructionsTitle.setFont(Constants.Fonts.TF_FONT_TITLE);
		instructionsTitle.setForeground(Color.white);
		titlePanel.add(instructionsTitle);

		// Create a tint panel
        JPanel coloredPanel1 = new JPanel();
		coloredPanel1.setPreferredSize(new Dimension(800,800));
        coloredPanel1.setBackground(Constants.Colors.SEMI_TRANSPARENT);
		coloredPanel1.setOpaque(true);
		coloredPanel1.setBounds(0,100,800,700);

		// instructions
		// create a panel to store the intructions
		JPanel infoPanel = new JPanel();
		infoPanel.setOpaque(false);

		JLabel instructions = new JLabel();
		instructions.setText("<html>Guess Who? is a two player game where players use differential yes or no questions to isolate a hidden character. The first player to guess the other player's hidden character wins.<br><br>Each player looks at their game board of 24 faces and thinks of a mystery character. The mystery character is the character your opponent has to guess and the character you have to answer questions about.<br><br>The youngest player goes first, beginning by asking the other player a characteristic found on one of their 24 visible characters (both players have the same 24 tiles). Example: “Does your character have long hair?”<br><br>If they say, “yes,” the asking player flips over all of the characters without long hair. If they say, “no,” the asking player flips over the characters that have long hair. Through the process of elimination, players will eventually be able to “guess” the name of the opponent's character.<br><br>Each player gets one yes or no question per turn and may only guess (to win the game) once per game. If a player successfully guesses their opponent's hidden character then they win; if their guess is wrong then they lose.<br><br>This version of Guess Who supports local Player-vs-Player and Player-vs-AI modes. The Player-vs-AI mode has a configurable difficulty, with 1 being the easiest and 10 being the hardest.</html>");
		instructions.setPreferredSize(new Dimension(600, 640)); 
		instructions.setFont(Constants.Fonts.SILVER_FONT);
		instructions.setForeground(Color.white);
		infoPanel.add(instructions);
		infoPanel.setBounds(0, 80, 800, 800);

		// display panels on HomeGUI frame
        //HomeGUI.frame.add(backPanel);
		addBackButton();
		HomeGUI.frame.add(infoPanel);
		HomeGUI.frame.add(titlePanel);
		// add the sound button
		TemplateGUI.addSoundButton();
		//Reload the and allow it to display the new screen
		HomeGUI.frame.add(coloredPanel1);
		HomeGUI.frame.repaint();
		HomeGUI.frame.revalidate();
    }//end of display method

}//end of InfoGUI class
