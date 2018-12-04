package hw4;
/********************************************************
 * N-Queens
 * @author Phillip McPherson
 * CS-701: HW4
 */
public class NQueens {

	static char[][] grid;
	
	public static void main(String[] args) {
		
		//If plotting queens was a success, print off the grid
		if(plotQueens(create(4,4), 0)) {
			printGrid(grid);
		}
		else
			System.out.println("No solution found.");
	}

	/*********************************************
	 * Initialize grid
	 * @param row amount of rows to create grid with
	 * @param col amount of columns to create grid with
	 */
	public static char[][] create(int row, int col) {
		grid = new char [row] [col];
		
		for (int x = 0; x < row; x++) {
			for (int y = 0; y < col; y++) {
				grid[x][y] = '.';
			}
		}
		
		return grid;
	}
	
	/*********************************************
	 * Place queens onto grid with the constraint being they cannot.
	 * This is using an incremental formulation in which we start with an 
	 * empty grid (or state) and add queens per action. At each recursive
	 * pass we're checking the next column.
	 * attack each other.
	 * @param grid the given NxN array
	 */
	public static boolean plotQueens(char[][] grid, int col) {
		//base case
		if (col >= grid.length)
			return true;
		
		
		for (int i = 0; i < grid.length; i++) {
				if(QAbsent(grid, i, col)) {
					grid[i][col] = 'Q';
					
					if(plotQueens(grid, col+1))
						return true;
					else
						grid[i][col] = '.';
				}
		}
		
		return false;
	}
	
	/*********************************************
	 * Check if a Queen present. This will help to facilitate
	 * adding queens to the leftmost empty column w/o being
	 * attacked.
	 * @param arr given array of Q's and .
	 * @param row current row
	 * @param col current column
	 * @return true if there is no queen present (absent); otherwise return false (present)
	 */
	public static boolean QAbsent(char[][] arr, int row, int col) {
		
		//check from upper left diagonal
		for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if(arr[i][j] == 'Q')
				return false; 
		}
		
		//check from upper right diagonal
		for(int i = row, j = col; i <= row && j >= 0; i++, j--) {
			if(arr[i][j] == 'Q')
				return false;
		}
		
		//check each column
		for(int i = 0; i < col; i++) {
			if(arr[row][i] == 'Q')
				return false; 
		}
		
		//*Actually don't need to do this as we already iterate over the rows.
		//*The calling function (plotQueens) does this for us
		//check each row
//		for(int i = 0; i < row; i++) {
//			if(arr[i][col] == 'Q')
//				absent = false; 
//		}
		return true;	// there is no Queen present 
	}
	
	/*******************************************************
	 * Print a multidimensional array
	 * @param array the given multidimensional array
	 */
	public static void printGrid(char[][] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length; j++)
				System.out.print(array[i][j]);
			System.out.println();
		}
	}
}