package assignment02;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author Brian Rodriguez & Chasen Chamberlain
 *
 */
public class LibraryTests
{
    Library smallLib= new Library();
    
    Library medLib = new Library ();
    
    ArrayList<LibraryBook> booksCheckedOut = new ArrayList<LibraryBook>();
    
    @Test
    public void testLibIsEmptyByTryingToLookSomethingUp ()
    {
        assertEquals(null, smallLib.lookup(978037429279L));
    }
    
    @Test
    public void testLibIsCompletelyEmptyByAnyOfTheLibraryMethods ()
    {
        booksCheckedOut = smallLib.lookup("Jane Doe");
        assertEquals(false, (booksCheckedOut == null || booksCheckedOut.size() != 0));
        assertEquals(false, (smallLib.checkout(978037429279L, "Jane Doe", 1, 1, 2008)));
        assertEquals(false, (smallLib.checkin(978037429279L)));
        assertEquals(false, (smallLib.checkin("Jane Doe")));
    }
    
    
    @Before
    public void addThreeBooksToLib ()
    {
        // test a small library
        smallLib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
        smallLib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
        smallLib.add(9780446580342L, "David Baldacci", "Simple Genius");
    }
    
    @Test
    public void testAfterAddingNoHolderAssociatedWithBook ()
    {
        assertEquals(null, smallLib.lookup(9780330351690L) );
    }
    
    @Test
    public void testThatCheckoutWorksForASpecificHolder ()
    {
        assertEquals(true, smallLib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008));
    }

    @Test
    public void testHolderStatus()
    {
        smallLib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008);
        booksCheckedOut = smallLib.lookup("Jane Doe");

        assertNotNull(booksCheckedOut);
        assertEquals(1, booksCheckedOut.size());
        assertEquals(true, booksCheckedOut.get(0).equals(new Book(9780330351690L, "Jon Krakauer", "Into the Wild")));
        assertEquals(true, booksCheckedOut.get(0).getHolder().equals("Jane Doe"));
        assertEquals(true, booksCheckedOut.get(0).getDueDate().equals(new GregorianCalendar(2008, 1, 1)));
    }
    
    @Test
    public void testHolderCheckingOutSameBookAsAnotherHolderDoesntWork ()
    {
        smallLib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008);
        assertEquals(false, smallLib.checkout(9780330351690L, "Bob Ross", 1, 1, 2008));
        
        booksCheckedOut = smallLib.lookup("Bob Ross");
        
        assertEquals(0, booksCheckedOut.size());
    }
    
    @Test
    public void testJaneDoeCheckingOutAnotherBook ()
    {
        smallLib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008);
        smallLib.checkout(9780374292799L, "Jane Doe", 1, 1, 2008);
        
        booksCheckedOut = smallLib.lookup("Jane Doe");
        
        assertEquals(true, booksCheckedOut.get(1).equals(new Book(9780330351690L, "Jon Krakauer", "Into the Wild")));
        assertEquals(true, booksCheckedOut.get(0).equals(new Book(9780374292799L, "Thomas L. Friedman", "The World is Flat")));
        assertEquals("Jane Doe", smallLib.lookup(9780374292799L));
        assertEquals("Jane Doe", smallLib.lookup(9780330351690L));
    }
    
    @Test
    public void testTwoDifferentHoldersReturningTheirBooks ()
    {
        smallLib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008);
        smallLib.checkout(9780374292799L, "Jane Doe", 1, 1, 2008);
        smallLib.checkout(9780446580342L, "Bob Ross", 1, 1, 2008);
        
        assertEquals(true, smallLib.checkin("Jane Doe"));
        assertEquals(true, smallLib.checkin(9780446580342L));
        
        assertEquals(booksCheckedOut, smallLib.lookup("Jane Doe"));
        assertEquals(null, smallLib.lookup(9780446580342L));
    }
    
    @Before
    public void addMediumLibrary()
    {
        
        medLib.addAll("Mushroom_Publishing.txt");

    }
    
    @Test
    public void testMedLibWithASingleCheckout()
    {
        medLib.checkout(9781843193319L, "Jane Doe", 1, 1, 2008);
        
        booksCheckedOut = medLib.lookup("Jane Doe");

        assertEquals("Jane Doe", medLib.lookup(9781843193319L));
        assertEquals(true, booksCheckedOut.get(0).equals(new Book(9781843193319L, "Alan Burt Akers", "Transit to Scorpio")));
    }
    
    @Test
    public void testMedLibCheckin()
    {
        medLib.checkout(9781843193319L, "Jane Doe", 1, 1, 2008);
        medLib.checkout(9781843190400L, "Jane Doe", 1, 1, 2008);
        medLib.checkout(9781843190110L, "Jane Doe", 1, 1, 2008);
        medLib.checkout(9781843191230L, "Jane Doe", 1, 1, 2008);
        
        assertEquals(true, medLib.checkin("Jane Doe"));
        
        assertEquals(booksCheckedOut, medLib.lookup("Jane Doe"));
        assertEquals(null, medLib.lookup(9781843190110L));


    }
}
