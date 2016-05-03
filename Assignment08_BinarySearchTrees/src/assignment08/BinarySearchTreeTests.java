package assignment08;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests Binary Search Tree Methods
 * 
 * @author Brian Rodriguez and Michael Kim
 */

public class BinarySearchTreeTests 
{
	BinarySearchTree<Integer> list;
	
	@Before
	public void setUpBefore ()
	{
		list = new BinarySearchTree<>();
		
		for(Integer i = 0; i <= 1_000;i++)
		{
			list.add(i);
		}
	}
	
	
	@Test
	public void toArrayListTest() 
	{
		ArrayList<Integer> integerList = new ArrayList<>();
		
		for(Integer i = 0; i <= 1_000;i++)
		{
			integerList.add(i);
		}
		
		assertEquals(true, list.toArrayList().equals(integerList));
		
		ArrayList<Integer> intList = new ArrayList<>();
		
		for(int i = 0; i <= 10000;i++)
		{
			intList.add(i);
		}
		
		ArrayList<Integer> intListSorted = new ArrayList<>();
		
		for(int i = 0; i <= 10000;i++)
		{
			intListSorted.add(i);
		}
		
		Collections.shuffle(intList);
		
		list.clear();
		
		list.addAll(intList);
		
		assertEquals(true, list.toArrayList().equals(intListSorted));
	}
	
	@Test
	public void addAllTest()
	{
		ArrayList<Integer> integerArray = new ArrayList<>();
		
		ArrayList<Integer> sortedArray = new ArrayList<>();
		
		BinarySearchTree<Integer> intList = new BinarySearchTree<>();
		
		for(Integer i = 0; i <= 10_000;i++)
		{
			integerArray.add(i);
			sortedArray.add(i);
		}
		
		Collections.shuffle(integerArray);
		
		assertEquals(true, intList.addAll(integerArray));
	
		
		assertEquals(true, intList.toArrayList().equals(sortedArray));
	}
	
	@Test
	public void clearTest()
	{
		list.clear();
		
		assertEquals(true, list.isEmpty());
		
		list.add(1);
		
		assertEquals(false, list.isEmpty());
		
		list.clear();
		
		assertEquals(true, list.isEmpty());
	}
	
	@Test
	public void testSize()
	{
		ArrayList<Integer> intArray = new ArrayList<>();
		
		assertEquals(1001, list.size());
		
		list.clear();
		
		assertEquals(0, list.size());
		
		list.add(10000);
		
		assertEquals(1, list.size());
		
		for(int i = 1; i <=10000;i++)
		{
			intArray.add(i);
		}
		
		Collections.shuffle(intArray);
		
		list.clear();
		
		list.addAll(intArray);
		
		assertEquals(10000, list.size());
	}
	
	@Test
	public void testAdd()
	{
		assertEquals(true, list.add(1001));
		assertEquals(1002, list.size());
		assertEquals(false, list.add(0));
		assertEquals(1002, list.size());
		assertEquals(true, list.contains(1001));
		assertEquals(true, list.contains(0));
	}
	
	@Test
	public void testContains()
	{
		assertEquals(false, list.contains(1001));
		assertEquals(true, list.contains(500));
		list.remove(500);
		assertEquals(false, list.contains(500));
		list.add(10000);
		assertEquals(true, list.contains(10000));
	}
	
	@Test
	public void testContainsAll()
	{
		ArrayList<Integer> intArray = new ArrayList<>();
		
		ArrayList<Integer> intArray2 = new ArrayList<>();

		
		for(int i = 0; i <=1000;i+=2)
		{
			intArray.add(i);
		}
		
		for(int i = 0; i <=1000;i++)
		{
			intArray2.add(i);
		}
		
		assertEquals(true, list.containsAll(intArray));
		
		assertEquals(true, list.containsAll(intArray2));
		
		list.remove(500);
		
		assertEquals(false, list.containsAll(intArray2));
	}
	
	@Test
	public void testFirst()
	{	
		ArrayList<Integer> intArray = new ArrayList<>();
		
		for(int i = 0; i <= 1000;i++)
		{
			intArray.add(i);
		}
		
		Collections.shuffle(intArray);
		
		assertEquals(true, list.first().equals(0));
		
		list.remove(0);
		
		assertEquals(false, list.first().equals(0));
		
		assertEquals(true, list.first().equals(1));
		
		
		list.removeAll(intArray);
		
		list.add(100);
		
		list.writeDot("testFirst");
		
		assertEquals(true, list.first().equals(100));
	}
	
	@Test
	public void testLast()
	{
		
		ArrayList<Integer> intArray = new ArrayList<>();
		
		for(int i = 0; i <= 1000;i++)
		{
			intArray.add(i);
		}
		
		Collections.shuffle(intArray);
		
		assertEquals(true, list.last().equals(1000));
		
		list.remove(888);
		
		assertEquals(false, list.last().equals(999));
		
		list.removeAll(intArray);
		
		list.add(123);
		
		assertEquals(false, list.last().equals(122));
		
		assertEquals(true, list.last().equals(123));
	}
	
	@Test
	public void testRemove()
	{
		assertEquals(true, list.remove(1000));
		assertEquals(false, list.remove(100001));
		assertEquals(true, list.remove(345));
		assertEquals(false, list.remove(345));
		list.add(1000);
		assertEquals(true, list.remove(1000));
	}
	
	@Test
	public void testRemoveAll()
	{
		ArrayList<Integer> intArray = new ArrayList<>();

		ArrayList<Integer> intArray2 = new ArrayList<>();

		for(int i = 0; i <= 1000;i++)
		{
			intArray.add(i);
		}
		
		for(int i = 0; i <= 1000; i+=2)
		{
			intArray2.add(i);
		}
		
		Collections.shuffle(intArray);
		
		Collections.shuffle(intArray2);
		
		assertEquals(true,list.removeAll(intArray));
		
		assertEquals(true, list.addAll(intArray));
		
		list.remove(1000);
		
		assertEquals(true, list.removeAll(intArray));
		
		list.addAll(intArray);
		
		assertEquals(true, list.removeAll(intArray2));
	}
	
	@Test
	public void isEmpty()
	{
		assertEquals(false, list.isEmpty());
		list.clear();
		assertEquals(true, list.isEmpty());
		list.add(100);
		assertEquals(false, list.isEmpty());
	}
	
	@Test (expected = NullPointerException.class)
	public void testAddException()
	{
		list.add(null);
	}
	
	@Test (expected = NullPointerException.class)
	public void testAddAllException()
	{
		ArrayList<Integer> array = new ArrayList<>();
		for(int i = 0; i < 10000;i++)
		{
			array.add(i);
			array.addAll(null);
		}
		
		list.addAll(array);
	}
	
	@Test (expected = NullPointerException.class)
	public void testContainsException()
	{
		list.contains(null);
	}
	
	@Test (expected = NullPointerException.class)
	public void testContainsAllException()
	{
		ArrayList<Integer> array = new ArrayList<>();
		for(int i = 0; i < 10000;i++)
		{
			array.add(i);
			array.addAll(null);
		}
		
		
		list.containsAll(array);
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testFirstException()
	{
		list.clear();
		list.first();
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testLastException()
	{
		list.clear();
		list.last();
	}
	
	@Test (expected = NullPointerException.class)
	public void testRemoveException()
	{
		list.remove(null);
	}
	
	@Test (expected = NullPointerException.class)
	public void testRemoveAllException()
	{
		ArrayList<Integer> array = new ArrayList<>();
		for(int i = 0; i < 10000;i++)
		{
			array.add(i);
			array.addAll(null);
		}
		
		list.removeAll(array);
	}
	
	@Test
	public void testAddAll10000()
	{
		list.clear();
		ArrayList<Integer> array = new ArrayList<>();

		for(int i = 0; i < 10000;i++)
		{
			array.add(i);
		}
		
		assertEquals(true,list.addAll(array));
	}
	
}
