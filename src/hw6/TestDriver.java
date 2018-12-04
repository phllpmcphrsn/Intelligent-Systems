package hw6;
import java.util.ArrayList;
import java.util.List;

import hw3.Node;

public class TestDriver {
	public static List<Node> terminalNodes;
	
	public static void main(String[] args) {
		Node aNode = new Node('A');
		Node bNode = new Node('B', 3);
		Node cNode = new Node('C', 2);
		Node dNode = new Node('D', 2);
		Node eNode = new Node('E', 3);
		Node fNode = new Node('F', 12);	
		Node gNode = new Node('G', 8);
		Node hNode = new Node('H', 2);
		Node iNode = new Node('I', 4);
		Node jNode = new Node('J', 6);
		Node kNode = new Node('K', 14);
		Node lNode = new Node('L', 5);
		Node mNode = new Node('M', 2);
		
		aNode.setChildren(bNode);
		aNode.setChildren(cNode);
		aNode.setChildren(dNode);
		bNode.setChildren(eNode);
		bNode.setChildren(fNode);
		bNode.setChildren(gNode);
		cNode.setChildren(hNode);
		cNode.setChildren(iNode);
		cNode.setChildren(jNode);
		dNode.setChildren(kNode);
		dNode.setChildren(lNode);
		dNode.setChildren(mNode);
		
		terminalNodes = new ArrayList<Node>();
		terminalNodes.add(eNode);
		terminalNodes.add(fNode);
		terminalNodes.add(gNode);
		terminalNodes.add(hNode);
		terminalNodes.add(iNode);
		terminalNodes.add(jNode);
		terminalNodes.add(kNode);
		terminalNodes.add(lNode);
		terminalNodes.add(mNode);
		
		List<Node> graph = new ArrayList<Node>();
		graph.add(aNode);
		graph.add(bNode);
		graph.add(cNode);
		graph.add(dNode);
		graph.add(eNode);
		graph.add(fNode);
		graph.add(gNode);
		graph.add(hNode);
		graph.add(iNode);
		graph.add(jNode);
		graph.add(kNode);
		graph.add(lNode);
		graph.add(mNode);
		
		char maxPlayer = 'X';
		char minPlayer = 'Y';
		minimax(graph, aNode.getDepth(), maxPlayer);
//		aNode.print();
		System.out.println(aNode.getDepth());
//		for(Node n : aNode.getChildren()) {
//			System.out.println(n.getNode() + " ");
//		}
		
	}

	public static int minimax(List<Node> graph, int depth, char player) {
		Node currNode = graph.get(0);
		double optimalValue, value;
		
		if(terminalTest(currNode))
			return currNode.getUtility();
		
		if(player == 'X') {
			optimalValue = Double.NEGATIVE_INFINITY;
			
			for(Node n : move(currNode)) {
				value = minimax(graph, depth+1, 'O');
				optimalValue = 
		}
		return 0;
	}
	
	private static boolean terminalTest(Node currNode) {
		if(terminalNodes.contains(currNode))
			return true;
		return false;
	}

	//Return list of possible moves
	public static List<Node> move(Node currNode) {
		List<Node> possibleMoves = currNode.getChildren();
		return possibleMoves;
	}
}
