package Model;

import java.util.ArrayList;
import java.util.List;

/** 
 * @author Warington
 *
 */
public enum CardNumberEnum {

	/** 1 */
	Ace("A") {
	},
	/** 2 */
	Two("2") {
	},
	/** 3 */
	Three("3") {
	},
	/** 4 */
	Four("4") {
	},
	/** 5 */
	Five("5") {
	},
	/** 6 */
	Six("6") {
	},
	/**  7*/
	Seven("7") {
	},
	/** 8 */
	Eight("8") {
	},
	/** 9 */
	Nine("9") {
	},
	/** 10 */
	Ten("10") {
	},
	/** 11 */
	Jack("J") {
	},
	/** 12 */
	Queen("Q") {
	},
	/** 13 */
	King("K") {
	};
	
	/** The display card number. */
	private String cardlebal;

	/**
	 * Instantiates a new Card Number Enum.
	 *
	 * @param cardlebalX
	 *            the card cardlebalX
	 */
	private CardNumberEnum(String cardlebalX) {
		cardlebal = cardlebalX;
	}

	/**
	 * Gets the card number.
	 *
	 * @return the card number
	 */
	public String getCardLebal() {
		return cardlebal;
	}
	
	// status list for active cardnumbers
	public static List<CardNumberEnum> getCardNumberList() {
			List<CardNumberEnum> up = new ArrayList<>();
			up.add(CardNumberEnum.Ace);
			up.add(CardNumberEnum.Two);
			up.add(CardNumberEnum.Three);
			up.add(CardNumberEnum.Four);
			up.add(CardNumberEnum.Five);
			up.add(CardNumberEnum.Six);
			up.add(CardNumberEnum.Seven);
			up.add(CardNumberEnum.Eight);
			up.add(CardNumberEnum.Nine);
			up.add(CardNumberEnum.Ten);
			up.add(CardNumberEnum.Jack);
			up.add(CardNumberEnum.Queen);
			up.add(CardNumberEnum.King);
			return up;
	}
	
	//  get royal flush enum list
	public static List<CardNumberEnum> getRoyalFlush() {
		List<CardNumberEnum> up = new ArrayList<>();
		up.add(CardNumberEnum.Ace);
		up.add(CardNumberEnum.Ten);
		up.add(CardNumberEnum.Jack);
		up.add(CardNumberEnum.Queen);
		up.add(CardNumberEnum.King);
		return up;
}
}
