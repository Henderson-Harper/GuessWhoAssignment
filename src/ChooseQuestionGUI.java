/**
 * @author Wen Yao Zhang, Nicolas Chan, Henderson Harper
 * Date: January 13th, 2024
 * File Name: ChooseQuestionGUI.java
 * Description: A GUI class that shows the Human player a list of questions they can ask.
 */

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ChooseQuestionGUI extends TemplateGUI{

    /**
	 * The display method creates and displays the screen to the window
     * @return void
     */
    public static void display() {
        HomeGUI.frame.getContentPane().removeAll();//clear everything that was there before

        Question[] qArr = Game.getQuestionListToCopy();

        //add title
        JPanel titlePanel = new JPanel();
		titlePanel.setOpaque(false);
		titlePanel.setBounds(0, 10, 800, 100);
		JLabel titleLabel = new JLabel("<html>"+Game.getPlayerNameFromIndex(Game.getCurTurn()));
		titleLabel.setPreferredSize(new Dimension(600, 100));
		titleLabel.setFont(Constants.Fonts.TF_FONT_TITLE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(Color.white);
		titlePanel.add(titleLabel);
        JPanel tipPanel = new JPanel();
        tipPanel.setOpaque(false);
        tipPanel.setBounds(0,60,800,100);
        JLabel tipLabel = new JLabel("<html><br>choose a question to ask:<html>");
        tipLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tipLabel.setFont(Constants.Fonts.SILVER_FONT_LARGE);
        tipPanel.add(tipLabel);


        //add the questions (displayed in a 3 wide 7 tall grid of 19 questions)
        JPanel questionPanel = new JPanel(new GridLayout(7,3));
        questionPanel.setOpaque(false);
        questionPanel.setBounds(20, 150, 750, 600);
        for (int i = 0; i < Constants.GameGUI.NUM_QUESTIONS; i++){//loop through every question and create a button for it
            Question tempQ = qArr[i];
            JButton buttonArray = new JButton();
            buttonArray.setOpaque(false);
            buttonArray.setIcon(Constants.Images.RESIZED_ASK_QUESTION_BUTTON_1);	
            buttonArray.setFocusPainted(false);
            buttonArray.setContentAreaFilled(false);
            buttonArray.setBorderPainted(false);
            buttonArray.setLayout(null);
            buttonArray.setPreferredSize(new Dimension(250, 72));
            JLabel questionText = new JLabel("<html><b>" + Integer.toString(i+1)+". " + qArr[i].getPhrasing() + "</html>");
            questionText.setBounds(25, 10, 230, 52);
            questionText.setFont(Constants.Fonts.SILVER_FONT);
            questionText.setForeground(Constants.Colors.DARK_BROWN);
            questionText.setOpaque(false);
            buttonArray.setToolTipText("Left Click to ask this question");
            buttonArray.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
				//Change the sprite/image of the button to change to the hover version of the image (Image 1. Button is lowered a little)
                    Constants.Images.confirmMouseHover9 = true;
                    buttonArray.setIcon(Constants.Images.RESIZED_ASK_QUESTION_BUTTON_1);
                    questionText.setBounds(25, 12, 230, 52);
                } //end of mouseEntered
            
                public void mouseExited(MouseEvent e) {
                    Constants.Images.confirmMouseHover9 = false;
                    buttonArray.setIcon(Constants.Images.RESIZED_ASK_QUESTION_BUTTON_2);
                    questionText.setBounds(25, 10, 230, 52);
                } //end of mouse Exited
            
                public void mousePressed(MouseEvent e) {
                    buttonArray.setIcon(Constants.Images.RESIZED_ASK_QUESTION_BUTTON_3);
                    questionText.setBounds(25, 12, 230, 52);
                } //end of mousePressed method
            
                public void mouseReleased(MouseEvent e) {
                    if(Constants.Images.confirmMouseHover9 == true){
                        Game.onQuestionChosen(tempQ);
                    }//end of if statement
                } //end of mouseReleased method
            }); //end of actionlistener adding thing
            buttonArray.add(questionText);//add the text to the button
            questionPanel.add(buttonArray);//add the button to the questionPanel
        }//end of for loop

        // add everything to the frame
        // add the sound button
		TemplateGUI.addSoundButton();
        addBackButton();//add the back button
        HomeGUI.frame.add(titlePanel);
        HomeGUI.frame.add(tipPanel);    
        HomeGUI.frame.add(questionPanel);

		//Reload the and allow it to display the new screen
        HomeGUI.frame.repaint();
		HomeGUI.frame.revalidate();
    }//end of display method
}//end of QuestionsGUI class