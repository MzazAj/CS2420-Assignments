package assignment11;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class PriotityQueueTests 
{
	PriorityQueue<Integer> queue;
	ArrayList<Integer> list;
	Comparator<String> cmp;
	
	@Before
	public void before()
	{
		queue = new PriorityQueue<>();
		list = new ArrayList<>();
		for(int i = 0; i <= 100000;i++)
		{
			list.add(i);
		}
		
		Collections.shuffle(list);
		
		for(int i = 0; i <= 100000;i++)
		{
			queue.add(list.get(i));
		}
		
		cmp = new Comparator<String>()
			{

				@Override
				public int compare(String o1, String o2) 
				{
					int o1Sum = 0;
					
					int o2Sum = 0;
					
					for(int i = 0; i < o1.length();i++)
					{
						o1Sum += o1.charAt(i);
					}
					
					for(int i = 0; i < o2.length();i++)
					{
						o2Sum += o2.charAt(i);
					}
					
					if(o2Sum > o1Sum)
					{
						return 1;
					}
					else if(o2Sum < o1Sum)
					{
						return -1;
					}
					else
					{
						return 0;
					}
				}
			};
	}
	
	@Test
	public void testFindMin() 
	{	
		assertEquals(true, queue.findMin().equals(0));
		queue.deleteMin();
		assertEquals(true, queue.findMin().equals(1));
		queue.add(-1);
		assertEquals(true, queue.findMin().equals(-1));
		queue.deleteMin();
		assertEquals(false, queue.findMin().equals(-1));
	}
	
	@Test
	public void testDeleteMin()
	{
		for(int i = 0; i <=5000;i++)
		{
			queue.deleteMin();
		}
		assertEquals(true, queue.findMin().equals(5001));
		queue.add(-1203);
		assertEquals(true, queue.findMin().equals(-1203));
		queue.deleteMin();
		assertEquals(false, queue.findMin().equals(-1203));
		queue.add(10000);
		assertEquals(false, queue.findMin().equals(10000));
	}
	
	@Test (expected=NoSuchElementException.class)
	public void testDeleteWhileEmpty()
	{
		queue.clear();
		queue.deleteMin();
	}
	
	@Test (expected=NoSuchElementException.class)
	public void testFindMinWhileEmpty()
	{
		queue.clear();
		queue.findMin();
	}

	@Test
	public void testAdd()
	{
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		queue.add(10);
		queue.add(4);
		queue.add(6);
		queue.add(11);
		
		assertEquals(true, queue.findMin().equals(4));
		queue.deleteMin();
		assertEquals(false, queue.findMin().equals(4));
		queue.deleteMin();
		assertEquals(true, queue.findMin().equals(10));
	}
	
	@Test (expected=NoSuchElementException.class)
	public void clearaWholeArrayFindMin()
	{
		queue.clear();
		queue.findMin();
	}
	
	@Test
	public void clearWholeArrayAdd()
	{
		queue.clear();
		queue.add(0);
		assertEquals(true, queue.findMin().equals(0));
	}
	
	@Test
	public void clearWholeArrayDeleteMin()
	{
		queue.clear();
		queue.add(132);
		queue.deleteMin();
		assertEquals(0, queue.size());
	}
	
	@Test
	public void testComparator()
	{
		PriorityQueue<String> queue = new PriorityQueue<>(cmp);
		
		String [] stringArray = StringGenerator.readFile("large_sample.txt");
		
		for(int i = 0; i < 3000;i++)
		{
			queue.add(stringArray[i]);
		}
		
		assertEquals(true, queue.findMin().equals("accommodativeness"));
		queue.deleteMin();
		assertEquals(true, queue.findMin().equals("acquaintanceships"));
	}
	
	
}
