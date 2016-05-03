package assignment06;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author Brian Rodriguez and Michael Kim
 *
 */
public class DoublyLinkedListTests 
{
	DoublyLinkedList<Integer> list;
	static DoublyLinkedList<String> emptyList;
	Iterator<Integer> iter;
	DoublyLinkedList<Integer> oneElement;

	@BeforeClass
	public static void setUpBeforeClass() 
	{
		emptyList = new DoublyLinkedList<String>();
	}
	
	@Before
	public void setUpBefore() throws Exception 
	{
		list = new DoublyLinkedList<Integer>();
		for(Integer i = 0; i < 1000000;i++)
		{
			list.addLast(i);
		}
		
		iter = list.iterator();
		
		oneElement = new DoublyLinkedList<Integer>();
		
		oneElement.addFirst(1);
		
	}

	@Test
	public void testGetMethods() 
	{
		list.addLast(1);
		assertEquals(true, list.getFirst().equals(0));
		assertEquals(true, list.get(1).equals(1));
		assertEquals(true, list.getLast().equals(1));
		assertEquals(true, list.get(0).equals(0));
		assertEquals(true, list.get(5000).equals(5000));
		assertEquals(true, list.get(999999).equals(999999));
	}

	@Test
	public void testRemoveFirstAndLast()
	{
		list.removeLast();
		assertEquals(true, list.getLast().equals(999998));
		list.removeFirst();
		assertEquals(true, list.getFirst().equals(1));
		list.removeFirst();
		list.removeFirst();
		assertEquals(true, list.getFirst().equals(3));
		list.removeLast();
		list.removeLast();
		assertEquals(true, list.getLast().equals(999996));
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testEmptyListExceptionNoSuchElementException1()
	{
		emptyList.removeFirst();
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testEmptyListExceptionNoSuchElementException2()
	{
		emptyList.removeLast();
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testEmptyListExceptionNoSuchElementException3()
	{
		emptyList.getFirst();
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testEmptyListExceptionNoSuchElementException4()
	{
		emptyList.getLast();
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testEmptyListExceptionIndexOutOfBoundsException()
	{
		emptyList.get(87);
	}
	
	@Test
	public void testClear()
	{
		list.clear();
		assertEquals(0, list.size());
		assertEquals(true, list.isEmpty());
		assertEquals(0, emptyList.size());
		emptyList.clear();
		assertEquals(0, emptyList.size());
		assertEquals(true, emptyList.isEmpty());
	}
	
	@Test
	public void testSize()
	{
		assertEquals(1000000, list.size());
		assertEquals(0, emptyList.size());
	}
	
	@Test
	public void testToArray()
	{
		
		Object [] nodeArray = list.toArray();
		
		Object [] comparingArray = new Integer [nodeArray.length];
		
		for(Integer i = 0; i < comparingArray.length;i++)
		{
			comparingArray [i] = i;
		}
		
		Assert.assertArrayEquals(nodeArray, comparingArray);
		
		Object [] emptyArray = emptyList.toArray();
		
		Assert.assertArrayEquals(new Object [0], emptyArray);
	}
	
	@Test
	public void testIndexOf()	
	{
		list.addLast(null);
		assertEquals(-1, emptyList.indexOf("fasf"));
		assertEquals(5000, list.indexOf(5000));
		assertEquals(999_999, list.indexOf(999_999));
		assertEquals(1_000_000, list.indexOf(null));
		assertEquals(-1, list.indexOf(9898512));
	}
	
	@Test
	public void testGetLastAndGetFirst()
	{
		DoublyLinkedList<Integer> newList = new DoublyLinkedList<Integer>();
		
		newList.addFirst(0);
		
		assertEquals(true, newList.getFirst().equals(0));
		assertEquals(true, newList.getLast().equals(0));
	}
	
	@Test
	public void testRemove()
	{
		list.remove(8);
		assertEquals(true, list.get(8).equals(9));
		assertEquals(true, list.get(9).equals(10));
		assertEquals(999999, list.size());
		list.remove(999_998);
		assertEquals(true, list.get(999_997).equals(999_998));
	}
	
	@Test
	public void testIterator()
	{
		iter.next();
		iter.remove();
		assertEquals(true, list.get(0).equals(1));
		iter.next();
		iter.remove();
		assertEquals(999_998, list.size());
		assertEquals(true, iter.hasNext());
	}
	
	@Test (expected = IllegalStateException.class)
	public void testIteratorIllegalStateWithoutCallingNext()
	{
		iter.remove();
	}
	
	@Test (expected = IllegalStateException.class)
	public void testIteratorRemovingTheSameElementTwice()
	{
		iter.next();
		iter.remove();
		iter.remove();
	}
	
	@Test
	public void testIteratorNext()
	{
		for(int i = 0; i < 999_999;i++)
		{
			iter.next();
			iter.remove();
		}
		
		assertEquals(true, iter.hasNext());
		assertEquals(1, list.size());
		assertEquals(true, list.get(0).equals(999_999));
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testIteratorTillEndPlusOne()
	{
		for(int i = 0; i <= 1_000_000;i++)
		{
			iter.next();
		}
	}
	
	@Test
	public void testLastIndexOf()
	{
		for(int i = 0; i < 1_000_000;i++)
		{
			list.addLast(i);
		}
		
		list.addLast(null);
		
		assertEquals(1_999_999, list.lastIndexOf(999_999));
		assertEquals(1_000_000, list.lastIndexOf(0));
		assertEquals(1_500_000, list.lastIndexOf(500_000));
		assertEquals(-1, list.lastIndexOf(134532536));
		assertEquals(-1, list.lastIndexOf(-1));
		assertEquals(2_000_000, list.lastIndexOf(null));
	}
	
	@Test
	public void testAdd()
	{
		list.add(4000, null);
		list.add(1_000_000, null);
		assertEquals(4000, list.indexOf(null));
		assertEquals(1_000_000, list.lastIndexOf(null));
		assertEquals(4001, list.lastIndexOf(4000));
		assertEquals(true, list.get(4001).equals(4000));
		assertEquals(null, list.get(1_000_000));
		assertEquals(null, list.get(4000));
	}
	
	@Test
	public void testLastIndexOfWithEmptyListAndOneElement()
	{
		assertEquals(-1, emptyList.lastIndexOf(null));
		assertEquals(-1, emptyList.indexOf(null));
		assertEquals(true, oneElement.get(0).equals(1));
		assertEquals(0, oneElement.lastIndexOf(1));
		assertEquals(0, oneElement.indexOf(1));
		assertEquals(true, oneElement.getFirst().equals(1));
		assertEquals(true, oneElement.getLast().equals(1));
	}
}