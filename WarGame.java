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
		// TODO: prompt user to enter a number between 1 and 52, 
		//		 then validate and return it
	}	

	public static int genInput(){
		//TODO : generate and return a random integer number between 1 and 52
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
 		//TODO: find the winner and return -1, 1 or 0 if it is tie, 
 		//user wins or computer wins 	
 	}

 	// add more methods if needed. 
}