package assignment09;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Brian Rodriguez and Michael Kim
 *
 * Creates the graph for our PathFinder Class
 */
public class Graph 
{	
	Node[][] nodeArray;
	
	int height;
	
	int width;
	
	/**
	 * Create the graph with the input height and width
	 * @param height
	 * @param width
	 */
	public Graph(int height, int width)
	{
		this.height = height;
		this.width = width;
		nodeArray = new Node[height][width];
	}
	
	/**
	 * Performs a Breadth-first-search on the start node and goal node.
	 * @param start
	 * @param goal
	 */
	public void bfs(Node start, Node goal)
	{
		//Create a Queue
		Queue<Node> queue = new LinkedList<Node>();
		//set current node = start
		Node current = start;
		//add the current to queue
		queue.add(current);
		//set it to visited
		current.visited = true;
		//while queue is not empty perform the actions
		while(!queue.isEmpty())
		{
			//remove the first item in the queue set it to current
			current = queue.remove();
			//if current equals our goal then break
			if(current.equals(goal))
			{
				break;
			}
			//for each neighbor of current's neighbors
			for(Node neighbor: current.neighbors)
			{
				//if the neighbor has been visited or it equals out of bounds or it is a wall then do nothing
				if(neighbor.visited || neighbor.item.equals("ob") || neighbor.item.equals("X"))
				{
					
				}
				// else set neighbor to visited, set neighbors came from to current node and add neighbor to the queue
				else
				{
					neighbor.visited = true;
					neighbor.cameFrom = current;
					queue.add(neighbor);
				}
			}
		}
		//if the current is not equal to goal then there is no solution
		if(!current.equals(goal))
		{
			return;
		}
		//else reconstruct the path to the start from goal
		else
		{
			//start at goal while node is not null then node = node.cameFrom
			for(Node node = goal; node != null; node = node.cameFrom)
			{
				//if the item equals G or S then do nothing
				if(node.item.equals("G") || node.item.equals("S"))
				{
					
				}
				//else set the item equal to .
				else
				{
					node.item = ".";
				}
			}
			
			return;
		}
	}
	
	/**
	 * Adds the input node to the graph
	 * @param verticie
	 */
	public void addVerticie(Node verticie)
	{		
		//two for loops to traverse through the nodeArray
		for(int j = 0; j < height;j++)
		{
			for(int k = 0; k < width;k++)
			{
				//if the item at indices j and k is null then set the
				//item = to verticie
				if(nodeArray[j][k] == null)
				{
					nodeArray[j][k] = verticie;
					return;
				}
				//else keep looking for a null item
				else
				{
					
				}
			}
		}
	}

	/**
	 * Adds the input nodes neighbors in relation to the given height index and width index
	 * @param verticie
	 * @param heightIdx
	 * @param widthIdx
	 */
	public void addNeighbors(Node verticie, int heightIdx, int widthIdx) 
	{
		//for each of these adds try to add verticie's neighbors if there is an exception
		//then set the neighbor = ob = Out of Bounds. So it does not add the neightbor to the queue
		//later
		try
		{
			verticie.neighbors.add(nodeArray[heightIdx+1][widthIdx]);
		}
		catch(Exception e)
		{
			verticie.neighbors.add(new Node("ob"));
		}
		
		try
		{
			verticie.neighbors.add(nodeArray[heightIdx-1][widthIdx]);
		}
		catch(Exception e)
		{
			verticie.neighbors.add(new Node("ob"));
		}
		
		try
		{
			verticie.neighbors.add(nodeArray[heightIdx][widthIdx+1]);
		}
		catch(Exception e)
		{			
			verticie.neighbors.add(new Node("ob"));
		}
		
		try
		{
			verticie.neighbors.add(nodeArray[heightIdx][widthIdx-1]);
		}
		catch(Exception e)
		{
			verticie.neighbors.add(new Node("ob"));
		}
	}
		
}
