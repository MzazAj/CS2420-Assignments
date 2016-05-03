package assignment13;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test cases for the Network Graph
 * 
 * @author Brian Rodriguez
 *
 */
public class NetworkGraphTests {

	static NetworkGraph network;
	static NetworkGraph airportGraph;
	static NetworkGraph smallnetwork;
	static NetworkGraph mediumnetwork;
	static NetworkGraph oneline;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		network = new NetworkGraph("testfile.csv");
		airportGraph = new NetworkGraph("flights-2015-q3.csv");
		smallnetwork = new NetworkGraph("testfile1.csv");
		mediumnetwork = new NetworkGraph("testfile2.csv");
		oneline = new NetworkGraph("oneline.csv");
	}

	@Test
	public void testNGwithNonExistingDestination() 
	{
		BestPath bestpath = network.getBestPath("NXH", "VTI", FlightCriteria.COST);
		
		BestPath solution = new BestPath();
		
		solution.addString("NXH");
		
		assertEquals(true, solution.equals(bestpath));
	}
	
	@Test
	public void testNGwithNonExistingOrigin()
	{
		BestPath bestpath = network.getBestPath("QWE", "NXH", FlightCriteria.DISTANCE);
		
		BestPath solution = new BestPath();
		
		assertEquals(true, bestpath.equals(solution));
	}
	
	@Test
	public void testWithNullOrigin()
	{
		BestPath bestpath = network.getBestPath(null, "VTI", FlightCriteria.COST);
		
		BestPath solution = new BestPath();

		solution.addString(null);
		solution.addString("VTI");
		
		assertEquals(true, solution.equals(bestpath));
	}
	
	@Test
	public void testWithNullDestination()
	{
		BestPath bestpath = network.getBestPath("NXH", null, FlightCriteria.COST);
		
		BestPath solution = new BestPath();
		
		solution.addString("NXH");
		solution.addString(null);
		
		assertEquals(true, solution.equals(bestpath));
	}
	
	@Test
	public void testBothNull()
	{
		BestPath bestpath = network.getBestPath(null, null, FlightCriteria.COST);

		BestPath solution = new BestPath();
		solution.addString(null);
		solution.addString(null);
		
		assertEquals(true, solution.equals(bestpath));
	}
	
	@Test
	public void testCost()
	{
		BestPath bestpath = network.getBestPath("NXH", "KQH", FlightCriteria.COST);
		
		BestPath solution = new BestPath();
		
		solution.addString("NXH");
		solution.addString("UYZ");
		solution.addString("UVA");
		solution.addString("KQH");
		solution.setPathLength(878.9);
		
		assertEquals(true, bestpath.equals(solution));
	}

	@Test
	public void testDistance()
	{
		BestPath bestpath = network.getBestPath("NXH", "UVA", FlightCriteria.DISTANCE);
		
		BestPath solution = new BestPath();
		
		solution.addString("NXH");
		solution.addString("UYZ");
		solution.addString("UVA");
		solution.setPathLength(2446);
		
		assertEquals(true, bestpath.equals(solution));
	}
	
	@Test
	public void testDelay()
	{
		BestPath bestpath = network.getBestPath("UYZ", "LGU", FlightCriteria.DELAY);
		
		BestPath solution = new BestPath();
		
		solution.addString("UYZ");
		solution.addString("UVA");
		solution.addString("KQH");
		solution.addString("NXT");
		solution.addString("LGU");
		
		solution.setPathLength(903);
		
		assertEquals(true, solution.equals(bestpath));
	}
	
	@Test
	public void testDistanceLargeFile()
	{
		BestPath shortestDistancePath = airportGraph.getBestPath("MOB", "ACV", FlightCriteria.DISTANCE);
		
		BestPath solution = new BestPath();
		
		solution.addString("MOB");
		solution.addString("DFW");
		solution.addString("SFO");
		solution.addString("ACV");
		solution.setPathLength(2253);
		
		assertEquals(true, shortestDistancePath.equals(solution));
	}
	
	@Test
	public void testTimeLargeFile()
	{
		BestPath shortestTimePath = airportGraph.getBestPath("MOB", "SLC", FlightCriteria.TIME);
		
		BestPath solution = new BestPath();
		
		solution.addString("MOB");
		solution.addString("DFW");
		solution.addString("SLC");
		solution.setPathLength(269.25341453111827);
		
		assertEquals(true, shortestTimePath.equals(solution));
	}
	
	@Test
	public void testCostLargeFile()
	{
		BestPath cheapestPath = airportGraph.getBestPath("LAS", "LAX", FlightCriteria.COST);
		
		BestPath solution = new BestPath();
		
		solution.addString("LAS");
		solution.addString("LAX");
		solution.setPathLength(138.3900000000065);
		
		assertEquals(true, solution.equals(cheapestPath));
	}
	
	@Test
	public void testCanceled()
	{
		BestPath bestpath = network.getBestPath("NXT", "NXH", FlightCriteria.CANCELED);
		
		BestPath solution = new BestPath();
		
		solution.addString("NXT");
		solution.addString("LGU");
		solution.addString("TIY");
		solution.addString("UVA");
		solution.addString("NXH");
		
		solution.setPathLength(1);
				
		assertEquals(true, solution.equals(bestpath));
	}
	
	@Test
	public void testCanceledLargeFile()
	{
		BestPath bestpath = airportGraph.getBestPath("MOB", "ACV", FlightCriteria.CANCELED);
		
		BestPath solution = new BestPath();
		
		solution.addString("MOB");
		solution.addString("DFW");
		solution.addString("FLL");
		solution.addString("SFO");
		solution.addString("ACV");
		solution.setPathLength(0.04178272980501395);
		
		assertEquals(true, solution.equals(bestpath));
	}
	
	@Test
	public void testDistanceWithAirline()
	{
		BestPath shortestDistancePath = airportGraph.getBestPath("SFO", "DFW", FlightCriteria.DISTANCE, "DL");
		
		BestPath solution = new BestPath();
		
		solution.addString("SFO");
		solution.addString("SLC");
		solution.addString("DFW");
		solution.setPathLength(1588);
		
		assertEquals(true, solution.equals(shortestDistancePath));
	}
	
	@Test
	public void testCostWithAirline()
	{
		BestPath bestpath = network.getBestPath("TIY", "HGR", FlightCriteria.COST, "MQ");
			
		BestPath solution = new BestPath();
		
		solution.addString("TIY");
		solution.addString("UYZ");
		solution.addString("HGR");
		solution.setPathLength(572.09);
		
		assertEquals(true, solution.equals(bestpath));
	}
	
	@Test
	public void testWithTwoNulls()
	{
		BestPath bestpath = network.getBestPath(null, null, FlightCriteria.COST);
		
		BestPath solution = new BestPath();
		
		solution.addString(null);
		solution.addString(null);
		
		assertEquals(true, solution.equals(bestpath));
	}
	
	@Test
	public void testCanceledSmallFile()
	{
		BestPath bestpath = network.getBestPath("UYZ", "GGB", FlightCriteria.CANCELED);
		
		BestPath solution = new BestPath();
		
		solution.addString("UYZ");
		solution.addString("GGB");
		solution.setPathLength(1);
		
		assertEquals(true, bestpath.equals(solution));		
	}
	
	@Test
	public void testWithNoBestPath()
	{
		BestPath bestpath = smallnetwork.getBestPath("ZVO", "PLK", FlightCriteria.CANCELED);
		
		BestPath solution = new BestPath();
		
		assertEquals(true, solution.equals(bestpath));
	}
	
	@Test
	public void testDelayLargeFile()
	{
		BestPath bestpath = network.getBestPath("LFD", "NXH", FlightCriteria.DELAY);
		
		BestPath solution = new BestPath();
		
		solution.addString("LFD");
		solution.addString("PEH");
		solution.addString("UVA");
		solution.addString("NXH");
		solution.setPathLength(505);
		
		assertEquals(true, solution.equals(bestpath));
	}
	
	@Test
	public void testCanceledMediumFile()
	{
		BestPath bestpath = mediumnetwork.getBestPath("JJJ", "BPZ", FlightCriteria.CANCELED);
		
		BestPath solution = new BestPath();
		
		solution.addString("JJJ");
		solution.addString("QNX");
		solution.addString("BPZ");
		solution.setPathLength(0.5833333333333333);
		
		assertEquals(true, solution.equals(bestpath));
	}
	
	@Test
	public void testDistanceAirline()
	{
		BestPath bestpath = mediumnetwork.getBestPath("JJJ", "BPZ", FlightCriteria.DISTANCE, "HA");
		
		BestPath solution = new BestPath();
		
		solution.addString("JJJ");
		solution.addString("PDP");
		solution.addString("BPZ");
		solution.setPathLength(3630);
		
		assertEquals(true, solution.equals(bestpath));
	}
	
	@Test
	public void testDelayAirline()
	{
		BestPath bestpath = mediumnetwork.getBestPath("BPZ", "JJJ", FlightCriteria.DELAY, "OO");
		
		BestPath solution = new BestPath();
		
		solution.addString("BPZ");
		solution.addString("JJJ");
		solution.setPathLength(339);
		
		System.out.println(bestpath.toString());
		assertEquals(true, solution.equals(bestpath));
	}
	
	@Test
	public void testCanceledAirline()
	{
		BestPath bestpath = mediumnetwork.getBestPath("BPZ", "JJJ", FlightCriteria.CANCELED, "AA");
		
		BestPath solution = new BestPath();
		
		solution.addString("BPZ");
		solution.addString("JJJ");
		solution.setPathLength(.4);
		
		assertEquals(true, solution.equals(bestpath));
	}
	
	@Test
	public void testOneline()
	{
		BestPath bestpath = oneline.getBestPath("OUF", "ADZ", FlightCriteria.COST);
		
		BestPath solution = new BestPath();
		
		solution.addString("OUF");
		
		assertEquals(true, solution.equals(bestpath));
	}
}
