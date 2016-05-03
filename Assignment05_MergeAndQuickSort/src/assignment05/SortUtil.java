package assignment05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class SortUtil {

    private static int mergesortThreshold = 5;
    private static int quicksortThreshold = 5;
    private static int pivotSelect = 0;
    
    
    /**
     * This method performs a mergesort on the generic ArrayList given as input.
     * @param array
     * @param comparator
     */
    public static<T> void mergesort(ArrayList<T> array, Comparator<? super T> comparator)
    {
		if(array.size() <= 1)
		{
			return;
		}
		
        T[] temp = (T[]) new Object[array.size()];
        
//        ArrayList<T> temp2 = new ArrayList<>(array.size());
//        for(int i = 0; i < array.size(); i++)
//        {
//            temp2.add(null);
//        }
          mergesortRecursive(array, temp, 0, array.size()-1 , comparator);
    }
    
//    private static<T> void mergesort(ArrayList<T> array, ArrayList<T> temp, int left, int right, Comparator<? super T> comparator)
//    {
//        if (left + mergesortThreshold > right)
//        {
//            insertionSort(array, left, right, comparator);
//        }
//        else {
//            int mid = (left + right) / 2;
//            mergesort(array, temp, left, mid, comparator);
//            mergesort(array, temp, mid+1, right, comparator);
//            merge(array, temp, left, mid+1, right, comparator);
//        }
//    }
    
    /**
     * Performs mergesort on the the the input ArrayList using recursive calls. If the threshold is greater than size of the subarray
     * then perform insertion sort on the subarray else it does mergesort until it reaches this threshold.
     * @param array
     * @param temp
     * @param left
     * @param right
     * @param comparator
     */
    private static <T> void mergesortRecursive(ArrayList<T> array, T[] temp, int left, int right, Comparator<? super T> comparator)
    {
        if (left + mergesortThreshold > right)
        {
            insertionSort(array, left, right, comparator);
        }
        else 
        {
            int mid = (left + right) / 2;
            mergesortRecursive(array, temp, left, mid, comparator);
            mergesortRecursive(array, temp, mid+1, right, comparator);
            merge(array, temp, left, mid+1, right, comparator);
        }
    }
    
    
//    private static <T> void merge (ArrayList<T> arr, ArrayList<T> temp, int leftPos, int middle, int rightEnd, Comparator<? super T> c)
//    {
//        int leftEnd = middle - 1;
//        int tempPos = leftPos;
//        int numberOfElements = rightEnd - leftPos + 1;
//        
//        while(leftPos <= leftEnd && middle <= rightEnd)
//        {
//            if(c.compare(arr.get(leftPos),arr.get(middle)) <= 0)
//            {
//                temp.set(tempPos, arr.get(leftPos));
//                tempPos++;
//                leftPos++;
//                //System.out.println(tempPos);
//            }
//            else
//            {
//                temp.set(tempPos, arr.get(middle));
//                tempPos++;
//                middle++;
//                //System.out.println(tempPos);
//            }
//        }   
//            
//        while (leftPos <= leftEnd)
//            {
//                temp.set(tempPos, arr.get(leftPos));
//                tempPos++;
//                leftPos++;
//                //System.out.println(tempPos);
//            }
//
//        while (middle <= rightEnd)
//            {
//                temp.set(tempPos, arr.get(middle));
//                tempPos++;
//                middle++;
//            }
//            
//        for(int i = 0; i < numberOfElements; i++, rightEnd--)
//            {
//                arr.set(rightEnd, temp.get(rightEnd));
//            }
//    }
    
    /**
     * Sorts two subarrays and merges them back into one whole array
     * @param arr inputArray that you are trying to merge
     * @param temp the temp array that is used to merge the two subarrays
     * @param leftPos is the left most index of the subarray
     * @param middle is the exact middle of the subarray
     * @param rightEnd RightEnd is the end of the subarray
     * @param c is the comparator using to compare two objects
     */
    private static <T> void merge (ArrayList<T> arr, T[] temp, int leftPos, int middle, int rightEnd, Comparator<? super T> c)
    {
        int leftEnd = middle - 1;
        int tempPos = leftPos;
        int numberOfElements = rightEnd - leftPos + 1;
        
        while(leftPos <= leftEnd && middle <= rightEnd)
        {
        	//if left pos is less than or equal to middle then set tempPos to the item at leftPos
            if(c.compare(arr.get(leftPos),arr.get(middle)) <= 0)
            {
                temp[tempPos] = arr.get(leftPos);
                tempPos++;
                leftPos++;
            }
            //else sets the tempPos to item at middle
            else
            {
                temp[tempPos] = arr.get(middle);
                tempPos++;
                middle++;
            }
        }   
        //if the leftPos is less than the leftEnd then add all the elements from leftPos to leftEnd to the temp
        while (leftPos <= leftEnd)
            {
                temp[tempPos] = arr.get(leftPos);
                tempPos++;
                leftPos++;
            }
        //if the middle is less than the rightEnd then add all the elements from middle to rightEnd to the temp
        while (middle <= rightEnd)
            {
                temp[tempPos] = arr.get(middle);
                tempPos++;
                middle++;
            }
            
        for(int i = 0; i < numberOfElements; i++, rightEnd--)
            {
                arr.set(rightEnd, temp[rightEnd]);
            }
    }
    
    /**
     * Sorts the array using insertion sort when the base case is reached
     * @param array the array being passed in
     * @param left the start of the array
     * @param right the end of the array
     * @param comparator used to compare the objects
     */
    private static <T> void insertionSort(ArrayList<T> array, int left, int right, Comparator<? super T> comparator)
    {
        for (int sorted = left + 1; sorted <= right; sorted++) {
            T temp = array.get(sorted);
            int unsorted = sorted;
            while (unsorted > left && comparator.compare(temp, array.get(unsorted - 1)) < 0)
            {
                array.set(unsorted, array.get(unsorted - 1));
                unsorted--;
            }
            array.set(unsorted, temp);
        }
    }
    
    /**
     * The driver method for quicksort. First tests the base case then starts the first recursive call
     * @param array
     * @param comparator
     */
    public static <T> void quicksort(ArrayList<T> array, Comparator<? super T> comparator)
    {
        if(array.size() <= 1)
        {
            return;
        }
        quicksortRecursive(array, 0, array.size() - 1, comparator);
    }
    
    
    /**
     * Recursively sorts the list using a quicksort algorithm
     * @param array
     * @param left First index of that array
     * @param right last index of the array
     * @param comparator comparator used to compare the objects
     */
    private static<T> void quicksortRecursive(ArrayList<T> array, int left, int right, Comparator<? super T> comparator)
    {
        if(left + quicksortThreshold > right)
        {
            insertionSort(array, left, right, comparator);
        }
        else{
            T pivot;
            partition(array, left, right, comparator);
            pivot = array.get(right);
            int leftCursor = left-1;
            int rightCursor = right;
            
            while(true)
            {
            	//starts from the left to find the value greater than the pivot
                while(leftCursor < right && comparator.compare(array.get(++leftCursor),(pivot)) < 0)
                {
                    
                }
                //starts from right to find a value less than the pivot but skips the pivot
                while(rightCursor > left && comparator.compare((array.get(--rightCursor)), pivot) > 0)
                {
                    
                }
                //if the positions equal eachother then it breaks out of the while loop
                if(leftCursor >= rightCursor)
                {
                    break;
                }
                //if it finds a value that is less than or greater then it swaps the values
                swap(array, leftCursor, rightCursor);
            }
            swap(array, leftCursor, right);
            quicksortRecursive(array, left, leftCursor - 1, comparator);
            quicksortRecursive(array, leftCursor + 1, right, comparator);
            
        }
    }
    
    /**
     * Selects the pivot depending on the value of pivot select.
     * if it is 0 swaps the middle one
     * if it is 1 swaps the quarter index
     * if it is 2 it takes the median of the first, middle and end
     * @param array
     * @param left
     * @param right
     * @param comparator
     */
    private static<T> void partition(ArrayList<T> array, int left, int right, Comparator<? super T> comparator)
    {
        int middle = left + (right-left) / 2;
        if(pivotSelect == 0)
        {   
            swap(array, middle, right);
        }
        else if(pivotSelect == 1)
        {
            int quarter = left + (right-left) / 4;
            swap(array, quarter, right);
        }
        else if(pivotSelect == 2)
        {
            if(comparator.compare(array.get(middle), (array.get(left))) < 0)
            {
                swap(array, left , middle);
            }
            if(comparator.compare(array.get(right), (array.get(left)))<0)
            {
                swap(array, left, right);
            }
            if(comparator.compare(array.get(right), (array.get(middle)))< 0)
            {
                swap(array, middle, right);
            }
            swap(array, middle, right);
        }
        else
        {
            swap(array, left, right);
        }
        
    }
    /**
     * This method generates and returns an ArrayList of integers 1 to size in ascending order.
     * @param size
     * @return
     */
    public static ArrayList<Integer> generateBestCase(int size)
    {
        ArrayList<Integer> temp = new ArrayList<>();
        
        for(int i = 1; i <= size; i++)
        {
            temp.add(i);
        }
        return temp;
    }
    
    /**
     * This method generates and returns an ArrayList of integers 1 to size in permuted order (i,e., randomly ordered). 
     * @param size
     * @return
     */
    public static ArrayList<Integer> generateAverageCase (int size)
    {
        
        Random random = new Random(22);
        ArrayList<Integer> temp = generateBestCase(size);
        for(int i = 0; i < size; i++)
        {
            swap(temp, i, random.nextInt(size));
        }
        return temp;
    }
    
    /**
     * This method generates and returns an ArrayList of integers 1 to size in descending order.
     * @param size
     * @return
     */
    public static ArrayList<Integer> generateWorstCase (int size)
    {
        ArrayList<Integer> temp = new ArrayList<>();
        
        for(int i = size; i > 0; i--)
        {
            temp.add(i);
        }
        return temp;
    }
    
    /**
     * Swaps the value of the two indices 
     * @param array
     * @param index1
     * @param index2
     */
    private static <T> void swap (ArrayList<T> array, int index1, int index2)
    {
        T temp = array.get(index1);
        array.set(index1, array.get(index2));
        array.set(index2, temp);
    }

    /**
     * Sets the threshhold for mergesort
     * @param threshold
     */
    public static void setThresholdMergeSort(int threshold) 
    {
        mergesortThreshold = threshold;
    }
    /**
     * Sets the threshold for quicksort
     * @param threshold
     */
    public static void setThresholdQuickSort(int threshold)
    {
        quicksortThreshold = threshold;
    }
}
