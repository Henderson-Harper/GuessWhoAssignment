/**
 * @author Wen Yao Zhang, Nicolas Chan, Henderson Harper
 * Date: January 13th, 2024
 * File Name: GuessCharacterGUI.java
 * Description: The screen for choosing a character to guess. This screen shows during gameplay for Human players.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuessCharacterGUI extends TemplateGUI {
    private static final int CHAR_ROWS = Constants.GameGUI.CHAR_ROWS;
    private static final int CHAR_COLS = Constants.GameGUI.CHAR_COLS;

    /**
     * The display method for GuessCharacterGUI. It shows a grid of characters that can be guessed.
     */
    public static void display() {
        HomeGUI.frame.getContentPane().removeAll();
        BoardCharacter[] bcArr = Game.getPlayerArray()[Game.getCurTurn()].getGuessingArray();//array of boardCharacters of the current player, AKA the board they see

        //Instructions/Title part
        JLabel instructionsLabel = new JLabel("<html><center>Click on one of the<br>characters to guess</html>");
        JPanel instructionsPanel = new JPanel();
		instructionsLabel.setFont(Constants.Fonts.TF_FONT_TITLE);
		instructionsLabel.setForeground(Color.white);
        instructionsPanel.add(instructionsLabel);
        instructionsPanel.setOpaque(false);
        instructionsPanel.setBounds(55, 20, 675, 100);

        //The panel that shows the characters
        JPanel charBoardPanel = new JPanel(new GridLayout(CHAR_ROWS, CHAR_COLS,10,10));
        for (int i = 0; i < CHAR_ROWS*CHAR_COLS; i++) {
            int tempInt = i;//because something about just using i
            JButton characterButton = new JButton();//each character is a button that can be pressed to guess that acharacter
            ImageIcon characterLogo;
            if(!bcArr[i].isEliminated()) {//if the character isn't eliminated...
                characterLogo = new ImageIcon(HomeGUI.class.getResource(bcArr[i].getImgAddress()));//... show their image
            } else {//if they are eliminated...
                characterLogo = new ImageIcon(HomeGUI.class.getResource("images/characters/Blank.jpg"));//...show the eliminated picture
            }//end of if/else
            characterButton.setIcon(characterLogo);
            characterButton.setOpaque(false);
            characterButton.setFocusPainted(false);
            characterButton.setContentAreaFilled(false);
            characterButton.setBorderPainted(false);
            characterButton.setToolTipText("Left Click to guess "+ bcArr[i].getName());
            characterButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {        
                    Game.onCharacterGuessChosen(bcArr[tempInt]);
                }//end of actionperformed method
		    });//end of actionListener instantiation
            charBoardPanel.add(characterButton);
        }//end of for loop
        charBoardPanel.setBounds(95, 150, 600, 580);
        charBoardPanel.setOpaque(false);

        // add the sound button
		TemplateGUI.addSoundButton();
        //add stuff to the frame
        addBackButton();
        HomeGUI.frame.add(instructionsPanel);
        HomeGUI.frame.add(charBoardPanel);
        HomeGUI.frame.repaint();
		HomeGUI.frame.revalidate();
    }//end of display method
}//end of GuessCharacterGUI method