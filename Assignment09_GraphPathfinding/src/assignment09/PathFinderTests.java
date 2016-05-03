package assignment09;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import org.junit.Test;

@SuppressWarnings("resource")

/**
 * Tests for our PathFinder class
 * SuppressWarnings because we were unable to close the bufferedReaders
 * 
 * @author Brian Rodriguez and Michael Kim
 *
 */
public class PathFinderTests {
		@Test
	public void testBigMaze() 
	{
		try 
		{
			FileReader sol = new FileReader("bigMazeSol.txt");
			
            BufferedReader solRead = new BufferedReader(sol);
            
            PathFinder.solveMaze("bigMaze.txt", "bigMazeOutput.txt");
            
            FileReader output = new FileReader("bigMazeOutput.txt");
            
            BufferedReader outRead = new BufferedReader(output);
            
            int dotcountSol = 0;
            
            int dotcountOut = 0;
            
            while(outRead != null || solRead != null)
            {
            	char[] solLine;
            	char[] outLine;
            	try
            	{
            		solLine = solRead.readLine().toCharArray();
            		outLine = outRead.readLine().toCharArray();
            	}
            	catch(NullPointerException e)
            	{
            		break;
            	}
            	
            	for(char character: solLine)
            	{
            		if(character == '.')
            		{
            			dotcountSol++;
            		}
            	}
            	for(char character: outLine)
            	{
            		if(character == '.')
            		{
            			dotcountOut++;
            		}
            	}

            }
            
            if(dotcountSol == dotcountOut)
            {
            	assertTrue(true);
            }
            else
            {
            	assertTrue(false);
            }
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testClassic() 
	{
		try 
		{
			FileReader sol = new FileReader("classicSol.txt");
			
            BufferedReader solRead = new BufferedReader(sol);
            
            PathFinder.solveMaze("classic.txt", "classicMazeOutput.txt");
            
            FileReader output = new FileReader("classicMazeOutput.txt");
            
            BufferedReader outRead = new BufferedReader(output);
            
            int dotcountSol = 0;
            
            int dotcountOut = 0;
            
            while(outRead != null || solRead != null)
            {
            	char[] solLine;
            	char[] outLine;
            	try
            	{
            		solLine = solRead.readLine().toCharArray();
            		outLine = outRead.readLine().toCharArray();
            	}
            	catch(NullPointerException e)
            	{
            		break;
            	}
            	
            	for(char character: solLine)
            	{
            		if(character == '.')
            		{
            			dotcountSol++;
            		}
            	}
            	for(char character: outLine)
            	{
            		if(character == '.')
            		{
            			dotcountOut++;
            		}
            	}

            }
            
            if(dotcountSol == dotcountOut)
            {
            	assertTrue(true);
            }
            else
            {
            	assertTrue(false);
            }
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testDemoMaze() 
	{
		try 
		{
			FileReader sol = new FileReader("demoMazeSol.txt");
			
            BufferedReader solRead = new BufferedReader(sol);
            
            PathFinder.solveMaze("demoMaze.txt", "demoMazeOutput.txt");
            
            FileReader output = new FileReader("demoMazeOutput.txt");
            
            BufferedReader outRead = new BufferedReader(output);
            
            int dotcountSol = 0;
            
            int dotcountOut = 0;
            
            while(outRead != null || solRead != null)
            {
            	char[] solLine;
            	char[] outLine;
            	try
            	{
            		solLine = solRead.readLine().toCharArray();
            		outLine = outRead.readLine().toCharArray();
            	}
            	catch(NullPointerException e)
            	{
            		break;
            	}
            	
            	for(char character: solLine)
            	{
            		if(character == '.')
            		{
            			dotcountSol++;
            		}
            	}
            	for(char character: outLine)
            	{
            		if(character == '.')
            		{
            			dotcountOut++;
            		}
            	}

            }
            
            if(dotcountSol == dotcountOut)
            {
            	assertTrue(true);
            }
            else
            {
            	assertTrue(false);
            }
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMediumMaze() 
	{
		try 
		{
			FileReader sol = new FileReader("mediumMazeSol.txt");
			
            BufferedReader solRead = new BufferedReader(sol);
            
            PathFinder.solveMaze("mediumMaze.txt", "mediumMazeOutput.txt");
            
            FileReader output = new FileReader("mediumMazeOutput.txt");
            
            BufferedReader outRead = new BufferedReader(output);
            
            int dotcountSol = 0;
            
            int dotcountOut = 0;
            
            while(outRead != null || solRead != null)
            {
            	char[] solLine;
            	char[] outLine;
            	try
            	{
            		solLine = solRead.readLine().toCharArray();
            		outLine = outRead.readLine().toCharArray();
            	}
            	catch(NullPointerException e)
            	{
            		break;
            	}
            	
            	for(char character: solLine)
            	{
            		if(character == '.')
            		{
            			dotcountSol++;
            		}
            	}
            	for(char character: outLine)
            	{
            		if(character == '.')
            		{
            			dotcountOut++;
            		}
            	}

            }
            
            if(dotcountSol == dotcountOut)
            {
            	assertTrue(true);
            }
            else
            {
            	assertTrue(false);
            }
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRandomMaze() 
	{
		try 
		{
			
			FileReader sol = new FileReader("randomMazeSol.txt");
			
            BufferedReader solRead = new BufferedReader(sol);
            
            PathFinder.solveMaze("randomMaze.txt", "randomMazeOutput.txt");
            
            FileReader output = new FileReader("randomMazeOutput.txt");
            
            BufferedReader outRead = new BufferedReader(output);
            
            int dotcountSol = 0;
            
            int dotcountOut = 0;
            
            while(outRead != null || solRead != null)
            {
            	char[] solLine;
            	char[] outLine;
            	try
            	{
            		solLine = solRead.readLine().toCharArray();
            		outLine = outRead.readLine().toCharArray();
            	}
            	catch(NullPointerException e)
            	{
            		break;
            	}
            	
            	for(char character: solLine)
            	{
            		if(character == '.')
            		{
            			dotcountSol++;
            		}
            	}
            	for(char character: outLine)
            	{
            		if(character == '.')
            		{
            			dotcountOut++;
            		}
            	}

            }
            
            if(dotcountSol == dotcountOut)
            {
            	assertTrue(true);
            }
            else
            {
            	assertTrue(false);
            }
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testStraight() 
	{
		try 
		{
			FileReader sol = new FileReader("straightSol.txt");
			
            BufferedReader solRead = new BufferedReader(sol);
            
            PathFinder.solveMaze("straight.txt", "straightMazeOutput.txt");
            
            FileReader output = new FileReader("straightMazeOutput.txt");
            
            BufferedReader outRead = new BufferedReader(output);
            
            int dotcountSol = 0;
            
            int dotcountOut = 0;
            
            while(outRead != null || solRead != null)
            {
            	char[] solLine;
            	char[] outLine;
            	try
            	{
            		solLine = solRead.readLine().toCharArray();
            		outLine = outRead.readLine().toCharArray();
            	}
            	catch(NullPointerException e)
            	{
            		break;
            	}
            	
            	for(char character: solLine)
            	{
            		if(character == '.')
            		{
            			dotcountSol++;
            		}
            	}
            	for(char character: outLine)
            	{
            		if(character == '.')
            		{
            			dotcountOut++;
            		}
            	}

            }
            
            if(dotcountSol == dotcountOut)
            {
            	assertTrue(true);
            }
            else
            {
            	assertTrue(false);
            }
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTinyMaze() 
	{
		try 
		{
			FileReader sol = new FileReader("tinyMazeSol.txt");
			
            BufferedReader solRead = new BufferedReader(sol);
            
            PathFinder.solveMaze("tinyMaze.txt", "tinyMazeOutput.txt");
            
            FileReader output = new FileReader("tinyMazeOutput.txt");
            
            BufferedReader outRead = new BufferedReader(output);
            
            int dotcountSol = 0;
            
            int dotcountOut = 0;
            
            while(outRead != null || solRead != null)
            {
            	char[] solLine;
            	char[] outLine;
            	try
            	{
            		solLine = solRead.readLine().toCharArray();
            		outLine = outRead.readLine().toCharArray();
            	}
            	catch(NullPointerException e)
            	{
            		break;
            	}
            	
            	for(char character: solLine)
            	{
            		if(character == '.')
            		{
            			dotcountSol++;
            		}
            	}
            	for(char character: outLine)
            	{
            		if(character == '.')
            		{
            			dotcountOut++;
            		}
            	}

            }
            
            if(dotcountSol == dotcountOut)
            {
            	assertTrue(true);
            }
            else
            {
            	assertTrue(false);
            }
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTinyOpen() 
	{
		try 
		{
			FileReader sol = new FileReader("tinyOpenSol.txt");
			
            BufferedReader solRead = new BufferedReader(sol);
            
            PathFinder.solveMaze("tinyOpen.txt", "tinyOpenMazeOutput.txt");
            
            FileReader output = new FileReader("tinyOpenMazeOutput.txt");
            
            BufferedReader outRead = new BufferedReader(output);
            
            int dotcountSol = 0;
            
            int dotcountOut = 0;
            
            while(outRead != null || solRead != null)
            {
            	char[] solLine;
            	char[] outLine;
            	try
            	{
            		solLine = solRead.readLine().toCharArray();
            		outLine = outRead.readLine().toCharArray();
            	}
            	catch(NullPointerException e)
            	{
            		break;
            	}
            	
            	for(char character: solLine)
            	{
            		if(character == '.')
            		{
            			dotcountSol++;
            		}
            	}
            	for(char character: outLine)
            	{
            		if(character == '.')
            		{
            			dotcountOut++;
            		}
            	}

            }
            
            if(dotcountSol == dotcountOut)
            {
            	assertTrue(true);
            }
            else
            {
            	assertTrue(false);
            }
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTurn() 
	{
		try 
		{
			FileReader sol = new FileReader("turnSol.txt");
			
            BufferedReader solRead = new BufferedReader(sol);
            
            PathFinder.solveMaze("turn.txt", "turnMazeOutput.txt");
            
            FileReader output = new FileReader("turnMazeOutput.txt");
            
            BufferedReader outRead = new BufferedReader(output);
            
            int dotcountSol = 0;
            
            int dotcountOut = 0;
            
            while(outRead != null || solRead != null)
            {
            	char[] solLine;
            	char[] outLine;
            	try
            	{
            		solLine = solRead.readLine().toCharArray();
            		outLine = outRead.readLine().toCharArray();
            	}
            	catch(NullPointerException e)
            	{
            		break;
            	}
            	
            	for(char character: solLine)
            	{
            		if(character == '.')
            		{
            			dotcountSol++;
            		}
            	}
            	for(char character: outLine)
            	{
            		if(character == '.')
            		{
            			dotcountOut++;
            		}
            	}

            }
            
            if(dotcountSol == dotcountOut)
            {
            	assertTrue(true);
            }
            else
            {
            	assertTrue(false);
            }
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUnsolvable() 
	{
		try 
		{
			FileReader sol = new FileReader("unsolvableSol.txt");
			
            BufferedReader solRead = new BufferedReader(sol);
            
            PathFinder.solveMaze("unsolvable.txt", "unsolvableMazeOutput.txt");
            
            FileReader output = new FileReader("unsolvableMazeOutput.txt");
            
            BufferedReader outRead = new BufferedReader(output);
            
            int dotcountSol = 0;
            
            int dotcountOut = 0;
            
            while(outRead != null || solRead != null)
            {
            	char[] solLine;
            	char[] outLine;
            	try
            	{
            		solLine = solRead.readLine().toCharArray();
            		outLine = outRead.readLine().toCharArray();
            	}
            	catch(NullPointerException e)
            	{
            		break;
            	}
            	
            	for(char character: solLine)
            	{
            		if(character == '.')
            		{
            			dotcountSol++;
            		}
            	}
            	for(char character: outLine)
            	{
            		if(character == '.')
            		{
            			dotcountOut++;
            		}
            	}

            }
            
            if(dotcountSol == dotcountOut)
            {
            	assertTrue(true);
            }
            else
            {
            	assertTrue(false);
            }
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}
