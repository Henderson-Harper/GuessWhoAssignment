/**
 * @author Wen Yao Zhang, Nicolas Chan, Henderson Harper
 * Date: January 13th, 2024
 * File Name: BoardCharacter.java
 * Description: The BoardCharacter class is the template for BoardCharacter objects.
 * 				A BoardCharacter objects represents a Guess Who person (ex. Al).
 * 				See the normal constructor for details on attributes.
 */
public class BoardCharacter {
	//Declare variables
	private String name;
	private boolean isEliminated;
	private String imgAddress;
	private String eyeColour;
	private String gender;
	private String skinTone;
	private String hairColour;
	private String hasFacialHair;
	private String hasGlasses;
	private String hasVisibleTeeth;
	private String hasHat;
	private String hairLength;
	private String hasPiercings;

	/**I used the auto-generate constructor button which is why it uses 'this.'.
	 * The constructor for the BoardCharacter class. 
	 * @param name The name of the boardCharacter
	 * @param isEliminated
	 * @param imgAddress
	 * @param eyeColour
	 * @param gender
	 * @param skinTone
	 * @param hairColour
	 * @param hasFacialHair
	 * @param hasGlasses
	 * @param hasVisibleTeeth
	 * @param hasHat
	 * @param hairLength
	 * @param hasPiercings
	 */
	public BoardCharacter(String name, String imgAddress, String gender, String eyeColour,
			String skinTone, String hairColour, String hasFacialHair, String hasGlasses, String hasVisibleTeeth,
			String hasHat, String hairLength, String hasPiercings) {
		this.name = name;
		this.isEliminated= false;//characters always start as not eliminated. This is kinda bad formatting but oh well 
		this.imgAddress = imgAddress;
		this.gender = gender;
		this.eyeColour = eyeColour;
		this.skinTone = skinTone;
		this.hairColour = hairColour;
		this.hasFacialHair = hasFacialHair;
		this.hasGlasses = hasGlasses;
		this.hasVisibleTeeth = hasVisibleTeeth;
		this.hasHat = hasHat;
		this.hairLength = hairLength;
		this.hasPiercings = hasPiercings;
	} //end of constructor
	
	/**
	 * Null constructor for BoardCharacters. It creates a blank BoardCharacter.
	 */
	public BoardCharacter() {
		this.name = null;
		this.imgAddress = null;
		this.eyeColour = null;
		this.gender = null;
		this.skinTone = null;
		this.hairColour = null;
		this.hasFacialHair = null;
		this.hasGlasses = null;
		this.hasVisibleTeeth = null;
		this.hasHat = null;
		this.hairLength = null;
		this.hasPiercings = null;
    }//end of null constructor
	
	/**
	 * A BoardCharacter constructor that is used for cloning BoardCharacters in order to stop pass-by-reference.
	 * @param bc The BoardCharacter to be copied
	 */
	public BoardCharacter(BoardCharacter bc){
		this.name = bc.getName();
		this.isEliminated = bc.isEliminated();
		this.imgAddress = bc.getImgAddress();
		this.gender = bc.getGender();
		this.eyeColour = bc.getEyeColour();
		this.skinTone = bc.getSkinTone();
		this.hairColour = bc.getHairColour();
		this.hasFacialHair = bc.getHasFacialHair();
		this.hasGlasses = bc.getHasGlasses();
		this.hasVisibleTeeth = bc.getHasVisibleTeeth();
		this.hasHat = bc.getHasHat();
		this.hairLength = bc.getHairLength();
		this.hasPiercings = bc.getHasPiercings();
	}//end of copying constructor

    /**
	 * Getter method for the BoardCharacter's name
	 * @return String - the name of the char (name)
	 */
	public String getName() {
		return name;
	}//end of getName method

	/**
	 * Setter method for the BoardCharacter's elimination status
	 * @param elim the new elimination status
	 * @return void
	 */
	public void setIsEliminated(Boolean elim){
		isEliminated = elim;
	}//end of setIsEliminated method

	/**
	 * Getter method for the BoardCharacter's elimination status
	 * @return boolean - Is the character eliminated (isEliminated)
	 */
	public boolean isEliminated() {
		return isEliminated;
	}//end of isEliminated method

	
	/**
	 * Getter method for the BoardCharacter's image address
	 * @return String - the imgAddress of the character (Location the chars image is stored, Returns imgAddress)
	 */
	public String getImgAddress() {
		return imgAddress;
	}//end of getImgAddress method

	/**
	 * Getter method for the BoardCharacter's eye colour
	 * @return String - The eye colour of the char (eyeColour)
	 */
	public String getEyeColour() {
		return eyeColour;
	}//end of getEyeColour method

	/**
	 * Getter method for the BoardCharacter's gender
	 * @return String - The gender of the char (gender)
	 */
	public String getGender() {
		return gender;
	}//end of getGender method

	/**
	 * Getter method for the BoardCharacter's skin tone
	 * @return String - The skin tone of the char (skinTone)
	 */
	public String getSkinTone() {
		return skinTone;
	}//end of getSkinTone method

	/**
	 * Getter method for the BoardCharacter's hair colour
	 * @return String - The hair colour of the char (hairColour)
	 */
	public String getHairColour() {
		return hairColour;
	}//end of getHairColour method

	/**
	 * Getter method for the BoardCharacter's facial hair status
	 * @return String - Returns if they have hair (hasFacialHair)
	 */
	public String getHasFacialHair() {
		return hasFacialHair;
	}//end of getHasFacialHair method

	/**
	 * Getter method for the BoardCharacter's glasses status
	 * @return String - returns if they have glasses (hasGlasses)
	 */
	public String getHasGlasses() {
		return hasGlasses;
	}//end of getHasGlasses method

	/**
	 * Getter method for the BoardCharacter's teeth visibility status
	 * @return String - Returns if they have visible teeth (hasVisibleTeeth)
	 */
	public String getHasVisibleTeeth() {
		return hasVisibleTeeth;
	}//end of getHasVisibleTeeth

	/**
	 * Getter method for the BoardCharacter's hat-wearing status
	 * @return String - Returns if they have a hat (hasHat)
	 */
	public String getHasHat() {
		return hasHat;
	}//end of getHasHat method

	/**
	 * Getter method for the BoardCharacter's hair length
	 * @return String - the hair length (hairLength)
	 */
	public String getHairLength() {
		return hairLength;
	}//end of getHairLength method

	/**
	 * Getter method for the BoardCharacter's piercings status
	 * @return String - Returns if they have piercings (hasPiercings)
	 */
	public String getHasPiercings() {
		return hasPiercings;
	}//end of getHasPiercings method
	
	/**
	 * A method that returns the value of a given attribute from a string of the attribute's name
	 * @param attr the attribute value being requested
	 * @return String - the value of the attribute requested
	 */
	public String getValueOfAttributeFromString(String attr){
		switch (attr){//we don't need to use breaks because return ends the method
			case "name":
				return name;
			case "eyeColour":
				return eyeColour;
			case "gender":
				return gender;
			case "skinTone":
				return skinTone;
			case "hairColour":
				return hairColour;
			case "hasFacialHair":
				return hasFacialHair;
			case "hasGlasses":
				return hasGlasses;
			case "hasVisibleTeeth":
				return hasVisibleTeeth;
			case "hasHat":
				return hasHat;
			case "hairLength":
				return hairLength;
			case "hasPiercings":
				return hasPiercings;
			default://we would like to hope this never happens
				return "error";
		}//end of switch/case
	}//end of getValueOfAttributeFromString method
}//end of BoardCharacter class
