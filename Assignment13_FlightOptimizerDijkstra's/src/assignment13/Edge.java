package assignment13;

import java.util.ArrayList;

/**
 * 
 * The edge class that represents the flights inside of a vertex
 * 
 * @author Brian Rodriguez
 *
 */
public class Edge 
{
	private String origin;
	private String destination;
	private String carrier;
	private int delay;
	private double canceled;
	private double time;
	private int distance;
	private double cost;
	private int count;
	private ArrayList<String> airlines;
	
	public Edge(String origin, String destination, String carrier, int delay, double canceled, double time, int distance, double cost)
	{
		this.origin = origin;
		this.destination = destination;
		this.carrier = carrier;
		this.delay = delay;
		this.canceled = canceled;
		this.time = time;
		this.distance = distance;
		this.cost = cost;
		count = 1;
		airlines = new ArrayList<String>();
		airlines.add(carrier);
	}
	
	/**
	 * Returns the airlines stored in this vertex
	 * @return
	 */
	public ArrayList<String> getAirlines()
	{
		return airlines;
	}
	
	/**
	 * Gets the origin of this edge
	 * @return
	 */
	public String getOrigin()
	{
		return origin;
	}
	
	/**
	 * Gets the destination of this edge
	 * @return
	 */
	public String getDestination()
	{
		return destination;
	}
	
	/**
	 * Gets the carrier of this edge
	 * @return
	 */
	public String getCarrier()
	{
		return carrier;
	}
	
	/**
	 * Gets the delay of this edge
	 * @return
	 */
	public int getDelay()
	{
		return delay;
	}
	
	/**
	 * Gets the canceled average of this edge
	 * @return
	 */
	public double getCanceled()
	{
		return canceled;
	}
	
	/**
	 * Gets the time of this edge
	 * @return
	 */
	public double getTime()
	{
		return time;
	}
	
	/**
	 * Gets the distance of this edge
	 * @return
	 */
	public int getDistance()
	{
		return distance;
	}
	
	/**
	 * Gets the cost of this edge
	 * @return
	 */
	public double getCost()
	{
		return cost;
	}
	
	/**
	 * Computes the average of all the variables of
	 *  this edge and a similar edge
	 * @param flight
	 */
	public void computeAvg(Edge flight)
	{
		//((avg * count) + data) / (count + 1)
		//count++
		
		this.delay = ((delay * count) + flight.getDelay()) / (count + 1);
		this.time = ((time * count) + flight.getTime()) / (count + 1);
		this.distance = ((distance * count) + flight.getDistance()) / (count + 1);
		this.cost = ((cost * count) + flight.getCost()) / (count + 1);
		this.canceled = ((canceled * count) + flight.getCanceled())/ (count + 1);
		this.count++;
		
		if(!airlines.contains(flight.getCarrier()))
		{			
			airlines.add(flight.getCarrier());
		}
	}
}
