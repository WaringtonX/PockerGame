package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** 
 * @author Warington
 *
 */
public class Card{
	/*
	 * object of cards
	 */
	private CardNumberEnum cardnumber;
	private CardTypeEnum cardtype;
	private static List<Card> cardlist = new ArrayList<Card>();
	
	// Constructor
	public void Card() {
		
	}
	
	/**
	 *  Generate a pack of cards
	 *  
	 * @return
	 */
	
	public static List<Card> getListofCards() {
		 
		for(CardTypeEnum cardtypes: CardTypeEnum.values()) {
			for(CardNumberEnum cardnumber: CardNumberEnum.values()) {
				Card card = new Card();
				card.cardnumber = cardnumber;
				card.cardtype = cardtypes;
				cardlist.add(card);
			}
		}
		
		return cardlist;
	}
	
	public CardNumberEnum getCardnumber() {
		return cardnumber;
	}


	public void setCardnumber(CardNumberEnum cardnumber) {
		this.cardnumber = cardnumber;
	}


	public CardTypeEnum getCardtype() {
		return cardtype;
	}


	public void setCardtype(CardTypeEnum cardtype) {
		this.cardtype = cardtype;
	}
	
	/**
	 * 
	 * A function to shuffle cards on a list
	 */
    public static void shuffleCards(List<Card> cards)
    {
            Collections.shuffle(cards);
    }


}
