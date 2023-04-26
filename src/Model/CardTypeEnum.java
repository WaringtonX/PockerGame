package Model;

import java.util.ArrayList;
import java.util.List;

/** 
 * @author Warington
 *
 */
public enum CardTypeEnum {

	/** 0 */
	Hearts("Hearts") {
	},
	/** 1 */
	Spade("Spade") {
	},
	/** 2 */
	Club("Club") {
	},
	/** 3 */
	Diamond("Diamond") {
	};
	
	/** The display name. */
	private String displayName;

	/**
	 * Instantiates a new Card Type Enum.
	 *
	 * @param displayNameX
	 *            the display name X
	 */
	private CardTypeEnum(String displayNameX) {
		displayName = displayNameX;
	}
	
	/**
	 * Gets the Card Type name.
	 *
	 * @return the friendly name
	 */
	public String getFriendlyName() {
		return displayName;
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
