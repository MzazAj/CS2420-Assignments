package assignment09;

import java.util.LinkedList;

	/**
	 * Node class to add elements to the Graph
	 *
	 * @author Brian Rodriguez and Michael Kim
	 * @param <E>
	 */
	public class Node 
	{
		String item;
		LinkedList<Node> neighbors;
		boolean visited;
		Node cameFrom;
		
		//Constructor for our node
		public Node(String item)
		{
			neighbors = new LinkedList<>();
			this.item = item;
			visited = false;
			cameFrom = null;
		}
	}