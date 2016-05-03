package assignment10;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for Chaining Hash Table
 * 
 * @author Brian Rodriguez and Michael Kim
 *
 */
public class ChainingHashTableTests {

	ChainingHashTable hashTable;
	
	@Before
	public void setupBefore()
	{
		String[] words = StringGenerator.readFile("large_sample.txt");
		
		Collection<String> list = new ArrayList<String>();
		
		for(int i = 0; i < words.length;i++)
		{
			list.add(words[i]);
		}
		
		hashTable =  new ChainingHashTable(10, new MediocreHashFunctor());
		
		hashTable.addAll(list);
	}
	
	@Test
	public void testAdd() 
	{
		ChainingHashTable hashTable =  new ChainingHashTable(10, new MediocreHashFunctor());
		assertEquals(true, hashTable.add("Dijkstra"));
		assertEquals(true, hashTable.add("dijkstra"));
		assertEquals(false, hashTable.add("Dijkstra"));
		assertEquals(true, hashTable.contains("Dijkstra"));
	}

	@Test
	public void testAddAllandContainsAll()
	{
		String[] words = StringGenerator.readFile("large_sample.txt");
		
		Collection<String> list = new ArrayList<String>();
		
		for(int i = 0; i < words.length;i++)
		{
			list.add(words[i]);
		}
		
		ChainingHashTable hashTable =  new ChainingHashTable(10, new MediocreHashFunctor());
		
		hashTable.addAll(list);
		
		assertEquals(true, hashTable.containsAll(list));
		
		hashTable.clear();
		
		assertEquals(false, hashTable.containsAll(list));
	}
	
	@Test
	public void testClearandSize()
	{
		String[] words = StringGenerator.readFile("large_sample.txt");
		
		Collection<String> list = new ArrayList<String>();
		
		for(int i = 0; i < words.length;i++)
		{
			list.add(words[i]);
		}
		
		hashTable.addAll(list);
		
		assertEquals(3000, hashTable.size());
		
		hashTable.clear();
		
		assertEquals(0, hashTable.size());
		
		hashTable.add("something");
		
		assertEquals(1, hashTable.size());
	}
	
	@Test
	public void testContains()
	{
		assertEquals(false, hashTable.contains("Dijkstra"));
		assertEquals(true, hashTable.contains("abase"));
		assertEquals(true, hashTable.contains("abrogate"));
		assertEquals(false, hashTable.contains("hashtable"));
	}
	
	@Test
	public void testisEmpty()
	{
		assertEquals(false, hashTable.isEmpty());
		hashTable.clear();
		assertEquals(true, hashTable.isEmpty());
		hashTable.add("something");
		assertEquals(false, hashTable.isEmpty());
	}
}
