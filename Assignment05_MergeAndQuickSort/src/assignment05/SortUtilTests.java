package assignment05;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

public class SortUtilTests {
	
	static Comparator<Integer> comparator;
	
	static Comparator<Integer> reversedComp;
	
	static Comparator<String> stringComp;
	
	static Comparator<Character> charComp;
	
	@BeforeClass
	public static void comparators ()
	{
		comparator = new Comparator <Integer> ()
		{

			@Override
			public int compare(Integer o1, Integer o2) 
			{
				if(o1 == null || o2 == null)
				{
					
				}
				
				return o1.compareTo(o2);
			}
	
		};
		
		reversedComp = new Comparator <Integer>()
		{

			@Override
			public int compare(Integer o1, Integer o2) 
			{
				if(o1.compareTo(o2) == -1)
				{
					return 1;
				}
				else if (o1.compareTo(o2) == 1)
				{
					return -1;
				}
				else
				{
					return 0;
				}
			}
	
		};
		
		stringComp = new Comparator <String>()
		{

			@Override
			public int compare(String o1, String o2) 
			{
				return o1.compareTo(o2);
			}
	
		};
		
		charComp = new Comparator <Character>()
				{

					@Override
					public int compare(Character o1, Character o2) 
					{
						return o1.compareTo(o2);
					}
			
				};
		
	}

	@Test
	public void testMegresortEdge() 
	{
		ArrayList<Integer> array = new ArrayList<Integer>();

		SortUtil.mergesort(array, comparator);
		
		assertEquals(true, array.equals(array));
	}

	@Test
	public void testMergesortHugeArrayAscendingOrderInteger ()
	{
		
		ArrayList<Integer> array = SortUtil.generateBestCase(10000);
				
		ArrayList<Integer> shuffledArray = 	SortUtil.generateAverageCase(10000);

		SortUtil.mergesort(shuffledArray, comparator);
		
		assertEquals(true, array.equals(shuffledArray));
		
		array = SortUtil.generateBestCase(1000000);
		
		shuffledArray = SortUtil.generateAverageCase(1000000);
		
		SortUtil.mergesort(shuffledArray, comparator);
		
		assertEquals(true, array.equals(shuffledArray));
		
		array = SortUtil.generateBestCase(10000000);
		
		shuffledArray = SortUtil.generateAverageCase(10000000);
		
		SortUtil.mergesort(shuffledArray, comparator);
		
		assertEquals(true, array.equals(shuffledArray));
	}
	
	@Test
	public void testMergesortSmallArraysReverseOrderInteger ()
	{
		ArrayList<Integer> array = SortUtil.generateWorstCase(500);
		
		ArrayList<Integer> shuffledArray = 	SortUtil.generateAverageCase(500);

		SortUtil.mergesort(shuffledArray, reversedComp);
		
		assertEquals(true, array.equals(shuffledArray));
		
		array = SortUtil.generateWorstCase(1000);
		
		shuffledArray = SortUtil.generateAverageCase(1000);
		
		SortUtil.mergesort(shuffledArray, reversedComp);
		
		assertEquals(true, array.equals(shuffledArray));
		
		array = SortUtil.generateWorstCase(5000);
		
		shuffledArray = SortUtil.generateAverageCase(5000);
		
		SortUtil.mergesort(shuffledArray, reversedComp);
		
		assertEquals(true, array.equals(shuffledArray));
	}
	
	@Test
	public void testMergesortLargeArraysReverseOrderedIntegers ()
	{
		ArrayList<Integer> array = SortUtil.generateWorstCase(100000);
		
		ArrayList<Integer> shuffledArray = 	SortUtil.generateAverageCase(100000);

		SortUtil.mergesort(shuffledArray, reversedComp);
		
		assertEquals(true, array.equals(shuffledArray));
		
		array = SortUtil.generateWorstCase(1000000);
		
		shuffledArray = SortUtil.generateAverageCase(1000000);
		
		SortUtil.mergesort(shuffledArray, reversedComp);
		
		assertEquals(true, array.equals(shuffledArray));
		
		array = SortUtil.generateWorstCase(10000000);
		
		shuffledArray = SortUtil.generateAverageCase(10000000);
		
		SortUtil.mergesort(shuffledArray, reversedComp);
		
		assertEquals(true, array.equals(shuffledArray));
	}
	
	@Test
	public void testMergesortSmallArrayStrings ()
	{
		ArrayList<String> shuffledArray = new ArrayList<String>();
		
		ArrayList<String> orderedArray = new ArrayList<String>();
		
		shuffledArray.add("qwerty");
		shuffledArray.add("deadpool");
		shuffledArray.add("spiderman");
		shuffledArray.add("batman");
		shuffledArray.add("wolverine");
		
		orderedArray.add("batman");
		orderedArray.add("deadpool");
		orderedArray.add("qwerty");
		orderedArray.add("spiderman");
		orderedArray.add("wolverine");
		
		SortUtil.mergesort(shuffledArray, stringComp);
		
		assertEquals(true, orderedArray.equals(shuffledArray));
	}
	
	@Test
	public void testMergesortWithCharacters ()
	{
		ArrayList<Character> shuffledArray = new ArrayList<>();
		
		ArrayList<Character> orderedArray = new ArrayList<>();
		
		shuffledArray.add('m');
		shuffledArray.add('l');
		shuffledArray.add('y');
		shuffledArray.add('q');
		shuffledArray.add('p');
		
		orderedArray.add('l');
		orderedArray.add('m');
		orderedArray.add('p');
		orderedArray.add('q');
		orderedArray.add('y');
		
		SortUtil.mergesort(shuffledArray, charComp);
		
		assertEquals(true, orderedArray.equals(shuffledArray));
	}
	
	@Test
	public void testQuicksortEdgecases ()
	{
		ArrayList<Integer> array = new ArrayList<Integer>();

		SortUtil.mergesort(array, comparator);
		
		assertEquals(true, array.equals(array));
	}
	
	@Test
	public void testQuicksortLargeArraysAscendingOrderIntegers ()
	{
		ArrayList<Integer> array = SortUtil.generateBestCase(10000);
		
		ArrayList<Integer> shuffledArray = 	SortUtil.generateAverageCase(10000);

		SortUtil.quicksort(shuffledArray, comparator);
		
		assertEquals(true, array.equals(shuffledArray));
		
		array = SortUtil.generateBestCase(1000000);
		
		shuffledArray = SortUtil.generateAverageCase(1000000);
		
		SortUtil.quicksort(shuffledArray, comparator);
		
		assertEquals(true, array.equals(shuffledArray));
		
		array = SortUtil.generateBestCase(10000000);
		
		shuffledArray = SortUtil.generateAverageCase(10000000);
		
		SortUtil.quicksort(shuffledArray, comparator);
		
		assertEquals(true, array.equals(shuffledArray));
	}
	
	@Test
	public void testQuicksortSmallArrayReversedOrderInteger ()
	{
		ArrayList<Integer> array = SortUtil.generateWorstCase(500);
		
		ArrayList<Integer> shuffledArray = 	SortUtil.generateAverageCase(500);

		SortUtil.quicksort(shuffledArray, reversedComp);
		
		assertEquals(true, array.equals(shuffledArray));
		
		array = SortUtil.generateWorstCase(1000);
		
		shuffledArray = SortUtil.generateAverageCase(1000);
		
		SortUtil.quicksort(shuffledArray, reversedComp);
		
		assertEquals(true, array.equals(shuffledArray));
		
		array = SortUtil.generateWorstCase(5000);
		
		shuffledArray = SortUtil.generateAverageCase(5000);
		
		SortUtil.quicksort(shuffledArray, reversedComp);
		
		assertEquals(true, array.equals(shuffledArray));
	}
	
	@Test
	public void testQuicksortLargeArraysReverseOrderedIntegers ()
	{
		ArrayList<Integer> array = SortUtil.generateWorstCase(100000);
		
		ArrayList<Integer> shuffledArray = 	SortUtil.generateAverageCase(100000);

		SortUtil.quicksort(shuffledArray, reversedComp);
		
		assertEquals(true, array.equals(shuffledArray));
		
		array = SortUtil.generateWorstCase(1000000);
		
		shuffledArray = SortUtil.generateAverageCase(1000000);
		
		SortUtil.quicksort(shuffledArray, reversedComp);
		
		assertEquals(true, array.equals(shuffledArray));
		
		array = SortUtil.generateWorstCase(10000000);
		
		shuffledArray = SortUtil.generateAverageCase(10000000);
		
		SortUtil.quicksort(shuffledArray, reversedComp);
		
		assertEquals(true, array.equals(shuffledArray));
	}
	
	@Test
	public void testQuicksortSmallArrayStrings ()
	{
		ArrayList<String> shuffledArray = new ArrayList<String>();
		
		ArrayList<String> orderedArray = new ArrayList<String>();
		
		shuffledArray.add("qwerty");
		shuffledArray.add("deadpool");
		shuffledArray.add("spiderman");
		shuffledArray.add("batman");
		shuffledArray.add("wolverine");
		
		orderedArray.add("batman");
		orderedArray.add("deadpool");
		orderedArray.add("qwerty");
		orderedArray.add("spiderman");
		orderedArray.add("wolverine");
		
		SortUtil.quicksort(shuffledArray, stringComp);
		
		assertEquals(true, orderedArray.equals(shuffledArray));
		
	}
	
	@Test
	public void testGenerateBestCase ()
	{
		ArrayList<Integer>  array = new ArrayList<Integer>();
		for(int i = 1; i <= 10000;i++)
		{
			array.add(i);
		}
		
		assertEquals(true, array.equals(SortUtil.generateBestCase(10000)));
	}
	
	@Test
	public void testGenerateWorstCase ()
	{
		ArrayList<Integer>  array = new ArrayList<Integer>();
		for(int i = 10000; i > 0;i--)
		{
			array.add(i);
		}
		
		assertEquals(true, array.equals(SortUtil.generateWorstCase(10000)));
	}
	
	@Test
	public void testQuicksortWithCharacters ()
	{
		ArrayList<Character> shuffledArray = new ArrayList<>();
		
		ArrayList<Character> orderedArray = new ArrayList<>();
		
		shuffledArray.add('m');
		shuffledArray.add('l');
		shuffledArray.add('y');
		shuffledArray.add('q');
		shuffledArray.add('p');
		
		orderedArray.add('l');
		orderedArray.add('m');
		orderedArray.add('p');
		orderedArray.add('q');
		orderedArray.add('y');
		
		SortUtil.quicksort(shuffledArray, charComp);
		
		assertEquals(true, orderedArray.equals(shuffledArray));
	}
}
