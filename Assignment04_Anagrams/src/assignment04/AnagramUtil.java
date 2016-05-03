package assignment04;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 
 * @author Brian Rodriguez and Chasen Chamberlain
 *
 */
public class AnagramUtil 
{
	/**
	 * This method returns the sorted version of the input string. The sorting must be accomplished using an insertion sort.
	 * @param word
	 * @return
	 */
	public static String sort (String word)
	{
		
		if(word == null)
		{
			return null;
		}
		
		class Acomparator implements Comparator<Character> 
		{

			@Override
			public int compare(Character a1, Character a2) 
			{
				
				return a1.compareTo(a2);
			}
			
		};
		
		Acomparator comparator = new Acomparator();
		
		String sortedWord = "";
		
		Character[] charArray = new Character[word.length()];
		
		for(int i = 0;i < word.length();i++)
		{
			charArray[i] = word.toLowerCase().charAt(i);
		}
		
		insertionSort(charArray, comparator);
		
		for(Character chars: charArray)
		{
			sortedWord += chars;
		}

		return sortedWord;
	}
	
	/**
	 * This generic method sorts the input array using an insertion sort and the input Comparator object.
	 * @param inputArray
	 * @param comparator
	 */
	public static <T> void insertionSort(T[] inputArray, Comparator<? super T> comparator)
	{
		for(int i = 0; i < inputArray.length;i++)
		{
			T indexOfSmallestEle = inputArray[i];
			int j;
			
			for(j = i - 1;j >= 0 && comparator.compare(inputArray[j], indexOfSmallestEle) > 0; j--)
			{
				inputArray[j + 1] = inputArray[j];
			}
			inputArray[j + 1] = indexOfSmallestEle;
		}
	}
	/**
	 * This method returns true if the two input strings are anagrams of each other, otherwise returns false.
	 * @param anagramLeft
	 * @param anagramRight
	 * @return
	 */
	public static boolean areAnagrams(String anagramLeft, String anagramRight)
	{
		return sort(anagramLeft).equals(sort(anagramRight));
	}
	/**
	 * This method returns the largest group of anagrams in the input array of words, in no particular order. 
	 * It returns an empty array if there are no anagrams in the input array.
	 * @param inputArray
	 * @return
	 */
	public static String[] getLargestAnagramGroup(String [] inputArray)
	{
		
		//initialize the arraylists and arrays
		String [] anagramArray = inputArray.clone();
		
		String[] finalArray;
		
		ArrayList<String> temp = new ArrayList<>();
		
		ArrayList<String> largestAnagramGroup = new ArrayList<>();
		
		for(int i = 0; i < anagramArray.length;i++)
		{			
			for(int j = 0; j < anagramArray.length;j++)
			{
				if(areAnagrams(anagramArray[i], anagramArray[j]))
				{
					if(temp.contains(anagramArray[j]))
					{
						
					}
					else
					{
						temp.add(anagramArray[j]);
					}
				}
			}
			if(temp.size() > largestAnagramGroup.size())
			{
				largestAnagramGroup.clear();
				largestAnagramGroup.addAll(temp);
				temp.clear();
			}
			else
			{
				temp.clear();
			}
		}
		
		if(largestAnagramGroup.size() <= 1)
		{
			return finalArray = new String[0];
		}
		else
		{
			finalArray = new String[largestAnagramGroup.size()];
			return finalArray = largestAnagramGroup.toArray(finalArray);
		}
	}
	/**
	 * Behaves the same as the previous method, but reads the list of words from the input filename. 
	 * It is assumed that the file contains one word per line. 
	 * If the file does not exist or is empty, the method returns an empty array because there are no anagrams.
	 * @param filename
	 * @return
	 */
	public static String[] getLargestAnagramGroup(String filename)
	{			
		return AnagramUtil.getLargestAnagramGroup(AnagramTester.readFile(filename));
	}
	
	/**
	 * Insertion sort for Strings
	 * @return
	 */
}
