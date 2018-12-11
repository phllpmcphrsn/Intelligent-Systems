package hw5;

//Tic-Tac-Toe
public class TestDriver {

	public static void main(String[] args) {
		Player max = new Player('X');
		Player min = new Player('O');
		Board board = new Board(max, min);		
		
		System.out.println("Welcome to the game of Tic-Tac-Toe!");
		Sysou
//		board.setBoard(1, 0, max);
//		board.setBoard(2, 1, max);
//		board.setBoard(0, 2, max);
//		board.setBoard(0, 1, min);
//		board.setBoard(1, 1, min);
//		board.setBoard(1, 2, min);

		board.printBoard();
		
		startGame(board, max);
	}
	
	/****************************************************************
	 * This method calls upon minimax to compute the best move to make 
	 * for Max. 
	 * @param game
	 * @param maxPlayer
	 */
	public static void startGame(Board game, Player maxPlayer) {
		int bestX = 0;
		int bestY = 0;
		int bestScore = -1000;
		int minimaxScore;
		char[][] board = game.getBoard();
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				
				if(board[i][j] == 0) {
					board[i][j] = maxPlayer.getPlayer();
					minimaxScore = game.minimax(board, 0, false);
					board[i][j] = 0; 

					if(minimaxScore > bestScore) {
						bestX = i;
						bestY = j;
						game.setBoard(bestX, bestY, game.getMax());
					}
				}
			}
		}
		System.out.printf("AI's best move is (%d,%d)\n", bestX, bestY);
	}
}
