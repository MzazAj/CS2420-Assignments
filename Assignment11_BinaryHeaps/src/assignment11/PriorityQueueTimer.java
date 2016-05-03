package assignment11;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/** 
 * Timer for the PriorityQueue add(AnyType x) findMin() and deleteMin() methods
 * 
 * @author Michael Kim and Brian Rodriguez
 */
public class PriorityQueueTimer
{

    public static Random random = new Random();
            public static void main(String[]args) throws IOException
            {
                System.out.println("\nN\tT(N)\t|\tT(N)/logN\tT(N)/N\t\tT(N)/N^2\tT(N)/N^3");
                //priorityQueueAdd();
                //priorityQueueDeleteMin();
                priorityQueueFindMin();         
            }
            
            public static void priorityQueueAdd() throws IOException
            {
                System.out.println("Priority Queue Add");
                DecimalFormat formatter = new DecimalFormat("0000E0");
                long startTime, midptTime, endTime;
                long timesToLoop = 1000;
                long size = 2_000_000;
                long Billion = 1_000_000_000;
                ArrayList<Integer> list = new ArrayList<>();
                PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
                for(int N = 100000; N <= size; N+=100000)
                {
                    System.out.print(N + "\t");
                    startTime = System.nanoTime();
                    // add N items to an ArrayList
                    for(int i = 0; i < N; i++)
                    {
                        list.add(i);
                    }
                    // shuffle the ArrayList
                    Collections.shuffle(list);
                    // add the items in the ArrayList to a PriorityQueue
                    for(Integer number: list)
                    {
                        priorityQueue.add(number);
                    }
                    // warm the system up
                    while(System.nanoTime() - startTime < Billion)
                    {
                        
                    }
                    // time add(AnyType x) method by adding item around middle of PriorityQueue
                    startTime = System.nanoTime();
                    for(long i = 0; i < timesToLoop; i++)
                    {
                        priorityQueue.add(N/2);
                    }
                    // subtract the time of the loop and the add() method
                    midptTime = System.nanoTime();
                    for(long i = 0; i < timesToLoop; i++)
                    {
                        
                    }
                    endTime = System.nanoTime();

                    // clear the PriorityQueue and ArrayList for the next iteration
                    priorityQueue.clear();
                    list.clear();
                            
                    // get the avgTime from subtracting the time of the method from the loop time
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
            
            public static void priorityQueueDeleteMin() throws IOException
            {
                System.out.println("Priority Queue Delete Min");
                DecimalFormat formatter = new DecimalFormat("0000E0");
                long startTime, midptTime, endTime;
                long timesToLoop = 1000;
                long size = 2_000_000;
                long Billion = 1_000_000_000;
                ArrayList<Integer> list = new ArrayList<>();
                PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
                for(int N = 100000; N <= size; N+=100000)
                {
                    System.out.print(N + "\t");
                    startTime = System.nanoTime();
                    // add N items to an ArrayList
                    for(int i = 0; i < N; i++)
                    {
                        list.add(i);
                    }
                    // shuffle the ArrayList
                    Collections.shuffle(list);
                    // add the items in the ArrayList to a PriorityQueue
                    for(Integer number: list)
                    {
                        priorityQueue.add(number);
                    }
                    // warm the system up
                    while(System.nanoTime() - startTime < Billion)
                    {
                        
                    }
                    // time deleteMin() method making sure to add an element each time you delete one
                    startTime = System.nanoTime();
                    for(long i = 0; i < timesToLoop; i++)
                    {
                        priorityQueue.deleteMin();
//                        priorityQueue.add(0);
                    }
                    // subtract the time of the loop and the add() method
                    midptTime = System.nanoTime();
//                    for(long i = 0; i < timesToLoop; i++)
//                    {
//                        priorityQueue.add(0);
//                    }
                    endTime = System.nanoTime();

                    // clear the PriorityQueue and ArrayList for the next iteration
                    priorityQueue.clear();
                    list.clear();
                            
                    // get the avgTime from subtracting the time of the method from the loop time
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
            
            public static void priorityQueueFindMin() throws IOException
            {
                System.out.println("Priority Queue Find Min");
                DecimalFormat formatter = new DecimalFormat("0000E0");
                long startTime, midptTime, endTime;
                long timesToLoop = 1000;
                long size = 2_000_000;
                long Billion = 1_000_000_000;
                PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
                for(int N = 100000; N <= size; N+=100000)
                {
                    System.out.print(N + "\t");
                    startTime = System.nanoTime();
                    for(int i = 0; i < N; i++)
                    {
                        priorityQueue.add(i);
                    }
                    // warm the system up
                    while(System.nanoTime() - startTime < Billion)
                    {
                        
                    }
                    // time findMin() method
                    startTime = System.nanoTime();
                    for(long i = 0; i < timesToLoop; i++)
                    {
                        priorityQueue.findMin();
                    }
                    // subtract the time of the empty loop
                    midptTime = System.nanoTime();
                    for(long i = 0; i < timesToLoop; i++)
                    {
                        
                    }
                    endTime = System.nanoTime();

                    // clear the priorityQueue for the next iteration
                    priorityQueue.clear();
                    
                    // get the avgTime from subtracting the time of the method from the loop time
                    double avgTimeTreeSetAdd = ((midptTime - startTime) - (endTime - midptTime)) / timesToLoop;
                    System.out.print(formatter.format(avgTimeTreeSetAdd)
                            + "\t|\t"
                            + formatter.format(avgTimeTreeSetAdd / (Math.log10(N) / Math.log10(2))) + "\t\t"
                            + formatter.format(avgTimeTreeSetAdd / N) + "\t\t"
                            + formatter.format(avgTimeTreeSetAdd / (N * N)) + "\t\t"
                            + formatter.format(avgTimeTreeSetAdd / (N * N * N)) + "\t\t");
                    System.out.println(avgTimeTreeSetAdd);

                }
            }
        }