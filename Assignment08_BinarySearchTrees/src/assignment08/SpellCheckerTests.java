package assignment08;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * SpellChecker Tests
 * 
 * @author Brian Rodriguez and Michael Kim
 */

public class SpellCheckerTests {

	SpellChecker spellChecker;
	BinarySearchTree<String> BST;
	List<String> listToCompare;
	@Before
	public void BuildDictionary()
	{
		spellChecker = new SpellChecker(new File("dictionary.txt"));
		BST = new BinarySearchTree<String>();
		listToCompare = new ArrayList<String>();
	}
	@Test
	public void testAddToDictionary() 
	{
		listToCompare.add("my");
		listToCompare.add("platos");
		assertEquals(listToCompare, spellChecker.spellCheck(new File("test_file.txt")));
		spellChecker.addToDictionary("platos");
		spellChecker.addToDictionary("my");
		listToCompare.remove("platos");
		listToCompare.remove("my");
		assertEquals(listToCompare, spellChecker.spellCheck(new File("test_file.txt")));
		List<String> misspelledWords = spellChecker.spellCheck(new File("test_file.txt"));
		assertEquals(0, misspelledWords.size());
	}
	
	@Test
	public void testRemoveFromDictionary() 
	{
		spellChecker.addToDictionary("platos");
		spellChecker.addToDictionary("my");
		assertEquals(listToCompare, spellChecker.spellCheck(new File("test_file.txt")));
		spellChecker.removeFromDictionary("abandoned");
		spellChecker.removeFromDictionary("acanthuses");
		listToCompare.add("abandoned");
		listToCompare.add("acanthuses");
		assertEquals(listToCompare, spellChecker.spellCheck(new File("test_file.txt")));
		List<String> misspelledWords = spellChecker.spellCheck(new File("test_file.txt"));
		assertEquals(2, misspelledWords.size());
	}
	
	@Test
	public void testSpellCheck() 
	{
		spellChecker.addToDictionary("platos");
		spellChecker.addToDictionary("my");
		spellChecker.addToDictionary("great");
		assertEquals(listToCompare, spellChecker.spellCheck(new File("test_file_spellcheck.txt")));
		spellChecker.removeFromDictionary("device");
		spellChecker.removeFromDictionary("samurai");
		spellChecker.removeFromDictionary("faded");
		listToCompare.add("device");
		listToCompare.add("samurai");
		listToCompare.add("faded");
		listToCompare.add("sensitive");
		assertEquals(listToCompare, spellChecker.spellCheck(new File("test_file_spellcheck.txt")));
		List<String> misspelledWords = spellChecker.spellCheck(new File("test_file_spellcheck.txt"));
		assertEquals(4, misspelledWords.size());
		
	}

}
