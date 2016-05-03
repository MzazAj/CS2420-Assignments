package assignment09;

public class TestPathFinder 
{
	
	public static void main(String[] args) {
		
		/*
		 * The below code assumes you have a file "tinyMaze.txt" in your project folder.
		 * If PathFinder.solveMaze is implemented, it will create a file "tinyMazeOutput.txt" in your project folder.
		 * 
		 * REMEMBER - You have to refresh your project to see the output file in your package explorer. 
		 * You are still required to make JUnit tests...just lookin' at text files ain't gonna fly. 
		 */
		PathFinder.solveMaze("tinyMaze.txt", "tinyMazeOutput.txt");
		PathFinder.solveMaze("bigMaze.txt", "bigMazeOutput.txt");
		PathFinder.solveMaze("classic.txt", "classicMazeOutput.txt");
		PathFinder.solveMaze("demoMaze.txt", "demoMazeOutput.txt");
		PathFinder.solveMaze("mediumMaze.txt", "mediumMazeOutput.txt");
		PathFinder.solveMaze("turn.txt", "turnMazeOutput.txt");
		PathFinder.solveMaze("unsolvable.txt", "unsolvableMazeOutput.txt");

	}
}