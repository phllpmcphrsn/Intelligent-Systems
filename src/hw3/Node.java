package hw3;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
		private char letter;			
		private List<Node> neighbors, children;
		private boolean visited = false;
		private boolean goal = false;
		private int value;
		private static int count = 0;

		
		public Node(char letter)
		{
			this.letter = letter;
			neighbors = new ArrayList<Node>();
			children = new ArrayList<Node>();
			count++;
		}

		public Node(char letter, int utility){
			this(letter);
			value = utility;
		}
		
//		Used for searching algorithms that require a designated goal Node
//		public Node(char letter, boolean goal){
//			this(letter);
//			this.goal = goal;
//		}

		public char getNode()
		{
			return letter;
		}
		public void setNode(char letter)
		{
			this.letter = letter;
		}
		public void setNeighbors(Node node) {
			neighbors.add(node);
		}
		
		public void setChildren(Node node) {
			children.add(node);
		}

		public void setVisited() {
			this.visited = true;
		}
		
		public List<Node> getChildren() {
			return children;
		}
		
		public List<Node> getNeighbor() {
			return neighbors;
		}
		public boolean isGoal() {
			return (goal == true) ? true : false;
		}
		
		public int getDepth() {
			return count;
		}
		public void print() {
			print("", true);
		}
		
	    private void print(String prefix, boolean isTail) {
	        System.out.println(prefix + (isTail ? "+── " : "|── ") + letter);
	        for (int i = 0; i < children.size() - 1; i++) {
	            children.get(i).print(prefix + (isTail ? "    " : "|   "), false);
	        }
	        if (children.size() > 0) {
	            children.get(children.size() - 1)
	                    .print(prefix + (isTail ?"    " : "|   "), true);
	        }
	    }

		public int getUtility() {
			return value;
		}
}
