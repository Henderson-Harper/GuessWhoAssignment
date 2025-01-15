/**
 * @author Wen Yao Zhang, Nicolas Chan, Henderson Harper
 * Date: January 13th, 2024
 * File Name: HomeGUI.java
 * Description: A large GUI class that displays the Home menu. There are buttons to:
 * 				- Quit
 * 				- Enter the settings screen
 * 				- Enter the Information screen
 * 				- Toggle music
 * 				- Start a Player vs Player game
 * 				- Start a Player vs AI game
 */

import java.io.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomeGUI {
    public static JFrame frame = new JFrame("Guess Who");//the one window that we use

	/**
	 * The display method for the HomeGUI screen. Called when the code is run.
	 */
    public static void display() {
		Constants.HomeGUI.isHomeGUI = true;
        Game.resetHistory();
		frame.getContentPane().removeAll();
		frame.setLayout(null);
		// change background colour
		frame.getContentPane().setBackground(Constants.Colors.BROWN);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {//we need to make sure that the LogWriter is closed so that nothing is lost, just in case.
				Game.closeLogWriter();
				System.exit(0);
			}//end of windowClosing method
		});//end of addWindowListener part
		
		// changes the icon of the frame
		ImageIcon GuessWhoIcon = new ImageIcon(HomeGUI.class.getResource("images/assets/icons/GuessWhoIcon.png"));

		// create a panel to store the logo
		JPanel logoPanel = new JPanel();
		JLabel logoHolder = new JLabel();
		logoPanel.setBounds(0,200,800,800);
		logoPanel.setOpaque(false);
		logoHolder.setIcon(Constants.Images.RESIZED_GUESS_WHO_LOGO);
		logoPanel.add(logoHolder);

		// create  a panel to store the background gif
		JPanel backgroundGif = new JPanel();
		backgroundGif.setOpaque(false);
		ImageIcon steamPunk = new ImageIcon(HomeGUI.class.getResource("images/assets/images/Background0.gif"));
      	JLabel steamPunkHolder = new JLabel();
		steamPunkHolder.setIcon(steamPunk);
		steamPunk.setImageObserver(steamPunkHolder);
		backgroundGif.add(steamPunkHolder);
		backgroundGif.setBounds(0, -5, 800, 800);
		
		// create panel to store the information button
		JPanel infoPanel = new JPanel();
		infoPanel.setOpaque(false);
		infoPanel.setBounds(182,10,75,75);
		// create the information button
		JButton infoButton = new JButton();
		infoButton.setOpaque(false);
		infoButton.setContentAreaFilled(false);
		infoButton.setBorderPainted(false);
		infoButton.setIcon(Constants.Images.RESIZED_INFO_LOGO_1);
		infoButton.setToolTipText("Left click to go into the settings menu");
        infoButton.setPreferredSize(new Dimension(70, 70));
		infoButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Constants.Images.confirmMouseHover4 = true;
				infoButton.setIcon(Constants.Images.RESIZED_INFO_LOGO_2);
			} //end of mouseEntered
		
			public void mouseExited(MouseEvent e) {
				//Change the sprite/image of the button to change to the neutral/non pressed version of the image (Image 2. No change to button.)
				Constants.Images.confirmMouseHover4 = false;
				infoButton.setIcon(Constants.Images.RESIZED_INFO_LOGO_1);
			} //end of mouse Exited
		
			public void mousePressed(MouseEvent e) {
				//Change the sprite/image of the button to change to the pressed version of the image (Image 23. Button is all the way down and is darker.)
				infoButton.setIcon(Constants.Images.RESIZED_INFO_LOGO_3);
			} //end of mousePressed method
		
			public void mouseReleased(MouseEvent e) {
				//Executes the code after the mouse is released on the button.
				if(Constants.Images.confirmMouseHover4){
					InfoGUI.display();
				}
			} //end of mouseReleased method
		}); //end of actionlistener adding thing
		infoPanel.add(infoButton);

		// create panel to store settings button
		JPanel settingsPanel = new JPanel();
		settingsPanel.setOpaque(false);
		settingsPanel.setBounds(10,10,75,75);
		// create the settings button
		JButton settingsButton = new JButton();
		settingsButton.setOpaque(false);
		settingsButton.setContentAreaFilled(false);
		settingsButton.setBorderPainted(false);
		settingsButton.setIcon(Constants.Images.RESIZED_SETTINGS_LOGO_1);
		settingsButton.setToolTipText("Left click to go into the settings menu");
        settingsButton.setPreferredSize(new Dimension(70, 70));
		settingsButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Constants.Images.confirmMouseHover4 = true;
				settingsButton.setIcon(Constants.Images.RESIZED_SETTINGS_LOGO_2);
			} //end of mouseEntered
		
			public void mouseExited(MouseEvent e) {
				//Change the sprite/image of the button to change to the neutral/non pressed version of the image (Image 2. No change to button.)
				Constants.Images.confirmMouseHover4 = false;
				settingsButton.setIcon(Constants.Images.RESIZED_SETTINGS_LOGO_1);
			} //end of mouse Exited
		
			public void mousePressed(MouseEvent e) {
				//Change the sprite/image of the button to change to the pressed version of the image (Image 23. Button is all the way down and is darker.)
				settingsButton.setIcon(Constants.Images.RESIZED_SETTINGS_LOGO_3);
			} //end of mousePressed method
		
			public void mouseReleased(MouseEvent e) {
				//Executes the code after the mouse is released on the button.
				if(Constants.Images.confirmMouseHover4){
					SettingsGUI.display();
				}
			} //end of mouseReleased method
		}); //end of actionlistener adding thing
		settingsPanel.add(settingsButton);

		// create panel to store the quit button
		JPanel exitPanel = new JPanel();
		exitPanel.setOpaque(false);
		exitPanel.setBounds(700,10,75,75);
		// create the information button
		JButton exitButton = new JButton();
		exitButton.setOpaque(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setBorderPainted(false);
		exitButton.setIcon(Constants.Images.RESIZED_EXIT_LOGO_1);
		exitButton.setToolTipText("Left click to close the game");
        exitButton.setPreferredSize(new Dimension(70, 70));
		exitButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Constants.Images.confirmMouseHover4 = true;
				exitButton.setIcon(Constants.Images.RESIZED_EXIT_LOGO_2);
			} //end of mouseEntered
		
			public void mouseExited(MouseEvent e) {
				//Change the sprite/image of the button to change to the neutral/non pressed version of the image (Image 2. No change to button.)
				Constants.Images.confirmMouseHover4 = false;
				exitButton.setIcon(Constants.Images.RESIZED_EXIT_LOGO_1);
			} //end of mouse Exited
		
			public void mousePressed(MouseEvent e) {
				//Change the sprite/image of the button to change to the pressed version of the image (Image 3. Button is all the way down and is darker.)
				exitButton.setIcon(Constants.Images.RESIZED_EXIT_LOGO_3);
			} //end of mousePressed method
		
			public void mouseReleased(MouseEvent e) {
				//Executes the code after the mouse is released on the button.
				if(Constants.Images.confirmMouseHover4){
					Game.writeLine("Exited Program");
					Game.onWindowClose();
				}//end of if statement
			} //end of mouseReleased method
		}); //end of actionlistener adding thing
		exitPanel.add(exitButton);

		// create panel to store the log button
		JPanel logPanel = new JPanel();
		logPanel.setOpaque(false);
		logPanel.setBounds(615,10,75,75);
		// create the information button
		JButton logButton = new JButton();
		logButton.setOpaque(false);
		logButton.setContentAreaFilled(false);
		logButton.setBorderPainted(false);
		logButton.setIcon(Constants.Images.RESIZED_LOG_BUTTON_2);
		logButton.setToolTipText("Left click to open the log menu");
        logButton.setPreferredSize(new Dimension(70, 70));
		logButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Constants.Images.confirmMouseHover21 = true;
				logButton.setIcon(Constants.Images.RESIZED_LOG_BUTTON_1);
			} //end of mouseEntered
		
			public void mouseExited(MouseEvent e) {
				//Change the sprite/image of the button to change to the neutral/non pressed version of the image (Image 2. No change to button.)
				Constants.Images.confirmMouseHover21 = false;
				logButton.setIcon(Constants.Images.RESIZED_LOG_BUTTON_2);
			} //end of mouse Exited
		
			public void mousePressed(MouseEvent e) {
				//Change the sprite/image of the button to change to the pressed version of the image (Image 3. Button is all the way down and is darker.)
				logButton.setIcon(Constants.Images.RESIZED_LOG_BUTTON_3);
			} //end of mousePressed method
		
			public void mouseReleased(MouseEvent e) {
				//Executes the code after the mouse is released on the button.
				if(Constants.Images.confirmMouseHover21){
					try {//we gotta use try/catch for the IOexception
						Desktop.getDesktop().edit(new File("src/Log.txt")); // open the log file as a window when the mouse button is released
					} catch (Exception err){
						err.printStackTrace();
					}//end of try/catch
				}//end of if statement
			} //end of mouseReleased method
		}); //end of actionlistener adding thing
		logPanel.add(logButton);

		// create panel to store the Player vs. Computer button
		JPanel AIVsPlayerPanel = new JPanel();
		AIVsPlayerPanel.setOpaque(false);
		JButton AIVsPlayerButton = new JButton();
		AIVsPlayerButton.setOpaque(false);
		AIVsPlayerButton.setContentAreaFilled(false);
		AIVsPlayerButton.setBorder(BorderFactory.createEmptyBorder());
		AIVsPlayerButton.setToolTipText("Left click to go into the AI Vs Player Menu");
		AIVsPlayerPanel.setBounds(50,531,300,130);
		AIVsPlayerButton.setIcon(Constants.Images.RESIZED_AI_VS_PLAYER_LOGO_2);
		AIVsPlayerButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Constants.Images.confirmMouseHover1 = true;
				AIVsPlayerButton.setIcon(Constants.Images.RESIZED_AI_VS_PLAYER_LOGO_1);
			} //end of mouseEntered
		
			public void mouseExited(MouseEvent e) {
				//Change the sprite/image of the button to change to the neutral/non pressed version of the image (Image 2. No change to button.)
				Constants.Images.confirmMouseHover1 = false;
				AIVsPlayerButton.setIcon(Constants.Images.RESIZED_AI_VS_PLAYER_LOGO_2);
			} //end of mouse Exited
		
			public void mousePressed(MouseEvent e) {
				//Change the sprite/image of the button to change to the pressed version of the image (Image 23. Button is all the way down and is darker.)
				AIVsPlayerButton.setIcon(Constants.Images.RESIZED_AI_VS_PLAYER_LOGO_3);
			} //end of mousePressed method
		
			public void mouseReleased(MouseEvent e) {
				//Executes the code after the mouse is released on the button.
				if(Constants.Images.confirmMouseHover1){
					try {
						Game.setGameType(Constants.GameTypes.PVE);
						Game.setupPlayerArray(Game.getGameType());
						FirstTurnChoiceGUI.display();
					} catch (IOException e1) {
						e1.printStackTrace(); //TODO change this to use log
					}//end of try/catch
				}
			} //end of mouseReleased method
		}); //end of actionlistener adding thing
		AIVsPlayerPanel.add(AIVsPlayerButton);

		// create panel to store the Player vs. Player button
		JPanel PlayerVsPlayerPanel = new JPanel();
		PlayerVsPlayerPanel.setOpaque(false);
		JButton PlayerVsPlayerButton = new JButton();
		PlayerVsPlayerButton.setOpaque(false);
		PlayerVsPlayerButton.setContentAreaFilled(false);
		PlayerVsPlayerButton.setBorder(BorderFactory.createEmptyBorder());
		PlayerVsPlayerButton.setToolTipText("Left click to go into the Player Vs Player Menu");
		PlayerVsPlayerPanel.setBounds(451,531,300,130);
		PlayerVsPlayerButton.setIcon(Constants.Images.RESIZED_PLAYER_VS_PLAYER_LOGO_1);
		PlayerVsPlayerButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Constants.Images.confirmMouseHover2 = true;
				PlayerVsPlayerButton.setIcon(Constants.Images.RESIZED_PLAYER_VS_PLAYER_LOGO_2);
			} //end of mouseEntered
		
			public void mouseExited(MouseEvent e) {
				//Change the sprite/image of the button to change to the neutral/non pressed version of the image (Image 2. No change to button.)
				Constants.Images.confirmMouseHover2 = false;
				PlayerVsPlayerButton.setIcon(Constants.Images.RESIZED_PLAYER_VS_PLAYER_LOGO_1);
			} //end of mouse Exited
		
			public void mousePressed(MouseEvent e) {
				//Change the sprite/image of the button to change to the pressed version of the image (Image 23. Button is all the way down and is darker.)
				PlayerVsPlayerButton.setIcon(Constants.Images.RESIZED_PLAYER_VS_PLAYER_LOGO_3);
			} //end of mousePressed method
		
			public void mouseReleased(MouseEvent e) {
				//Executes the code after the mouse is released on the button.
				if(Constants.Images.confirmMouseHover2){
					try {
						Game.setGameType(Constants.GameTypes.PVP);
						Game.setupPlayerArray(Game.getGameType());
						FirstTurnChoiceGUI.display();
					} catch (IOException e1) {
						e1.printStackTrace();//TODO change this to use log
					}//end of try/catch
				}
			} //end of mouseReleased method
		}); //end of actionlistener adding thing
		PlayerVsPlayerPanel.add(PlayerVsPlayerButton);
		
		// add the sound button
		TemplateGUI.addSoundButton();
		//Add stuff to the frame
		frame.setIconImage(GuessWhoIcon.getImage());
		frame.add(infoPanel);
		frame.add(logPanel);
		frame.add(settingsPanel);
		frame.add(AIVsPlayerPanel);
		frame.add(PlayerVsPlayerPanel);
		frame.add(logoPanel);
		HomeGUI.frame.add(exitPanel);
		frame.add(backgroundGif);
		frame.repaint();
		frame.revalidate();
		frame.setSize(800,800); // width, height
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//end of display method

	
	
}//end of HomeGUI class