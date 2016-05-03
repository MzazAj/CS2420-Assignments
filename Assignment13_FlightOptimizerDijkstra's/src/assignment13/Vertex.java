package assignment13;

import java.util.HashMap;

/**
 * 
 * The vertex class that represents an airport
 * 
 * @author Brian Rodriguez
 *
 */
public class Vertex implements Comparable<Vertex>
{
	private String airport;
	private boolean visited;
	private Vertex prev;
	private HashMap<String, Edge> flights;
	private FlightCriteria criteria;
	private double cost;
	private int delay;
	private double canceled;
	private double time;;
	private int distance;
	
	public Vertex(String airport)
	{
		this.airport = airport;
		cost = Double.MAX_VALUE;
		visited = false;
		this.prev = null;
		flights = new HashMap<String, Edge>();
		criteria = null;
		delay = Integer.MAX_VALUE;
		canceled = Double.MAX_VALUE;
		time = Double.MAX_VALUE;
		distance = Integer.MAX_VALUE;
	}
	/**
	 * Gets the Delay
	 * @return
	 */
	public int getDelay() 
	{
		return delay;
	}
	/**
	 * Sets the Delay
	 * @param delay
	 */
	public void setDelay(int delay) 
	{
		this.delay = delay;
	}
	/**
	 * Gets the Canceled
	 * @return
	 */
	public double getCanceled() 
	{
		return canceled;
	}
	/**
	 * Sets Canceled
	 * @param cancelled
	 */
	public void setCanceled(double cancelled) 
	{
		this.canceled = cancelled;
	}

	/**
	 * Gets the Time
	 * @return
	 */
	public double getTime() 
	{
		return time;
	}
	/**
	 * Sets the time
	 * @param time
	 */
	public void setTime(double time) 
	{
		this.time = time;
	}

	/**
	 * Gets the Distance
	 * @return
	 */
	public int getDistance() 
	{
		return distance;
	}
	
	/**
	 * Sets the Distance
	 * @param distance
	 */
	public void setDistance(int distance) 
	{
		this.distance = distance;
	}

	/**
	 * Gets the Criteria
	 * @return
	 */
	public FlightCriteria getCriteria() 
	{
		return criteria;
	}

	/**
	 * Adds an edge to this vertex
	 * @param flight
	 */
	public void addEdge(Edge flight)
	{
		flights.put(flight.getDestination(), flight);
	}
	
	/**
	 * Returns the flights of this vertex
	 * @return
	 */
	public HashMap<String, Edge> getFlights()
	{
		return flights;
	}
	
	/**
	 * Sets the criteria
	 * @param criteria
	 */
	public void setCriteria(FlightCriteria criteria)
	{
		this.criteria = criteria;
	}
	
	/**
	 * Gets the cost
	 * @return
	 */
	public double getCost()
	{
		return cost;
	}
	
	/**
	 * Sets the cost
	 * @param cost
	 */
	public void setCost(double cost)
	{
		this.cost = cost;
	}
	
	/**
	 * Sets the previous vertex
	 * @param vertex
	 */
	public void setPrev(Vertex vertex)
	{
		this.prev = vertex;
	}
	
	/**
	 * Gets the previous vertex
	 * @return
	 */
	public Vertex getPrevious()
	{
		return prev;
	}
	
	/**
	 * Gets the airport name
	 * @return
	 */
	public String getAirport()
	{
		return airport;
	}
	
	/**
	 * Gets the visited
	 */
	public boolean getVisted()
	{
		return visited;
	}
	
	/**
	 * Sets visited to a boolean
	 */
	public void setVisited(boolean bool)
	{
		visited = bool;
	}

	/**
	 * The comparable method used to insert
	 * Items in the priority queue using a switch statement based
	 * on criteria
	 */
	@Override
	public int compareTo(Vertex airport) 
	{
		switch(criteria)
		{
			case COST:
				if(this.cost > airport.getCost())
				{
					return 1;
				}
				else if(this.cost < airport.getCost())
				{
					return -1;
				}
				else
				{
					return 0;
				}
			case DISTANCE:
				if(this.getDistance() > airport.getDistance())
				{
					return 1;
				}
				else if(this.getDistance() < airport.getDistance())
				{
					return -1;
				}
				else
				{
					return 0;
				}
			case TIME:
				if(this.getTime() > airport.getTime())
				{
					return 1;
				}
				else if(this.getTime() < airport.getTime())
				{
					return -1;
				}
				else
				{
					return 0;
				}
			case DELAY:
				if(this.getDelay() > airport.getDelay())
				{
					return 1;
				}
				else if(this.getDelay() < airport.getDelay())
				{
					return -1;
				}
				else
				{
					return 0;
				}
			case CANCELED:
				if(this.getCanceled() > airport.getCanceled())
				{
					return 1;
				}
				else if(this.getCanceled() < airport.getCanceled())
				{
					return -1;
				}
				else
				{
					return 0;
				}
			default: 
				System.out.println("Not working");
				return 0;
		}
	}
	
}