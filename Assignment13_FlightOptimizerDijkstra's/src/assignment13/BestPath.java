/**
 * 
 */
package assignment13;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is what we will test your code on. If your BestPath
 * objects equal ours (using the .equals method given) then you will
 * pass the tests. Do no modify anything that is given (use it of
 * course but don't change names etc.)
 * 
 * @author CS2420 Teaching Staff - Spring 2016
 */
public class BestPath {
	
	/**
	 * This should contain the nodes between the origin and destination
	 * inclusive. For example if I want the path between SLC and MEM it
	 * should have SLC (index 0), MEM (index 1). If there are lay overs
	 * it should include them in between (turns out you can fly to Memphis
	 * from here directly).
	 */
	private ArrayList<String> path;
	
	/**
	 * Since some path costs are going to be doubles sometimes use a double
	 * when costs are integers cast to a double.
	 */
	private double pathLength;
	
	private FlightCriteria criteria;
		
	public BestPath()
	{
		path = new ArrayList<>();
		pathLength = 0;
		criteria = null;
	}
	
	/**
	 * Sets the criteria for this path
	 * @param criteria
	 */
	public void setCriteria(FlightCriteria criteria)
	{
		this.criteria = criteria;
	}
	
	/**
	 * Adds to the arraylist using a vertex
	 * @param route
	 */
	public void addVertex(Vertex route)
	{
		path.add(route.getAirport());
		
	}
	
	/**
	 * Sets the path length by getting using the criteria
	 * and getting the value from the vertex. Also reverses the
	 * path so it is in correct order
	 * @param route
	 */
	public void setPathLength(Vertex route)
	{
		Collections.reverse(path);
		switch(criteria)
		{
		case COST:
			pathLength = route.getCost();
			break;
		case DISTANCE:
			pathLength = route.getDistance();
			break;
		case DELAY:
			pathLength = route.getDelay();
			break;
		case TIME:
			pathLength = route.getTime();
			break;
		case CANCELED:
			pathLength = route.getCanceled();
			break;
		}
	}
	
	/**
	 * Method for setting path length using a double.
	 * For testing purposes
	 * @param pathLength
	 */
	public void setPathLength(double pathLength)
	{
		this.pathLength = pathLength;
	}
	
	/**
	 * Adds a string to the path.
	 * For testing purposes
	 * @param route
	 */
	public void addString(String route)
	{
		path.add(route);
	}
	
	/**
	 * Gets the best path
	 * @return
	 */
	public ArrayList<String> getPath()
	{
		return this.path;
	}
	
	/**
	 * gets the path length
	 * @return
	 */
	public double getPathLength()
	{
		return pathLength;
	}

	/**
	 * Returns a boolean if the object passed in is a 
	 * BestPath object and they both equal eachother
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof BestPath) {
			BestPath other = (BestPath) o;
			return this.pathLength == other.pathLength && this.path.equals(other.path);
		}
		return false;
	}
	
	/**
	 * Prints out the path length and the path of this
	 * BestPath
	 */
	@Override
	public String toString() {
		return "Path Length: " + pathLength + "\nPath: "+ this.path;
	}
}