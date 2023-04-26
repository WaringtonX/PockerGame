

import java.util.List;

import Model.Card;
import Model.CardNumberEnum;
import Model.CardTypeEnum;
import Model.HandsEnum;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author warin
 * Card Results object
 *
 */
public class CardResults {
	
	// Variables
	private List<Card> playecards;
	private CardNumberEnum carnumber;
	private HandsEnum handsenum;
	
	public  CardResults() {
	}
	
	public List<Card> getPlayecards() {
		return playecards;
	}
	public void setPlayecards(List<Card> playecards) {
		this.playecards = playecards;
	}
	public CardNumberEnum getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(CardNumberEnum carnumber) {
		this.carnumber = carnumber;
	}
	public HandsEnum getHandsenum() {
		return handsenum;
	}
	public void setHandsenum(HandsEnum handsenum) {
		this.handsenum = handsenum;
	}
	
	//  functions takes list of cards , assess , the return results based on card patterns
	public HandsEnum getCardsResulst() {
		// Create an object of Hands Enums
		HandsEnum results = null; 
		String suitename = playecards.get(0).getCardtype().getFriendlyName();
	    boolean isroyalflush = false;
	    boolean isSequencial = true;
	    boolean isfourofakind = false;
	    boolean isfullhouse = false;
	    boolean isthree = false;
	    boolean istwopair = false;
	    boolean isonepair = false;
	    
	    // initialize card number enum list
		List<CardNumberEnum> cardnum = new ArrayList<CardNumberEnum>();
		List<Integer> cardnumberlist = new ArrayList<Integer>();
		int[] counts = new int[15];	
		int numsamesuite = 0;
		
		// iterate through the player cards list , check if the name is similar throughout the list 
		// add card numbers
		for(Card card : playecards) {
			if(card.getCardtype().getFriendlyName().equals(suitename)) {
				numsamesuite ++;
			}
			cardnum.add(card.getCardnumber());
			if(card.getCardnumber().getCardLebal() != "J" && card.getCardnumber().getCardLebal() != "Q" && card.getCardnumber().getCardLebal() != "K" && card.getCardnumber().getCardLebal() != "A") {
				int num = Integer.parseInt(card.getCardnumber().getCardLebal());
				cardnumberlist.add(num);
			}
		}
		
		// check if card hand is a royal flush
		if(cardnum.containsAll(CardNumberEnum.getRoyalFlush()) && CardNumberEnum.getRoyalFlush().containsAll(cardnum)) {
			isroyalflush = true;
		}
		
		// sort list of player cards
		Collections.sort(cardnumberlist);
		
		//if card consist of number check if numbers are sequential
		if(cardnumberlist.size() == 5) {
			//System.out.println("Count : " + cardnumberlist.size());
			for(int i = 1; i < cardnumberlist.size();i++) {
				if (cardnumberlist.get(i) - cardnumberlist.get(i-1) != 1) {
			        isSequencial = false;
			        break;
			    } 
			}
		}else {
			isSequencial = false;
		}
		
		
		// boolean for different card hands
		isfourofakind = RepeatCardsCount(playecards,4);
		isfullhouse = iSfullHouse(playecards);
		isthree = RepeatCardsCount(playecards,3);
		istwopair = isPair(playecards,2);
		isonepair = isPair(playecards,1);

		// check card status and set results
		if(isroyalflush && (numsamesuite == 5)) {
			results = HandsEnum.Royalflush;
		}
		else if(isSequencial &&  (numsamesuite == 5)) {
			results = HandsEnum.StraightFlush;
		}else if(isfourofakind) {
			results = HandsEnum.FourofaKind;
		}else if(isfullhouse){
			results = HandsEnum.FullHouse;
		}
		else if (numsamesuite == 5) {
			results = HandsEnum.Flush;
		}else if(isSequencial) {
			results = HandsEnum.Straight;
		}else if(isthree) {
			results = HandsEnum.ThreeofaKind;
		}else if(istwopair) {
			results = HandsEnum.TwoPair;
		}
		else if(isonepair) {
			results = HandsEnum.OnePair;
		}
		else {
			results = HandsEnum.HighCards;
		}
		
		return results;
	}
	
	// a function to look for repeating number or values in card list 
	// it accepts a value for the number of times card numbers are repeating
	public boolean RepeatCardsCount(List<Card> arr,int numberofcards){
	    int[] counts = new int[15];
	    for (Card c: arr) {
	    	if(c.getCardnumber().getCardLebal() == "J" || c.getCardnumber().getCardLebal() == "Q" || c.getCardnumber().getCardLebal() == "K" ||c.getCardnumber().getCardLebal() == "A") {
				if(c.getCardnumber().getCardLebal() == "A") {
					counts[1]++;
					if (counts[1] == numberofcards) return true;
				}else if(c.getCardnumber().getCardLebal() == "J") {
					counts[11]++;
					if (counts[11] == numberofcards) return true;
				}else if(c.getCardnumber().getCardLebal() == "Q") {
					counts[12]++;
					if (counts[12] == numberofcards) return true;
				}
				else if(c.getCardnumber().getCardLebal() == "K") {
					counts[13]++;
					if (counts[13] == numberofcards) return true;
				}			
			}else {
		    	int nums = Integer.parseInt(c.getCardnumber().getCardLebal());
		        counts[nums]++;
				if (counts[nums] == numberofcards) return true;
			}
	    }
	    return false;
	}
	
	// a function to check if card deck is a full house
	public boolean iSfullHouse(List<Card> arr){
	    int[] counts = new int[15];
	    boolean istthreefound = false;
	    boolean istwofound = false;
	    boolean ispair = false;
	    int countpairs = 0;
	    
	    for (Card c: arr) {
	    	if(c.getCardnumber().getCardLebal() == "J" || c.getCardnumber().getCardLebal() == "Q" || c.getCardnumber().getCardLebal() == "K" ||c.getCardnumber().getCardLebal() == "A") {
				if(c.getCardnumber().getCardLebal() == "A") {
					counts[1]++;
				}else if(c.getCardnumber().getCardLebal() == "J") {
					counts[11]++;
				}else if(c.getCardnumber().getCardLebal() == "Q") {
					counts[12]++;
				}
				else if(c.getCardnumber().getCardLebal() == "K") {
					counts[13]++;
				}			
			}else {
		    	int nums = Integer.parseInt(c.getCardnumber().getCardLebal());
		        counts[nums]++;
			}
	    }
	    
	    for(int i = 1;i < CardNumberEnum.getCardNumberList().size()+1;i++) {
	    	    if(counts[i] == 3) {
	    	    	istthreefound = true;
	    	    }else if(counts[i] == 2)  {
	    	    	istwofound = true;
	    	    	countpairs++;
	    	    }
	    }
	    
	    if(istthreefound && istwofound) {
	    	return true;
	    }
	    
	    if(countpairs == 2) {
	    	ispair = true;
	    }
	    
	    return false;
	}
	
	// a function to check for pair of cards
	//  and the number of those pairs
	public boolean isPair(List<Card> arr,int numpairs){
	    int[] counts = new int[15];
	    int countpairs = 0;
	    
	    for (Card c: arr) {
	    	if(c.getCardnumber().getCardLebal() == "J" || c.getCardnumber().getCardLebal() == "Q" || c.getCardnumber().getCardLebal() == "K" ||c.getCardnumber().getCardLebal() == "A") {
				if(c.getCardnumber().getCardLebal() == "A") {
					counts[1]++;
				}else if(c.getCardnumber().getCardLebal() == "J") {
					counts[11]++;
				}else if(c.getCardnumber().getCardLebal() == "Q") {
					counts[12]++;
				}
				else if(c.getCardnumber().getCardLebal() == "K") {
					counts[13]++;
				}			
			}else {
		    	int nums = Integer.parseInt(c.getCardnumber().getCardLebal());
		        counts[nums]++;
			}
	    }
	    
	    for(int i = 1;i < CardNumberEnum.getCardNumberList().size()+1;i++) {
	    	    if(counts[i] == 2) {
	    	    	countpairs++;
	    	    }
	    }
	    
	    if(countpairs == numpairs) {
	    	return true;
	    }
	    
	    return false;
	}
	
	
	// a function to check if the card list consist of unique suits
	public boolean areAllDistinct(List<CardTypeEnum> blocksList) {
	    return blocksList.stream().map(CardTypeEnum::getFriendlyName).distinct().count() == blocksList.size();
	}
	
}
