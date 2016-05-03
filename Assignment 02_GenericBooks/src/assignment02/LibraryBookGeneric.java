package assignment02;

import java.util.GregorianCalendar;

/**
 * 
 * @author Brian Rodriguez & Chasen Chamberlain
 *
 */
public class LibraryBookGeneric <Type> extends Book
{
	private Type bookHolder;
	
	private GregorianCalendar dueDate;
	
	public LibraryBookGeneric(long isbn, String author, String title) 
	{
		super(isbn, author, title);
	}
	
	/**
	 * returns the book holder for this generic
	 * @return
	 */
	public Type getHolder ()
	{
		return this.bookHolder;
	}
	
	/**
	 * returns due Date
	 * @return the due Date of this generic
	 */
	public GregorianCalendar getDueDate()
	{
		return this.dueDate;
	}
	
	/**
	 * sets both bookholder and dueDate to null
	 */
	public void checkIn ()
	{
		this.bookHolder = null;
		this.dueDate = null;
	}
	
	/**
	 * Sets the bookholder to param bookHolder and sets dueDate to param dueDate
	 * @param bookHolder
	 * @param dueDate
	 */
	public void checkOut (Type bookHolder, GregorianCalendar dueDate)
	{
		this.bookHolder = bookHolder;
		
		this.dueDate = dueDate;
	}
}
