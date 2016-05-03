package assignment08;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;


/**
 * Timer for BST
 * 
 * @author Brian Rodriguez and Michael Kim
 */

public class BinarySearchTreeTimer 
{	
		    public static void main(String[]args) throws IOException
		    {
		        System.out.println("\nN\tT(N)\t|\tT(N)/logN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");    
		        BSTSortedOrderContainsMethod();
		        BSTShuffledOrderContainsMethod();
		        TreeSetBSTShuffledOrderContainsAndAddMethod();		    }

		    public static void BSTSortedOrderContainsMethod() throws IOException
		    {
		        System.out.println("BSTSortedOrder");
		        DecimalFormat formatter = new DecimalFormat("0000E0");
		        long startTime, midptTime, endTime;
		        long timesToLoop = 100;
		        long size = 10_000;
		        long Billion = 1_000_000_000;
		        ArrayList<Integer> integerArray = new ArrayList<Integer>();
		        BinarySearchTree<Integer> integerBST = new BinarySearchTree<Integer>();
		        for(int N = 1000; N <= size; N+=100)
		        {
		            System.out.print(N + "\t");
		            startTime = System.currentTimeMillis();
		            //Add N items into a list that will be added to a BST
		            for(int i = 0; i < N; i++)
		            {
		            	integerArray.add(i);
		            }
		            //Add items in list to BST
		            integerBST.addAll(integerArray);
		            //Warm the System up
		            while(System.nanoTime() - startTime < Billion)
		            {
		                
		            }
		            //Time containsAll method for every element in BST
		            startTime = System.currentTimeMillis();
		            for(long i = 0; i < timesToLoop; i++)
		            {
		                integerBST.containsAll(integerArray);
		            }
		            
		            //Subtract the time of the empty loop
		            midptTime = System.currentTimeMillis();
		            for(long i = 0; i < timesToLoop; i++)
		            {
		            	
		            }
		            endTime = System.currentTimeMillis();
		            
		            //Clear the list and BST for the next loop
		            integerArray.clear();
		            integerBST.clear();
		                    
		            //Get the avgTime from subtracting the time of the method from the loop time
		            double avgTime = ((midptTime - startTime) - (endTime - midptTime)) / timesToLoop;
		            System.out.print(formatter.format(avgTime)
		                    + "\t|\t"
		                    + formatter.format(avgTime / (Math.log10(N) / Math.log10(2))) + "\t\t"
		                    + formatter.format(avgTime / N) + "\t\t"
		                    + formatter.format(avgTime / (N * N)) + "\t\t"
		                    + formatter.format(avgTime / (N * N * N)) + "\t\t");
		            System.out.println(avgTime);
		        }
		    }
		    
		    public static void BSTShuffledOrderContainsMethod() throws IOException
		    {
		        System.out.println("BST Shuffled Order");
		        DecimalFormat formatter = new DecimalFormat("0000E0");
		        long startTime, midptTime, endTime;
		        long timesToLoop = 1000;
		        long size = 10_000;
		        long Billion = 1_000_000_000;
		        ArrayList<Integer> integerArray = new ArrayList<Integer>();
		        ArrayList<Integer> tempArray = new ArrayList<Integer>();
		        BinarySearchTree<Integer> integerBST = new BinarySearchTree<Integer>();
		        for(int N = 1000; N <= size; N+=100)
		        {
		            System.out.print(N + "\t");
		            startTime = System.nanoTime();
		            //Add N items into a list that will be added to a BST
		            for(int i = 0; i < N; i++)
		            {
		            	integerArray.add(i);
		            }
		            tempArray = new ArrayList<Integer>(integerArray);
		            //Shuffle the contents in the temp Array(Temp array is same as int array)
		            Collections.shuffle(tempArray);
		            //Add items in list to BST
		            integerBST.addAll(tempArray);
		            //Warm the System up
		            while(System.nanoTime() - startTime < Billion)
		            {
		                
		            }
		            //Time containsAll method for every element in BST
		            startTime = System.nanoTime();
		            for(long i = 0; i < timesToLoop; i++)
		            {
		                integerBST.containsAll(integerArray);
		            }
		            //Subtract the time of the empty loop
		            midptTime = System.nanoTime();
		            for(long i = 0; i < timesToLoop; i++)
		            {
		            	
		            }
		            endTime = System.nanoTime();
		            
		            //Clear the list and BST for the next loop
		            integerArray.clear();
		            integerBST.clear();
		                    
		            //Get the avgTime from subtracting the time of the method from the loop time
		            double avgTime = ((midptTime - startTime) - (endTime - midptTime)) / timesToLoop;
		            System.out.print(formatter.format(avgTime)
		                    + "\t|\t"
		                    + formatter.format(avgTime / (Math.log10(N) / Math.log10(2))) + "\t\t"
		                    + formatter.format(avgTime / N) + "\t\t"
		                    + formatter.format(avgTime / (N * N)) + "\t\t"
		                    + formatter.format(avgTime / (N * N * N)) + "\t\t");
		            System.out.println(avgTime);
		        }
		    }
		    
		    public static void TreeSetBSTShuffledOrderContainsAndAddMethod() throws IOException
		    {
		        System.out.println("TreeSet & BST Shuffled Order");
		        DecimalFormat formatter = new DecimalFormat("0000E0");
		        long startTime, midptTime, endTime;
		        long timesToLoop = 1000;
		        long size = 10_000;
		        long Billion = 1_000_000_000;
		        ArrayList<Integer> integerArray = new ArrayList<Integer>();
		        ArrayList<Integer> tempArray = new ArrayList<Integer>();
		        BinarySearchTree<Integer> integerBST = new BinarySearchTree<Integer>();
		        TreeSet<Integer> integerTreeSet = new TreeSet<Integer>();
		        for(int N = 1000; N <= size; N+=100)
		        {
		            System.out.println(N + "\t");
		            startTime = System.nanoTime();
		            for(int i = 0; i < N; i++)
		            {
		            	integerArray.add(i);
		            }
		            while(System.nanoTime() - startTime < Billion)
		            {
		                
		            }
		            tempArray = new ArrayList<Integer>(integerArray);
		            Collections.shuffle(tempArray);
		            for(long i = 0; i < timesToLoop; i++)
		            {
		            	integerTreeSet.addAll(tempArray);
		            	integerTreeSet.clear();
		            }
		            
		            midptTime = System.nanoTime();
		            for(long i = 0; i < timesToLoop; i++)
		            {
		            	integerTreeSet.clear();
		            }
		            endTime = System.nanoTime();
		            
		            integerTreeSet.addAll(tempArray);
		            System.out.println("Average Time TreeSet Add");
		            double avgTimeTreeSetAdd = ((midptTime - startTime) - (endTime - midptTime)) / timesToLoop;
		            System.out.print(formatter.format(avgTimeTreeSetAdd)
		                    + "\t|\t"
		                    + formatter.format(avgTimeTreeSetAdd / (Math.log10(N) / Math.log10(2))) + "\t\t"
		                    + formatter.format(avgTimeTreeSetAdd / N) + "\t\t"
		                    + formatter.format(avgTimeTreeSetAdd / (N * N)) + "\t\t"
		                    + formatter.format(avgTimeTreeSetAdd / (N * N * N)) + "\t\t");
		            System.out.println(avgTimeTreeSetAdd);
		            for(long i = 0; i < timesToLoop; i++)
		            {
		            	integerBST.addAll(tempArray);
		            	integerBST.clear();
		            }
		            
		            midptTime = System.nanoTime();
		            for(long i = 0; i < timesToLoop; i++)
		            {
		            	integerBST.clear();
		            }
		            endTime = System.nanoTime();
		            
		            integerBST.addAll(tempArray);
		                    
		            System.out.println("Average Time BST Add");
		            double avgTimeBSTAdd = ((midptTime - startTime) - (endTime - midptTime)) / timesToLoop;
		            System.out.print(formatter.format(avgTimeBSTAdd)
		                    + "\t|\t"
		                    + formatter.format(avgTimeBSTAdd / (Math.log10(N) / Math.log10(2))) + "\t\t"
		                    + formatter.format(avgTimeBSTAdd / N) + "\t\t"
		                    + formatter.format(avgTimeBSTAdd / (N * N)) + "\t\t"
		                    + formatter.format(avgTimeBSTAdd / (N * N * N)) + "\t\t");
		            System.out.println(avgTimeBSTAdd);
		            startTime = System.nanoTime();
		            
		            for(long i = 0; i < timesToLoop; i++)
		            {
		                integerTreeSet.containsAll(integerArray);
		            }
		            
		            midptTime = System.nanoTime();
		            for(long i = 0; i < timesToLoop; i++)
		            {
		            	
		            }
		            endTime = System.nanoTime();
		                    
		            System.out.println("Average Time TreeSet Contains");
		            double avgTimeTreeSet = ((midptTime - startTime) - (endTime - midptTime)) / timesToLoop;
		            System.out.print(formatter.format(avgTimeTreeSet)
		                    + "\t|\t"
		                    + formatter.format(avgTimeTreeSet / (Math.log10(N) / Math.log10(2))) + "\t\t"
		                    + formatter.format(avgTimeTreeSet / N) + "\t\t"
		                    + formatter.format(avgTimeTreeSet / (N * N)) + "\t\t"
		                    + formatter.format(avgTimeTreeSet / (N * N * N)) + "\t\t");
		            System.out.println(avgTimeTreeSet);
		            
		            startTime = System.nanoTime();
		            for(long i = 0; i < timesToLoop; i++)
		            {
		                integerBST.containsAll(integerArray);
		            }
		            midptTime = System.nanoTime();
		            for(long i = 0; i < timesToLoop; i++)
		            {
		            	
		            }
		            endTime = System.nanoTime();
		            
		            integerTreeSet.clear();
		            integerArray.clear();
		            integerBST.clear();
		            
		            System.out.println("Average Time BST Contains");
		            double avgTimeBST = ((midptTime - startTime) - (endTime - midptTime)) / timesToLoop;
		            System.out.print(formatter.format(avgTimeBST)
		                    + "\t|\t"
		                    + formatter.format(avgTimeBST / (Math.log10(N) / Math.log10(2))) + "\t\t"
		                    + formatter.format(avgTimeBST / N) + "\t\t"
		                    + formatter.format(avgTimeBST / (N * N)) + "\t\t"
		                    + formatter.format(avgTimeBST / (N * N * N)) + "\t\t");
		            System.out.println(avgTimeBST);

		        }
		    }
		}

		  

