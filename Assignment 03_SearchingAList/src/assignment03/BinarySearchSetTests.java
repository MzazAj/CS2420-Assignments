package assignment03;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.Test;
/**
 * 
 * @author Brian Rodriguez and Chasen Chamberlain
 *
 */
public class BinarySearchSetTests 
{

	@Test
	public void testAddingItemsInAnyParticularOrder() 
	{
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>();
		assertEquals(null ,set.comparator());
		Object array[] = new Object[]{1, 2, 3, 6, 64, 84};
		assertEquals(true, set.add(1));
		set.add(3);
		set.add(6);
		assertEquals(false, set.add(6));
		set.add(2);
		set.add(84);
		set.add(64);
	}

	@Test
	public void testRemovingItemsAndContains ()
	{
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>();
		ArrayList<Integer> array = new ArrayList<Integer>();
		ArrayList<Integer> setOfNums = new ArrayList<Integer> ();
		setOfNums.add(124); 
		setOfNums.add(234);
		setOfNums.add(534); 
		setOfNums.add(4523);
		for(int i = 0; i <= 100000; i++)
		{
			array.add(i);
		}
		set.addAll(array);
		set.remove(534);
		set.remove(234);
		set.remove(124);
		set.remove(4523);
		assertEquals(false, set.containsAll(setOfNums));
		assertEquals(false, set.contains(534));
		assertEquals(false, set.contains(4523));
	}
	
	@Test
	public void testFirstLastbyAddingAndRemoving ()
	{
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>();
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i = 0; i <= 10000; i++)
		{
			array.add(i);
		}
		set.addAll(array);
		assertEquals(true, set.first().equals(0));
		assertEquals(true, set.last().equals(10000));
		set.remove(0);
		set.remove(10000);
		assertEquals(false, set.first().equals(0));
		assertEquals(false, set.last().equals(10000));
		set.add(0);
		set.add(10000);
		assertEquals(true, set.first().equals(0));
		assertEquals(true, set.last().equals(10000));
	}
	
	@Test
	public void testIfSetIsEmpty()
	{
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>();
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i = 0; i <= 10000; i++)
		{
			array.add(i);
		}
		assertEquals(true, set.isEmpty());
		set.addAll(array);
		assertEquals(false, set.isEmpty());
		set.removeAll(array);
		assertEquals(true, set.isEmpty());
		set.add(23142536);
		assertEquals(false, set.isEmpty());
		set.remove(23142563);
		assertEquals(false, set.isEmpty());
	}
	
	@Test
	public void testToArray ()
	{
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>();
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for(int i = 0; i < 10000;i++)
		{
			arrayList.add(i);
		}
		set.addAll(arrayList);
		Object[] objectArray = set.toArray();
		for(int i = 0; i < objectArray.length - 1;i++)
		{
			assertEquals(i, objectArray[i]);
		}
	}
	
	@Test
	public void testClear ()
	{
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>();
		assertEquals(true, set.isEmpty());
		for(int i = 0; i < 10000; i++)
		{
			set.add(i);
		}
		assertEquals(false, set.isEmpty());
		set.clear();
		assertEquals(true, set.isEmpty());
	}
	
	@Test (expected=NoSuchElementException.class)
	public void testIteratorForNoSuchElementException () 
	{
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>();
		assertEquals(false,set.iterator().hasNext());
		Iterator<Integer> setIter = set.iterator();
		for(int i = 0; i < 100000;i++)
		{
			set.add(i);
		}
		for(int i = 0; i <= set.size();i++)
		{
			setIter.next();
		}
	}
	
	@Test (expected=IllegalStateException.class)
	public void testIteratorForIllegalStateException () 
	{
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>();
		assertEquals(false, set.iterator().hasNext());
		Iterator<Integer> setIter = set.iterator();
		for(int i = 0; i < 100_000;i++)
		{
			set.add(i);
		}
		setIter.remove();
	}
	
	@Test
	public void testSuccessfulIteration () 
	{
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>();
		
		assertEquals(false, set.iterator().hasNext());
		
		Iterator<Integer> setIter = set.iterator();
		
		for(int i = 0; i < 100_000;i++)
		{
			set.add(i);
		}
		for(int i = 0; i <= set.size()-1;i++)
		{
			setIter.next();
		}

		assertEquals(false, setIter.hasNext());
	}
	
	@Test 
	public void testAddingWithComparator ()
	{
		LibraryBook book = new LibraryBook(9781843190004L, "Moyra Caldecott", "Weapons of the Wolfhound");
				
		Comparator<LibraryBook> mComparator = new Comparator<LibraryBook>() 
				{
					@Override
					public int compare(LibraryBook o1, LibraryBook o2) 
					{
						return o1.getAuthor().compareTo(o2.getAuthor());
					}
				};
				
		Library library = new Library();
		library.addAll("Mushroom_Publishing.txt");
		BinarySearchSet<LibraryBook> set = new BinarySearchSet<LibraryBook>(mComparator);
		set.addAll(library.library);
		Object[] libraryArray = set.toArray();
		assertEquals(true, set.contains(book));
	}
	
	@Test
	public void testRemovingWithComparator()
	{
		LibraryBook book = new LibraryBook(9781843190004L, "Moyra Caldecott", "Weapons of the Wolfhound");
		
		Comparator<LibraryBook> mComparator = new Comparator<LibraryBook>() 
				{
					@Override
					public int compare(LibraryBook o1, LibraryBook o2) 
					{
						return o1.getAuthor().compareTo(o2.getAuthor());
					}
				};
		Library library = new Library();
		library.addAll("Mushroom_Publishing.txt");
		BinarySearchSet<LibraryBook> set = new BinarySearchSet<LibraryBook>(mComparator);
		assertEquals(true, set.isEmpty());
		set.addAll(library.library);
		Object[] libraryArray = set.toArray();
		set.remove(book);
		assertEquals(false, set.isEmpty());
		set.removeAll(library.library);
		assertEquals(true, set.isEmpty());

	}
	
	@Test (expected=NullPointerException.class)
	public void testAddingANullElement()
	{
		BinarySearchSet<Integer> set = new BinarySearchSet<Integer>();
		set.add(4);
		set.add(5);
		set.add(90);
		set.add(null);
		set.add(3);
	}
	
	@Test (expected=NoSuchElementException.class)
	public void testFirstThrowingExceptions ()
	{
		BinarySearchSet<String> set = new BinarySearchSet<String>();
		set.add("What?");
		assertEquals(false, set.isEmpty());
		set.remove("What?");
		assertEquals(true, set.isEmpty());
		set.first();
	}
	
	@Test (expected=NoSuchElementException.class)
	public void testLastThrowingExceptions ()
	{
		BinarySearchSet<String> set = new BinarySearchSet<String>();
		set.add("What?");
		assertEquals(false, set.isEmpty());
		set.remove("What?");
		assertEquals(true, set.isEmpty());
		set.last();
	}

}
