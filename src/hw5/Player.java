package hw5;

public class Player {
	private char player; 	

	public Player(char value) {
		this.player = value;
	}

	public char getPlayer() {
		return player;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Player other = (Player) obj;
		if (player != other.player) {
			return false;
		}
		return true;
	}
}
