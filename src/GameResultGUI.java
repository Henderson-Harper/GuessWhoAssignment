/**
 * @author Wen Yao Zhang, Nicolas Chan, Henderson Harper
 * Date: January 13th, 2024
 * File Name: GameResultGUI.java
 * Description: A GUI class that displays the game over screen and the winner.
*/

import javax.swing.*;
import java.awt.*;

public class GameResultGUI extends TemplateGUI{
    static JFrame frame2 = new JFrame("YOU CAN CLOSE THIS POPUP WINDOW IT IS A JOKE");//for the easter egg
    /**
	 * The display method creates and displays the game over screen to the window so the user can see it.
	 */
    public static void display() {

        //EASTER EGG thingy
        /*
        No.
        // create  a panel to store the background gif
		JPanel backgroundGekkoDancingGif = new JPanel();
		backgroundGekkoDancingGif.setOpaque(false);
		ImageIcon gekkoDancing = new ImageIcon(HomeGUI.class.getResource("images/assets/images/geck-dance-loop1337.gif"));
      	JLabel gekkoDancingHolder = new JLabel();
        gekkoDancingHolder.setIcon(gekkoDancing);
		gekkoDancing.setImageObserver(gekkoDancingHolder);
		backgroundGekkoDancingGif.add(gekkoDancingHolder);
		backgroundGekkoDancingGif.setBounds(0, 0, 800, 800);
        */

         // create  a panel to store the background gif
		JPanel backgroundHiMrAGif= new JPanel();
		backgroundHiMrAGif.setOpaque(false);
		ImageIcon hiMrA = new ImageIcon(HomeGUI.class.getResource("images/assets/images/2024-01-13-Hi-Mr-A.gif"));
      	JLabel hiMrAHolder = new JLabel();
        hiMrAHolder.setIcon(hiMrA);
        hiMrA.setImageObserver(hiMrAHolder);
		backgroundHiMrAGif.add(hiMrAHolder);
		backgroundHiMrAGif.setBounds(250, 0, 300, 200);

        /*
        //add the stuff to the easter egg frame
        frame2.add(backgroundHiMrAGif);
        frame2.add(backgroundGekkoDancingGif);
		frame2.repaint();
		frame2.revalidate();
		frame2.setSize(800,800); // width, height
		frame2.setVisible(true);
		frame2.setResizable(false);*/
        
        //ok onto the regular stuff
        HomeGUI.frame.getContentPane().removeAll();
        

        JPanel titlePanel = new JPanel();
		titlePanel.setOpaque(false);
        titlePanel.setBounds(100, 20, 600, 120);
		JLabel titleLabel = new JLabel("<html><center>"+Game.getPlayerNameFromIndex(Game.getWinnerIndex()) + "<br>won the game!</center></html>");
		titleLabel.setFont(Constants.Fonts.TF_FONT_TITLE);
		titleLabel.setForeground(Color.white);
        titlePanel.add(titleLabel);

        JPanel explanationPanel = new JPanel();
        explanationPanel.setOpaque(false);
        explanationPanel.setBounds(50, 150, 700, 200);
        JLabel explanationLabel = new JLabel("<html><center>They won because "+Game.getHistoryPlayer(0)+"<br>guessed their opponent's<br>mystery character "+ ((Game.getHistoryResponse(0)) ? "correctly." : "incorrectly.")+"</center></html>");//using short form if statement
        explanationLabel.setFont(Constants.Fonts.TF_FONT_TITLE);
		explanationLabel.setForeground(Color.white);
        explanationPanel.add(explanationLabel);

        //characters remaining panel
        JPanel charsRemainingPanel = new JPanel(new GridLayout(1,2,100,0));
        charsRemainingPanel.setOpaque(false);
        charsRemainingPanel.setBounds(50, 350, 700, 300);
        //characters remaining label for player 1
        JLabel p1Label = new JLabel("<html><center>" + Game.getPlayerNameFromIndex(0)+" had " + Game.getPlayerArray()[0].getCharsRemaining()+"<br>characters left.</center></html>");
        p1Label.setFont(Constants.Fonts.TF_FONT_TITLE);
		p1Label.setForeground(Color.white);
        charsRemainingPanel.add(p1Label);
        //characters remaining label for player 2
        JLabel p2Label = new JLabel("<html><center>" + Game.getPlayerNameFromIndex(1)+" had " + Game.getPlayerArray()[1].getCharsRemaining()+"<br>characters left.</center></html>");
        p2Label.setFont(Constants.Fonts.TF_FONT_TITLE);
		p2Label.setForeground(Color.white);
        charsRemainingPanel.add(p2Label);

        //if the game is vs AI, display the AI's mystery character.
        if (Game.getPlayerArray()[1] instanceof AI){//we need to use this ugly way because the gameType is already reset to null
            //create a new panel
            JPanel aiMCPanel = new JPanel();
            aiMCPanel.setOpaque(false);
            aiMCPanel.setBounds(50, 650, 700, 100);
            //create a new label
            JLabel aiMCLabel = new JLabel("<html><center>" + Game.getPlayerNameFromIndex(1)+"'s person was<br>" + ((AI) Game.getPlayerArray()[1]).getMCName()+".</center></html>");
            aiMCPanel.add(aiMCLabel);
            aiMCLabel.setFont(Constants.Fonts.TF_FONT_TITLE);
		    aiMCLabel.setForeground(Color.white);
            HomeGUI.frame.add(aiMCPanel);
        }//end of if statement

		//add stuff to the frame
        addBackButton();
        HomeGUI.frame.add(titlePanel);
        HomeGUI.frame.add(explanationPanel);
        HomeGUI.frame.add(charsRemainingPanel);
        //display the new screen
        HomeGUI.frame.repaint();
		HomeGUI.frame.revalidate();
    }//end of display method
}//end of QuestionsGUI class