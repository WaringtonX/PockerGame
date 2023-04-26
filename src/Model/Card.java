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
	private String cardsuit;
	private String cardcolor;
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_BLACK = "\u001B[90m";
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
				AddCardSuit(cardtypes.getFriendlyName(),card);
				AddCardSuitColor(cardtypes.getFriendlyName(),card);
				cardlist.add(card);
			}
		}
		
		return cardlist;
	}

	//add a card suit string
	public static void  AddCardSuit(String type,Card cards) {
		if(type.equals("Hearts")) {
			cards.cardsuit = "\u2665";
		}else if(type.equals("Spade")) {
			cards.cardsuit = "\u2660";
		}else if(type.equals("Club")) {
			cards.cardsuit = "\u2663";
		}else if(type.equals("Diamond")) {
			cards.cardsuit = "\u2666";
		}
	}
	
	// color of suit based on suite type
	public static void  AddCardSuitColor(String type,Card cards) {
		if(type.equals("Hearts") || type.equals("Diamond")) {
			cards.cardcolor = ANSI_RED;
		}else if(type.equals("Spade") || type.equals("Club")) {
			cards.cardcolor = ANSI_BLACK;
		}
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
	
	public String getCardsuit() {
		return cardsuit;
	}

	public void setCardsuit(String cardsuit) {
		this.cardsuit = cardsuit;
	}

	public String getCardcolor() {
		return cardcolor;
	}

	public void setCardcolor(String cardcolor) {
		this.cardcolor = cardcolor;
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
