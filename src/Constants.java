/**
 * @author Wen Yao Zhang, Nicolas Chan, Henderson Harper
 * Date: January 13th, 2024
 * File Name: Constants.java
 * Description: A bunch of constants to be used in game.
 *              They are all divided into different classes because there are so many of them.
 */
import java.awt.*;
import javax.swing.*;

public final class Constants {
    public static final class GameGUI { //GameGUI constants are for information regarding the game.
        public static final int NUM_ATTR = 11;
        public static final int NUM_CHAR = 24;
        public static final int CHAR_ROWS = 4;
        public static final int CHAR_COLS = 6;
        public static final int SELECTION_ROWS = 2;
        public static final int SELECTION_COLS = 2;
        public static final int NUM_QUESTIONS = 19;
        public static final String AI_NAME = "The AI";
    }//end of GameGUI class

    public static class HomeGUI{ // constant to check if we are in HomeGUI screen
        public static boolean isHomeGUI;//this is not a constant but its ok
    }//end of HomeGUI class
    
    public static final class Images{ /*Images constants are for the file paths for images.
            The images appended with 1 are for the buttons when they are hovered over.
            The images appended with 2 are for the buttons when they are in their normal state.
            The images appended with 3 are for the buttons when they are pressed.
        */
        static boolean confirmMouseHover1 = false;/*these aren't constants, but this is the best placement for them.
                                                    If they are true, the button is being hovered over. If they are false, the button is not being hovered over.
                                                    */
        // Player Vs AI Button 
        private static final ImageIcon AI_VS_PLAYER_LOGO_1 = new ImageIcon(Constants.class.getResource("images/assets/icons/PvAI1.png"));
        private static final Image AI_VS_PLAYER_LOGO_TEMP_1 = AI_VS_PLAYER_LOGO_1.getImage().getScaledInstance(180, 90, Image.SCALE_SMOOTH); // width - height
        public static final ImageIcon RESIZED_AI_VS_PLAYER_LOGO_1 = new ImageIcon(AI_VS_PLAYER_LOGO_TEMP_1);

        private static final ImageIcon AIVsPlayerLogo2 = new ImageIcon(Constants.class.getResource("images/assets/icons/PvAI2.png"));
        private static final Image AI_VS_PLAYER_LOGO_TEMP_2 = AIVsPlayerLogo2.getImage().getScaledInstance(180, 90, Image.SCALE_SMOOTH); // width - height
        public static final ImageIcon RESIZED_AI_VS_PLAYER_LOGO_2 = new ImageIcon(AI_VS_PLAYER_LOGO_TEMP_2);

        private static final ImageIcon AI_VS_PLAYER_LOGO_3 = new ImageIcon(Constants.class.getResource("images/assets/icons/PvAI3.png"));
        private static final Image AI_VS_PLAYER_LOGO_TEMP_3 = AI_VS_PLAYER_LOGO_3.getImage().getScaledInstance(180, 90, Image.SCALE_SMOOTH); // width - height
        public static final ImageIcon RESIZED_AI_VS_PLAYER_LOGO_3 = new ImageIcon(AI_VS_PLAYER_LOGO_TEMP_3);

        // Player Vs AI Button 
        static boolean confirmMouseHover2 = false;
        private static final ImageIcon PLAYER_VS_PLAYER_LOGO_1 = new ImageIcon(Constants.class.getResource("images/assets/icons/PvP2.png"));
        private static final Image PLAYER_VS_PLAYER_LOGO_TEMP_1 = PLAYER_VS_PLAYER_LOGO_1.getImage().getScaledInstance(180, 90, Image.SCALE_SMOOTH); // width - height
        public static final ImageIcon RESIZED_PLAYER_VS_PLAYER_LOGO_1 = new ImageIcon(PLAYER_VS_PLAYER_LOGO_TEMP_1);

        private static final ImageIcon PLAYER_VS_PLAYER_LOGO_2 = new ImageIcon(Constants.class.getResource("images/assets/icons/PvP1.png"));
        private static final Image PLAYER_VS_PLAYER_LOGO_TEMP_2 = PLAYER_VS_PLAYER_LOGO_2.getImage().getScaledInstance(180, 90, Image.SCALE_SMOOTH); // width - height
        public static final ImageIcon RESIZED_PLAYER_VS_PLAYER_LOGO_2 = new ImageIcon(PLAYER_VS_PLAYER_LOGO_TEMP_2);

        private static final ImageIcon PLAYER_VS_PLAYER_LOGO_3 = new ImageIcon(Constants.class.getResource("images/assets/icons/PvP3.png"));
        private static final Image PLAYER_VS_PLAYER_LOGO_TEMP_3 = PLAYER_VS_PLAYER_LOGO_3.getImage().getScaledInstance(180, 90, Image.SCALE_SMOOTH); // width - height
        public static final ImageIcon RESIZED_PLAYER_VS_PLAYER_LOGO_3 = new ImageIcon(PLAYER_VS_PLAYER_LOGO_TEMP_3);

        // Sound Button - on
        public static boolean confirmMouseHover3 = false;
        private static final ImageIcon SOUND_LOGO_1 = new ImageIcon(Constants.class.getResource("images/assets/icons/SoundOn1.png"));
		private static final Image SOUND_LOGO_TEMP_1 = SOUND_LOGO_1.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH); // width - height
        public static final ImageIcon RESIZED_SOUND_LOGO_1 = new ImageIcon(SOUND_LOGO_TEMP_1);

        private static final ImageIcon SOUND_LOGO_2 = new ImageIcon(Constants.class.getResource("images/assets/icons/SoundOn2.png"));
		private static final Image SOUND_LOGO_TEMP_2 = SOUND_LOGO_2.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH); // width - height
        public static final ImageIcon RESIZED_SOUND_LOGO_2 = new ImageIcon(SOUND_LOGO_TEMP_2);

        private static final ImageIcon SOUND_LOGO_3 = new ImageIcon(Constants.class.getResource("images/assets/icons/SoundOn3.png"));
		private static final Image SOUND_LOGO_TEMP_3 = SOUND_LOGO_3.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH); // width - height
        public static final ImageIcon RESIZED_SOUND_LOGO_3 = new ImageIcon(SOUND_LOGO_TEMP_3);
        
        //Sound Button - off
        private static final ImageIcon SOUND_LOGO_4 = new ImageIcon(Constants.class.getResource("images/assets/icons/SoundOff1.png"));
		private static final Image SOUND_LOGO_TEMP_4 = SOUND_LOGO_4.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH); // width - height
        public static final ImageIcon RESIZED_SOUND_LOGO_4 = new ImageIcon(SOUND_LOGO_TEMP_4);

        private static final ImageIcon SOUND_LOGO_5 = new ImageIcon(Constants.class.getResource("images/assets/icons/SoundOff2.png"));
		private static final Image SOUND_LOGO_TEMP_5 = SOUND_LOGO_5.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH); // width - height
        public static final ImageIcon RESIZED_SOUND_LOGO_5 = new ImageIcon(SOUND_LOGO_TEMP_5);

        private static final ImageIcon SOUND_LOGO_6 = new ImageIcon(Constants.class.getResource("images/assets/icons/SoundOff3.png"));
		private static final Image SOUND_LOGO_Temp6 = SOUND_LOGO_6.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH); // width - height
        public static final ImageIcon RESIZED_SOUND_LOGO_6 = new ImageIcon(SOUND_LOGO_Temp6);

        // Exit Button 
        static boolean confirmMouseHover4 = false;
        private static final ImageIcon EXIT_LOGO_1 = new ImageIcon(Constants.class.getResource("images/assets/icons/Exit1.png"));
		private static final Image EXIT_LOGO_TEMP_1 = EXIT_LOGO_1.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_EXIT_LOGO_1 = new ImageIcon(EXIT_LOGO_TEMP_1);

        private static final ImageIcon EXIT_LOGO_2 = new ImageIcon(Constants.class.getResource("images/assets/icons/Exit2.png"));
		private static final Image EXIT_LOGO_TEMP_2 = EXIT_LOGO_2.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_EXIT_LOGO_2 = new ImageIcon(EXIT_LOGO_TEMP_2);

        private static final ImageIcon EXIT_LOGO_3 = new ImageIcon(Constants.class.getResource("images/assets/icons/Exit3.png"));
		private static final Image EXIT_LOGO_TEMP_3 = EXIT_LOGO_3.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_EXIT_LOGO_3 = new ImageIcon(EXIT_LOGO_TEMP_3);

        // Settings Button 
        static boolean confirmMouseHover5 = false;
        private static final ImageIcon SETTINGS_LOGO_1 = new ImageIcon(Constants.class.getResource("images/assets/icons/Settings1.png"));
		private static final Image SETTINGS_LOGO_TEMP_1 = SETTINGS_LOGO_1.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_SETTINGS_LOGO_1 = new ImageIcon(SETTINGS_LOGO_TEMP_1);

        private static final ImageIcon SETTINGS_LOGO_2 = new ImageIcon(Constants.class.getResource("images/assets/icons/Settings2.png"));
		private static final Image SETTINGS_LOGO_TEMP_2 = SETTINGS_LOGO_2.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_SETTINGS_LOGO_2 = new ImageIcon(SETTINGS_LOGO_TEMP_2);

        private static final ImageIcon SETTINGS_LOGO_3 = new ImageIcon(Constants.class.getResource("images/assets/icons/Settings3.png"));
		private static final Image SETTINGS_LOGO_TEMP_3 = SETTINGS_LOGO_3.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_SETTINGS_LOGO_3 = new ImageIcon(SETTINGS_LOGO_TEMP_3);
        
        // Settings Button 
        static boolean confirmMouseHover6 = false;
        private static final ImageIcon INFO_LOGO_1 = new ImageIcon(Constants.class.getResource("images/assets/icons/Info1.png"));
		private static final Image INFO_LOGO_TEMP_1 = INFO_LOGO_1.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_INFO_LOGO_1 = new ImageIcon(INFO_LOGO_TEMP_1);

        private static final ImageIcon INFO_LOGO_2 = new ImageIcon(Constants.class.getResource("images/assets/icons/Info2.png"));
		private static final Image INFO_LOGO_TEMP_2 = INFO_LOGO_2.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_INFO_LOGO_2 = new ImageIcon(INFO_LOGO_TEMP_2);

        private static final ImageIcon INFO_LOGO_3 = new ImageIcon(Constants.class.getResource("images/assets/icons/Info3.png"));
		private static final Image INFO_LOGO_TEMP_3 = INFO_LOGO_3.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_INFO_LOGO_3 = new ImageIcon(INFO_LOGO_TEMP_3);

        // Home Button 
        public static boolean confirmMouseHover7 = false;
        private static final ImageIcon HOME_LOGO_1 = new ImageIcon(Constants.class.getResource("images/assets/icons/Home1.png"));
		private static final Image HOME_LOGO_TEMP_1 = HOME_LOGO_1.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_HOME_LOGO_1 = new ImageIcon(HOME_LOGO_TEMP_1);

        private static final ImageIcon HOME_LOGO_2 = new ImageIcon(Constants.class.getResource("images/assets/icons/Home2.png"));
		private static final Image HOME_LOGO_TEMP_2 = HOME_LOGO_2.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_HOME_LOGO_2 = new ImageIcon(HOME_LOGO_TEMP_2);

        private static final ImageIcon HOME_LOGO_3 = new ImageIcon(Constants.class.getResource("images/assets/icons/Home3.png"));
		private static final Image HOME_LOGO_TEMP_3 = HOME_LOGO_3.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_HOME_LOGO_3 = new ImageIcon(HOME_LOGO_TEMP_3);

        // Main Guess Who Logo
        private static final ImageIcon GUESS_WHO_LOGO = new ImageIcon(Constants.class.getResource("images/assets/images/GuessWhoLogo.png"));
        private static final Image GUESS_WHO_LOGO_TEMP = GUESS_WHO_LOGO.getImage().getScaledInstance(450, 180, Image.SCALE_SMOOTH); // width - height
        public static final ImageIcon RESIZED_GUESS_WHO_LOGO = new ImageIcon(GUESS_WHO_LOGO_TEMP);

        // TemplateGUI Back Button
        public static boolean confirmMouseHover8 = false;
        private static final ImageIcon BACK_LOGO_1 = new ImageIcon(Constants.class.getResource("images/assets/icons/back1.png"));
		private static final Image BACK_LOGO_TEMP_1 = BACK_LOGO_1.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_BACK_LOGO_1 = new ImageIcon(BACK_LOGO_TEMP_1);

        private static final ImageIcon BACK_LOGO_2 = new ImageIcon(Constants.class.getResource("images/assets/icons/back2.png"));
		private static final Image BACK_LOGO_TEMP_2 = BACK_LOGO_2.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_BACK_LOGO_2 = new ImageIcon(BACK_LOGO_TEMP_2);

        private static final ImageIcon BACK_LOGO_3 = new ImageIcon(Constants.class.getResource("images/assets/icons/back3.png"));
		private static final Image BACK_LOGO_TEMP_3 = BACK_LOGO_3.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_BACK_LOGO_3 = new ImageIcon(BACK_LOGO_TEMP_3);

        // Player 1 Button
        static boolean confirmMouseHover9 = false;
        private static final ImageIcon BUTTON_TEMPLATE_1 = new ImageIcon(Constants.class.getResource("images/assets/icons/buttonTemplate1.png"));
		private static final Image BUTTON_TEMPLATE_TEMP_1 = BUTTON_TEMPLATE_1.getImage().getScaledInstance(270, 110, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_BUTTON_TEMPLATE_1 = new ImageIcon(BUTTON_TEMPLATE_TEMP_1);

        private static final ImageIcon BUTTON_TEMPLATE_2 = new ImageIcon(Constants.class.getResource("images/assets/icons/buttonTemplate2.png"));
		private static final Image BUTTON_TEMPLATE_TEMP_2 = BUTTON_TEMPLATE_2.getImage().getScaledInstance(270, 110, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_BUTTON_TEMPLATE_2 = new ImageIcon(BUTTON_TEMPLATE_TEMP_2);

        private static final ImageIcon BUTTON_TEMPLATE_3 = new ImageIcon(Constants.class.getResource("images/assets/icons/buttonTemplate3.png"));
		private static final Image BUTTON_TEMPLATE_TEMP_3 = BUTTON_TEMPLATE_3.getImage().getScaledInstance(270, 110, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_BUTTON_TEMPLATE_3 = new ImageIcon(BUTTON_TEMPLATE_TEMP_3);
        
        // Player 2 Button
        public static boolean confirmMouseHover10 = false;

        //Asking questions button
        private static final ImageIcon ASK_QUESTION_1 = new ImageIcon(Constants.class.getResource("images/assets/icons/buttonTemplate1.png"));
		private static final Image ASK_QUESTION_TEMP_1 = ASK_QUESTION_1.getImage().getScaledInstance(250, 80, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_ASK_QUESTION_BUTTON_1 = new ImageIcon(ASK_QUESTION_TEMP_1);

        private static final ImageIcon ASK_QUESTION_2 = new ImageIcon(Constants.class.getResource("images/assets/icons/buttonTemplate2.png"));
		private static final Image ASK_QUESTION_TEMP_2 = ASK_QUESTION_2.getImage().getScaledInstance(250, 80, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_ASK_QUESTION_BUTTON_2 = new ImageIcon(ASK_QUESTION_TEMP_2);

        private static final ImageIcon ASK_QUESTION_3 = new ImageIcon(Constants.class.getResource("images/assets/icons/buttonTemplate3.png"));
		private static final Image ASK_QUESTION_TEMP_3 = ASK_QUESTION_3.getImage().getScaledInstance(250, 80, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_ASK_QUESTION_BUTTON_3 = new ImageIcon(ASK_QUESTION_TEMP_3);

        // Question Button
        static boolean confirmMouseHover11 = false;
        private static final ImageIcon QUESTION_BUTTON_1 = new ImageIcon(Constants.class.getResource("images/assets/icons/Question1.png"));
		private static final Image QUESTION_BUTTON_TEMP_1 = QUESTION_BUTTON_1.getImage().getScaledInstance(170, 50, Image.SCALE_SMOOTH); // width - height 
		public static final ImageIcon RESIZED_QUESTION_BUTTON_1 = new ImageIcon(QUESTION_BUTTON_TEMP_1);

        private static final ImageIcon QUESTION_BUTTON_2 = new ImageIcon(Constants.class.getResource("images/assets/icons/Question2.png"));
		private static final Image QUESTION_BUTTON_TEMP_2 = QUESTION_BUTTON_2.getImage().getScaledInstance(170, 50, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_QUESTION_BUTTON_2 = new ImageIcon(QUESTION_BUTTON_TEMP_2);

        private static final ImageIcon QUESTION_BUTTON_3 = new ImageIcon(Constants.class.getResource("images/assets/icons/Question3.png"));
		private static final Image QUESTION_BUTTON_TEMP_3 = QUESTION_BUTTON_3.getImage().getScaledInstance(170, 50, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_QUESTION_BUTTON_3 = new ImageIcon(QUESTION_BUTTON_TEMP_3);

        // Instruction Button
        static boolean confirmMouseHover12 = false;
        private static final ImageIcon INSTRUCTIONS_BUTTON_1 = new ImageIcon(Constants.class.getResource("images/assets/icons/Instructions1.png"));
		private static final Image INSTRUCTIONS_BUTTON_TEMP_1 = INSTRUCTIONS_BUTTON_1.getImage().getScaledInstance(170, 50, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_INSTRUCTIONS_BUTTON_1 = new ImageIcon(INSTRUCTIONS_BUTTON_TEMP_1);

        private static final ImageIcon INSTRUCTIONS_BUTTON_2 = new ImageIcon(Constants.class.getResource("images/assets/icons/Instructions2.png"));
		private static final Image INSTRUCTIONS_BUTTON_TEMP_2 = INSTRUCTIONS_BUTTON_2.getImage().getScaledInstance(170, 50, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_INSTRUCTIONS_BUTTON_2 = new ImageIcon(INSTRUCTIONS_BUTTON_TEMP_2);

        private static final ImageIcon INSTRUCTIONS_BUTTON_3 = new ImageIcon(Constants.class.getResource("images/assets/icons/Instructions3.png"));
		private static final Image INSTRUCTIONS_BUTTON_TEMP_3 = INSTRUCTIONS_BUTTON_3.getImage().getScaledInstance(170, 50, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_INSTRUCTIONS_BUTTON_3 = new ImageIcon(INSTRUCTIONS_BUTTON_TEMP_3);

        // Guess Button
        public static boolean confirmMouseHover13 = false;
        private static final ImageIcon GUESS_BUTTON_1 = new ImageIcon(Constants.class.getResource("images/assets/icons/Guess1.png"));
		private static final Image GUESS_BUTTON_TEMP_1 = GUESS_BUTTON_1.getImage().getScaledInstance(170, 50, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_GUESS_BUTTON_1 = new ImageIcon(GUESS_BUTTON_TEMP_1);

        private static final ImageIcon GUESS_BUTTON_2 = new ImageIcon(Constants.class.getResource("images/assets/icons/Guess2.png"));
		private static final Image GUESS_BUTTON_TEMP_2 = GUESS_BUTTON_2.getImage().getScaledInstance(170, 50, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_GUESS_BUTTON_2 = new ImageIcon(GUESS_BUTTON_TEMP_2);

        private static final ImageIcon GUESS_BUTTON_3 = new ImageIcon(Constants.class.getResource("images/assets/icons/Guess3.png"));
		private static final Image GUESS_BUTTON_TEMP_3 = GUESS_BUTTON_3.getImage().getScaledInstance(170, 50, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_GUESS_BUTTON_3 = new ImageIcon(GUESS_BUTTON_TEMP_3);

        // Settings Choice Button
        public static boolean confirmMouseHover14 = false;
        private static final ImageIcon SETTINGS_CHOICE_BUTTON_1 = new ImageIcon(Constants.class.getResource("images/assets/icons/SettingsChoice1.png"));
		private static final Image SETTINGS_CHOICE_BUTTON_TEMP_1 = SETTINGS_CHOICE_BUTTON_1.getImage().getScaledInstance(170, 50, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_SETTINGS_CHOICE_BUTTON_1 = new ImageIcon(SETTINGS_CHOICE_BUTTON_TEMP_1);

        private static final ImageIcon SETTINGS_CHOICE_BUTTON_2 = new ImageIcon(Constants.class.getResource("images/assets/icons/SettingsChoice2.png"));
		private static final Image SETTINGS_CHOICE_BUTTON_TEMP_2 = SETTINGS_CHOICE_BUTTON_2.getImage().getScaledInstance(170, 50, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_SETTINGS_CHOICE_BUTTON_2 = new ImageIcon(SETTINGS_CHOICE_BUTTON_TEMP_2);

        private static final ImageIcon SETTINGS_CHOICE_BUTTON_3 = new ImageIcon(Constants.class.getResource("images/assets/icons/SettingsChoice3.png"));
		private static final Image SETTINGS_CHOICE_BUTTON_TEMP_3 = SETTINGS_CHOICE_BUTTON_3.getImage().getScaledInstance(170, 50, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_SETTINGS_CHOICE_BUTTON_3 = new ImageIcon(SETTINGS_CHOICE_BUTTON_TEMP_3);

        // Yes Button
        static boolean confirmMouseHover15 = false;
        private static final ImageIcon YES_BUTTON_1 = new ImageIcon(Constants.class.getResource("images/assets/icons/yesButton1.png"));
		private static final Image YES_CHOICE_BUTTON_1TEMP_1 = YES_BUTTON_1.getImage().getScaledInstance(250, 115, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_YES_CHOICE_BUTTON1 = new ImageIcon(YES_CHOICE_BUTTON_1TEMP_1);

        private static final ImageIcon YES_BUTTON_2 = new ImageIcon(Constants.class.getResource("images/assets/icons/yesButton2.png"));
		private static final Image YES_CHOICE_BUTTON_TEMP_2 = YES_BUTTON_2.getImage().getScaledInstance(250, 115, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_YES_CHOICE_BUTTON_2 = new ImageIcon(YES_CHOICE_BUTTON_TEMP_2);

        private static final ImageIcon YES_BUTTON_3 = new ImageIcon(Constants.class.getResource("images/assets/icons/yesButton3.png"));
		private static final Image YES_CHOICE_BUTTON_1TEMP_3 = YES_BUTTON_3.getImage().getScaledInstance(250, 115, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_YES_CHOICE_BUTTON_3 = new ImageIcon(YES_CHOICE_BUTTON_1TEMP_3);

        // No Button
        static boolean confirmMouseHover16 = false;
        private static final ImageIcon NO_BUTTON_1 = new ImageIcon(Constants.class.getResource("images/assets/icons/noButton1.png"));
		private static final Image NO_CHOICE_BUTTON_TEMP_1 = NO_BUTTON_1.getImage().getScaledInstance(250, 115, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_NO_CHOICE_BUTTON_1 = new ImageIcon(NO_CHOICE_BUTTON_TEMP_1);

        private static final ImageIcon NO_BUTTON_2 = new ImageIcon(Constants.class.getResource("images/assets/icons/noButton2.png"));
		private static final Image NO_CHOICE_BUTTON_TEMP_2 = NO_BUTTON_2.getImage().getScaledInstance(250, 115, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_NO_CHOICE_BUTTON_2 = new ImageIcon(NO_CHOICE_BUTTON_TEMP_2);

        private static final ImageIcon NO_BUTTON_3 = new ImageIcon(Constants.class.getResource("images/assets/icons/noButton3.png"));
		private static final Image NO_CHOICE_BUTTON_TEMP_3 = NO_BUTTON_3.getImage().getScaledInstance(250, 115, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_NO_CHOICE_BUTTON_3 = new ImageIcon(NO_CHOICE_BUTTON_TEMP_3);

        // Continue Button
        static boolean confirmMouseHover17 = false;
        private static final ImageIcon CONTINUE_BUTTON_1 = new ImageIcon(Constants.class.getResource("images/assets/icons/continue1.png"));
		private static final Image CONTINUE_BUTTON_TEMP_1 = CONTINUE_BUTTON_1.getImage().getScaledInstance(270, 115, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_CONTINUE_BUTTON_1 = new ImageIcon(CONTINUE_BUTTON_TEMP_1);

        private static final ImageIcon CONTINUE_BUTTON_2 = new ImageIcon(Constants.class.getResource("images/assets/icons/continue2.png"));
		private static final Image CONTINUE_BUTTON_TEMP_2 = CONTINUE_BUTTON_2.getImage().getScaledInstance(270, 115, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_CONTINUE_BUTTON_2 = new ImageIcon(CONTINUE_BUTTON_TEMP_2);

        private static final ImageIcon CONTINUE_BUTTON_3 = new ImageIcon(Constants.class.getResource("images/assets/icons/continue3.png"));
		private static final Image CONTINUE_BUTTON_TEMP_3 = CONTINUE_BUTTON_3.getImage().getScaledInstance(270, 115, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_CONTINUE_BUTTON_3 = new ImageIcon(CONTINUE_BUTTON_TEMP_3);

        // Submit Button
        static boolean confirmMouseHover18 = false;
        private static final ImageIcon SUBMIT_BUTTON_1 = new ImageIcon(Constants.class.getResource("images/assets/icons/submit1.png"));
		private static final Image SUBMIT_BUTTON_TEMP_1 = SUBMIT_BUTTON_1.getImage().getScaledInstance(140, 60, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_SUBMIT_BUTTON_1 = new ImageIcon(SUBMIT_BUTTON_TEMP_1);

        private static final ImageIcon SUBMIT_BUTTON_2 = new ImageIcon(Constants.class.getResource("images/assets/icons/submit2.png"));
		private static final Image SUBMIT_BUTTON_TEMP_2 = SUBMIT_BUTTON_2.getImage().getScaledInstance(140, 60, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_SUBMIT_BUTTON_2 = new ImageIcon(SUBMIT_BUTTON_TEMP_2);

        private static final ImageIcon SUBMIT_BUTTON_3 = new ImageIcon(Constants.class.getResource("images/assets/icons/submit3.png"));
		private static final Image SUBMIT_BUTTON_TEMP_3 = SUBMIT_BUTTON_3.getImage().getScaledInstance(140, 60, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_SUBMIT_BUTTON_3 = new ImageIcon(SUBMIT_BUTTON_TEMP_3);

        // Add button
        public static boolean confirmMouseHover19 = false;
        private static final ImageIcon ADD_BUTTON_1 = new ImageIcon(Constants.class.getResource("images/assets/icons/add1.png"));
		private static final Image ADD_BUTTON_TEMP_1 = ADD_BUTTON_1.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_ADD_BUTTON_1 = new ImageIcon(ADD_BUTTON_TEMP_1);

        private static final ImageIcon ADD_BUTTON_2 = new ImageIcon(Constants.class.getResource("images/assets/icons/add2.png"));
		private static final Image ADD_BUTTON_TEMP_2 = ADD_BUTTON_2.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_ADD_BUTTON_2 = new ImageIcon(ADD_BUTTON_TEMP_2);

        private static final ImageIcon ADD_BUTTON_3 = new ImageIcon(Constants.class.getResource("images/assets/icons/add3.png"));
		private static final Image ADD_BUTTON_TEMP_3 = ADD_BUTTON_3.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_ADD_BUTTON_3 = new ImageIcon(ADD_BUTTON_TEMP_3);

        // Subtract Button (-)
        public static boolean confirmMouseHover20 = false;
        private static final ImageIcon DEC_BUTTON_1 = new ImageIcon(Constants.class.getResource("images/assets/icons/dec1.png"));
		private static final Image DEC_BUTTON_TEMP_1 = DEC_BUTTON_1.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_DEC_BUTTON_1 = new ImageIcon(DEC_BUTTON_TEMP_1);

        private static final ImageIcon DEC_BUTTON_2 = new ImageIcon(Constants.class.getResource("images/assets/icons/dec2.png"));
		private static final Image DEC_BUTTON_TEMP_2 = DEC_BUTTON_2.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_DEC_BUTTON_2 = new ImageIcon(DEC_BUTTON_TEMP_2);

        private static final ImageIcon DEC_BUTTON_3 = new ImageIcon(Constants.class.getResource("images/assets/icons/dec3.png"));
		private static final Image DEC_BUTTON_TEMP_3 = DEC_BUTTON_3.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_DEC_BUTTON_3 = new ImageIcon(DEC_BUTTON_TEMP_3);

        // History image background
        private static final ImageIcon HISTORY_IMAGE_ICON = new ImageIcon(HomeGUI.class.getResource("images/assets/images/History.png"));
		private static final Image HISTORY_IMAGE_ICON_TEMP = HISTORY_IMAGE_ICON.getImage().getScaledInstance(230, 680, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_HISTORY_IMAGE_ICON = new ImageIcon(HISTORY_IMAGE_ICON_TEMP);

        // Current Player Label
        private static final ImageIcon CURRENT_PLAYER_LABEL_ICON = new ImageIcon(HomeGUI.class.getResource("images/assets/images/CurrentPlayerLabel.png"));
		private static final Image CURRENT_PLAYER_LABEL_ICON_Temp = CURRENT_PLAYER_LABEL_ICON.getImage().getScaledInstance(435, 89, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_CURRENT_PLAYER_LABEL_ICON = new ImageIcon(CURRENT_PLAYER_LABEL_ICON_Temp);

        // Choose first player Label
        private static final Image CURRENT_PLAYER_LABEL_ICON_TEMP_2 = CURRENT_PLAYER_LABEL_ICON.getImage().getScaledInstance(435, 160, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_CURRENT_PLAYER_LABEL_ICON_2 = new ImageIcon(CURRENT_PLAYER_LABEL_ICON_TEMP_2);

        // Steampunk Text Field
        private static final ImageIcon STEAM_PUNK_TEXT_FIELD = new ImageIcon(HomeGUI.class.getResource("images/assets/icons/textField.png"));
		private static final Image STEAM_PUNK_TEXT_FIELD_TEMP = STEAM_PUNK_TEXT_FIELD.getImage().getScaledInstance(235, 80, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_STEAMPUNK_TEXT_FIELD = new ImageIcon(STEAM_PUNK_TEXT_FIELD_TEMP); 

        // log Button
        public static boolean confirmMouseHover21 = false;
        private static final ImageIcon LOG_BUTTON_1 = new ImageIcon(Constants.class.getResource("images/assets/icons/logButton1.png"));
		private static final Image LOG_BUTTON_TEMP_1 = LOG_BUTTON_1.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_LOG_BUTTON_1 = new ImageIcon(LOG_BUTTON_TEMP_1);

        private static final ImageIcon LOG_BUTTON_2 = new ImageIcon(Constants.class.getResource("images/assets/icons/logButton2.png"));
		private static final Image LOG_BUTTON_TEMP_2 = LOG_BUTTON_2.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_LOG_BUTTON_2 = new ImageIcon(LOG_BUTTON_TEMP_2);

        private static final ImageIcon LOG_BUTTON_3 = new ImageIcon(Constants.class.getResource("images/assets/icons/logButton3.png"));
		private static final Image LOG_BUTTON_TEMP_3 = LOG_BUTTON_3.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH); // width - height
		public static final ImageIcon RESIZED_LOG_BUTTON_3 = new ImageIcon(LOG_BUTTON_TEMP_3);
    }//end of Images class

    public static final class Colors {//The Colors class is for... colors.
        public static final Color SEMI_TRANSPARENT = new Color(0,0,0,220);
        public static final Color DARK_BLUE = new Color(2, 88, 163,255);
        public static final Color LIGHT_BLUE = new Color(3,110,204,255);
        public static final Color WHITE = new Color(255,255,255,255);
        public static final Color SEMI_TRANSPARENT_GREEN = new Color(24, 112, 130, 255);
        public static final Color SEMI_TRANSPARENT_RED = new Color(175, 137, 146, 255);
        public static final Color SILVER = new Color(232, 232, 226);
        public static final Color BROWN = new Color(163, 93, 63);
        public static final Color DARK_BROWN = new Color(58, 23, 0);
        public static final Color DARK_BROWN_2 = new Color(22, 13, 9);
    
    }//end of Colors class

    public static final class Fonts {//The Fonts class is for fonts.
        public static final Font COMIC_SANS_TITLE = new Font("Comic Sans MS", Font.BOLD, 30);
        public static final Font COMIC_SANS_FONT = new Font("Comic Sans MS", Font.TRUETYPE_FONT, 14);
        public static final Font SILVER_FONT = new Font("Silver",Font.TRUETYPE_FONT, 21);
        public static final Font SILVER_FONT_MEDIUM = new Font("Silver",Font.TRUETYPE_FONT, 23);
        public static final Font SILVER_FONT_LARGE = new Font("Silver",Font.TRUETYPE_FONT, 30);
        public static final Font TF_FONT_TITLE = new Font("ThaleahFat", Font.TRUETYPE_FONT, 50);
        public static final Font TF_FONT_TITLE_2 = new Font("ThaleahFat", Font.TRUETYPE_FONT, 37);
        public static final Font TF_FONT_SUBTITLE = new Font("ThaleahFat", Font.TRUETYPE_FONT, 30);
        public static final Font TF_FONT_SUBTITLE_2 = new Font("ThaleahFat", Font.TRUETYPE_FONT, 27);
    }//end of Fonts class
    
    enum GameTypes{/*from w3schools: An enum is a special "class" that represents a group of constants.
                    (https://www.w3schools.com/java/java_enums.asp)
                    Basically this enum is for the type of game that is ongoing. There are 3 options:
                    - PVP, which is player vs player
                    - PVE, which is player vs AI
                    - NONE, which is that there is no game running currently
                    */
        PVP,
        PVE,
        NONE
    }//end of GameTypes enum   
}//end of Constants class
