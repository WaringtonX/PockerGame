import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import Model.*;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Main {
	
	// intialize variables and objects
	private static List<Card> cards = new ArrayList<Card>();
	private static List<Card> playercards = new ArrayList<Card>();
	public  static Player mplayer = new Player();
	private static  Random rand = new Random();
	private static CardResults cardresults = new CardResults();
	private static int numberofcards = 5;
	private static int playernumber;
	private static List<Card> testcards = new ArrayList<Card>();
	
	// Color variables
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String	MAGENTA	= "\u001B[35m";
	public static final String ANSI_BRIGHT_BLACK = "\u001B[90m";
	
	
	public static void main(String  args[]) {
		// start method
		 Init();
	}
	
	// a function consisting of the initial method to start application
	private static void Init() {
		System.out.println(ANSI_CYAN +"*******************************************************************"+ ANSI_RESET);
		System.out.println(ANSI_CYAN +"***************** WELCOME TO THE POCKER GAME **********************"+ ANSI_RESET);
		System.out.println(ANSI_CYAN +"*******************************************************************"+ ANSI_RESET);
		
		System.out.println();
        System.out.println("Select your Option");
        System.out.println( ANSI_RED + "1.Start Game\n2.Unit Testing\n3.Exit Game" + ANSI_RESET);
        System.out.println("Option : ");
        
        //a scanner listening for input
        Scanner ins = new Scanner(System.in);
        int option = ins.nextInt();
        
        if(option == 1) {
        	RunGame();
        }else if(option == 2) {
        	UnitTesting();
        }else if(option == 3) {
        	System.exit(0);
        }
	}
	
	// a function to run  the game
	private static void RunGame() {
		System.out.println(ANSI_GREEN +"*******************************************************************"+ ANSI_RESET);
		System.out.println(ANSI_GREEN +"************************* POCKER GAME *****************************"+ ANSI_RESET);
		System.out.println(ANSI_GREEN +"*******************************************************************"+ ANSI_RESET);
		
     	cards = Card.getListofCards();
		playernumber = rand.nextInt(1000);
		
		Scanner ins = new Scanner(System.in);
		System.out.println("");
		System.out.println("Please enter your username!");
		String name = ins.nextLine();
		
		mplayer.setName(name);
		mplayer.setPlayernumber(playernumber);
		
		System.out.println(" ");
		System.out.println(ANSI_CYAN + "Player Name : " + mplayer.getName() + "(" + mplayer.getPlayernumber() +")"+ ANSI_RESET);
		System.out.println("");
		
		//Class c = this.getClass();
		//System.out.println( Main.class.getCanonicalName());
		
		Playgame();
		
		System.out.println();
        System.out.println("Pocker Game");
        System.out.println("1. Play Again\n2. Back");
        System.out.println("Select an option : ");

        /// a loop to loop input user options until user exit application
        int k = 1;
        while (k != 0)
        {
            k = ins.nextInt();
            switch (k)
            {
                    case 1:
                    	Playgame();
                            break;
                    case 2:
                       Init();
            }

    		System.out.println();
            System.out.println("Pocker Game");
            System.out.println("1. Play Again\n2. Back");
            System.out.println("Select an option : ");
        }
        
        ins.close();
	}
	
	// a function that start the game 
	private static void Playgame() {
		// shuffling card deck per every single function call
        Card.shuffleCards(cards);
        String display = "";
        playercards.clear();
        
       // PrintStream used to output "UTF-8"  and  interpret unicode
		PrintStream outStream = null;
		try {
			outStream = new PrintStream(System.out, true, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		for (int i = 0; i < numberofcards; i++)
        {
			playercards.add(cards.get(i));
        }
		
        cardresults.setPlayecards(playercards);
		for(Card playercard : playercards) {
			
			display += playercard.getCardtype().getSuitColor() + playercard.getCardnumber().getCardLebal() + playercard.getCardtype().getSuitIcon() +" "+ ANSI_RESET;
		}
		
		
		// displaying results
		System.out.println(ANSI_YELLOW + "Shuffling .. Shuffling ... Shuffling" + ANSI_RESET);
	    //System.out.println(display);
        outStream.println(display);
		System.out.println(ANSI_CYAN  +"You have : "  + ANSI_RESET + ANSI_YELLOW + cardresults.getCardsResulst().getFriendlyName()+  ANSI_RESET ); 
	}
	
	// a function to do a few unit tests
	private static void UnitTesting() {
		System.out.println(ANSI_RED +"*******************************************************************"+ ANSI_RESET);
		System.out.println(ANSI_RED +"************************ UNIT TESTING *****************************"+ ANSI_RESET);
		System.out.println(ANSI_RED +"*******************************************************************"+ ANSI_RESET);
		System.out.println();
		
        System.out.println("Select your Option");
        System.out.println(ANSI_RED + "1.Royal Flush \n2.Straight Flush\n3.Four of a Kind\n4.Full House\n5.Flush\n6. Straight\n7.Three of a kind\n8.Two pair\n9.One pair\n10. Back" + ANSI_RESET);
        System.out.println("Option : ");
        Scanner ins = new Scanner(System.in);
        
        // card objects
        Card tcard = null;
        Card tcard1 = null;
        Card tcard2 = null;
        Card tcard3 = null;
        Card tcard4 = null;
        int k = 1;
        while (k != 0)
        {
            k = ins.nextInt();
            switch (k)
            {
                    case 1:
                            testcards.clear();
                            tcard = new Card();
                            tcard1 = new Card();
                            tcard2 = new Card();
                            tcard3 = new Card();
                            tcard4 = new Card();
                            
                            tcard.setCardnumber(CardNumberEnum.Ten);
                            tcard.setCardtype(CardTypeEnum.Hearts);
                            
                            tcard1.setCardnumber(CardNumberEnum.Jack);
                            tcard1.setCardtype(CardTypeEnum.Hearts);
                         
                            tcard2.setCardnumber(CardNumberEnum.Queen);
                            tcard2.setCardtype(CardTypeEnum.Hearts);
                            
                            tcard3.setCardnumber(CardNumberEnum.King);
                            tcard3.setCardtype(CardTypeEnum.Hearts);
                            
                            tcard4.setCardnumber(CardNumberEnum.Ace);
                            tcard4.setCardtype(CardTypeEnum.Hearts);
                            
                            testcards.add(tcard);
                            testcards.add(tcard1);
                            testcards.add(tcard2);
                            testcards.add(tcard3);
                            testcards.add(tcard4);
                            getUnitTestResuts(testcards);
                            
                            break;
                    case 2:
                        testcards.clear();
                        tcard = new Card();
                        tcard1 = new Card();
                        tcard2 = new Card();
                        tcard3 = new Card();
                        tcard4 = new Card();
                        
                        tcard.setCardnumber(CardNumberEnum.Four);
                        tcard.setCardtype(CardTypeEnum.Club);
                        
                        tcard1.setCardnumber(CardNumberEnum.Five);
                        tcard1.setCardtype(CardTypeEnum.Club);
                                             
                        tcard2.setCardnumber(CardNumberEnum.Six);
                        tcard2.setCardtype(CardTypeEnum.Club);
                        
                        tcard3.setCardnumber(CardNumberEnum.Seven);
                        tcard3.setCardtype(CardTypeEnum.Club);
                        
                        tcard4.setCardnumber(CardNumberEnum.Eight);
                        tcard4.setCardtype(CardTypeEnum.Club);
                        
                        testcards.add(tcard);
                        testcards.add(tcard1);
                        testcards.add(tcard2);
                        testcards.add(tcard3);
                        testcards.add(tcard4);
                        getUnitTestResuts(testcards);
                        
                        break;
                    case 3:
                        testcards.clear();
                        tcard = new Card();
                        tcard1 = new Card();
                        tcard2 = new Card();
                        tcard3 = new Card();
                        tcard4 = new Card();
                        
                        tcard.setCardnumber(CardNumberEnum.Ace);
                        tcard.setCardtype(CardTypeEnum.Hearts);
                        
                        tcard1.setCardnumber(CardNumberEnum.Ace);
                        tcard1.setCardtype(CardTypeEnum.Spade);
                                             
                        tcard2.setCardnumber(CardNumberEnum.Ace);
                        tcard2.setCardtype(CardTypeEnum.Club);
                        
                        tcard3.setCardnumber(CardNumberEnum.Ace);
                        tcard3.setCardtype(CardTypeEnum.Diamond);
                        
                        tcard4.setCardnumber(CardNumberEnum.Eight);
                        tcard4.setCardtype(CardTypeEnum.Spade);
                        
                        testcards.add(tcard);
                        testcards.add(tcard1);
                        testcards.add(tcard2);
                        testcards.add(tcard3);
                        testcards.add(tcard4);
                        getUnitTestResuts(testcards);
                        break;
                    case 4:
                        testcards.clear();
                        tcard = new Card();
                        tcard1 = new Card();
                        tcard2 = new Card();
                        tcard3 = new Card();
                        tcard4 = new Card();
                        
                        tcard.setCardnumber(CardNumberEnum.Ace);
                        tcard.setCardtype(CardTypeEnum.Spade);
                        
                        tcard1.setCardnumber(CardNumberEnum.Ace);
                        tcard1.setCardtype(CardTypeEnum.Hearts);
                                                                  
                        tcard2.setCardnumber(CardNumberEnum.Ace);
                        tcard2.setCardtype(CardTypeEnum.Club);
                                         
                        tcard3.setCardnumber(CardNumberEnum.Six);
                        tcard3.setCardtype(CardTypeEnum.Spade);
                        
                        tcard4.setCardnumber(CardNumberEnum.Six);
                        tcard4.setCardtype(CardTypeEnum.Diamond);
                        
                        testcards.add(tcard);
                        testcards.add(tcard1);
                        testcards.add(tcard2);
                        testcards.add(tcard3);
                        testcards.add(tcard4);
                        getUnitTestResuts(testcards);
                        break;
                       
                    case 5:
                        testcards.clear();
                        tcard = new Card();
                        tcard1 = new Card();
                        tcard2 = new Card();
                        tcard3 = new Card();
                        tcard4 = new Card();
                        
                        tcard.setCardnumber(CardNumberEnum.Four);
                        tcard.setCardtype(CardTypeEnum.Diamond);
                        
                        tcard1.setCardnumber(CardNumberEnum.Eight);
                        tcard1.setCardtype(CardTypeEnum.Diamond);
                        
                        tcard2.setCardnumber(CardNumberEnum.Six);
                        tcard2.setCardtype(CardTypeEnum.Diamond);
                        
                        tcard3.setCardnumber(CardNumberEnum.Seven);
                        tcard3.setCardtype(CardTypeEnum.Diamond);
                        
                        tcard4.setCardnumber(CardNumberEnum.Two);
                        tcard4.setCardtype(CardTypeEnum.Diamond);
                        
                        testcards.add(tcard);
                        testcards.add(tcard1);
                        testcards.add(tcard2);
                        testcards.add(tcard3);
                        testcards.add(tcard4);
                        getUnitTestResuts(testcards);           	
                    	break;
                    case 6 :
                        testcards.clear();
                        tcard = new Card();
                        tcard1 = new Card();
                        tcard2 = new Card();
                        tcard3 = new Card();
                        tcard4 = new Card();
                        
                        tcard.setCardnumber(CardNumberEnum.Three);
                        tcard.setCardtype(CardTypeEnum.Spade);
                        
                        tcard1.setCardnumber(CardNumberEnum.Four);
                        tcard1.setCardtype(CardTypeEnum.Club);
                        
                        tcard2.setCardnumber(CardNumberEnum.Five);
                        tcard2.setCardtype(CardTypeEnum.Hearts);
                        
                        tcard3.setCardnumber(CardNumberEnum.Six);
                        tcard3.setCardtype(CardTypeEnum.Spade);
                        
                        tcard4.setCardnumber(CardNumberEnum.Seven);
                        tcard4.setCardtype(CardTypeEnum.Diamond);
                        
                        testcards.add(tcard);
                        testcards.add(tcard1);
                        testcards.add(tcard2);
                        testcards.add(tcard3);
                        testcards.add(tcard4);
                        getUnitTestResuts(testcards);
                    	 break;
                    case 7:
                        testcards.clear();
                        tcard = new Card();
                        tcard1 = new Card();
                        tcard2 = new Card();
                        tcard3 = new Card();
                        tcard4 = new Card();
                        
                        tcard.setCardnumber(CardNumberEnum.King);
                        tcard.setCardtype(CardTypeEnum.Spade);
                        
                        tcard1.setCardnumber(CardNumberEnum.King);
                        tcard1.setCardtype(CardTypeEnum.Hearts);
                        
                        tcard2.setCardnumber(CardNumberEnum.King);
                        tcard2.setCardtype(CardTypeEnum.Club);
                        
                        tcard3.setCardnumber(CardNumberEnum.Five);
                        tcard3.setCardtype(CardTypeEnum.Spade);
                        
                        tcard4.setCardnumber(CardNumberEnum.Eight);
                        tcard4.setCardtype(CardTypeEnum.Diamond);
                        
                        testcards.add(tcard);
                        testcards.add(tcard1);
                        testcards.add(tcard2);
                        testcards.add(tcard3);
                        testcards.add(tcard4);
                        getUnitTestResuts(testcards);
                    	break;
                    case 8:
                        testcards.clear();
                        tcard = new Card();
                        tcard1 = new Card();
                        tcard2 = new Card();
                        tcard3 = new Card();
                        tcard4 = new Card();
                        
                        tcard.setCardnumber(CardNumberEnum.Three);
                        tcard.setCardtype(CardTypeEnum.Club);
                        
                        tcard1.setCardnumber(CardNumberEnum.Nine);
                        tcard1.setCardtype(CardTypeEnum.Spade);
                        
                        tcard2.setCardnumber(CardNumberEnum.Nine);
                        tcard2.setCardtype(CardTypeEnum.Hearts);
                        
                        tcard3.setCardnumber(CardNumberEnum.Five);
                        tcard3.setCardtype(CardTypeEnum.Diamond);
                        
                        tcard4.setCardnumber(CardNumberEnum.Five);
                        tcard4.setCardtype(CardTypeEnum.Club);
                        
                        testcards.add(tcard);
                        testcards.add(tcard1);
                        testcards.add(tcard2);
                        testcards.add(tcard3);
                        testcards.add(tcard4);
                        getUnitTestResuts(testcards);
                    	break;
                    case 9:
                        testcards.clear();
                        tcard = new Card();
                        tcard1 = new Card();
                        tcard2 = new Card();
                        tcard3 = new Card();
                        tcard4 = new Card();
                        
                        tcard.setCardnumber(CardNumberEnum.Nine);
                        tcard.setCardtype(CardTypeEnum.Spade);
                        
                        tcard1.setCardnumber(CardNumberEnum.Ten);
                        tcard1.setCardtype(CardTypeEnum.Hearts);
                        
                        tcard2.setCardnumber(CardNumberEnum.Six);
                        tcard2.setCardtype(CardTypeEnum.Club);
                        
                        tcard3.setCardnumber(CardNumberEnum.Six);
                        tcard3.setCardtype(CardTypeEnum.Spade);
                        
                        tcard4.setCardnumber(CardNumberEnum.Two);
                        tcard4.setCardtype(CardTypeEnum.Diamond);
                        
                        testcards.add(tcard);
                        testcards.add(tcard1);
                        testcards.add(tcard2);
                        testcards.add(tcard3);
                        testcards.add(tcard4);
                        getUnitTestResuts(testcards);
                    	break;
                    case 10:
                    	Init();
            }

            System.out.println("Select your Option");
            System.out.println(ANSI_RED + "1.Royal Flush \n2.Straight Flush\n3.Four of a Kind\n4.Full House\n5.Flush\n6. Straight\n7.Three of a kind\n8.Two pair\n9.One pair\n10. Back" + ANSI_RESET);
            System.out.println("Option : ");
        }   
        
	}
	
	
	// a function to out put unit test results
	private static void getUnitTestResuts(List<Card> card) {
		   String display = "";
		   cardresults.setPlayecards(card);
		   
		    PrintStream outStream = null;
			try {
				outStream = new PrintStream(System.out, true, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		   for(Card playercard : card) {
				
				display += playercard.getCardtype().getSuitColor() + playercard.getCardnumber().getCardLebal() + playercard.getCardtype().getSuitIcon() +" "+ ANSI_RESET;
			}
		   outStream.println(display);
		   System.out.println(ANSI_CYAN  +"You have : "  + ANSI_RESET + ANSI_YELLOW + cardresults.getCardsResulst().getFriendlyName()+  ANSI_RESET);	
	}

}
