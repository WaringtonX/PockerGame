package Model;

import java.util.List;
import java.util.ArrayList;

/** 
 * @author Warington
 *
 */
public enum HandsEnum {

	/** 0 */
	Royalflush("Royal Flush") {
	},
	/** 1 */
	StraightFlush("Straight Flush") {
	},
	/** 2 */
	FourofaKind("Four of a Kind") {
	},
	/** 3 */
	FullHouse("Full House") {
	},
	/** 4 */
	Flush("Flush") {
	},
	/** 5 */
	Straight("Straight") {
	},
	/** 6 */
	ThreeofaKind("Three of a Kind") {
	},
	/** 7 */
	TwoPair("Two Pair") {
	},
	/** 8 */
	OnePair("One Pair") {
	},
	/** 9 */
	HighCards("High Cards") {
	};
	
	/** The display name. */
	private String displayName;

	/**
	 * Instantiates a new Hand Type Enum.
	 *
	 * @param displayNameX
	 *            the display name X
	 */
	private HandsEnum(String displayNameX) {
		displayName = displayNameX;
	}

	/**
	 * Gets the friendly name.
	 *
	 * @return the friendly name
	 */
	public String getFriendlyName() {
		return displayName;
	}
	
	// status list for active Hand types
	public static List<HandsEnum> getHandsList() {
			List<HandsEnum> up = new ArrayList<>();
			up.add(HandsEnum.StraightFlush);
			up.add(HandsEnum.FourofaKind);
			up.add(HandsEnum.FullHouse);
			up.add(HandsEnum.Flush);
			up.add(HandsEnum.Straight);
			up.add(HandsEnum.ThreeofaKind);
			up.add(HandsEnum.TwoPair);
			up.add(HandsEnum.OnePair);
			up.add(HandsEnum.HighCards);
			return up;
	}
}
