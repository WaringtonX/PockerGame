package Model;

import java.util.ArrayList;
import java.util.List;

/** 
 * @author Warington
 *
 */

public enum CardTypeEnum {

	/** 0 */
	Hearts("Hearts","\u2665","\u001B[31m") {
	},
	/** 1 */
	Spade("Spade","\u2660","\u001B[90m") {
	},
	/** 2 */
	Club("Club","\u2663","\u001B[90m") {
	},
	/** 3 */
	Diamond("Diamond","\u2666","\u001B[31m") {
	};
	
	/** The displayName;suitcolor
	 *  and suiticon  */
	private String suiticon;
	private String suitcolor;
	private String displayName;

	/**
	 * Instantiates a new Card Type Enum.
	 *
	 * @param displayNameX,suiticonX,suitcolorX
	 *            the displayNameX, display suiticonX and suitcolorX
	 */
	private CardTypeEnum(String displayNameX,String suiticonX,String suitcolorX) {
		displayName = displayNameX;
		suiticon = suiticonX;
		suitcolor = suitcolorX;
	}
	
	/**
	 * Gets the friendly name.
	 *
	 * @return the friendly name
	 */
	
	public String getFriendlyName() {
		return displayName;
	}
	
	/**
	 * Gets the Card Type Suit icon.
	 *
	 * @return suit icon
	 */
	public String getSuitIcon() {
		return suiticon;
	}
	
	/**
	 * Gets the Card Type Suit Color.
	 *
	 * @return suit color
	 */
	public String getSuitColor() {
		return suitcolor;
	}
	
	
	// status list for active Card types
	public static List<CardTypeEnum> getCardTypeList() {
			List<CardTypeEnum> up = new ArrayList<>();
			up.add(CardTypeEnum.Hearts);
			up.add(CardTypeEnum.Spade);
			up.add(CardTypeEnum.Club);
			up.add(CardTypeEnum.Diamond);
			return up;
	}
	
}
