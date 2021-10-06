//import libraries

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
	
	// game mechanics
	public static void main(String[] args) {
		
		char[][] board = {{'1', '|', '2', '|', '3'},
				{'-', '+', '-', '+', '-'},
				{'4', '|', '5', '|', '6'},
				{'-', '+', '-', '+', '-'},
				{'7', '|', '8', '|', '9'}};
		
		print(board);

		while(true) {
			
			Scanner scan = new Scanner(System.in);
			
			System.out.print("Press 1 to 9 to place: ");
			
			int playerPos = scan.nextInt();
			while(playerPositions.contains(playerPos)|| cpuPositions.contains(playerPositions)) {
				System.out.println("Position taken!");
				playerPos = scan.nextInt();
			}
			place(board, playerPos, "player");
			
			String result = win();
			if(result.length() > 0) {
				System.out.println(result);
				break;
			}
			
			Random random = new Random();
			int cpuPos = random.nextInt(9) + 1;
			while(cpuPositions.contains(cpuPos)|| playerPositions.contains(cpuPos)) {
				playerPos = scan.nextInt();
			}
			place(board, cpuPos, "cpu");
			
			print(board);
			
			result = win();
			if(result.length() > 0) {
				System.out.println(result);
				break;
			}
			
		}
		
	}
	
	//	print game board
	public static void print(char[][] board) {
		
		for (char[] row : board) {
			for (char col : row) {
				System.out.print(col);
			}
			System.out.println();
		}
		
	}
	
	//	placing moves
	public static void place(char[][] board, int pos, String user) {
		
		char symbol = ' ';
		
		if(user.equals("player")) {
			symbol = 'X';
			playerPositions.add(pos);
		} else if(user.equals("cpu")) {
			symbol = 'O';
			cpuPositions.add(pos);
		}
		
		switch(pos) {
			case 1:
				board[0][0] = symbol;
				break;
			case 2:
				board[0][2] = symbol;
				break;
			case 3:
				board[0][4] = symbol;
				break;
			case 4:
				board[2][0] = symbol;
				break;
			case 5:
				board[2][2] = symbol;
				break;
			case 6:
				board[2][4] = symbol;
				break;
			case 7:
				board[4][0] = symbol;
				break;
			case 8:
				board[4][2] = symbol;
				break;
			case 9:
				board[4][4] = symbol;
				break;
			default:
				break;
		}
		
	}
	
	//	winning conditions
	public static String win() {
		
		List topRow = Arrays.asList(1, 2, 3);
		List midRow = Arrays.asList(4, 5, 6);
		List botRow = Arrays.asList(7, 8, 9);
		List leftCol = Arrays.asList(1, 4, 7);
		List midCol = Arrays.asList(2, 5, 8);
		List rightCol = Arrays.asList(3, 6, 9);
		List leftDiag = Arrays.asList(3, 5, 7);
		List rightDiag = Arrays.asList(1, 5, 9);
		
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(leftDiag);
		winning.add(rightDiag);
		
		for(List l : winning) {
			if(playerPositions.containsAll(l)) {
				return "YOU WIN!";
			} else if(cpuPositions.containsAll(l)){
				return "YOU LOSE!";
			} else if(playerPositions.size() + cpuPositions.size() == 9) {
				return "DRAW!";
			}
		}
		
		return "";
		
	}
	
}
