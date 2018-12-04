package hw2;

public class Agent {
	static String[][] rooms = 
		{
			{"A", "Dirty"},
			{"B", "Dirty"}
		};
	static int location = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		vacuum(rooms);
		System.out.println(rooms[0][0] + " "+ rooms[0][1]);
	}
	
	public static void vacuum(String[][] room_table) {
		boolean read = true;
		/**
		 * This will run forever, of course, but the first three loops
		 * demonstrates the behavior desired. The vacuum is essentially 
		 * polling for a dirty location by moving back and forth between
		 * A and B. 
		 */
		do {
			if (room_table[location][1] == "Dirty") {
				suck();
			}
			else if (room_table[location][0] == "A") {
				move();
			}
			else if (room_table[location][0] == "B") {
				move();
			}
		}while(read);
	}
	
	public static void suck() {
		System.out.println("Cleaned room " + rooms[location][0]);
		rooms[location][1] = "Clean";
	}
	
	public static void move() {
		System.out.println("Moving to next location");
		location = (location + 1) % 2;
	}
}
