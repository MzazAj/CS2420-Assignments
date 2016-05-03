package assignment10;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Timer for the Hash Functors and Hash Tables
 * @author Brian Rodriguez and Michael Kim
 *
 */
public class HashFunctionTimer {

	private static GoodHashFunctor GHF = new GoodHashFunctor(); 
	private static MediocreHashFunctor MHF = new MediocreHashFunctor();
	private static BadHashFunctor BHF = new BadHashFunctor();
	
	public static void main(String[]args) throws IOException
	{
//        System.out.println("\nN\tT(N)\t|\tT(N)/logN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");    
        timerForFunctors();
        //timerForHashTables();
	}

		    public static void timerForFunctors() throws IOException
		    {
		        System.out.println("Timer For Functors");
		        DecimalFormat formatter = new DecimalFormat("0000E0");
		        long startTime, midptTime, endTime;
		        long timesToLoop = 100;
		        long size = 50_000;
		        long Billion = 1_000_000_000;
		        QuadProbeHashTable quadProbeGHF;
		        QuadProbeHashTable quadProbeMHF;
		        QuadProbeHashTable quadProbeBHF;
		        int quadProbeGHFCollisionCount;
		        int quadProbeMHFCollisionCount;
		        int quadProbeBHFCollisionCount;
		        ArrayList<String> arrayOfStrings = new ArrayList<>();
		        
		        for(int N = 2500; N <= size; N+=2500)
		        {
		        	quadProbeGHF = new QuadProbeHashTable(100000, GHF);
		        	quadProbeMHF = new QuadProbeHashTable(100000, MHF);
		        	quadProbeBHF = new QuadProbeHashTable(100000, BHF);
		        	
//		            System.out.println(N + "\t");
		            startTime = System.nanoTime();
		            //Add N items (random strings of length 8) into a list to be used in the Hash Tables
		            for(int i = 0; i < N; i++)
		            {
		            	arrayOfStrings.add(StringGenerator.randomString(8));
		            }
//		            //Warm the System up
//		            while(System.nanoTime() - startTime < Billion)
//		            {
//		                
//		            }
//		            startTime = System.nanoTime();
//		            //Add all the items to the Hash table and avg. out over times to loop
//		            for(long i = 0; i < timesToLoop; i++)
//		            {
//		            	quadProbeGHF.addAll(arrayOfStrings);
//		            	quadProbeGHF.clear();
//		            }
//		            
//		            midptTime = System.nanoTime();
//		            for(long i = 0; i < timesToLoop; i++)
//		            {
//		            	quadProbeGHF.clear();
//		            }
//		            endTime = System.nanoTime();
//
//		            //Get the number of collision for these items
//		            quadProbeGHF.addAll(arrayOfStrings);
//		            quadProbeGHFCollisionCount = quadProbeGHF.getCollisions();
//		            System.out.println("Quad Probe GHF Collision Count & Running Time");
//		            System.out.println(quadProbeGHFCollisionCount);
//		            //Clear Hash Table
//		            quadProbeGHF.clear();
		            
////		            Get avg. time of adding to Hash Table
//		            double avgTime = ((midptTime - startTime) - (endTime - midptTime)) / timesToLoop;
//		            System.out.print(formatter.format(avgTime)
//		                    + "\t|\t"
//		                    + formatter.format(avgTime / (Math.log10(N) / Math.log10(2))) + "\t\t"
//		                    + formatter.format(avgTime / N) + "\t\t"
//		                    + formatter.format(avgTime / (N * N)) + "\t\t"
//		                    + formatter.format(avgTime / (N * N * N)) + "\t\t");
//		            System.out.println(avgTime);
		            
		            startTime = System.nanoTime();
		          //Add all the items to the Hash table and avg. out over times to loop
		            for(long i = 0; i < timesToLoop; i++)
		            {
		            	quadProbeMHF.addAll(arrayOfStrings);
		            	quadProbeMHF.clear();
		            }
		            
		            midptTime = System.nanoTime();
		            for(long i = 0; i < timesToLoop; i++)
		            {
		            	quadProbeMHF.clear();
		            }
		            endTime = System.nanoTime();

		            //Get the number of collision for these items
		            quadProbeMHF.addAll(arrayOfStrings);
		            quadProbeMHFCollisionCount = quadProbeMHF.getCollisions();
//		            System.out.println("Quad Probe MHF Collision Count & Running Time");
		            System.out.println(quadProbeMHFCollisionCount);
		          //Clear Hash Table
		            quadProbeMHF.clear();

		            //Get avg. time of adding to Hash Table
//		            double avgTime2 = ((midptTime - startTime) - (endTime - midptTime)) / timesToLoop;
//		            System.out.print(formatter.format(avgTime2)
//		                    + "\t|\t"
//		                    + formatter.format(avgTime2 / (Math.log10(N) / Math.log10(2))) + "\t\t"
//		                    + formatter.format(avgTime2 / N) + "\t\t"
//		                    + formatter.format(avgTime2 / (N * N)) + "\t\t"
//		                    + formatter.format(avgTime2 / (N * N * N)) + "\t\t");
//		            System.out.println(avgTime2);
		            
//		            startTime = System.nanoTime();
//		          //Add all the items to the Hash table and avg. out over times to loop
//		            for(long i = 0; i < 100; i++)
//		            {
//		            	quadProbeBHF.addAll(arrayOfStrings);
//		            	quadProbeBHF.clear();
//		            }
//		            
//		            midptTime = System.nanoTime();
//		            for(long i = 0; i < 100; i++)
//		            {
//		            	quadProbeBHF.clear();
//		            }
//		            endTime = System.nanoTime();
//
//		            //Get the number of collision for these items
//		            quadProbeBHF.addAll(arrayOfStrings);
//		            quadProbeBHFCollisionCount = quadProbeBHF.getCollisions();
////		            System.out.println("Quad Probe BHF Collision Count & Running Time");
//		            System.out.println(quadProbeBHFCollisionCount);
//		          //Clear Hash Table
//		            quadProbeBHF.clear();
//		            
//		            //Get avg. time of adding to Hash Table
////		            double avgTime3 = ((midptTime - startTime) - (endTime - midptTime)) / timesToLoop;
////		            System.out.print(formatter.format(avgTime3)
////		                    + "\t|\t"
////		                    + formatter.format(avgTime3 / (Math.log10(N) / Math.log10(2))) + "\t\t"
////		                    + formatter.format(avgTime3 / N) + "\t\t"
////		                    + formatter.format(avgTime3 / (N * N)) + "\t\t"
////		                    + formatter.format(avgTime3 / (N * N * N)) + "\t\t");
////		            System.out.println(avgTime3);
//		            arrayOfStrings.clear();
		        }
		    }
		    public static void timerForHashTables() throws IOException
		    {
		        System.out.println("Hash Table Timer");
		        DecimalFormat formatter = new DecimalFormat("0000E0");
		        long startTime, midptTime, endTime;
		        long timesToLoop = 100;
		        long size = 10000;
		        long Billion = 1_000_000_000;
		        QuadProbeHashTable quadProbeGHF;
		        ChainingHashTable chainingHashTableGHF;
		        int quadProbeGHFCollisionCount;
		        int chainingGHFCollisionCount;
		        ArrayList<String> arrayOfStrings = new ArrayList<>();
		        
		        for(int N = 1000; N <= size; N+=1000)
		        {
		        	quadProbeGHF = new QuadProbeHashTable(10000, GHF);
		        	chainingHashTableGHF = new ChainingHashTable(100000, GHF);
		            System.out.println(N + "\t");
		            startTime = System.nanoTime();
		          //Add N items (random strings of length 8) into a list to be used in the Hash Tables
		            for(int i = 0; i < N; i++)
		            {
		            	arrayOfStrings.add(StringGenerator.randomString(8));
		            }
		            //Warm the System up
		            while(System.nanoTime() - startTime < Billion)
		            {
		                
		            }
		            startTime = System.nanoTime();
		          //Add all the items to the Hash table and avg. out over times to loop
		            for(long i = 0; i < timesToLoop; i++)
		            {
		            	quadProbeGHF.addAll(arrayOfStrings);
		            	quadProbeGHF.clear();
		            }
		            
		            midptTime = System.nanoTime();
		            for(long i = 0; i < timesToLoop; i++)
		            {
		            	quadProbeGHF.clear();
		            }
		            endTime = System.nanoTime();

		            //Get the number of collision for these items
		            quadProbeGHF.addAll(arrayOfStrings);
		            quadProbeGHFCollisionCount = quadProbeGHF.getCollisions();
		            System.out.println("Quad Probe GHF Collision Count & Running Time");
		            System.out.println(quadProbeGHFCollisionCount);
		          //Clear Hash Table
		            quadProbeGHF.clear();

		            //Get avg. time of adding to Hash Table
		            double avgTime = ((midptTime - startTime) - (endTime - midptTime)) / timesToLoop;
		            System.out.print(formatter.format(avgTime)
		                    + "\t|\t"
		                    + formatter.format(avgTime / (Math.log10(N) / Math.log10(2))) + "\t\t"
		                    + formatter.format(avgTime / N) + "\t\t"
		                    + formatter.format(avgTime / (N * N)) + "\t\t"
		                    + formatter.format(avgTime / (N * N * N)) + "\t\t");
		            System.out.println(avgTime);
		            
		            startTime = System.nanoTime();
		          //Add all the items to the Hash table and avg. out over times to loop
		            for(long i = 0; i < timesToLoop; i++)
		            {
		            	chainingHashTableGHF.addAll(arrayOfStrings);
		            	chainingHashTableGHF.clear();
		            }
		            
		            midptTime = System.nanoTime();
		            for(long i = 0; i < timesToLoop; i++)
		            {
		            	chainingHashTableGHF.clear();
		            }
		            endTime = System.nanoTime();

		            //Get the number of collision for these items
		            chainingHashTableGHF.addAll(arrayOfStrings);
		            chainingGHFCollisionCount = chainingHashTableGHF.getCollisions();
		            System.out.println("Chaining GHF Collision Count & Running Time");
		            System.out.println(chainingGHFCollisionCount);
		          //Clear Hash Table
		            chainingHashTableGHF.clear();

		            //Get avg. time of adding to Hash Table
		            double avgTime2 = ((midptTime - startTime) - (endTime - midptTime)) / timesToLoop;
		            System.out.print(formatter.format(avgTime2)
		                    + "\t|\t"
		                    + formatter.format(avgTime2 / (Math.log10(N) / Math.log10(2))) + "\t\t"
		                    + formatter.format(avgTime2 / N) + "\t\t"
		                    + formatter.format(avgTime2 / (N * N)) + "\t\t"
		                    + formatter.format(avgTime2 / (N * N * N)) + "\t\t");
		            System.out.println(avgTime2);
		            arrayOfStrings.clear();
		        }
		    }
	}