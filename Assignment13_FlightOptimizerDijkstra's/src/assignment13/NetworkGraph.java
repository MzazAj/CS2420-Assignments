/**
 * 
 */
package assignment13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * <p>This class represents a graph of flights and airports along with specific
 * data about those flights. It is recommended to create an airport class and a
 * flight class to represent nodes and edges respectively. There are other ways
 * to accomplish this and you are free to explore those.</p>
 * 
 * <p>Testing will be done with different criteria for the "best" path so be
 * sure to keep all information from the given file. Also, before implementing
 * this class (or any other) draw a diagram of how each class will work in
 * relation to the others. Creating such a diagram will help avoid headache and
 * confusion later.</p>
 * 
 * <p>Be aware also that you are free to add any member variables or methods
 * needed to completed the task at hand</p>
 * 
 * @author CS2420 Teaching Staff - Spring 2016
 */
public class NetworkGraph {
	
	HashMap<String, Vertex> airports;
	
	/**
	 * <p>Constructs a NetworkGraph object and populates it with the information
	 * contained in the given file. See the sample files or a randomly generated
	 * one for the proper file format.</p>
	 * 
	 * <p>You will notice that in the given files there are duplicate flights with
	 * some differing information. That information should be averaged and stored
	 * properly. For example some times flights are canceled and that is
	 * represented with a 1 if it is and a 0 if it is not. When several of the same
	 * flights are reported totals should be added up and then reported as an
	 * average or a probability (value between 0-1 inclusive).</p>
	 * 
	 * @param flightInfoPath - The path to the file containing flight data. This
	 * should be a *.csv(comma separated value) file
	 * 
	 * @throws FileNotFoundException The only exception that can be thrown in
	 * this assignment and only if a file is not found.
	 */
	public NetworkGraph(String flightInfoPath) throws FileNotFoundException 
	{	
		//creates the airports
		airports = new HashMap<String, Vertex>();
		//creates the file from flightInfoPath
		File flightFile = new File(flightInfoPath);
		//Creates a file reader from the file
		FileReader flightFileReader = new FileReader(flightFile);
		//creates a buffered reader from the file reader
		BufferedReader fileBufferedReader = new BufferedReader(flightFileReader);
		//creates a scanner from the buffered reader
		Scanner scanner = new Scanner(fileBufferedReader);
		//sets the scanners delimiter
		scanner.useDelimiter("[,\n]");
		//skips the first line of input since it is not parseable
		//to to numbered values
		scanner.nextLine();
		//While scanner has next line
		while(scanner.hasNextLine())
		{
			//Initializes the essential variables for the edges
			//and vertices
			String ori = scanner.next();
			String dest = scanner.next();
			String carrier = scanner.next();
			int delay = scanner.nextInt();
			int canceled = scanner.nextInt();
			double time = scanner.nextInt();
			int distance = scanner.nextInt();
			double cost = scanner.nextDouble();
			
			//If either of the numbered variables are less than 0 then skip this line
			if(cost >= 0 && distance >= 0 && time >=0 && canceled >= 0 && delay >= 0)
			{
				//creates a new vertex and edge
				Vertex origin = new Vertex(ori);
							
				Edge flight = new Edge(ori, dest, carrier, delay, canceled, time, distance, cost);
				//if airports contains the origin then see if the airport
				//contains the flight and if it does compute the average
				//else add the edge to the airport
				if(airports.containsKey(ori))
				{
					Vertex airport = airports.get(ori);
					
					if(airport.getFlights().containsKey(dest))
					{
						airport.getFlights().get(dest).computeAvg(flight);
					}
					else
					{
						airport.addEdge(flight);
					}
				}
				//else add the airport to the hashmap and
				// add the edge
				else
				{
					airports.put(ori, origin);
					airports.get(ori).addEdge(flight);
				}
			}
			//so it doesnt throw a null pointer
			if(scanner.hasNextLine())
			{
				scanner.nextLine();				
			}
		}
		scanner.close();
	}

	/**
	 * This method returns a BestPath object containing information about the best
	 * way to fly to the destination from the origin. "Best" is defined by the
	 * FlightCriteria parameter <code>enum</code>. This method should throw no
	 * exceptions and simply return a BestPath object with information dictating
	 * the result. For example, if a destination or origin is not contained in
	 * this instance of NetworkGraph simply return a BestPath with no path (not a
	 * <code>null</code> path). If origin or destination are <code>null</code>
	 * return a BestPath object with null as origin or destination (which ever is
	 * <code>null</code>.
	 * 
	 * @param origin - The starting location to find a path from. This should be a
	 * 3 character long string denoting an airport.
	 * 
	 * @param destination - The destination location from the starting airport.
	 * Again, this should be a 3 character long string denoting an airport.
	 * 
	 * @param criteria - This enum dictates the definition of "best". Based on this
	 * value a path should be generated and return.
	 * 
	 * @return - An object containing path information including origin, destination,
	 * and everything in between.
	 */
	public BestPath getBestPath(String origin, String destination, FlightCriteria criteria) 
	{	
		//Creates new BestPath object
		BestPath bestPath = new BestPath();
		//If either the origin, destination are null then add either of them
		//to the best path and return the best path
		if(origin == null || destination == null)
		{
			if(origin == null)
			{
				bestPath.addString(null);
			}
			else
			{
				bestPath.addString(origin);
			}
			
			if(destination == null)
			{
				bestPath.addString(null);
			}
			else
			{
				bestPath.addString(destination);
			}
			return bestPath;
		}
		else if(!airports.containsKey(origin) || !airports.containsKey(destination))
		{
			if(!airports.containsKey(origin))
			{
				return bestPath;
			}
			else
			{
				bestPath.addString(origin);
				return bestPath;
			}
		}
		
		
		return Dijkstra(origin, destination, criteria, null);
	}
	
	/**
	 * Dijkstra's algorithm for each case of criteria
	 * Calculates the best path depending on the criteria
	 * @param <criteria>
	 * @param origin
	 * @param destination
	 * @param criteria
	 * @return A best path object
	 */
	private BestPath Dijkstra(String origin, String destination, FlightCriteria criteria, String airline) 
	{
		//set best path = null
		BestPath bestPath = null;
		//for each criteria and if the airline is null or not
		//do dijkstra's for each criteria
		switch(criteria)
		{
			case COST:
				if(airline == null)
				{
					bestPath = dijkstraCost(origin, destination, criteria, null);					
				}
				else
				{
					bestPath = dijkstraCost(origin, destination, criteria, airline);
				}
				break;
			case DISTANCE:
				if(airline == null)
				{
					bestPath = dijkstraDistance(origin, destination, criteria, null);					
				}
				else
					bestPath = dijkstraDistance(origin, destination, criteria, airline);
				break;
			case DELAY:
				if(airline == null)
				{
					bestPath = dijkstraDelay(origin, destination, criteria, null);					
				}
				else
				{
					bestPath = dijkstraDelay(origin, destination, criteria, airline);
				}
				break;
			case TIME:
				if(airline == null)
				{
					bestPath = dijkstraTime(origin, destination, criteria, null);					
				}
				else
				{
					bestPath = dijkstraTime(origin, destination, criteria, airline);
				}
				break;
			case CANCELED:
				if(airline == null)
				{
					bestPath = dijkstraCanceled(origin, destination, criteria, null);
				}
				else
				{
					bestPath = dijkstraCanceled(origin, destination, criteria, airline);
				}
				break;
		}
		//reset all the values of every airport
		for(Vertex vertex: airports.values())
		{
			vertex.setVisited(false);
			vertex.setPrev(null);
			vertex.setCanceled(Double.MAX_VALUE);
			vertex.setCost(Double.MAX_VALUE);
			vertex.setDelay(Integer.MAX_VALUE);
			vertex.setDistance(Integer.MAX_VALUE);
			vertex.setTime(Integer.MAX_VALUE);
			vertex.setCriteria(null);
		}
		
		return bestPath;
	}
		
	/**
	 * Performs Dijkstra's algorithm using Cost as the measure
	 * @param origin
	 * @param destination
	 * @param criteria
	 * @param airline
	 * @return
	 */
	private BestPath dijkstraCost(String origin, String destination, FlightCriteria criteria, String airline) 
	{
		BestPath bestPath =  new BestPath();
		bestPath.setCriteria(criteria);
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		Vertex start;
		Vertex end;
		Vertex currVertex;
		//set start equal to the origin
		start = airports.get(origin);
		//set end equal to the destination
		end = airports.get(destination);
		//set start cost to 0
		start.setCost(0);
		//set the the criteria to the input criteria
		start.setCriteria(criteria);
		//add the start vertex to the pq
		pq.add(start);
		//while pq is not empty
		if(airline == null)
		{
			while(!pq.isEmpty())
			{
				//remove and set the criteria of the vertex
				currVertex = pq.remove();
				currVertex.setCriteria(criteria);
				//if the current vertex is equal to the end then 
				//back track to the original
				if(currVertex.equals(end))
				{
					for(Vertex goal = currVertex; goal != null;goal = goal.getPrevious())
					{
						bestPath.addVertex(goal);
					}
					bestPath.setPathLength(end);
					break;
				}
				//mark the current vertex as visited
				currVertex.setVisited(true);
				//for each edge in the vertex check to see if it
				//is visited then calculate the cost of the vertex
				//add it to the pq
				for(Edge flight : currVertex.getFlights().values())
				{
					if(airports.containsKey(flight.getDestination()))
					{
						Vertex destVertex = airports.get(flight.getDestination());
						destVertex.setCriteria(criteria);
						
						if(destVertex.getVisted() == false)
						{
							if(destVertex.getCost() > cost(currVertex) + cost(flight))
							{
								pq.remove(destVertex);
								destVertex.setPrev(currVertex);
								destVertex.setCost(cost(currVertex) + cost(flight));
								pq.add(destVertex);
							}							
						}					
					}
					
				}
			}
		}
		else
		{
			//while pq is not empty
			while(!pq.isEmpty())
			{
				//remove and set the criteria of the vertex
				currVertex = pq.remove();
				currVertex.setCriteria(criteria);
				//if the current vertex is equal to the end then 
				//back track to the original
				if(currVertex.getAirport().equals(end.getAirport()))
				{
					for(Vertex goal = currVertex; goal != null;goal = goal.getPrevious())
					{
						bestPath.addVertex(goal);
					}
					bestPath.setPathLength(end);
					break;
				}
				//mark the current vertex as visited
				currVertex.setVisited(true);
				//for each edge in the vertex check to see if it
				//is visited then calculate the cost of the vertex
				//add it to the pq
				for(Edge flight : currVertex.getFlights().values())
				{
					if(airports.containsKey(flight.getDestination()))
					{
						Vertex destVertex = airports.get(flight.getDestination());
						destVertex.setCriteria(criteria);
						
						if(flight.getAirlines().contains(airline))
						{
							if(destVertex.getVisted() == false)
							{
								if(cost(destVertex) > cost(currVertex) + cost(flight))
								{
									pq.remove(destVertex);
									destVertex.setPrev(currVertex);
									destVertex.setCost(cost(currVertex) + cost(flight));
									pq.add(destVertex);
								}
							}
						}
					}
				}
			}
		}
		return bestPath;
	}
	
	/**
	 * Performs Dijkstra's algorithm using Distance as the measure
	 * @param origin
	 * @param destination
	 * @param criteria
	 * @param airline
	 * @return
	 */
	private BestPath dijkstraDistance(String origin, String destination, FlightCriteria criteria, String airline)
	{
		BestPath bestPath =  new BestPath();
		bestPath.setCriteria(criteria);
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		Vertex start;
		Vertex end;
		Vertex currVertex;
		start = airports.get(origin);
		
		end = airports.get(destination);
		
		start.setDistance(0);
		start.setCriteria(criteria);
		
		pq.add(start);
		if(airline == null)
		{
			while(!pq.isEmpty())
				//while pq is not empty
				while(!pq.isEmpty())
				{
					//remove and set the criteria of the vertex
					currVertex = pq.remove();
					currVertex.setCriteria(criteria);
					//if the current vertex is equal to the end then 
					//back track to the original
					if(currVertex.getAirport().equals(end.getAirport()))
					{
						for(Vertex goal = currVertex; goal != null;goal = goal.getPrevious())
						{
							bestPath.addVertex(goal);
						}
						bestPath.setPathLength(end);
						break;
					}
					//mark the current vertex as visited
					currVertex.setVisited(true);
					//for each edge in the vertex check to see if it
					//is visited then calculate the cost of the vertex
					//add it to the pq
				for(Edge flight : currVertex.getFlights().values())
				{
					if(airports.containsKey(flight.getDestination()))
					{
						Vertex destVertex = airports.get(flight.getDestination());
						destVertex.setCriteria(criteria);
						
						if(destVertex.getVisted() == false)
						{
							if(destVertex.getDistance() > distance(currVertex) + distance(flight))
							{
								pq.remove(destVertex);
								destVertex.setPrev(currVertex);
								destVertex.setDistance(distance(currVertex) + distance(flight));
								pq.add(destVertex);
							}							
						}
					}
				}
			}
		}
		else
		{
			//while pq is not empty
			while(!pq.isEmpty())
			{
				//remove and set the criteria of the vertex
				currVertex = pq.remove();
				currVertex.setCriteria(criteria);
				//if the current vertex is equal to the end then 
				//back track to the original
				if(currVertex.getAirport().equals(end.getAirport()))
				{
					for(Vertex goal = currVertex; goal != null;goal = goal.getPrevious())
					{
						bestPath.addVertex(goal);
					}
					bestPath.setPathLength(end);
					break;
				}
				//mark the current vertex as visited
				currVertex.setVisited(true);
				//for each edge in the vertex check to see if it
				//is visited then calculate the cost of the vertex
				//add it to the pq
				for(Edge flight : currVertex.getFlights().values())
				{
					if(airports.containsKey(flight.getDestination()))
					{
						Vertex destVertex = airports.get(flight.getDestination());
						destVertex.setCriteria(criteria);
						
						if(flight.getAirlines().contains(airline))
						{
							if(destVertex.getVisted() == false)
							{
								if(distance(destVertex) > distance(currVertex) + distance(flight))
								{
									pq.remove(destVertex);
									destVertex.setPrev(currVertex);
									destVertex.setDistance(distance(currVertex) + distance(flight));
									pq.add(destVertex);
								}
							}
						}
					}
				}
			}
		}
		return bestPath;
	}

	/**
	 * Performs Dijkstra's algorithm using Delay as the measure 
	 * @param origin
	 * @param destination
	 * @param criteria
	 * @param airline
	 * @return
	 */
	private BestPath dijkstraDelay(String origin, String destination, FlightCriteria criteria, String airline) 
	{
		BestPath bestPath =  new BestPath();
		bestPath.setCriteria(criteria);
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		Vertex start;
		Vertex end;
		Vertex currVertex;
		start = airports.get(origin);
		
		end = airports.get(destination);
		
		start.setDelay(0);
		start.setCriteria(criteria);
		
		pq.add(start);
		if(airline == null)
		{
			//while pq is not empty
			while(!pq.isEmpty())
			{
				//remove and set the criteria of the vertex
				currVertex = pq.remove();
				currVertex.setCriteria(criteria);
				//if the current vertex is equal to the end then 
				//back track to the original
				if(currVertex.getAirport().equals(end.getAirport()))
				{
					for(Vertex goal = currVertex; goal != null;goal = goal.getPrevious())
					{
						bestPath.addVertex(goal);
					}
					bestPath.setPathLength(end);
					break;
				}
				//mark the current vertex as visited
				currVertex.setVisited(true);
				//for each edge in the vertex check to see if it
				//is visited then calculate the cost of the vertex
				//add it to the pq
				
				for(Edge flight : currVertex.getFlights().values())
				{
					if(airports.containsKey(flight.getDestination()))
					{
						Vertex destVertex = airports.get(flight.getDestination());
						destVertex.setCriteria(criteria);
						
						if(destVertex.getVisted() == false)
						{
							if(destVertex.getDelay() > delay(currVertex) + delay(flight))
							{
								pq.remove(destVertex);
								destVertex.setPrev(currVertex);
								destVertex.setDelay(delay(currVertex) + delay(flight));
								pq.add(destVertex);
							}							
						}
					}
				}
			}
		}
		else
		{
			//while pq is not empty
			while(!pq.isEmpty())
			{
				//remove and set the criteria of the vertex
				currVertex = pq.remove();
				currVertex.setCriteria(criteria);
				//if the current vertex is equal to the end then 
				//back track to the original
				if(currVertex.getAirport().equals(end.getAirport()))
				{
					for(Vertex goal = currVertex; goal != null;goal = goal.getPrevious())
					{
						bestPath.addVertex(goal);
					}
					bestPath.setPathLength(end);
					break;
				}
				//mark the current vertex as visited
				currVertex.setVisited(true);
				//for each edge in the vertex check to see if it
				//is visited then calculate the cost of the vertex
				//add it to the pq
				for(Edge flight : currVertex.getFlights().values())
				{
					if(airports.containsKey(flight.getDestination()))
					{
						Vertex destVertex = airports.get(flight.getDestination());
						destVertex.setCriteria(criteria);
						
						if(flight.getAirlines().contains(airline))
						{
							if(destVertex.getVisted() == false)
							{
								if(delay(destVertex) > delay(currVertex) + delay(flight))
								{
									pq.remove(destVertex);
									destVertex.setPrev(currVertex);
									destVertex.setDelay(delay(currVertex) + delay(flight));
									pq.add(destVertex);
								}
							}
						}						
					}
				}
			}
		}
		return bestPath;
	}

	/**
	 * Performs Dijkstra's algorithm using Time as the measure
	 * @param origin
	 * @param destination
	 * @param criteria
	 * @param airline
	 * @return
	 */
	private BestPath dijkstraTime(String origin, String destination, FlightCriteria criteria, String airline) 
	{
		BestPath bestPath =  new BestPath();
		bestPath.setCriteria(criteria);
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		Vertex start;
		Vertex end;
		Vertex currVertex;
		start = airports.get(origin);
		
		end = airports.get(destination);
		
		start.setTime(0);
		start.setCriteria(criteria);
		
		pq.add(start);
		if(airline == null)
		{
			//while pq is not empty
			while(!pq.isEmpty())
			{
				//remove and set the criteria of the vertex
				currVertex = pq.remove();
				currVertex.setCriteria(criteria);
				//if the current vertex is equal to the end then 
				//back track to the original
				if(currVertex.getAirport().equals(end.getAirport()))
				{
					for(Vertex goal = currVertex; goal != null;goal = goal.getPrevious())
					{
						bestPath.addVertex(goal);
					}
					bestPath.setPathLength(end);
					break;
				}
				//mark the current vertex as visited
				currVertex.setVisited(true);
				//for each edge in the vertex check to see if it
				//is visited then calculate the cost of the vertex
				//add it to the pq
				for(Edge flight : currVertex.getFlights().values())
				{
					if(airports.containsKey(flight.getDestination()))
					{
						Vertex destVertex = airports.get(flight.getDestination());
						destVertex.setCriteria(criteria);
						
						if(destVertex.getVisted() == false)
						{
							if(time(destVertex) > time(currVertex) + time(flight))
							{							
								destVertex.setPrev(currVertex);
								destVertex.setTime(time(currVertex) + time(flight));
								pq.remove(destVertex);
								pq.add(destVertex);
							}							
						}
					}
				}
			}
		}
		else
		{
			//while pq is not empty
			while(!pq.isEmpty())
			{
				//remove and set the criteria of the vertex
				currVertex = pq.remove();
				currVertex.setCriteria(criteria);
				//if the current vertex is equal to the end then 
				//back track to the original
				if(currVertex.getAirport().equals(end.getAirport()))
				{
					for(Vertex goal = currVertex; goal != null;goal = goal.getPrevious())
					{
						bestPath.addVertex(goal);
					}
					bestPath.setPathLength(end);
					break;
				}
				//mark the current vertex as visited
				currVertex.setVisited(true);
				//for each edge in the vertex check to see if it
				//is visited then calculate the cost of the vertex
				//add it to the pq
				for(Edge flight : currVertex.getFlights().values())
				{
					if(airports.containsKey(flight.getDestination()))
					{
						Vertex destVertex = airports.get(flight.getDestination());
						destVertex.setCriteria(criteria);
						
						if(flight.getAirlines().contains(airline))
						{
							if(destVertex.getVisted() == false)
							{
								if(time(destVertex) > time(currVertex) + time(flight))
								{
									pq.remove(destVertex);
									destVertex.setPrev(currVertex);
									destVertex.setTime(time(currVertex) + time(flight));
									pq.add(destVertex);
								}
							}
						}
					}
				}
			}
		}
		return bestPath;
	}

	/**
	 * Performs Dijkstra's algorithm using Canceled as the measure
	 * @param origin
	 * @param destination
	 * @param criteria
	 * @param airline
	 * @return
	 */
	private BestPath dijkstraCanceled(String origin, String destination, FlightCriteria criteria, String airline) 
	{
		BestPath bestPath =  new BestPath();
		bestPath.setCriteria(criteria);
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		Vertex start;
		Vertex end;
		Vertex currVertex;
		start = airports.get(origin);
		
		end = airports.get(destination);
		
		start.setCanceled(0);
		start.setCriteria(criteria);
		
		pq.add(start);
		if(airline == null)
		{
			//while pq is not empty
			while(!pq.isEmpty())
			{
				//remove and set the criteria of the vertex
				currVertex = pq.remove();
				currVertex.setCriteria(criteria);
				//if the current vertex is equal to the end then 
				//back track to the original
				if(currVertex.getAirport().equals(end.getAirport()))
				{
					for(Vertex goal = currVertex; goal != null;goal = goal.getPrevious())
					{
						bestPath.addVertex(goal);
					}
					bestPath.setPathLength(end);
					break;
				}
				//mark the current vertex as visited
				currVertex.setVisited(true);
				//for each edge in the vertex check to see if it
				//is visited then calculate the cost of the vertex
				//add it to the pq
				for(Edge flight : currVertex.getFlights().values())
				{
					if(airports.containsKey(flight.getDestination()))
					{
						Vertex destVertex = airports.get(flight.getDestination());
						destVertex.setCriteria(criteria);
						
						if(destVertex.getVisted() == false)
						{
							if(canceled(destVertex) > canceled(currVertex) + canceled(flight))
							{
								pq.remove(destVertex);
								destVertex.setPrev(currVertex);
								destVertex.setCanceled(canceled(currVertex) + canceled(flight));
								pq.add(destVertex);
							}							
						}
					}
				}
			}
		}
		else
		{
			//while pq is not empty
			while(!pq.isEmpty())
			{
				//remove and set the criteria of the vertex
				currVertex = pq.remove();
				currVertex.setCriteria(criteria);
				//if the current vertex is equal to the end then 
				//back track to the original
				if(currVertex.getAirport().equals(end.getAirport()))
				{
					for(Vertex goal = currVertex; goal != null;goal = goal.getPrevious())
					{
						bestPath.addVertex(goal);
					}
					bestPath.setPathLength(end);
					break;
				}
				//mark the current vertex as visited
				currVertex.setVisited(true);
				//for each edge in the vertex check to see if it
				//is visited then calculate the cost of the vertex
				//add it to the pq
				for(Edge flight : currVertex.getFlights().values())
				{
					if(airports.containsKey(flight.getDestination()))
					{
						Vertex destVertex = airports.get(flight.getDestination());
						destVertex.setCriteria(criteria);
						
						if(flight.getAirlines().contains(airline))
						{
							if(destVertex.getVisted() == false)
							{
								if(canceled(destVertex) > canceled(currVertex) + canceled(flight))
								{
									pq.remove(destVertex);
									destVertex.setPrev(currVertex);
									destVertex.setCanceled(canceled(currVertex) + canceled(flight));
									pq.add(destVertex);
								}
							}
						}
					}
				}
			}
		}
		return bestPath;
	}

	/**
	 * Gets the cost of the Edge
	 * @param flight
	 * @return
	 */
	private double cost(Edge flight) 
	{		
		return flight.getCost();
	}
	
	/**
	 * Gets the cost of the Vertex
	 * @param airport
	 * @return
	 */
	private double cost(Vertex airport)
	{
		return airport.getCost();
	}
	
	/**
	 * Gets the delay of the Edge
	 * @param flight
	 * @return
	 */
	private int delay(Edge flight)
	{
		return flight.getDelay();
	}
	
	/**
	 * Gets the delay of the Vertex
	 * @param airport
	 * @return
	 */
	private int delay(Vertex airport)
	{
		return airport.getDelay();
	}
	
	/**
	 * Gets the time of the Edge
	 * @param flight
	 * @return
	 */
	private double time(Edge flight)
	{
		return flight.getTime();
	}
	
	/**
	 * Gets the time of the Vertex
	 * @param airport
	 * @return
	 */
	private double time(Vertex airport)
	{
		return airport.getTime();
	}
	
	/**
	 * Gets the canceled probability of the Edge
	 * @param flight
	 * @return
	 */
	private double canceled(Edge flight)
	{
		return flight.getCanceled();
	}
	
	/**
	 * Gets the canceled probability of the Edge
	 * @param airport
	 * @return
	 */
	private double canceled(Vertex airport)
	{
		return airport.getCanceled();
	}
	
	/**
	 * Gets the distance of the flight
	 * @param flight
	 * @return
	 */
	private int distance(Edge flight)
	{
		return flight.getDistance();
	}
	
	/**
	 * Gets the distance of the Vertex
	 * @param airport
	 * @return
	 */
	private int distance(Vertex airport)
	{
		return airport.getDistance();
	}

	/**
	 * <p>This overloaded method should do the same as the one above only when looking for paths
	 * skip the ones that don't match the given airliner.</p>
	 * 
	 * @param origin - The starting location to find a path from. This should be a
	 * 3 character long string denoting an airport.
	 * 
	 * @param destination - The destination location from the starting airport.
	 * Again, this should be a 3 character long string denoting an airport.
	 * 
	 * @param criteria - This enum dictates the definition of "best". Based on this
	 * value a path should be generated and return.
	 * 
	 * @param airliner - a string dictating the airliner the user wants to use exclusively. Meaning
	 * no flights from other airliners will be considered.
	 * 
	 * @return - An object containing path information including origin, destination,
	 * and everything in between.
	 */
	public BestPath getBestPath(String origin, String destination, FlightCriteria criteria, String airliner) 
	{		
		//Creates a new bestpath
		BestPath bestPath = new BestPath();
		//If either the origin, destination are null then add either of them
		//to the best path and return the best path
		if(origin == null || destination == null || airports.get(origin) == null || airports.get(destination) == null)
		{
			if(origin == null || airports.get(origin) == null)
			{
				bestPath.addString(null);
			}
			else
			{
				bestPath.addString(origin);
			}
			
			if(destination == null || airports.get(destination) == null)
			{
				bestPath.addString(null);
			}
			else
			{
				bestPath.addString(destination);
			}
			return bestPath;
		}
		
		if(airliner == null)
		{
			return bestPath;
		}
		
		return Dijkstra(origin, destination, criteria, airliner);
	}
}