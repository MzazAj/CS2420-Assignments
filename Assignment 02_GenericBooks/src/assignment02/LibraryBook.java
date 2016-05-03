package assignment02;
import java.util.GregorianCalendar;

/**
 * 
 * @author Brian Rodriguez & Chasen Chamberlain
 *
 */
public class LibraryBook extends Book {

	private String bookHolder;
	
	private GregorianCalendar dueDate;
	
	public LibraryBook (long isbn, String author, String title)
	{
		super(isbn, author, title);
	}
	
	/**
	 * returns the book holder for this book
	 * @return book holder
	 */
	public String getHolder ()
	{
		return this.bookHolder;
	}
	
	/**
	 * returns the due date for this book
	 * @return due date
	 */
	public GregorianCalendar getDueDate()
	{
		return this.dueDate;
	}
	
	/**
	 * checks in the book and sets both bookholder and dueDate to null
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
	public void checkOut (String bookHolder, GregorianCalendar dueDate)
	{
		this.bookHolder = bookHolder;
		
		this.dueDate = dueDate;
	}
}
