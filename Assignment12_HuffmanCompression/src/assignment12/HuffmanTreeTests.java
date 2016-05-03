package assignment12;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.Test;

/**
 * Tests for the HuffmanTree
 * 
 * @author Brian Rodriguez
 *
 */
public class HuffmanTreeTests {

	@Test
	public void testIheartData() 
	{
		File original = new File("original.txt");
		
		File compressedFile = new File("originalCompressed.txt");
		
		File decompressedFile = new File("originalDecomp.txt");
		
		HuffmanTree trie = new HuffmanTree();
		
		trie.compressFile(original, compressedFile);
		
		trie.decompressFile(compressedFile, decompressedFile);
		
		try 
		{
			FileReader sol = new FileReader(original);

			BufferedReader solRead = new BufferedReader(sol);

			FileReader output = new FileReader(decompressedFile);

			BufferedReader outRead = new BufferedReader(output);

			while (outRead != null || solRead != null) 
			{
				char[] solLine;
				char[] outLine;
				try 
				{
					solLine = solRead.readLine().toCharArray();
					outLine = outRead.readLine().toCharArray();
				} 
				catch (NullPointerException e) 
				{
					break;
				}

				if(solLine.length != outLine.length)
				{				
					solRead.close();
					outRead.close();
					assertTrue(false);
				}
				
				for(int i = 0; i < solLine.length || i < outLine.length;i++)
				{
					if(solLine[i] != outLine[i])
					{
						solRead.close();
						outRead.close();
						assertTrue(false);		
					}
				}
			}
			
			solRead.close();
			outRead.close();
			assertTrue(true);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLargeSample() 
	{
		File original = new File("large_sample.txt");
		
		File compressedFile = new File("largeCompressed.txt");
		
		File decompressedFile = new File("largeDecomp.txt");
		
		HuffmanTree trie = new HuffmanTree();
		
		trie.compressFile(original, compressedFile);
		
		trie.decompressFile(compressedFile, decompressedFile);
		
		try 
		{
			FileReader sol = new FileReader(original);

			BufferedReader solRead = new BufferedReader(sol);

			FileReader output = new FileReader(decompressedFile);

			BufferedReader outRead = new BufferedReader(output);

			while (outRead != null || solRead != null) 
			{
				char[] solLine;
				char[] outLine;
				try 
				{
					solLine = solRead.readLine().toCharArray();
					outLine = outRead.readLine().toCharArray();
				} 
				catch (NullPointerException e) 
				{
					break;
				}

				if(solLine.length != outLine.length)
				{				
					solRead.close();
					outRead.close();
					assertTrue(false);
				}
				
				for(int i = 0; i < solLine.length || i < outLine.length;i++)
				{
					if(solLine[i] != outLine[i])
					{
						solRead.close();
						outRead.close();
						assertTrue(false);		
					}
				}
			}
			
			solRead.close();
			outRead.close();
			assertTrue(true);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFullBook() 
	{
		File original = new File("fullbook");
		
		File compressedFile = new File("fullbookCompresed.txt");
		
		File decompressedFile = new File("fullBookDecomp.txt");
		
		HuffmanTree trie = new HuffmanTree();
		
		trie.compressFile(original, compressedFile);
		
		trie.decompressFile(compressedFile, decompressedFile);
		
		try 
		{
			FileReader sol = new FileReader(original);

			BufferedReader solRead = new BufferedReader(sol);

			FileReader output = new FileReader(decompressedFile);

			BufferedReader outRead = new BufferedReader(output);

			while (outRead != null || solRead != null) 
			{
				char[] solLine;
				char[] outLine;
				try 
				{
					solLine = solRead.readLine().toCharArray();
					outLine = outRead.readLine().toCharArray();
				} 
				catch (NullPointerException e) 
				{
					break;
				}

				if(solLine.length != outLine.length)
				{				
					solRead.close();
					outRead.close();
					assertTrue(false);
				}
				
				for(int i = 0; i < solLine.length || i < outLine.length;i++)
				{
					if(solLine[i] != outLine[i])
					{
						solRead.close();
						outRead.close();
						assertTrue(false);		
					}
				}
			}
			
			solRead.close();
			outRead.close();
			assertTrue(true);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAladdin() 
	{
		File original = new File("Aladdin");
		
		File compressedFile = new File("aladdinCompressed.txt");
		
		File decompressedFile = new File("aladdinDecomp.txt");
		
		HuffmanTree trie = new HuffmanTree();
		
		trie.compressFile(original, compressedFile);
		
		trie.decompressFile(compressedFile, decompressedFile);
		
		try 
		{
			FileReader sol = new FileReader(original);

			BufferedReader solRead = new BufferedReader(sol);

			FileReader output = new FileReader(decompressedFile);

			BufferedReader outRead = new BufferedReader(output);

			while (outRead != null || solRead != null) 
			{
				char[] solLine;
				char[] outLine;
				try 
				{
					solLine = solRead.readLine().toCharArray();
					outLine = outRead.readLine().toCharArray();
				} 
				catch (NullPointerException e) 
				{
					break;
				}

				if(solLine.length != outLine.length)
				{				
					solRead.close();
					outRead.close();
					assertTrue(false);
				}
				
				for(int i = 0; i < solLine.length || i < outLine.length;i++)
				{
					if(solLine[i] != outLine[i])
					{
						solRead.close();
						outRead.close();
						assertTrue(false);		
					}
				}
			}
			
			solRead.close();
			outRead.close();
			assertTrue(true);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBeggar() 
	{
		File original = new File("beggar");
		
		File compressedFile = new File("beggarCompressed.txt");
		
		File decompressedFile = new File("beggarDecomp.txt");
		
		HuffmanTree trie = new HuffmanTree();
		
		trie.compressFile(original, compressedFile);
		
		trie.decompressFile(compressedFile, decompressedFile);
		
		try 
		{
			FileReader sol = new FileReader(original);

			BufferedReader solRead = new BufferedReader(sol);

			FileReader output = new FileReader(decompressedFile);

			BufferedReader outRead = new BufferedReader(output);

			while (outRead != null || solRead != null) 
			{
				char[] solLine;
				char[] outLine;
				try 
				{
					solLine = solRead.readLine().toCharArray();
					outLine = outRead.readLine().toCharArray();
				} 
				catch (NullPointerException e) 
				{
					break;
				}

				if(solLine.length != outLine.length)
				{				
					solRead.close();
					outRead.close();
					assertTrue(false);
				}
				
				for(int i = 0; i < solLine.length || i < outLine.length;i++)
				{
					if(solLine[i] != outLine[i])
					{
						solRead.close();
						outRead.close();
						assertTrue(false);		
					}
				}
			}
			
			solRead.close();
			outRead.close();
			assertTrue(true);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCharlie() 
	{
		File original = new File("charlie");
		
		File compressedFile = new File("charlieCompressed.txt");
		
		File decompressedFile = new File("charlieDecomp.txt");
		
		HuffmanTree trie = new HuffmanTree();
		
		trie.compressFile(original, compressedFile);
		
		trie.decompressFile(compressedFile, decompressedFile);
		
		try 
		{
			FileReader sol = new FileReader(original);

			BufferedReader solRead = new BufferedReader(sol);

			FileReader output = new FileReader(decompressedFile);

			BufferedReader outRead = new BufferedReader(output);

			while (outRead != null || solRead != null) 
			{
				char[] solLine;
				char[] outLine;
				try 
				{
					solLine = solRead.readLine().toCharArray();
					outLine = outRead.readLine().toCharArray();
				} 
				catch (NullPointerException e) 
				{
					break;
				}

				if(solLine.length != outLine.length)
				{				
					solRead.close();
					outRead.close();
					assertTrue(false);
				}
				
				for(int i = 0; i < solLine.length || i < outLine.length;i++)
				{
					if(solLine[i] != outLine[i])
					{
						solRead.close();
						outRead.close();
						assertTrue(false);		
					}
				}
			}
			
			solRead.close();
			outRead.close();
			assertTrue(true);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDarkness() 
	{
		File original = new File("darkness");
		
		File compressedFile = new File("darknessCompressed.txt");
		
		File decompressedFile = new File("darknessDecomp.txt");
		
		HuffmanTree trie = new HuffmanTree();
		
		trie.compressFile(original, compressedFile);
		
		trie.decompressFile(compressedFile, decompressedFile);
		
		try 
		{
			FileReader sol = new FileReader(original);

			BufferedReader solRead = new BufferedReader(sol);

			FileReader output = new FileReader(decompressedFile);

			BufferedReader outRead = new BufferedReader(output);

			while (outRead != null || solRead != null) 
			{
				char[] solLine;
				char[] outLine;
				try 
				{
					solLine = solRead.readLine().toCharArray();
					outLine = outRead.readLine().toCharArray();
				} 
				catch (NullPointerException e) 
				{
					break;
				}

				if(solLine.length != outLine.length)
				{				
					solRead.close();
					outRead.close();
					assertTrue(false);
				}
				
				for(int i = 0; i < solLine.length || i < outLine.length;i++)
				{
					if(solLine[i] != outLine[i])
					{
						solRead.close();
						outRead.close();
						assertTrue(false);		
					}
				}
			}
			
			solRead.close();
			outRead.close();
			assertTrue(true);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
