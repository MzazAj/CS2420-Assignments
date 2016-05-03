package assignment04;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author Brian Rodriguez and Chasen Chamberlain
 *
 */

public class AnagramTests 
{

	@Test
	public void testInsertionSortStrings() 
	{
		assertEquals("ginrst", AnagramUtil.sort("String"));
		assertEquals(true, AnagramUtil.areAnagrams("String", "grinst"));
		assertEquals(false, AnagramUtil.areAnagrams("qwerty", "trewq"));
		assertEquals("eqrtwy", AnagramUtil.sort("qwerty"));
	}
	
	@Test
	public void testGetLargestAnagramGroup ()
	{
		String[] array = new String[] { "carets", "Caller", "eat", "cellar", "recall", "Caters", "Ate", "caster",
				"aspired", "allergy", "despair", "asp", "pas", "least", "sap", "spa", "diapers", "praised", "crates",
				"Reacts", "bats", "tea", "Stab", "stale", "tabs", "recast", "darters", "Gallery", "retards", "starred",
				"code", "Coed", "deco", "traders", "traces", };
		
		String[] sortedArray = new String[] {"carets", "Caters", "caster", "crates", "Reacts", "recast", "traces"};
		
		String[] arrayNoAnagrams = new String[] {"carets", "eat", "sap", "Gallery", "deco"};
		
		assertEquals(sortedArray[0], AnagramUtil.getLargestAnagramGroup(array)[0]);
		
		assertEquals(sortedArray.length, AnagramUtil.getLargestAnagramGroup(array).length);
		
		assertEquals(0, AnagramUtil.getLargestAnagramGroup(arrayNoAnagrams).length);
	}
	
	@Test
	public void testGetLargestAnagramGroupWithLargerElementSizes ()
	{
		String[] sortedArray = new String[] {"carets", "Caters", "caster", "crates", "traces", "Reacts", "recast", };
		
		Assert.assertArrayEquals(sortedArray ,AnagramUtil.getLargestAnagramGroup("moderate_words_list.txt"));
		
		String[] largerSortedArray = new String[]{"accrues", "accurse", "accuser"};
		
		Assert.assertArrayEquals(largerSortedArray, AnagramUtil.getLargestAnagramGroup("large_sample.txt"));
	}
	
	
	@Test
	public void testRandomVarietyArray ()
	{
		String[] randomArray = new String []{"tea", "wham", "Goon", "Porque", "eat", "ATE"};
		
		String[] sortedArray = new String []{"tea", "eat", "ATE"};
		
		Assert.assertArrayEquals(sortedArray, AnagramUtil.getLargestAnagramGroup(randomArray));
	}
	
	@Test
	public void testArrayWithAllTheSameWords()
	{
		String[] sameWords = new String [] {"tea", "tea", "tea", "tea", "tea", "tea", "tea"};
		
		assertEquals(0, AnagramUtil.getLargestAnagramGroup(sameWords).length);
		
		String[] sameWordsAgain = new String [] {"WHYYOUDOTHIS","WHYYOUDOTHIS", "WHYYOUDOTHIS", "WHYYOUDOTHIS", "WHYYOUDOTHIS","WHYYOUDOTHIS", "WHYYOUDOTHIS"};
		
		assertEquals(0, AnagramUtil.getLargestAnagramGroup(sameWordsAgain).length);
	}
	
	@Test
	public void testAreAnagrams()
	{
		assertFalse(AnagramUtil.areAnagrams("qwrewt", "dsvds"));
		assertTrue(AnagramUtil.areAnagrams("poop", "OOPP"));
		assertTrue(AnagramUtil.areAnagrams("asdfghjklzxcvbnm", "mnbvcxzlkjhgfdsa"));
		assertFalse(AnagramUtil.areAnagrams("qwertyuiopasdfghjklzxcvbnm", "qwertyuiopsdfghjklzxcvbnm"));
		assertTrue(AnagramUtil.areAnagrams("", ""));
	}
	
	@Test
	public void testGetLargestAnagramGroupWithNoAnagrams ()
	{
		String [] array = new String []{"qwerty", "WHYYOUDOTHIS", "qwertyjndvh", "hello", "poop", "World"};
		
		assertEquals(0, AnagramUtil.getLargestAnagramGroup(array).length);
		
		String [] noAnagrams = new String [] {"qerwgredf", "qwerty", "qwert", "qwer", "SKJVNDKJNV", "cat"};
		
		assertEquals(0, AnagramUtil.getLargestAnagramGroup(noAnagrams).length);
	}
	
	@Test
	public void testGetLargestAnagramGroupWithNoAnagramsLargeFile()
	{
		assertEquals(0, AnagramUtil.getLargestAnagramGroup("no_anagrams.txt").length);
		assertEquals(0, AnagramUtil.getLargestAnagramGroup("no_anagram.txt").length);
	}
	
	@Test
	public void testFileDoesNotExist ()
	{
		assertEquals(0, AnagramUtil.getLargestAnagramGroup("FILEDOESNOTEXIST.txt").length);
		assertEquals(0, AnagramUtil.getLargestAnagramGroup("").length);
		assertEquals(0, AnagramUtil.getLargestAnagramGroup("helloWorld.txt").length);
	}
	
}
