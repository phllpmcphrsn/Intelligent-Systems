package hw3;

public class Edge {
	private final Node source, destination;
	private final int cost;
	

	public Edge(Node source, Node destination, int cost) {
		this.source = source;
		this.destination = destination;
		this.cost = cost;
	}

	public Node getSource() {
		return source;
	}

	public Node getDestination() {
		return destination;
	}

	public int getCost() {
		return cost;
	}
	
	public String connection() {
		return source + " connects to " + destination;
	}
}
