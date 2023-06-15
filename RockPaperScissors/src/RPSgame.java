import java.awt.Choice;
import java.util.Scanner;

import javax.sql.rowset.JoinRowSet;

public class RPSgame {
static Scanner sc=new Scanner(System.in);
static String choice[]= {"Rock","Paper","Scissor"};
static int playerScore=0;
static int ComputerScore=0;

public static void main(String[] args) {
	System.out.println("Enter Your Name");
	String playerName=sc.next();
	
	RockPaperScissorsDataBase dBase=new RockPaperScissorsDataBase();
	dBase.insertPlayer(playerName, 0);
	
	while (playerScore<3 && ComputerScore<3) {
		System.out.println("Enter Your Choice :");
		System.out.println("0. Rock");
		System.out.println("1. Paper");
		System.out.println("2. Scissor");
		int playerChoice=sc.nextInt();
		if (playerChoice<3) {
		int computerChoice=(int)(Math.random()*3);
		System.out.println("ComputerChoice :"+choice[computerChoice]);
	System.out.println("============================================");	
			
		
		int result=compareChoice(playerChoice,computerChoice);
		if (result==1) {
			playerScore++;
			System.out.println("Player Win");
			System.out.println("============================================");	
		}
		else if (result==-1) {
			ComputerScore++;
			System.out.println("Computer Win");
			System.out.println("============================================");	
		}
		else {
			System.out.println("Its a Tie");
			System.out.println("============================================");	
		}
		System.out.println("Score:\n\n"+playerName+":"+playerScore+"\nComputer:"+ComputerScore);
		System.out.println("============================================");	
	}
		else {
			System.out.println("Invalid Input");
		}
	}
	if (playerScore>ComputerScore) {
		System.out.println("Congratilations You Win");
		System.out.println("============================================");	
		dBase.updateScore(playerName, playerScore);
	}
	else {
		System.out.println("Sorry You lose");
		System.out.println("============================================");	
	}
   }


public static int compareChoice(int playerChoice, int computerChoice) {
	
	if (playerChoice==computerChoice){
		return 0;
	}
	else if ((playerChoice==0 && computerChoice==2)
			||(playerChoice==1 && computerChoice==0)
			||(playerChoice==2 && computerChoice==1)){
		return 1;
		
	}
	else {
		return -1;
	}
	
}
}
