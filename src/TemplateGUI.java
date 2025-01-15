/**
* @author Henderson Harper, Wen Yao Zhang, Nicolas Chan
* Date: January 13th, 2024
* File Name: TemplateGUI.java
* Description: TemplateGUI is a class that other GUI classes inherit. It has a utility method to easily create a back button.
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
import java.net.URISyntaxException;

public abstract class TemplateGUI{
	/**
	 * A method to add a back button in the top left corner to various GUI screens.
	 */
    public static void addBackButton(){
        // create panel to store the back button
		JPanel backPanel = new JPanel();
		backPanel.setOpaque(false);
		backPanel.setBounds(10,10,75,75);
		// create the information button and format it
		JButton backButton = new JButton();
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.setIcon(Constants.Images.RESIZED_BACK_LOGO_1);
        backButton.setPreferredSize(new Dimension(70, 70));
		backButton.setToolTipText("Left Click to go back");
		backButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {//do stuff when the button is hovered over/clicked (function names are self-explanatory)
				Constants.Images.confirmMouseHover8 = true;
				backButton.setIcon(Constants.Images.RESIZED_BACK_LOGO_1);
			} //end of mouseEntered
	
			public void mouseExited(MouseEvent e) {
				//Change the sprite/image of the button to change to the neutral/non pressed version of the image (Image 2. No change to button.)
				Constants.Images.confirmMouseHover8 = false;
				backButton.setIcon(Constants.Images.RESIZED_BACK_LOGO_2);
			} //end of mouse Exited
	
			public void mousePressed(MouseEvent e) {
				//Change the sprite/image of the button to change to the pressed version of the image (Image 23. Button is all the way down and is darker.)
				backButton.setIcon(Constants.Images.RESIZED_BACK_LOGO_3);
			} //end of mousePressed method
	
			public void mouseReleased(MouseEvent e) {
				//Executes the code after the mouse is released on the button.
				if(Constants.Images.confirmMouseHover8){
					back();
				}
			} //end of mouseReleased method
		}); //end of actionlistener adding thing
		//add stuff to the frame
		backPanel.add(backButton);
		HomeGUI.frame.add(backPanel);
	}//end of addBackButton method

	/**
	 * A method that toggles the sound on or off
	 */
	public static void addSoundButton(){
		// create panel to store sound button
		JPanel soundPanel = new JPanel();
		soundPanel.setOpaque(false);
		if(Constants.HomeGUI.isHomeGUI == true){
			soundPanel.setBounds(96,10,75,75);
		} else{
			soundPanel.setBounds(700,10,75,75);
		}//end of if/else tree
		//add and format the sound button itself
		JButton soundButton = new JButton();
		soundButton.setOpaque(false);
		soundButton.setContentAreaFilled(false);
		soundButton.setBorderPainted(false);
		soundButton.setPreferredSize(new Dimension(70, 70));
		if (Game.getSettingVal("Music").equals("On")) {
			soundButton.setIcon(Constants.Images.RESIZED_SOUND_LOGO_1);
		} else {
			soundButton.setIcon(Constants.Images.RESIZED_SOUND_LOGO_4);
		}//end of if/else tree
		soundButton.setToolTipText("Left click to mute/unmute");
		soundButton.addMouseListener(new MouseAdapter() {//basically make the button change when hovered/pressed & mute/unmute on click
			public void mouseEntered(MouseEvent e) {
				Constants.Images.confirmMouseHover3 = true;
				if (Game.getSettingVal("Music").equals("On")){
					soundButton.setIcon(Constants.Images.RESIZED_SOUND_LOGO_2);
				}else{
					soundButton.setIcon(Constants.Images.RESIZED_SOUND_LOGO_5);
				}//end of if/else tree
			} //end of mouseEntered
		
			public void mouseExited(MouseEvent e) {
				//Change the sprite/image of the button to change to the neutral/non pressed version of the image (Image 2. No change to button.)
				Constants.Images.confirmMouseHover3 = false;
				if (Game.getSettingVal("Music").equals("On")){
					soundButton.setIcon(Constants.Images.RESIZED_SOUND_LOGO_1);
				}else{
					soundButton.setIcon(Constants.Images.RESIZED_SOUND_LOGO_4);
				}//end of if/else tree
			} //end of mouseExited method
			
			public void mousePressed(MouseEvent e) {
				//Change the sprite/image of the button to change to the pressed version of the image (Image 23. Button is all the way down and is darker.)
				if (Game.getSettingVal("Music").equals("On")){
					soundButton.setIcon(Constants.Images.RESIZED_SOUND_LOGO_3);
				} else{
					soundButton.setIcon(Constants.Images.RESIZED_SOUND_LOGO_6);
				}//end of if/else tree
			} //end of mousePressed method

			public void mouseReleased(MouseEvent e) {
				//Executes the code after the mouse is released on the button.
				if (Game.getSettingVal("Music").equals("On")) {
					try {
						TimeUnit.MILLISECONDS.sleep(75);
						Game.setSetting("Music","Off");
						soundButton.setIcon(Constants.Images.RESIZED_SOUND_LOGO_4);
						Game.endMusic();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}//end of try/catch
				} else {
					try {
						TimeUnit.MILLISECONDS.sleep(75);
						Game.setSetting("Music","On");
						soundButton.setIcon(Constants.Images.RESIZED_SOUND_LOGO_1);
						Game.startMusic();
					} catch (InterruptedException | URISyntaxException e1) {
						e1.printStackTrace();
					}//end of try/catch
				}//end of if/else tee
			}//end of mouseReleased method
		}); //end of mouselistener adding thing
		//add to frame
		soundPanel.add(soundButton);
		HomeGUI.frame.add(soundPanel);
	}//end of addSoundButton method

    public static void back(){
        HomeGUI.frame.getContentPane().removeAll();//remove all items from the frame
        if (Game.getIsUndergoingGame() == false){
            HomeGUI.display();
        } else {
            GameGUI.display();
        }//end of if/else
    }// end of back method

}//end of TemplateGUI method