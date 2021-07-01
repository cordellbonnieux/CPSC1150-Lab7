import java.util.Scanner; 
/**
 * <h2> Game of War </h2>
 * <b>Student: Cordell Bonnieux</b><br>
 * <b>Class: CPSC 1150 W01</b><br>
 * <b>Professor: Dr. Bita Shadgar</b><br>
 * <b>Date: June 30 2021</b>
 * <p>
 * This Game of War asks the player for a number and calculates a card from a deck of cards.
 * The program then generates a card to play against the user. The card with the higher rank, 
 * despite the suit, wins. The player's score is incremented for each win, and doubled for each tie.
 * The game repeats for 10 rounds; after, the program is exited.
 * </p>
 * 
 * <p>
 * You will notice that rather than linearly assigning a card value to a number between 1 and 52, this program uses division and modulo to calculate the cards.
 * This method is proven to provide 52 unique results, it imitates the random nature of picking a card off the top of a stack. Though the user may enter
 * "10", this does not mean they will get a card numbered "10". To support my claim, I've written the results of this operation 
 * in an external repl <a href="https://replit.com/join/duruuullcj-cordellbonnieux" target="_blank">here</a>.
 * </p>
 * 
 * <h3>Part B Answers</h3>
 * <ol>
 * 		<li>
 * 			<b>Q:</b> 
 * 			"In the main method to call genInput method use the name of class and dot operator,
 *			i.e: replace comp = genInput(); (line8) with comp = WarGame.genInput();
 *			and compile and run the program. What happens?"
 *			<br>
 *			<br><b>A:</b>
 *			The program runs the same, this is because we are now explicitly calling the class(WarGame) which genInput() resides in; the reason that 
 *			this was unecessary before, is because the method we are calling it from (main) is also already in that same class (WarGame).
 *		</li>
 *		<br>
 * 		<li> 
 * 			<b>Q:</b>
 * 			"Now remove static modifier in the getInput method’s header and compile the
 *			program. What happens? Justify the result."
 *			<br><b>A:</b>
 *			This change causes a compile error, this is because getInput() is now non-static thus, we cannot call the method in the same way. 
 *			In order to call it as such, we would need to create a new class with this non-static method, then in our WarGame class main method create a new instance of 
 *			our new class as an object and then call the method in dot notation from that new object (of the new class).
 *
 *			For our purposes this is redundant, because this method is part of the WarGame class and necessary for it to function; it is not an outside class
 *			that I am calling to use it's functionality (like I am with Scanner).
 * 		</li> 
 * </ol>
 * 
 * @author Cordell Bonnieux
 * @version 1.0
 * @since 2021-06-30
 * 
 * <h3>Test Cases:</h3>
 * <div style="display:flex;">
 * <img src="img/test1.png" style="margin:5px;">
 * <img src="img/test2.png" style="margin:5px;">
 * </div>
 * 
 * <h3>Pseudocode:</h3>
 * <h4>Main()</h4>
 * <h5>START</h5>
 * <ul>
 *		<li>Compute constant integer ROUND = 10</li>
 *		<li>Compute integers user, comp, score = 0</li>
 *		<li>For integer r = 1, as long as r < ROUND, ++r</li>
 *		<ul>
 *			<li>Compute comp = genInput()</li>
 *			<li>Compute user = getInput()</li>
 *			<li>Compute printRoundInfo(r, user, comp)</li>
 *			<li>Compute score = printRoundResult(score, user, comp)</li>
 *		</ul>
 *		<li>Print "End of Game!"</li>
 *		<li>End </li>
 * </ul>
 * <h4>genInput()</h4>
 * <ul>
 * 		<li>Retrun a random integer between 1 and 52 (inclusive)</li>
 * 
 * </ul>
 * <h4>getInput()</h4>
 * <ul>
 * 		<li>Print "Please enter an integer between 1 and 52"</li>
 * 		<li>Read integer num</li>
 * 		<li>If num > 52 Or num < 1</li>
 * 		<ul>
 * 			<li>Return getInput()</li>
 * 		</ul>
 * 		<li>Return num</li>
 * </ul>
 * <h4>printRoundInfo(r, user, comp)</h4>
 * <ul>
 * 		<li>Print "R" + r + ": Computer card is " + getRank(comp) + " of " + getSuit(comp) 
 * 				; User card is " + getRank(user) + " of " + getSuit(user) </li>
 * </ul>
 * <h4>printRoundResult(score, user, comp)</h4>
 * <ul>
 * 		<li>Compute integer winner = findWinner(user, comp)</li>
 * 		<li>If winner == 0</li>
 * 		<ul>
 * 			<li>score *= 2</li>
 * 			<li>Print "It's a tie - user score is " + score</li>
 * 		</ul>
 * 		<li>Else if winner == 1</li>
 * 		<ul>
 * 			<li>Compute score += 1</li>
 * 			<li>Print "User wins - user score is " + score</li>
 * 		</ul>
 * 		<li>Else</li>
 * 		<ul>
 * 			<li>Print "Computer wins - user score is " + score</li>
 * 		</ul>
 * 		<li>Return score</li>
 * </ul>
 * <h4>findWinner(user, comp)</h4>
 * <ul>
 * 		<li>Compute user /= 4, comp /= 4</li>
 * 		<li>If user == 0</li>
 * 		<ul>
 * 			<li>user = 13</li>
 * 		</ul>
 * 		<li>Else if comp == 0</li>
 * 		<ul>
 * 			<li>comp = 13</li>
 * 		</ul>
 * 		<li>If user > comp</li>
 * 		<ul>
 * 			<li>Return 1</li>
 * 		</ul>
 * 		<li>Else if comp > user</li>
 * 		<ul>
 * 			<li>Return -1</li>
 * 		</ul>
 * 		<li>Else</li>
 * 		<ul>
 * 			<li>Return 0</li>
 * 		</ul>
 * </ul>
 * <h4>getRank(num)</h4>
 * <ul>
 * 		<li>Compute n /= 4</li>
 * 		<li>Compute String rank</li>
 * 		<li>If n == 1</li>
 * 		<ul>
 * 			<li>Compute rank = "One"</li>
 * 		</ul>
 * 		<li>Else if n == 2</li>
 * 		<ul>
 * 			<li>Compute rank = "Two"</li>
 * 		</ul>
  * 	<li>Else if n == 3</li>
 * 		<ul>
 * 			<li>Compute rank = "Three"</li>
 * 		</ul>
  * 	<li>Else if n == 4</li>
 * 		<ul>
 * 			<li>Compute rank = "Four"</li>
 * 		</ul>
  * 	<li>Else if n == 5</li>
 * 		<ul>
 * 			<li>Compute rank = "Five"</li>
 * 		</ul>
  * 	<li>Else if n == 6</li>
 * 		<ul>
 * 			<li>Compute rank = "Six"</li>
 * 		</ul>
  * 	<li>Else if n == 7</li>
 * 		<ul>
 * 			<li>Compute rank = "Seven"</li>
 * 		</ul>
  * 	<li>Else if n == 8</li>
 * 		<ul>
 * 			<li>Compute rank = "Eight"</li>
 * 		</ul>
  * 	<li>Else if n == 9</li>
 * 		<ul>
 * 			<li>Compute rank = "Nine"</li>
 * 		</ul>
  * 	<li>Else if n == 10</li>
 * 		<ul>
 * 			<li>Compute rank = "Ten"</li>
 * 		</ul>
  * 	<li>Else if n == 11</li>
 * 		<ul>
 * 			<li>Compute rank = "Jack"</li>
 * 		</ul>
  * 	<li>Else if n == 12</li>
 * 		<ul>
 * 			<li>Compute rank = "Queen"</li>
 * 		</ul>
 * 		<li>Else</li>
 * 		<ul>
 * 			<li>Compute rank = King</li>
 * 		</ul>
 * 		<li>Return rank</li>
 * </ul>
 * <h4>getSuit(num)</h4>
 * <ul>
 * 		<li>Compute num %= 4</li>
 * 		<li>Compute string suit</li>
  * 	<li>If suit == 0</li>
 * 		<ul>
 * 			<li>Compute suit = "Diamonds"</li>
 * 		</ul>
 * 		<li>Else if suit == 1</li>
 * 		<ul>
 * 			<li>Compute suit = "Clubs"</li>
 * 		</ul>
  * 	<li>Else if suit == 2</li>
 * 		<ul>
 * 			<li>Compute suit = "Hearts"</li>
 * 		</ul>
   * 	<li>Else if suit == 3</li>
 * 		<ul>
 * 			<li>Compute = "Spades"</li>
 * 		</ul>
 * 		<li>Return suit</li>
 * </ul>
 * <h5>END</h5>
 */
public class WarGame{
	/**
	 * This method acts as the index for the program. First assigning an amount of rounds(10), 
	 * then incrementing the core of the program times the number of rounds(10).	 * 
	 * @param args
	 */
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

	/**
	 * This method prompts the user to enter an integer between 1 - 52, then reads the integer.
	 * If the integer is below 1 or above 52, the mothod starts over, if not it returns the integer.	 * 
	 * @param input
	 * @return
	 */
	public static int getInput(Scanner input){
		// prompt user to enter a number between 1 and 52, 
		System.out.print("Please enter an integer between 1 and 52: ");
		int num = input.nextInt();

		// then validate and return it
		if (num > 52 || num < 1)
			return getInput(input);

		return num;
	}	
	/**
	 * This method generates a random integer between 1 and 52 and returns it.
	 * @return
	 */
	public static int genInput(){
		// generate and return a random integer number between 1 and 52
		int num = (int)(1 + Math.random() * 52);

		return num;
    }
	/**
	 * This method prints out the round number followed by which cards the user and computer have chosen.
	 * @param r
	 * @param user
	 * @param comp
	 */
    public static void printRoundInfo(int r, int user, int comp){
    	System.out.print("R" + r + ": ");
    	System.out.print("Computer card is " + getRank(comp) + " of " + getSuit(comp));
    	System.out.println("; User card is " + getRank(user) + " of " + getSuit(user));
    }

	/**
	 * This method, first calls the {@code findWinner()} with {@code user} and {@code comp} as parameters and stores its 
	 * returned value in an integer called {@code winner}. If {@code winner} equals 0, it's a tie the user is prompted and the user's score is doubled.
	 * If the value is 1, the user wins, prompt them and increment the score. If {@code winner} is neither, the computer wins, and the user is prompted.
	 * The score is then returned.
	 * @param score
	 * @param user
	 * @param comp
	 * @return
	 */
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

	/**
	 * This method takes two para meters {@code user} and {@code comp}, divides them by 4 and stores the subsequent values back into their respective variables.
	 * The method then checks if {@code user} or {@code comp} equals 0, if they do change them to 13. Then, compare the two values if user's value is greater return 1,
	 * If the computer's is higher, return -1, finally if they are equal return 0.
	 * @param user
	 * @param comp
	 * @return
	 */
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

	 /**
	  * This method takes the parameter num, divides it by 4 then stores the result back into num. Then a string variable called rank is created.
	  * num is then compared, if it equals an integer between 2 and 10, it's text value is stored in rank; similarily if it's value is 1, 11, 12, 0 or 13
	  * rank will then equal "Ace", "Jack", "Queen" or "King" for both 0 and 13. After rank is assigned, return it.
	  * @return
	  */
	public static String getRank(int num) {
		
		// calculate the card number 
		num /= 4;
		
		// var to store rank name
		String rank;

		// assign the rank text name
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
	/**
	 * This method gets a value num and stores it's modulus by 4 remainder back into num. If num is 0, 1, 2 or 3, a string variable
	 * named suit is created and assigned "Diamonds", "Clubs", "Hearts" or "Spades" resepectively. The suit is then returned.
	 * @param num
	 * @return
	 */
	public static String getSuit(int num) {
		
		// calculate the suit
		num %= 4;

		// var to store suit name
		String suit = "";

		// assign suit name 
		switch(num) {
			case 0: suit = "Diamonds";
				break;
			case 1: suit = "Clubs";
				break;
			case 2: suit = "Hearts";
				break;
			case 3: suit = "Spades";
		}

		return suit;
	}
}