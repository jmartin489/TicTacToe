package tttascii;
import java.util.Scanner;

public class TTTLogic 
{
	private String[][] board =  {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
	private int position;
	private int turnCount = 0;
	
	Scanner keyboard = new Scanner(System.in);
	
	public void displayBoard()
	{
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0;  j < board[i].length; j++)
			{
				System.out.print(board[i][j] + "\t");
			}
			
			System.out.println();
		}
	}
	
	public boolean gameOver()
	{
		return playerXWin() || playerOWin() || tieGame();
	}
	
	public boolean boardFull()
	{
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				if(board[i][j] != "X" && board[i][j] != "O")
					return false;
		
		return true;
	}
	
	public boolean tieGame() 
	{
		if(boardFull() && !playerXWin() && !playerOWin())
			return true;		
	
		return false;
	}
	public boolean playerOWin() 
	{
		if(board[0][0] == "O" && board[0][1] == "O" && board[0][2] == "O")
			return true;
		else if(board[0][0] == "O" && board[1][0] == "O" && board[2][0] == "O")
			return true;
		else if(board[0][0] == "O" && board[1][1] == "O" && board[2][2] == "O")
			return true;
		else if(board[0][1] == "O" && board[1][1] == "O" && board[2][1] == "O")
			return true;
		else if(board[0][2] == "O" && board[1][2] == "O" && board[2][2] == "O")
			return true;
		else if(board[2][0] == "O" && board[1][1] == "O" && board[0][2] == "O")
			return true;
		else if(board[2][0] == "O" && board[2][1] == "O" && board[2][2] == "O")
			return true;
		else
			return false;
	}
	
	public boolean playerXWin() 
	{
		if(board[0][0] == "X" && board[0][1] == "X" && board[0][2] == "X")
			return true;
		else if(board[0][0] == "X" && board[1][0] == "X" && board[2][0] == "X")
			return true;
		else if(board[0][0] == "X" && board[1][1] == "X" && board[2][2] == "X")
			return true;
		else if(board[0][1] == "X" && board[1][1] == "X" && board[2][1] == "X")
			return true;
		else if(board[0][2] == "X" && board[1][2] == "X" && board[2][2] == "X")
			return true;
		else if(board[2][0] == "X" && board[1][1] == "X" && board[0][2] == "X")
			return true;
		else if(board[2][0] == "X" && board[2][1] == "X" && board[2][2] == "X")
			return true;
		else
			return false;
	}
	
	public void placeX(int x)
	{
		if(x == 1 && !board[0][0].equals("X") && !board[0][0].equals("O"))
			board[0][0] = "X";
		else if(x == 2 && !board[0][1].equals("X") && !board[0][1].equals("O"))
			board[0][1] = "X";
		else if(x == 3 && !board[0][2].equals("X") && !board[0][2].equals("O"))
			board[0][2] = "X";
		else if(x == 4 && !board[1][0].equals("X") && !board[1][0].equals("O"))
			board[1][0] = "X";
		else if(x == 5 && !board[1][1].equals("X") && !board[1][1].equals("O"))
			board[1][1] = "X";
		else if(x == 6 && !board[1][2].equals("X") && !board[1][2].equals("O"))
			board[1][2] = "X";
		else if(x == 7 && !board[2][0].equals("X") && !board[2][0].equals("O"))
			board[2][0] = "X";
		else if(x == 8 && !board[2][1].equals("X") && !board[2][1].equals("O"))
			board[2][1] = "X";
		else if(x == 9 && !board[2][2].equals("X") && !board[2][2].equals("O"))
			board[2][2] = "X";
		else
		{
			System.out.println("Space taken or invalid input!");
			turnCount--;
		}
	}
	
	public void placeO(int x)
	{
		if(x == 1 && !board[0][0].equals("X") && !board[0][0].equals("O"))
			board[0][0] = "O";
		else if(x == 2 && !board[0][1].equals("X") && !board[0][1].equals("O"))
			board[0][1] = "O";
		else if(x == 3 && !board[0][2].equals("X") && !board[0][2].equals("O"))
			board[0][2] = "O";
		else if(x == 4 && !board[1][0].equals("X") && !board[1][0].equals("O"))
			board[1][0] = "O";
		else if(x == 5 && !board[1][1].equals("X") && !board[1][1].equals("O"))
			board[1][1] = "O";
		else if(x == 6 && !board[1][2].equals("X") && !board[1][2].equals("O"))
			board[1][2] = "O";
		else if(x == 7 && !board[2][0].equals("X") && !board[2][0].equals("O"))
			board[2][0] = "O";
		else if(x == 8 && !board[2][1].equals("X") && !board[2][1].equals("O"))
			board[2][1] = "O";
		else if(x == 9 && !board[2][2].equals("X") && !board[2][2].equals("O"))
			board[2][2] = "O";
		else
		{
			System.out.println("Space taken or invalid input!");
			turnCount--;
		}
	}
	
	public void start()
	{	
		displayBoard();
		while(!gameOver())
		{
			if(turnCount % 2 == 0)
				playerXSequence();
			else
				playerOSequence();
			
			if(playerXWin())
				System.out.println("Player X wins!");
			else if(playerOWin())
				System.out.println("Player O wins!");
			else if(tieGame())
			{
				System.out.println("It's a draw!");
			}
			displayBoard();
			
			turnCount++;
		}
	}

	public void playerOSequence() 
	{
		System.out.println("Player O's turn");
		System.out.println("Enter the position (1-9)");
		
		position = keyboard.nextInt();
		placeO(position);
	}

	public void playerXSequence() 
	{
		System.out.println("Player X's turn");
		System.out.println("Enter position (1-9)");
		
		position = keyboard.nextInt();
		placeX(position);
	}
}
