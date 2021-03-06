package assignment11;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Represents a priority queue of generically-typed items. 
 * The queue is implemented as a min heap. 
 * The min heap is implemented implicitly as an array.
 * 
 * @author 
 */
@SuppressWarnings("unchecked")
public class PriorityQueue<AnyType> {

    private int currentSize;

    private AnyType[] array;

    private Comparator<? super AnyType> cmp;

    /**
     * Constructs an empty priority queue. Orders elements according
     * to their natural ordering (i.e., AnyType is expected to be Comparable)
     * AnyType is not forced to be Comparable.
     */
    
    public PriorityQueue() {
        currentSize = 0;
        cmp = null;
        array = (AnyType[]) new Object[10]; // safe to ignore warning
    }

    /**
     * Construct an empty priority queue with a specified comparator.
     * Orders elements according to the input Comparator (i.e., AnyType need not
     * be Comparable).
     */
    public PriorityQueue(Comparator<? super AnyType> c) {
        currentSize = 0;
        cmp = c;
        array = (AnyType[]) new Object[10]; // safe to ignore warning
    }

    /**
     * @return the number of items in this priority queue.
     */
    public int size() {
        return currentSize;
    }

    /**
     * Makes this priority queue empty.
     */
    public void clear() {
        currentSize = 0;
    }

    /**
     * @return the minimum item in this priority queue.
     * @throws NoSuchElementException if this priority queue is empty.
     * 
     * (Runs in constant time.)
     */
    public AnyType findMin() throws NoSuchElementException {
        // FILL IN -- do not return null
        if(currentSize == 0)
        {
            throw new NoSuchElementException();
        }
        else
        {
            return array[0];
        }
    }


    /**
     * Removes and returns the minimum item in this priority queue.
     * 
     * @throws NoSuchElementException if this priority queue is empty.
     * 
     * (Runs in logarithmic time.)
     */
    public AnyType deleteMin() throws NoSuchElementException {
        // FILL IN -- do not return null

        // if the heap is empty, throw a NoSuchElementException

        // store the minimum item so that it may be returned at the end

        // replace the item at minIndex with the last item in the tree

        // update size
        
        // percolate the item at minIndex down the tree until heap order is restored
        // It is STRONGLY recommended that you write a percolateDown helper method!

        // return the minimum item that was stored

        if(currentSize == 0)
        {
            throw new NoSuchElementException();
        }
        AnyType minItem = array[0];
        array[0] = array[currentSize - 1];
        array[currentSize - 1] = null;
        currentSize--;
        percolateDown(0);
        return minItem;
    }
    
    private void percolateDown(int index)
    {
        if(index == currentSize - 1)
        {
            return;
        }
        
        AnyType temp = array[index];
        AnyType left;
        AnyType right;
        if(2*index + 1 > currentSize)
        {
            left = null;
        }
        else
        {
            left = array[2*index + 1];
        }
        if(2*index + 2 > currentSize)
        {
            right = null;
        }
        else
        {
            right = array[2*index + 2];
        }
        
        if(left == null && right == null)
        {
            return;
        }
        if((right != null && left != null))
        {
            if(compare(temp, left) <= 0 && compare(temp, right) <= 0)
            {
                return;
            }
            else if(compare(right, left) < 0)
            {
                array[index] = array[2*index + 2];
                array[2*index + 2] = temp;
                percolateDown(2*index + 2);     
            }
            else
            {
                array[index] = array[2*index + 1];
                array[2*index + 1] = temp;
                percolateDown(2*index + 1);
            }
        }
        else
        {
            if(left == null && compare(temp, right) <= 0)
            {
                return;
            }
            else if(left == null && compare(temp, right) > 0)
            {
                array[index] = right;
                array[2*index + 2] = temp;
                percolateDown(2*index + 2);
                return;
            }
            if(right == null && compare(temp,left) <= 0)
            {
                return;
            }
            else if (right == null && compare(temp, left) > 0)
            {
                array[index] = left;
                array[2*index + 1] = temp;
                percolateDown(2*index + 1);
                return;
            }
        }
    }

    /**
     * Adds an item to this priority queue.
     * 
     * (Runs in logarithmic time.) Can sometimes terminate early.
     * 
     * @param x -- the item to be inserted
     */
    public void add(AnyType x) {
        // FILL IN

        // if the array is full, double its capacity

        // add the new item to the next available node in the tree, so that
        // complete tree structure is maintained

        // update size

        // percolate the new item up the levels of the tree until heap order is restored
        // It is STRONGLY recommended that you write a percolateUp helper method!

        if(x == null)
        {
            return;
        }
        if(currentSize == array.length)
        {
            AnyType[] temp = (AnyType[]) new Object[array.length * 2];
            for(int i = 0; i < currentSize; i++)
            {
                temp[i] = array[i];
            }
            array = temp;
        }
        array[currentSize] = x;
        percolateUp(currentSize);
        currentSize++;
    }
    
    private void percolateUp(int index)
    {
        AnyType temp = array[index];
        if(compare(temp, array[(index - 1) / 2]) >= 0)
        {
            return;
        }
        else
        {
            array[index] = array[(index - 1) / 2];
            array[(index - 1) / 2] = temp;
            percolateUp((index - 1) / 2);
        }
    }

    /**
     * Generates a DOT file for visualizing the binary heap.
     */
    public void generateDotFile(String filename) {
        try(PrintWriter out = new PrintWriter(filename)) {
            out.println("digraph Heap {\n\tnode [shape=record]\n");

            for(int i = 0; i < currentSize; i++) {
                out.println("\tnode" + i + " [label = \"<f0> |<f1> " + array[i] + "|<f2> \"]");
                if(((i*2) + 1) < currentSize)
                    out.println("\tnode" + i + ":f0 -> node" + ((i*2) + 1) + ":f1");
                if(((i*2) + 2) < currentSize)
                    out.println("\tnode" + i + ":f2 -> node" + ((i*2) + 2) + ":f1");
            }
            out.println("}");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Internal method for comparing lhs and rhs using Comparator if provided by the
     * user at construction time, or Comparable, if no Comparator was provided.
     */
    private int compare(AnyType lhs, AnyType rhs) {
        if (cmp == null) {
            return ((Comparable<? super AnyType>) lhs).compareTo(rhs); // safe to ignore warning
        }
        // We won't test your code on non-Comparable types if we didn't supply a Comparator

        return cmp.compare(lhs, rhs);
    }



    //LEAVE IN for grading purposes
    public Object[] toArray() {    
        Object[] ret = new Object[currentSize];
        for(int i = 0; i < currentSize; i++) {
            ret[i] = array[i];
        }
        return ret;
    }
}