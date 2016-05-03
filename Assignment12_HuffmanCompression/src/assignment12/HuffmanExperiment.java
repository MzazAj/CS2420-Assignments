package assignment12;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * @author Brian Rodriguez and Michael Kim
 *
 * Creates compressed and decompressed files for the experiments
 */
public class HuffmanExperiment 
{
	
	public static void main(String args[])
	{
		HuffmanTree trie = new HuffmanTree();
		// set frequency and number of unique characters not to exceeed 222
		int frequency = 100;
		
		int numofUniqueChars = 200;
		
		//Creates compressed and decompressed files
		File compressedUniqueCharacters = new File("compressedUniqueCharacters.txt");
		
		File decompressedUniqueCharacters = new File("decompressedUniqueCharacters.txt");
		//creates the original file ot be compressed and decompressed
		File file = makeUniqueChars(numofUniqueChars, frequency, "unique");
		//compresssed and decompresses the file
		trie.compressFile(file, compressedUniqueCharacters);
		
		trie.decompressFile(compressedUniqueCharacters, decompressedUniqueCharacters);
		//calculates the ratio
		Double ratioUnique = ((double)compressedUniqueCharacters.length() / ((double) decompressedUniqueCharacters.length()));
		
		//prints out the ratio frequency and number of unique characters used
		System.out.println("Unique Ratio :" + ratioUnique + " Frequency : " + frequency + " Num of Unique Chars: " + numofUniqueChars);
		//rinse and repeat for the next two
		File compressedNonCharacters = new File("compressedNonUniqueCharacters.txt");
		
		File decompressedNonCharacters = new File("decompressedNonUniqueCharacters.txt");

		File fileNonUnique = makeUniqueChars(numofUniqueChars, frequency, "non-unique");
		
		trie.compressFile(fileNonUnique, compressedNonCharacters);
		
		trie.decompressFile(compressedNonCharacters, decompressedNonCharacters);
		
		Double ratioNonunique = ((double) compressedNonCharacters.length()) / ((double) decompressedNonCharacters.length());
		
		System.out.println("Non-Unique Ratio :" + ratioNonunique + " Frequency : " + frequency + " Num of Unique Chars: " + numofUniqueChars);
		
		File compressedSemiCharacters = new File("compressedSemiUniqueCharacters.txt");
		
		File decompressedSemiCharacters = new File("decompressedSemiUniqueCharacters.txt");

		File fileSemiUnique = makeUniqueChars(numofUniqueChars, frequency, "semi-unique");
		
		trie.compressFile(fileSemiUnique, compressedSemiCharacters);
		
		trie.decompressFile(compressedSemiCharacters, decompressedSemiCharacters);
		
		Double ratioSemiunique = ((double) compressedSemiCharacters.length()) / ((double) decompressedSemiCharacters.length());
		
		System.out.println("Semi-Unique Ratio :" + ratioSemiunique + " Frequency : " + frequency + " Num of Unique Chars: " + numofUniqueChars);
	}
	
	/**
	 * Creates a file comprised of the number of unique characters and frequency 
	 * plus the style you would like
	 * @param numofCharacters
	 * @param frequency
	 * @param style
	 * @return
	 */
	public static File makeUniqueChars(int numofCharacters, int frequency, String style)
	{
		if(style.equals("unique"))
		{
			//creates the file
			File file = new File("huffman_Experiement");
			//creates the filewriter
			FileWriter writer = null;
			
			try 
			{
				//sets file writer to new file writer
				writer = new FileWriter(file);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			//wraps the file writer in a print writer
			PrintWriter printWriter = new PrintWriter(writer);
			//initialize the string to be inputed to the file
			String uniqueCharacter = "";
			
			//go for as many frequencies
			for(int i = 0; i < frequency;i++)
			{
				//adds the character at the ASCII of i to the string
				for(int j = 32; j <= numofCharacters + 32;j++)
				{
					char Character = (char) + j;
					
					uniqueCharacter += Character;
				}
			}
			//prints the string the the file
			printWriter.println(uniqueCharacter);
			//close the print writer
			printWriter.close();
			
			return file;
		}
		//rinse and repeat for the next two
		else if (style.equals("non-unique"))
		{
			File file = new File("huffman_Experiement");
			
			FileWriter writer = null;
			
			try 
			{
				writer = new FileWriter(file);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			PrintWriter printWriter = new PrintWriter(writer);
			
			String uniqueCharacter = "";
			
			
			for(int i = 0; i < frequency;i++)
			{
				for(int j = 32; j <= numofCharacters + 32;j++)
				{					
					char Character = 'a';
				
					uniqueCharacter += Character;
				}
			}
			printWriter.println(uniqueCharacter);
			
			printWriter.close();
			
			return file;
		}
		else
		{
			File file = new File("huffman_Experiement");
			
			FileWriter writer = null;
			
			try 
			{
				writer = new FileWriter(file);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			PrintWriter printWriter = new PrintWriter(writer);
			
			String uniqueCharacter = "";
			
			for(int i = 0; i < frequency;i++)
			{
				for(int j = 32; j <= (numofCharacters/2) + 32; j++)
				{
					char Character = (char) + j;
					
					uniqueCharacter += Character;
				}
			}
			printWriter.println(uniqueCharacter);
			
			printWriter.close();
			
			return file;
		}
	}
}
