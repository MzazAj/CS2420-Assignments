//package assignment06;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.DecimalFormat;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.Random;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartUtilities;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.data.xy.XYSeries;
//import org.jfree.data.xy.XYSeriesCollection;
//
///**
// * Creates a timer for the DoublyLinkedList and ArrayList
// * @author Michael Kim and Brian Rodriguez
// *
// */
//public class DoublyLinkedListTimer {
//	
//	
//	public static Random random = new Random(2);
//    public static void main(String[]args) throws IOException
//    {
//        System.out.println("\nN\tT(N)\t|\tT(N)/logN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
//        //addFirstDoublyLinkedList();
//        //getDoublyLinkedList();
//        //removeDoublyLinkedList();
//        //addArrayList();
//        //getArrayList();
//        removeArrayList();
//    }
//
//    public static void addFirstDoublyLinkedList() throws IOException
//    {
//        System.out.println("Add First Doubly Linked List");
//        XYSeriesCollection collection = new XYSeriesCollection();
//    	XYSeries series1 = new XYSeries("addFirst Method");
//        DecimalFormat formatter = new DecimalFormat("0000E0");
//        long startTime, midptTime, endTime;
//        long timesToLoop = 5000;
//        long size = 3_000_000;
//        long Billion = 1_000_000_000;
//        ArrayList<Integer> integerArray;
//        ArrayList<Integer> tempArray = new ArrayList<Integer>();;
//        DoublyLinkedList<Integer> testList = new DoublyLinkedList<Integer>();
//        for(int N = 100000; N <= size; N+=100000)
//        {
//        	int startingPoint = N - 500000;
//            System.out.print(N + "\t");
//            startTime = System.nanoTime();
//            for(int i = startingPoint; i < N; i++)
//            {
//            	testList.addFirst(0);
//            }
//            //System.out.println("\n" + testList.size() + "\n");
//            while(System.nanoTime() - startTime < Billion)
//            {
//                
//            }
//            startTime = System.nanoTime();
//            for(long i = 0; i < timesToLoop; i++)
//            {
//                testList.addFirst(0);
//            }
//            
//            midptTime = System.nanoTime();
//            for(long i = 0; i < timesToLoop; i++)
//            {
//            }
//            endTime = System.nanoTime();
//            
//                    
//            double avgTime = ((midptTime - startTime) - (endTime - midptTime)) / timesToLoop;
//            System.out.print(formatter.format(avgTime)
//                    + "\t|\t"
//                    + formatter.format(avgTime / (Math.log10(N) / Math.log10(2))) + "\t\t"
//                    + formatter.format(avgTime / N) + "\t\t"
//                    + formatter.format(avgTime / (N * N)) + "\t\t"
//                    + formatter.format(avgTime / (N * N * N)) + "\t\t");
//            System.out.println(avgTime);
//            series1.add(N, avgTime);
//            collection = new XYSeriesCollection();
//            collection.addSeries(series1);
//            JFreeChart lineChartObject = ChartFactory.createXYLineChart("Runtime vs DoublyLinkedList addFirst Method",
//                    "Size of Words (number of characters)", "Runtime in nanoseconds (ns)", collection,
//                    PlotOrientation.VERTICAL, true, true, false);
//            int width = 640;
//            int height = 480;
//            File lineChart = new File("C:/Users/user/Desktop/addFirstDoublyLinkedList.jpeg");
//            ChartUtilities.saveChartAsJPEG(lineChart, lineChartObject, width, height);
//        }
//    }
//    
//    public static void getDoublyLinkedList() throws IOException
//    {
//        System.out.println("Get Doubly Linked List");
//        XYSeriesCollection collection = new XYSeriesCollection();
//    	XYSeries series1 = new XYSeries("get Method");
//        DecimalFormat formatter = new DecimalFormat("0000E0");
//        long startTime, midptTime, endTime;
//        long timesToLoop = 1000;
//        long size = 2_000_000;
//        long Billion = 1_000_000_000;
//        ArrayList<Integer> integerArray;
//        ArrayList<Integer> tempArray = new ArrayList<Integer>();;
//        DoublyLinkedList<Integer> testList = new DoublyLinkedList<Integer>();
//        for(int N = 100000; N <= size; N+=100000)
//        {
//        	int startingPoint = N - 100000;
//            System.out.print(N + "\t");
//            int FourthofList = N/4;
//            startTime = System.nanoTime();
//            for(int i = startingPoint; i < N; i++)
//            {
//            	testList.addFirst(i);
//            } 
//            //System.out.println("\n" + testList.size() + "\n");
//            while(System.nanoTime() - startTime < Billion)
//            {
//                
//            }
//            startTime = System.nanoTime();
//            for(long i = 0; i < timesToLoop; i++)
//            {
//                testList.get(FourthofList);
//            }
//            
//            midptTime = System.nanoTime();
//            for(long i = 0; i < timesToLoop; i++)
//            {
//            	
//            }
//            endTime = System.nanoTime();
//                    
//            double avgTime = ((midptTime - startTime) - (endTime - midptTime)) / timesToLoop;
//            System.out.print(formatter.format(avgTime)
//                    + "\t|\t"
//                    + formatter.format(avgTime / (Math.log10(N) / Math.log10(2))) + "\t\t"
//                    + formatter.format(avgTime / N) + "\t\t"
//                    + formatter.format(avgTime / (N * N)) + "\t\t"
//                    + formatter.format(avgTime / (N * N * N)) + "\t\t");
//            System.out.println(avgTime);
//            series1.add(N, avgTime);
//            collection = new XYSeriesCollection();
//            collection.addSeries(series1);
//            JFreeChart lineChartObject = ChartFactory.createXYLineChart("Runtime vs DoublyLinkedList Get Method",
//                    "Size of Words (number of characters)", "Runtime in nanoseconds (ns)", collection,
//                    PlotOrientation.VERTICAL, true, true, false);
//            int width = 640;
//            int height = 480;
//            File lineChart = new File("C:/Users/user/Desktop/getDoublyLinkedList.jpeg");
//            ChartUtilities.saveChartAsJPEG(lineChart, lineChartObject, width, height);
//        }
//    }
//    
//    public static void removeDoublyLinkedList() throws IOException
//    {
//        System.out.println("Remove Doubly Linked List");
//        XYSeriesCollection collection = new XYSeriesCollection();
//    	XYSeries series1 = new XYSeries("remove Method");
//        DecimalFormat formatter = new DecimalFormat("0000E0");
//        long startTime, midptTime, endTime;
//        long timesToLoop = 1000;
//        long size = 3_000_000;
//        long Billion = 1_000_000_000;
//        ArrayList<Integer> integerArray;
//        ArrayList<Integer> tempArray = new ArrayList<Integer>();;
//        DoublyLinkedList<Integer> testList = new DoublyLinkedList<Integer>();
//        DoublyLinkedList<Integer> tempList;
//        for(int N = 100000; N <= size; N+=100000)
//        {
//        	int startingPoint = N - 100000;
//            System.out.print(N + "\t");
//            int FourthofList = N/4;
//            startTime = System.nanoTime();
//            for(int i = 0; i < N; i++)
//            {
//            	testList.addFirst(i);
//            }
//            while(System.nanoTime() - startTime < Billion)
//            {
//                
//            }
//            startTime = System.nanoTime();
//            for(long i = 0; i < timesToLoop; i++)
//            {
//                testList.remove(FourthofList);
//                //testList.add(FourthofList, FourthofList);
//                testList.addFirst(0);
//            }
//            
//            midptTime = System.nanoTime();
//            for(long i = 0; i < timesToLoop; i++)
//            {
//            	testList.addFirst(0);
//            }
//         
//            endTime = System.nanoTime();
//            
//            testList.clear();
//                   
//            //System.out.println("\n" + testList.size() + "\n");
//            double avgTime = ((midptTime - startTime) - (endTime - midptTime)) / timesToLoop;
//            System.out.print(formatter.format(avgTime)
//                    + "\t|\t"
//                    + formatter.format(avgTime / (Math.log10(N) / Math.log10(2))) + "\t\t"
//                    + formatter.format(avgTime / N) + "\t\t"
//                    + formatter.format(avgTime / (N * N)) + "\t\t"
//                    + formatter.format(avgTime / (N * N * N)) + "\t\t");
//            System.out.println(avgTime);
//            series1.add(N, avgTime);
//            collection = new XYSeriesCollection();
//            collection.addSeries(series1);
////            JFreeChart lineChartObject = ChartFactory.createXYLineChart("Runtime vs DoublyLinkedList Remove Method",
////                    "Size of Words (number of characters)", "Runtime in nanoseconds (ns)", collection,
////                    PlotOrientation.VERTICAL, true, true, false);
////            int width = 640;
////            int height = 480;
////            File lineChart = new File("C:/Users/user/Desktop/removeDoublyLinkedList.jpeg");
////            ChartUtilities.saveChartAsJPEG(lineChart, lineChartObject, width, height);
//        }
//    }
//   
//    public static void addArrayList() throws IOException
//    {
//        System.out.println("Add ArrayList");
//        XYSeriesCollection collection = new XYSeriesCollection();
//    	XYSeries series1 = new XYSeries("add Method");
//        DecimalFormat formatter = new DecimalFormat("0000E0");
//        long startTime, midptTime, endTime;
//        long timesToLoop = 1000;
//        long size = 1_000_000;
//        long Billion = 1_000_000_000;
//        ArrayList<Integer> integerArray = new ArrayList<Integer>();
//        ArrayList<Integer> tempArray = new ArrayList<Integer>();
//        DoublyLinkedList<Integer> testList = new DoublyLinkedList<Integer>();
//        for(int N = 100000; N <= size; N+=100000)
//        {
//        	int startingPoint = N - 100000;
//            System.out.print(N + "\t");
//            startTime = System.nanoTime();
//            for(int i = startingPoint; i < N; i++)
//            {
//            	integerArray.add(i);
//            }
//            while(System.nanoTime() - startTime < Billion)
//            {
//                
//            }
//            startTime = System.nanoTime();
//            for(long i = 0; i < timesToLoop; i++)
//            {
//            	tempArray = new ArrayList<Integer>(integerArray);
//                tempArray.add(0, 0);
//            }
//            
//            midptTime = System.nanoTime();
//            for(long i = 0; i < timesToLoop; i++)
//            {
//            	tempArray = new ArrayList<Integer>(integerArray);
//            }
//            endTime = System.nanoTime();
//                   
//            double avgTime = ((midptTime - startTime) - (endTime - midptTime)) / timesToLoop;
//            System.out.print(formatter.format(avgTime)
//                    + "\t|\t"
//                    + formatter.format(avgTime / (Math.log10(N) / Math.log10(2))) + "\t\t"
//                    + formatter.format(avgTime / N) + "\t\t"
//                    + formatter.format(avgTime / (N * N)) + "\t\t"
//                    + formatter.format(avgTime / (N * N * N)) + "\t\t");
//            System.out.println(avgTime);
//            series1.add(N, avgTime);
//            collection = new XYSeriesCollection();
//            collection.addSeries(series1);
////            JFreeChart lineChartObject = ChartFactory.createXYLineChart("Runtime vs ArrayList Add Method at Beginning of List",
////                    "Size of Words (number of characters)", "Runtime in nanoseconds (ns)", collection,
////                    PlotOrientation.VERTICAL, true, true, false);
////            int width = 640;
////            int height = 480;
////            File lineChart = new File("C:/Users/user/Desktop/addArrayList.jpeg");
////            ChartUtilities.saveChartAsJPEG(lineChart, lineChartObject, width, height);
//        }
//    }
//    
//    public static void getArrayList() throws IOException
//    {
//        System.out.println("Get ArrayList");
//        XYSeriesCollection collection = new XYSeriesCollection();
//    	XYSeries series1 = new XYSeries("get Method");
//        DecimalFormat formatter = new DecimalFormat("0000E0");
//        long startTime, midptTime, endTime;
//        long timesToLoop = 10000;
//        long size = 3_000_000;
//        long Billion = 1_000_000_000;
//        ArrayList<Integer> integerArray = new ArrayList<Integer>();
//        ArrayList<Integer> tempArray = new ArrayList<Integer>();;
//        DoublyLinkedList<Integer> testList = new DoublyLinkedList<Integer>();
//        for(int N = 500000; N <= size; N+=100000)
//        {
//        	int startingPoint = N - 500000;
//            System.out.print(N + "\t");
//            startTime = System.nanoTime();
//            for(int i = startingPoint; i < N; i++)
//            {
//            	integerArray.add(i);
//            }
//            while(System.nanoTime() - startTime < Billion)
//            {
//                
//            }
//            startTime = System.nanoTime();
//            for(long i = 0; i < timesToLoop; i++)
//            {
//                integerArray.get(/*random.nextInt(N)*/ 1000);
//            }
//            
//            midptTime = System.nanoTime();
//            for(long i = 0; i < timesToLoop; i++)
//            {
//            	
//            }
//            endTime = System.nanoTime();
//                    
//            double avgTime = ((midptTime - startTime) - (endTime - midptTime)) / timesToLoop;
//            System.out.print(formatter.format(avgTime)
//                    + "\t|\t"
//                    + formatter.format(avgTime / (Math.log10(N) / Math.log10(2))) + "\t\t"
//                    + formatter.format(avgTime / N) + "\t\t"
//                    + formatter.format(avgTime / (N * N)) + "\t\t"
//                    + formatter.format(avgTime / (N * N * N)) + "\t\t");
//            System.out.println(avgTime);
//            series1.add(N, avgTime);
//            collection = new XYSeriesCollection();
//            collection.addSeries(series1);
//            JFreeChart lineChartObject = ChartFactory.createXYLineChart("Runtime vs ArrayList Get Method",
//                    "Size of Words (number of characters)", "Runtime in nanoseconds (ns)", collection,
//                    PlotOrientation.VERTICAL, true, true, false);
//            int width = 640;
//            int height = 480;
//            File lineChart = new File("C:/Users/user/Desktop/getArrayList.jpeg");
//            ChartUtilities.saveChartAsJPEG(lineChart, lineChartObject, width, height);
//        }
//    }
//    
//    public static void removeArrayList() throws IOException
//    {
//        System.out.println("Remove ArrayList");
//        XYSeriesCollection collection = new XYSeriesCollection();
//    	XYSeries series1 = new XYSeries("remove Method");
//        DecimalFormat formatter = new DecimalFormat("0000E0");
//        long startTime, midptTime, endTime;
//        long timesToLoop = 1000;
//        long size = 2_000_000;
//        long Billion = 1_000_000_000;
//        ArrayList<Integer> integerArray = new ArrayList<Integer>();;
//        ArrayList<Integer> tempArray = new ArrayList<Integer>();;
//        DoublyLinkedList<Integer> testList = new DoublyLinkedList<Integer>();
//        for(int N = 100000; N <= size; N+=100000)
//        {
//        	int startingPoint = N - 100000;
//            System.out.print(N + "\t");
//            int halfofList = N/2;
//            startTime = System.nanoTime();
//            for(int i = startingPoint; i < N; i++)
//            {
//            	integerArray.add(i, i);
//            }
//            while(System.nanoTime() - startTime < Billion)
//            {
//                
//            }
//            startTime = System.nanoTime();
//            for(long i = 0; i < timesToLoop; i++)
//            {
//            	tempArray = new ArrayList<Integer>(integerArray);
//                tempArray.remove(halfofList);
//            }
//            
//            midptTime = System.nanoTime();
//            for(long i = 0; i < timesToLoop; i++)
//            {
//            	tempArray = new ArrayList<Integer>(integerArray);
//            }
//            endTime = System.nanoTime();
//                    
//            double avgTime = ((midptTime - startTime) - (endTime - midptTime)) / timesToLoop;
//            System.out.print(formatter.format(avgTime)
//                    + "\t|\t"
//                    + formatter.format(avgTime / (Math.log10(N) / Math.log10(2))) + "\t\t"
//                    + formatter.format(avgTime / N) + "\t\t"
//                    + formatter.format(avgTime / (N * N)) + "\t\t"
//                    + formatter.format(avgTime / (N * N * N)) + "\t\t");
//            System.out.println(avgTime);
//            series1.add(N, avgTime);
//            collection = new XYSeriesCollection();
//            collection.addSeries(series1);
////            JFreeChart lineChartObject = ChartFactory.createXYLineChart("Runtime vs ArrayList Remove Method",
////                    "Size of Words (number of characters)", "Runtime in nanoseconds (ns)", collection,
////                    PlotOrientation.VERTICAL, true, true, false);
////            int width = 640;
////            int height = 480;
////            File lineChart = new File("C:/Users/user/Desktop/removeArrayList.jpeg");
////            ChartUtilities.saveChartAsJPEG(lineChart, lineChartObject, width, height);
//        }
//    }
//}
