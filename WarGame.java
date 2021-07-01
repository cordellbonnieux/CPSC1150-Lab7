import java.util.Scanner; 
public class WarGame{
	public static void main(String[] args){
     	Scanner scan = new Scanner(System.in);  
		final int ROUND = 10;
		int user, comp, score = 0;
		for (int r=1; r < ROUND +1; ++r) {
			comp = genInput();
			user = getInput(scan);
			printRoundInfo(r, user, comp);
			score = printRoundResult(score, user, comp);
		}
		System.out.println("End of Game!");
      	scan.close();
	}

	public static int getInput(Scanner input){
		// prompt user to enter a number between 1 and 52, 
		System.out.print("Please enter an integer between 1 and 52: ");
		int num = input.nextInt();

		// then validate and return it
		if (num > 52 || num < 1)
			return getInput(input);

		return num;
	}	

	public static int genInput(){
		// generate and return a random integer number between 1 and 52
		int num = (int)(1 + Math.random() * 52);

		return num;
    }

    public static void printRoundInfo(int r, int user, int comp){
    	System.out.print("R" + r + ": ");
    	System.out.print("Computer card is " + getRank(comp) + " of " + getSuit(comp));
    	System.out.println("; User card is " + getRank(user) + " of " + getSuit(user));
    }

    public static int printRoundResult(int score, int user, int comp){
    	int winner = findWinner(user, comp);
    	switch (winner){
    		case 0 : score *=2;
    			System.out.println("It’s tie – user score is " + score);
    			break;
    		case 1 : score +=1;
 				System.out.println("User wins – user score is " + score);
    			break;
    		default : 
    		 	System.out.println("Computer wins – user score is " + score);
    			break;
     	}
     	return score;
    }

 	public static int findWinner(int user, int comp){
 		
		// find the card played
		user /= 4;
		comp /= 4;

		// 0 = 13, so change the possible 0s to 13s for comparrison
		if (user == 0)
			user = 13;
		else if (comp == 0)
			comp = 13;

		// find the winner and return -1, 1 or 0 if it is tie, 
		if (user > comp)
			return 1;
		else if (comp > user)
			return -1;
		else 
			return 0;	
 	}

 	// add more methods if needed. 
	public static String getRank(int num) {
		
		// calculates the card number 
		num /= 4;
		
		String rank;

		// create a text label for the card
		switch(num) {
			case 1: rank = "Ace";
				break;
			case 2: rank = "Two";
				break;
			case 3: rank = "Three";
				break;
			case 4: rank = "Four";
				break;
			case 5: rank = "Five";
				break;
			case 6: rank = "Six";
				break;
			case 7: rank = "Seven";
				break;
			case 8: rank = "Eight";
				break;
			case 9: rank = "Nine";
				break;
			case 10: rank = "Ten";
				break;
			case 11: rank = "Jack";
				break;
			case 12: rank = "Queen";
				break;
			default: rank = "King";
		}

		return rank;
	}

	public static String getSuit(int num) {
		
		return "";
	}
}