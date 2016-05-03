package assignment07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class containing the checkFile method for checking if the (, [, and { symbols
 * in an input file are correctly matched.
 * 
 * @author Brian Rodriguez and Michael Kim
 */

public class BalancedSymbolChecker {

	/**
	 * Returns a message indicating whether the input file has unmatched
	 * symbols. (Use the methods below for constructing messages.) Throws
	 * FileNotFoundException if the file does not exist.
	 */
	public String checkFile(String filename) throws FileNotFoundException {
		LinkedListStack<Character> stack = new LinkedListStack<>();
		File file = new File(filename);
		Scanner in = new Scanner(file);
		int lineNumber = 0;
		Boolean openBlock = false;
		
		while(in.hasNext())
		{
			Boolean quoteBlock = false;
			Boolean charBlock = false;
			lineNumber += 1;
			String current = in.nextLine();
			char[] chars = new char[current.length()];
			current.getChars(0, current.length(), chars, 0);
			
			for(int i = 1; i <= chars.length; i++)
			{
				char currChar = chars[i - 1];
				char nextChar;
				char prevChar;
				if(i < chars.length)
				{
					nextChar = chars[i];
				}
				else
				{
					nextChar = '\u0000';
				}
				
				if(i >= 2)
				{
					prevChar = chars[i-2];
				}
				else
				{
					prevChar = '\u0000';
				}

				if(currChar == '/' && nextChar == '/' && !openBlock && !quoteBlock)
				{
					break;
				}
				else if(currChar == '/' && nextChar == '*' && !quoteBlock)
				{
					openBlock = true;
				}
				else if(currChar == '*' && nextChar == '/' && !quoteBlock)
				{
					if(prevChar == '/')
					{
						openBlock = true;
					}
					else
					{
						openBlock = false;
					}
				}
				else if(currChar == '"' && !openBlock && !charBlock)
				{
					if(prevChar == '\\' && currChar == '"')
					{
						
					}
					else
					{
							quoteBlock = !quoteBlock;
					}
				}
				else if(currChar == '\'' && !openBlock && !quoteBlock)
				{
					if(prevChar == '\\' && currChar == '\'')
					{
						
					}
					else
					{
						charBlock = !charBlock;
					}
				}
				
				if(!openBlock && !quoteBlock && !charBlock)
				{
					if(currChar == '(' || currChar == '{' || currChar == '[')
					{
						stack.push(currChar);
					}
				
					else if (currChar == ')' || currChar == '}' || currChar == ']')
					{
						
						if(stack.size() > 0)
						{
							char poppedSymbol = stack.pop();
						
							if(poppedSymbol == '(')
							{
								if(!(currChar == ')'))
								{
									in.close();
									return unmatchedSymbol(lineNumber, i, currChar, ')');
								}
							}
							if(poppedSymbol == '{')
							{
								if(!(currChar == '}'))
								{
									in.close();
									return unmatchedSymbol(lineNumber, i, currChar, '}');
								}
							}
							if(poppedSymbol == '[')
							{
								if(!(currChar == ']'))
								{
									in.close();
									return unmatchedSymbol(lineNumber, i, currChar, ']');
								}
							}
						}
						else
						{
							in.close();
							return unmatchedSymbol(lineNumber, i, currChar, ' ');
						}
					}	
				}
			}
		}
		
		in.close();
		
		if(openBlock)
		{
			return unfinishedComment();
		}
		if(!stack.isEmpty())
		{
			char poppedSymbol = stack.pop();
			
			if(poppedSymbol == '(')
			{
				return unmatchedSymbolAtEOF(')');
			}
			if(poppedSymbol == '{')
			{
				return unmatchedSymbolAtEOF('}');
			}
			if(poppedSymbol == '[')
			{
				return unmatchedSymbolAtEOF(']');
			}
		}
		return allSymbolsMatch();
	}

	/**
	 * Returns an error message for unmatched symbol at the input line and
	 * column numbers. Indicates the symbol match that was expected and the
	 * symbol that was read.
	 */
	private String unmatchedSymbol(int lineNumber, int colNumber, char symbolRead, char symbolExpected) {
		return "ERROR: Unmatched symbol at line " + lineNumber + " and column " + colNumber + ". Expected " + symbolExpected
				+ ", but read " + symbolRead + " instead.";
	}

	/**
	 * Returns an error message for unmatched symbol at the end of file.
	 * Indicates the symbol match that was expected.
	 */
	private String unmatchedSymbolAtEOF(char symbolExpected) {
		return "ERROR: Unmatched symbol at the end of file. Expected " + symbolExpected + ".";
	}

	/**
	 * Returns an error message for a file that ends with an open /* comment.
	 */
	private String unfinishedComment() {
		return "ERROR: File ended before closing comment.";
	}

	/**
	 * Returns a message for a file in which all symbols match.
	 */
	private String allSymbolsMatch() {
		return "No errors found. All symbols match.";
	}
}