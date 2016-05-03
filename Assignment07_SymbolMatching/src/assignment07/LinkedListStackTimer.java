package assignment07;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartUtilities;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.data.xy.XYSeries;
//import org.jfree.data.xy.XYSeriesCollection;
	

/**
 * Timer for LinkedListStack
 * 
 * @author Brian Rodriguez and Michael Kim
 *
 */
public class LinkedListStackTimer {
		
	    public static void main(String[]args) throws IOException
	    {
	        System.out.println("\nN\tT(N)\t|\tT(N)/logN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
	        stackPushMethod();
	        //stackPopMethod();
	        //stackPeekMethod();
	       
	    }

	    public static void stackPushMethod() throws IOException
	    {
	        System.out.println("LinkedListStack Push");
//	        XYSeriesCollection collection = new XYSeriesCollection();
//	    	XYSeries series1 = new XYSeries("addFirst Method");
	        DecimalFormat formatter = new DecimalFormat("0000E0");
	        long startTime, midptTime, endTime;
	        long timesToLoop = 100;
	        long size = 5_000_000;
	        long Billion = 1_000_000_000;
	        ArrayList<Integer> integerArray;
	        ArrayList<Integer> tempArray = new ArrayList<Integer>();
	        LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
	        for(int N = 100_000; N <= size; N+=100_000)
	        {
	        	int startingPoint = N - 100000;
	            System.out.print(N + "\t");
	            startTime = System.nanoTime();
	            for(int i = startingPoint; i < N; i++)
	            {
	            	stack.push(0);
	            }
	            //System.out.println("\n" + testList.size() + "\n");
	            while(System.nanoTime() - startTime < Billion)
	            {
	                
	            }
	            startTime = System.nanoTime();
	            for(long i = 0; i < timesToLoop; i++)
	            {
	                stack.push(0);
	                stack.pop();
	            }
	            
	            midptTime = System.nanoTime();
	            for(long i = 0; i < timesToLoop; i++)
	            {
	            	stack.push(0);
	            }
	            endTime = System.nanoTime();
	            for(long i = 0; i < timesToLoop; i++)
	            {
	            	stack.pop();
	            }
	            
	                    
	            double avgTime = ((midptTime - startTime) - (endTime - midptTime)) / timesToLoop;
	            System.out.print(formatter.format(avgTime)
	                    + "\t|\t"
	                    + formatter.format(avgTime / (Math.log10(N) / Math.log10(2))) + "\t\t"
	                    + formatter.format(avgTime / N) + "\t\t"
	                    + formatter.format(avgTime / (N * N)) + "\t\t"
	                    + formatter.format(avgTime / (N * N * N)) + "\t\t");
	            System.out.println(avgTime);
//	            series1.add(N, avgTime);
//	            collection = new XYSeriesCollection();
//	            collection.addSeries(series1);
//	            JFreeChart lineChartObject = ChartFactory.createXYLineChart("Runtime vs LinkedListStack Push Method",
//	                    "Size of List (Number of Elements)", "Runtime in nanoseconds (ns)", collection,
//	                    PlotOrientation.VERTICAL, true, true, false);
//	            int width = 640;
//	            int height = 480;
//	            File lineChart = new File("C:/Users/user/Desktop/LinkedListStackPushMethod.jpeg");
//	            ChartUtilities.saveChartAsJPEG(lineChart, lineChartObject, width, height);
	        }
	    }
	    public static void stackPopMethod() throws IOException
	    {
	        System.out.println("LinkedListStack Pop");
//	        XYSeriesCollection collection = new XYSeriesCollection();
//	    	XYSeries series1 = new XYSeries("addFirst Method");
	        DecimalFormat formatter = new DecimalFormat("0000E0");
	        long startTime, midptTime, endTime;
	        long timesToLoop = 1000;
	        long size = 5_000_000;
	        long Billion = 1_000_000_000;
	        ArrayList<Integer> integerArray;
	        ArrayList<Integer> tempArray = new ArrayList<Integer>();
	        LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
	        for(int N = 100000; N <= size; N+=100_000)
	        {
	        	int startingPoint = N - 100000;
	            System.out.print(N + "\t");
	            startTime = System.nanoTime();
	            for(int i = startingPoint; i < N; i++)
	            {
	            	stack.push(0);
	            }
	            //System.out.println("\n" + testList.size() + "\n");
	            while(System.nanoTime() - startTime < Billion)
	            {
	                
	            }
	            startTime = System.nanoTime();
	            for(long i = 0; i < timesToLoop; i++)
	            {
	                stack.pop();
	                stack.push(0);
	            }
	            
	            midptTime = System.nanoTime();
	            for(long i = 0; i < timesToLoop; i++)
	            {
	            	stack.push(0);
	            }
	            endTime = System.nanoTime();
	            for(long i = 0; i < timesToLoop; i++)
	            {
	            	stack.pop();
	            }
	            
	                    
	            double avgTime = ((midptTime - startTime) - (endTime - midptTime)) / timesToLoop;
	            System.out.print(formatter.format(avgTime)
	                    + "\t|\t"
	                    + formatter.format(avgTime / (Math.log10(N) / Math.log10(2))) + "\t\t"
	                    + formatter.format(avgTime / N) + "\t\t"
	                    + formatter.format(avgTime / (N * N)) + "\t\t"
	                    + formatter.format(avgTime / (N * N * N)) + "\t\t");
	            System.out.println(avgTime);
//	            series1.add(N, avgTime);
//	            collection = new XYSeriesCollection();
//	            collection.addSeries(series1);
//	            JFreeChart lineChartObject = ChartFactory.createXYLineChart("Runtime vs LinkedListStack Pop Method",
//	                    "Size of List (Number of Elements)", "Runtime in nanoseconds (ns)", collection,
//	                    PlotOrientation.VERTICAL, true, true, false);
//	            int width = 640;
//	            int height = 480;
//	            File lineChart = new File("C:/Users/user/Desktop/LinkedListStackPopMethod.jpeg");
//	            ChartUtilities.saveChartAsJPEG(lineChart, lineChartObject, width, height);
	        }
	    }
	    public static void stackPeekMethod() throws IOException
	    {
	        System.out.println("LinkedListStack Peek");
//	        XYSeriesCollection collection = new XYSeriesCollection();
//	    	XYSeries series1 = new XYSeries("addFirst Method");
	        DecimalFormat formatter = new DecimalFormat("0000E0");
	        long startTime, midptTime, endTime;
	        long timesToLoop = 260;
	        long size = 5_000_000;
	        long Billion = 1_000_000_000;
	        ArrayList<Integer> integerArray;
	        ArrayList<Integer> tempArray = new ArrayList<Integer>();
	        LinkedListStack<Integer> stack = new LinkedListStack<Integer>();
	        for(int N = 100_000; N <= size; N+=100000)
	        {
	        	int startingPoint = N - 100000;
	            System.out.print(N + "\t");
	            startTime = System.nanoTime();
	            for(int i = startingPoint; i < N; i++)
	            {
	            	stack.push(0);
	            }
	            //System.out.println("\n" + testList.size() + "\n");
	            while(System.nanoTime() - startTime < Billion)
	            {
	                
	            }
	            startTime = System.nanoTime();
	            for(long i = 0; i < timesToLoop; i++)
	            {
	                stack.peek();
	            }
	            
	            midptTime = System.nanoTime();
	            for(long i = 0; i < timesToLoop; i++)
	            {
	            }
	            endTime = System.nanoTime();
	            
	                    
	            double avgTime = ((midptTime - startTime) - (endTime - midptTime)) / timesToLoop;
	            System.out.print(formatter.format(avgTime)
	                    + "\t|\t"
	                    + formatter.format(avgTime / (Math.log10(N) / Math.log10(2))) + "\t\t"
	                    + formatter.format(avgTime / N) + "\t\t"
	                    + formatter.format(avgTime / (N * N)) + "\t\t"
	                    + formatter.format(avgTime / (N * N * N)) + "\t\t");
	            System.out.println(avgTime);
//	            series1.add(N, avgTime);
//	            collection = new XYSeriesCollection();
//	            collection.addSeries(series1);
//	            JFreeChart lineChartObject = ChartFactory.createXYLineChart("Runtime vs LinkedListStack Peek Method",
//	                    "Size of List (Number of Elements)", "Runtime in nanoseconds (ns)", collection,
//	                    PlotOrientation.VERTICAL, true, true, false);
//	            int width = 640;
//	            int height = 480;
//	            File lineChart = new File("C:/Users/user/Desktop/LinkedListStackPeekMethod.jpeg");
//	            ChartUtilities.saveChartAsJPEG(lineChart, lineChartObject, width, height);
	        }
	    }
}

	  