package hw3;
/*******************************************************
 * This program is based upon the graph submitted as 
 * part of this homework
 * 
 * @author Philiip McPherson
 * CS-701
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;


public class A_star {

	static ArrayList<Edge> edges = new ArrayList<Edge>();
	
	public static void main(String[] args) {
		Node aNode = new Node('A');
		Node bNode = new Node('B');
		Node cNode = new Node('C');
		Node dNode = new Node('D');
		Node eNode = new Node('E');
		Node fNode = new Node('F', true);	//Goal node
		Node gNode = new Node('G');
		Node hNode = new Node('H');
		Node iNode = new Node('I');
		Node jNode = new Node('J');
		
		aNode.setNeighbors(bNode);
		aNode.setNeighbors(cNode);
		bNode.setNeighbors(aNode);
		bNode.setNeighbors(dNode);
		bNode.setNeighbors(eNode);
		cNode.setNeighbors(dNode);
		cNode.setNeighbors(gNode);
		dNode.setNeighbors(bNode);
		dNode.setNeighbors(cNode);
		dNode.setNeighbors(eNode);
		dNode.setNeighbors(iNode);
		dNode.setNeighbors(gNode);
		eNode.setNeighbors(bNode);
		eNode.setNeighbors(dNode);
		fNode.setNeighbors(gNode);
		gNode.setNeighbors(cNode);
		gNode.setNeighbors(dNode);
		gNode.setNeighbors(fNode);
		gNode.setNeighbors(hNode);
		hNode.setNeighbors(gNode);
		iNode.setNeighbors(dNode);
		iNode.setNeighbors(jNode);
		jNode.setNeighbors(iNode);
		
		//Not sure if I'll get the proper use out of Edge
		Edge e1 = new Edge (aNode, bNode, 3);
		Edge e2 = new Edge (aNode, cNode, 1);
		Edge e3 = new Edge (bNode, dNode, 8);
		Edge e4 = new Edge (bNode, eNode, 11);
		Edge e5 = new Edge (cNode, dNode, 5);
		Edge e6 = new Edge (cNode, gNode, 8);
		Edge e7 = new Edge (dNode, eNode, 23);
		Edge e8 = new Edge (dNode, gNode, 2);
		Edge e9 = new Edge (dNode, iNode, 10);
		Edge e10 = new Edge (gNode, fNode, 3);
		Edge e11 = new Edge (gNode, hNode, 20);
		Edge e12 = new Edge (iNode, jNode, 17);
		
		edges.add(e1);
		edges.add(e2);
		edges.add(e3);
		edges.add(e4);
		edges.add(e5);
		edges.add(e6);
		edges.add(e7);
		edges.add(e8);
		edges.add(e9);
		edges.add(e10);
		edges.add(e11);
		edges.add(e12);
		
		BFS(aNode);
		A(aNode,fNode);

	}
	
	public static boolean BFS(Node start) {
		Queue<Node> frontier = new LinkedList<Node>();   //essentially the searched/discovered neighbors 
		start.setVisited();
		Set<Node> explored = new HashSet<Node>();	//where each visited neighbor will be stored
		frontier.add(start);
		
		//if frontier is not empty, proceed with search
		while(!frontier.isEmpty()) {
			Node node = frontier.remove();
			explored.add(node);
			
			List<Node> childNodes = node.getNeighbor();		//create a list of child nodes (or neighbors)
			System.out.println(node.getNode() +" ");
			
			for (Node child : childNodes) {
				if( !(explored.contains(child) || frontier.contains(child)) ){
					if(child.isGoal()) {
						System.out.println(child.getNode() + " -- Reached the goal!");
						return true;
					}
					
					frontier.add(child);
					explored.add(child);
					child.setVisited();
				}
			}
		}
		return false;
		
	}
	
	
	/*********************************************************/
	/*********************************************************/
	
	/*****************************************************************
	 * A* implementation
	 * @param start start node
	 * @param goal end node
	 */
	public static void A(Node start, Node goal) {
		Queue<Node> frontier = new LinkedList<Node>();   
		Set<Node> explored = new HashSet<Node>();
		Map<Node, Integer> totalCost = new HashMap<Node, Integer>(); //will hold cost associated with each node
		Node currNode = null;
		int cost = 0;
		
		frontier.add(start);
		totalCost.put(start, cost);
		start.setVisited();
		
		while(!frontier.isEmpty()) {
			currNode = frontier.remove();
			explored.add(currNode);
			
			if (currNode == goal) {
				System.out.println(currNode.getNode());
				break;
			}

			List<Node> childNodes = currNode.getNeighbor();
			System.out.println(currNode.getNode() +" ");
			
			for (Node child : childNodes) {  
				cost += getDistance(currNode, child);
				
				if( !(explored.contains(child) || frontier.contains(child)) ){
					totalCost.put(child, cost);					
					frontier.add(child);
					explored.add(child);
					child.setVisited();
				}
			}
		}
		
	}
	
	//Heuristic function
    public static int getDistance(Node start, Node goal) {
        for (Edge edge : edges) {
            if (edge.getSource().equals(start) && edge.getDestination().equals(goal))
                return edge.getCost();
        }
        return 0;
    }
}
