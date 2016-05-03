package assignment09;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * @author Brian Rodriguez and Michael Kim
 *
 * Outputs a solution to the Input Maze file if one exists. (Must be in valid format to work)
 */
public class PathFinder 
{
	static int height;
	
	static int width;
	
	/**
	 * Finds the shortest possible path for the input maze and prints
	 * it to an output file
	 * @param inputFile
	 * @param outputFile
	 */
	public static void solveMaze(String inputFile, String outputFile)
	{	
		String line = null;
		
		try 
		{
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(inputFile);

            //Wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            //Parse both the heigh and width in the line
            String[] dimensions = bufferedReader.readLine().split(" ");

            height = Integer.parseInt(dimensions[0]);

            width = Integer.parseInt(dimensions[1]);
            
            //create graph with the height and width
    		Graph graph = new Graph(height, width);
    		
    		//set start and goal = null
    		Node start = null;
    		
    		Node goal = null;

    		//read each line in the bufferedReader while it has next line
            while((line = bufferedReader.readLine()) !=null) 
            {
            	//create charArray with line
            	char [] charArray = line.toCharArray();
            	
            	//go through each char in the array and add it to the graph
            	for(char Character: charArray)
            	{
            		//if Character is S set it = start
            		if(Character == 'S')
            		{
            			start = new Node(Character + "");
            			graph.addVerticie(start);
            		}
            		//if Character is G set it = goal
            		else if(Character == 'G')
            		{
            			goal = new Node(Character + "");
            			graph.addVerticie(goal);
            		}
            		//add Character to the graph
            		else
            		{
            			graph.addVerticie(new Node(Character + ""));
            		}
            	}
            }
            
            //Determine the neighbors for each vertices in the graph
            for(int j = 0; j < height;j++)
            {
            	for(int k = 0; k < width;k++)
            	{
            		graph.addNeighbors(graph.nodeArray[j][k], j, k);
            	}
            }
            
            //Perform BFS on the start and goal
            graph.bfs(start, goal);
            
            //Write each line to the output file
            try(PrintWriter output = new PrintWriter(new FileWriter(outputFile))) 
            {
                output.println(height + " " + width);
                for(int j = 0; j < height;j++)
                {
                	for(int k = 0; k < width;k++)
                	{
                		output.write(graph.nodeArray[j][k].item);
                	}
                	output.println();
                }
           }

            //close bufferedReader.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) 
		{
         ex.printStackTrace();               
        }
        catch(IOException ex) 
		{
            ex.printStackTrace();                 
        }
		
	}
}
