/**
 * @author Wen Yao Zhang, Nicolas Chan, Henderson Harper
 * Date: January 13th, 2024
 * File Name: FirstTurnChoiceGUI
 * Description: The screen that displays when the user clicks to start a game. 
 * 				There are options for either player 1 (human) or player 2 (other Human if PVP, or the AI if PVE)
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FirstTurnChoiceGUI extends TemplateGUI{
	
    public static void display() {
		Constants.HomeGUI.isHomeGUI = false;
        HomeGUI.frame.getContentPane().removeAll();

		// Create a tint panel
        JPanel coloredPanel = new JPanel();
		coloredPanel.setPreferredSize(new Dimension(800,800));
        coloredPanel.setBackground(Constants.Colors.SEMI_TRANSPARENT);
		coloredPanel.setOpaque(true);
		coloredPanel.setBounds(0,403,800,50);

		// create  a panel to store the background 
		JPanel background = new JPanel();
		background.setOpaque(false);
		ImageIcon backgroundIcon = new ImageIcon(HomeGUI.class.getResource("images/assets/images/Background1.png"));
      	JLabel backgroundIconHolder = new JLabel();
		backgroundIconHolder.setIcon(backgroundIcon);
		backgroundIcon.setImageObserver(backgroundIconHolder);
		background.add(backgroundIconHolder);
		background.setBounds(0, -5, 800, 800);

		// title
		// create a panel to store the title
		JPanel titlePanel = new JPanel();
		titlePanel.setOpaque(false);
		JLabel fcTitle = new JLabel();
		if (Game.getGameType().equals(Constants.GameTypes.PVP)){//if the game is a player vs player game (PVP)
            fcTitle.setText("Player Vs Player");
			titlePanel.setBounds(230, 130, 600, 45);
        } else {//if not, it is player vs ai
            fcTitle.setText("Player Vs AI");
			titlePanel.setBounds(290, 130, 600, 45);
        }//end of if/else tree
		fcTitle.setPreferredSize(new Dimension(600, 45));
		fcTitle.setFont(Constants.Fonts.TF_FONT_TITLE);
		fcTitle.setForeground(Color.white);
		titlePanel.add(fcTitle);

		// title background
		// create a panel to store the title background
		JPanel titleBackground = new JPanel();
		titleBackground.setBounds(120, 100, 600, 300);
		titleBackground.setOpaque(false);
		JLabel backgroundHolder = new JLabel();
		backgroundHolder.setIcon(Constants.Images.RESIZED_CURRENT_PLAYER_LABEL_ICON_2);
		titleBackground.add(backgroundHolder);

		// Question
		// create a panel to store the question
		JPanel questionPanel = new JPanel();
		questionPanel.setOpaque(false);
		JLabel question = new JLabel();
		question.setText("Who do you want to go first?");
		question.setPreferredSize(new Dimension(600, 150)); 
		question.setFont(Constants.Fonts.TF_FONT_SUBTITLE_2);
		question.setForeground(Color.white);
		questionPanel.add(question);
		questionPanel.setBounds(250, 150, 600, 300);

		JPanel reminderPanel = new JPanel();
		reminderPanel.setOpaque(false);
		JLabel reminder = new JLabel();
		reminder.setText("Remember to think of a mystery character!");
		reminder.setPreferredSize(new Dimension(800, 150)); 
		reminder.setFont(Constants.Fonts.TF_FONT_SUBTITLE);
		reminder.setForeground(Color.white);
		reminderPanel.add(reminder);
		reminderPanel.setBounds(125, 350, 800, 100);

        // create panel to store the player1 panel
		JPanel player1Panel = new JPanel();
		player1Panel.setOpaque(false);
		player1Panel.setBounds(50,550,300,120);
		JPanel player1TextPanel = new JPanel();
		player1TextPanel.setOpaque(false);
		player1TextPanel.setBounds(50,578,300,120);
		JLabel player1Label = new JLabel("<html><center>" + Game.getPlayerNameFromIndex(0) + "</center></html>");
		player1Label.setForeground(Constants.Colors.SILVER);
		player1Label.setFont(Constants.Fonts.TF_FONT_SUBTITLE);
		JButton player1Button = new JButton();
		player1Button.setOpaque(false);
		player1Button.setFocusPainted(false);
		player1Button.setContentAreaFilled(false);
		player1Button.setBorderPainted(false);
		player1Button.setIcon(Constants.Images.RESIZED_BUTTON_TEMPLATE_2);
		player1Button.setToolTipText("Left Click to get " + Game.getPlayerNameFromIndex(0) + " to go first");
		player1Button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
				//Change the sprite/image of the button to change to the hover version of the image (Image 1. Button is lowered a little)
				Constants.Images.confirmMouseHover9 = true;
				player1Button.setIcon(Constants.Images.RESIZED_BUTTON_TEMPLATE_1);
				player1TextPanel.setBounds(50,581,300,120);
			} //end of mouseEntered
		
			public void mouseExited(MouseEvent e) {
				//Change the sprite/image of the button to change to the neutral/non pressed version of the image (Image 2. No change to button.)
				Constants.Images.confirmMouseHover9 = false;
				player1Button.setIcon(Constants.Images.RESIZED_BUTTON_TEMPLATE_2);
				player1TextPanel.setBounds(50,578,300,120);
			} //end of mouse Exited
		
			public void mousePressed(MouseEvent e) {
				//Change the sprite/image of the button to change to the pressed version of the image (Image 23. Button is all the way down and is darker.)
				player1Button.setIcon(Constants.Images.RESIZED_BUTTON_TEMPLATE_3);
				player1TextPanel.setBounds(50,581,300,120);
			} //end of mousePressed method
		
			public void mouseReleased(MouseEvent e) {
				//Executes the code after the mouse is released on the button.
				if(Constants.Images.confirmMouseHover9){
					Game.startGame(0);
				}//end of if statement
			} //end of mouseReleased method
		}); //end of actionlistener adding thing
		player1Panel.add(player1Button);
		player1TextPanel.add(player1Label);

        // create panel to store the player2 panel
		JPanel player2Panel = new JPanel();
		player2Panel.setOpaque(false);
		player2Panel.setBounds(450,550,300,120);
		JPanel player2TextPanel = new JPanel();
		player2TextPanel.setOpaque(false);
		player2TextPanel.setBounds(450,578,300,120);
		JLabel player2Label = new JLabel();
		JButton player2Button = new JButton();
		player2Button.setIcon(Constants.Images.RESIZED_BUTTON_TEMPLATE_1);
		player2Button.setOpaque(false);
		player2Button.setFocusPainted(false);
		player2Button.setContentAreaFilled(false);
		player2Button.setBorderPainted(false);
		player2Button.setPreferredSize(new Dimension(300,120));
		player2Label.setFont(Constants.Fonts.TF_FONT_SUBTITLE);
		player2Label.setForeground(Constants.Colors.SILVER);
		player2Button.setToolTipText("Left Click to get " + Game.getPlayerNameFromIndex(1) + " to go first");
        if (Game.getPlayerArray()[1].getClass() == Human.class){
            player2Label.setText("<html><center>" + Game.getPlayerNameFromIndex(1) + "</center></html>");
		} else {
            player2Label.setText("<html><center>" + Game.getPlayerNameFromIndex(1) + " (Level: "+Game.getSettingVal("Difficulty") + ")</center></html>");
		}//end of if/else tree

		player2Button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
				//Change the sprite/image of the button to change to the hover version of the image (Image 1. Button is lowered a little)
				Constants.Images.confirmMouseHover10 = true;
				player2Button.setIcon(Constants.Images.RESIZED_BUTTON_TEMPLATE_1);
				player2TextPanel.setBounds(450,581,300,120);
			} //end of mouseEntered
		
			public void mouseExited(MouseEvent e) {
				//Change the sprite/image of the button to change to the neutral/non pressed version of the image (Image 2. No change to button.)
				Constants.Images.confirmMouseHover10 = false;
				player2Button.setIcon(Constants.Images.RESIZED_BUTTON_TEMPLATE_2);
				player2TextPanel.setBounds(450,578,300,120);
			} //end of mouse Exited
		
			public void mousePressed(MouseEvent e) {
				//Change the sprite/image of the button to change to the pressed version of the image (Image 23. Button is all the way down and is darker.)
				player2Button.setIcon(Constants.Images.RESIZED_BUTTON_TEMPLATE_3);
				player2TextPanel.setBounds(450,581,300,120);
			} //end of mousePressed method
		
			public void mouseReleased(MouseEvent e) {
				//Executes the code after the mouse is released on the button.
				if(Constants.Images.confirmMouseHover10){
					Game.startGame(1);
				}//end of if statement
			} //end of mouseReleased method
		}); //end of actionlistener adding thing

		player2Panel.add(player2Button);
		player2TextPanel.add(player2Label);

		// display panels on HomeGUI frame
        addBackButton();
		// add the sound button
		TemplateGUI.addSoundButton();
		HomeGUI.frame.add(player2TextPanel);
		HomeGUI.frame.add(player1TextPanel);
        HomeGUI.frame.add(player1Panel);
        HomeGUI.frame.add(player2Panel);
		HomeGUI.frame.add(questionPanel);
		HomeGUI.frame.add(reminderPanel);
		HomeGUI.frame.add(titlePanel);
		HomeGUI.frame.add(titleBackground);
		HomeGUI.frame.add(coloredPanel);
		HomeGUI.frame.add(background);
		//Reload the and allow it to display the new screen
		HomeGUI.frame.repaint();
		HomeGUI.frame.revalidate();
    }//end of display method
	
}//end of InfoGUI class
