package hw5;
/******************************************************************
 * The core class of this Tic-Tac-Toe program. It creates the game board and 
 * computes the best move the AI (Max) player to make. This is done 
 * using the minimax algorithm. 
 * @author phllp
 *
 *******************************************************************/
public class Board {
	private char[][] board;
	static Player max;
	static Player min;
	
	public Board() {
		init();
	}
	
	public Board(Player max, Player min) {
		this();
		this.max = max;
		this.min = min;
	}
	
	public void init() {
		board = new char[3][3];
	}

	/**************************************************************
	 * Recursive method to compute minimax value for the best move
	 * to make. The terminating statement compares the current board
	 * against the terminal states.
	 * @param grid
	 * @param depth
	 * @param isMax
	 * @return best score to be used for making the best move
	 */
	public int minimax(char[][] grid, int depth, boolean isMax) {
		if (terminalState(grid))
			return score(grid, depth);
		//Max turn
		if(isMax) {
			int bestScore = Integer.MIN_VALUE;      

			for(int i = 0; i < grid.length; i++) {
				for(int j = 0; j < grid.length; j++) {
					if(grid[i][j] == 0) {
						grid[i][j] = max.getPlayer();
						bestScore = Integer.max(bestScore, minimax(grid, depth+1, false));
						grid[i][j] = 0;
					}
				}
			}
			return bestScore;
		}
		
		//Min Turn
		else {
			int bestScore = Integer.MAX_VALUE; 

			for(int i = 0; i < grid.length; i++) {
				for(int j = 0; j < grid.length; j++) {
					if(grid[i][j] == 0) {
						grid[i][j] = min.getPlayer();
						bestScore = Integer.min(bestScore, minimax(grid, depth+1, true)); 
						grid[i][j] = 0;
					}
				}
			}
			return bestScore;
		}
	}

	/**********************************************************************
	 * Check for terminal state
	 * @param grid
	 * @return
	 */
	private boolean terminalState(char[][] grid) {
		if(!movesAvailable(grid))
			return true;
		return (hasPlayerWon(grid, max)||hasPlayerWon(grid, min));
	}

	/**********************************************************************
	 * Checks to rows, columns, and diagonals to see if a player has won
	 * @param grid
	 * @param p
	 * @return 
	 */
	private static boolean hasPlayerWon(char[][] grid, Player p) {
		char player = p.getPlayer();
		int size = grid.length;

		//check each row
		for(int row = 0; row < size; row++) {
			if( ( grid[row][0] == player) && ( grid[row][1] == player ) && ( grid[row][2] == player ) )
				return true;
		}
		
		//check each column
		for(int col = 0; col < size; col++) {
			if( ( grid[0][col] == player ) && ( grid[1][col] == player ) && ( grid[2][col] == player ))
				return true;
		}
		
		//check from upper left diagonal
		if( ( grid[0][0] == player ) && ( grid[1][1] == player ) && ( grid[2][2] == player ) )
			return true;
		
		//check from upper right diagonal
		if( ( grid[0][2] == player ) && ( grid[1][1] == player ) && ( grid[2][0] == player ) )
			return true;		
		
		return false;
	}
	
	/***********************************************************************
	 * Returns the score of the winning player. In order to reach the most optimal
	 * score we must also factor in the depth. This way the AI can win by choosing 
	 * the move(s) that will breed the fastest win.
	 * @param grid
	 * @param depth 
	 * @return score of corresponding player or 0 for a tie game
	 */
	private int score(char grid[][], int depth) {
		if(hasPlayerWon(grid, max)) {
			return 10 - depth;
		}
		
		else if(hasPlayerWon(grid, min)) {
			return -10 + depth;
		}
		
		return 0; //TIE 
	}
	
	private boolean movesAvailable(char[][] grid){
		boolean movesAvailable = false;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid.length; j++) {
				if(grid[i][j] == 0)
					movesAvailable  = true;
			}
		}
		return movesAvailable;
	}
	
	
	public void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j] == ' ')
					System.out.print(' ' + " | ");
				else
					System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			
			if(i < board.length - 1) //properly formats game board
				System.out.println("------------");
		}
		System.out.println();
	}
	

	public Player getMax() {
		return max;
	}
	
	//testing purposes
	public void setBoard(int x, int y, Player player) {
		board[x][y] = player.getPlayer();
	}
	
	public char[][] getBoard() {
		return board;
	}

}
