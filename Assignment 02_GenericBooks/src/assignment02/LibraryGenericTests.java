package assignment02;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import assignment02.LibraryGeneric;/**
 * 
 * @author Brian Rodriguez & Chasen Chamberlain
 *
 */
public class LibraryGenericTests 
{	
	
	/**
	 * DID NOT KNOW HOW TO COMPARE A TYPE ARRAY WITH ANOTHER. 
	 * IN OTHER WORDS IT WAS VREY HARD TO CONVERT AN ARRAY TO ANOTHER WITHOUT 
	 * ADDING ALL THE ELEMENTS MANUALLY
	 */
	@Test
	public void testCheckoutWithLookUpType() 
	{
		LibraryGeneric<String> lib1 = new LibraryGeneric<String>();
	    lib1.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
	    lib1.add(9780330351690L, "Jon Krakauer", "Into the Wild");
	    lib1.add(9780446580342L, "David Baldacci", "Simple Genius");
	    lib1.addAll("Mushroom_Publishing.txt");
	    String person1 = "Brian Rodriguez";
	    
		lib1.checkout(9780446580342L, person1, 12, 9, 2016);
		lib1.checkout(9781843193319L, person1,12, 9, 2016);
		lib1.checkout(9781843192954L, person1, 12, 9, 2016);
		lib1.checkout(9781843192701L, person1, 12, 9, 2016);
		
		LibraryGeneric<String> lib2 = new LibraryGeneric<String>();
		
		lib2.add(9780446580342L, "David Baldacci", "Simple Genius");
		lib2.add(9781843192701L, "Moyra Caldecott", "The Lily and the Bull");
		lib2.add(9781843192954L, "Dennis Radha-Rose", "The Anxiety Relief Program");
		lib2.add(9781843193319L, "Alan Burt Akers", "Transit to Scorpio");
		
		assertEquals(lib2 , lib1.lookup(person1));
	}
	
	@Test
	public void testCheckOutWithLookUpISBN ()
	{
		LibraryGeneric<String> lib1 = new LibraryGeneric<String>();
	    lib1.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
	    lib1.add(9780330351690L, "Jon Krakauer", "Into the Wild");
	    lib1.add(9780446580342L, "David Baldacci", "Simple Genius");
	    lib1.addAll("Mushroom_Publishing.txt");
	    String person1 = "Brian Rodriguez";
	    String person2 = "Steven Rodriguez";
	    String person3 = "Sandy Rodriguez";
	    String person4 = "Lorenzo Rodriguez";
	    
		lib1.checkout(9780446580342L, person1, 12, 9, 2016);
		lib1.checkout(9781843193319L, person2,12, 9, 2016);
		lib1.checkout(9781843192954L, person3, 12, 9, 2016);
		lib1.checkout(9781843192701L, person4, 12, 9, 2016);
		
		assertEquals(person1 ,lib1.lookup(9780446580342L));
		assertEquals(person2, lib1.lookup(9781843193319L));
	    assertEquals(person3, lib1.lookup(9781843192954L));
	    assertEquals(person4, lib1.lookup(9781843192701L));
	}
	
	@Test
	public void testCheckOutWithCheckInISBN ()
	{
		LibraryGeneric<String> lib1 = new LibraryGeneric<String>();
	    lib1.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
	    lib1.add(9780330351690L, "Jon Krakauer", "Into the Wild");
	    lib1.add(9780446580342L, "David Baldacci", "Simple Genius");
	    lib1.addAll("Mushroom_Publishing.txt");
	    String person1 = "Brian Rodriguez";
	    String person2 = "Steven Rodriguez";
	    String person3 = "Sandy Rodriguez";
	    String person4 = "Lorenzo Rodriguez";
	    
		lib1.checkout(9780446580342L, person1, 12, 9, 2016);
		lib1.checkout(9781843193319L, person2,23, 4, 2016);
		lib1.checkout(9781843192954L, person3, 11, 6, 2016);
		lib1.checkout(9781843192701L, person4, 6, 8, 2016);
		lib1.checkout(9780330351690L, person3, 23, 11, 2016);
		lib1.checkout(9780374292799L, person4, 1, 4, 2016);
		
		assertEquals(true, lib1.checkin(9780446580342L));
		assertEquals(true, lib1.checkin(9781843193319L));
		assertEquals(true, lib1.checkin(9781843192954L));
		assertEquals(false, lib1.checkin(9781843190073L));
		assertEquals(false, lib1.checkin(9788888888889L));
		assertEquals(false, lib1.checkin(0));
	}
	
	@Test
	public void testCheckOutWithCheckInType ()
	{
		LibraryGeneric<String> lib1 = new LibraryGeneric<String>();
	    lib1.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
	    lib1.add(9780330351690L, "Jon Krakauer", "Into the Wild");
	    lib1.add(9780446580342L, "David Baldacci", "Simple Genius");
	    lib1.addAll("Mushroom_Publishing.txt");
	    String person1 = "Brian Rodriguez";
	    String person2 = "Steven Rodriguez";
	    String person3 = "Sandy Rodriguez";
	    String person4 = "Lorenzo Rodriguez";
	    
		lib1.checkout(9780446580342L, person3, 12, 9, 2016);
		lib1.checkout(9781843193319L, person2,23, 4, 2016);
		lib1.checkout(9781843192954L, person4, 11, 6, 2016);
		lib1.checkout(9781843192701L, person4, 6, 8, 2016);
		lib1.checkout(9780330351690L, person3, 23, 11, 2016);
		lib1.checkout(9780374292799L, person3, 1, 4, 2016);
		
		assertEquals(true, lib1.checkin(person3));
		assertEquals(false, lib1.checkin(person1));
		assertEquals(false, lib1.checkin(null));
		assertEquals(true, lib1.checkin(person2));
		assertEquals(true, lib1.checkin(person4));
	}
	
	@Test
	public void testOrderedByAuthor()
	{
		LibraryGeneric<String> lib1 = new LibraryGeneric<String>();
	    lib1.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
	    lib1.add(9780330351690L, "Jon Krakauer", "Into the Wild");
	    lib1.add(9780446580342L, "David Baldacci", "Simple Genius");
	    lib1.addAll("Mushroom_Publishing.txt");
	    
	    ArrayList<LibraryBookGeneric<String>> sortedLib = lib1.getOrderedByAuthor();
	    
	    
	    LibraryBookGeneric<String> Whistler = new LibraryBookGeneric<String>(9781843192022L, "Roger Taylor", "Whistler");
	    LibraryBookGeneric<String> ComingoftheThird = new LibraryBookGeneric<String>(9781843190073L, "Jen Alexander", "The Coming of the Third");
	    LibraryBookGeneric<String> BathCity = new LibraryBookGeneric<String>(9781843190042L, "Martyn Folkes", "Bath City Centre Street Map and Guide");
	    LibraryBookGeneric<String> WeaponsWolfhound = new LibraryBookGeneric<String>(9781843190004L, "Moyra Caldecott", "Weapons of the Wolfhound");

	    
	    assertEquals(Whistler, sortedLib.get(23));
	    assertEquals(ComingoftheThird, sortedLib.get(12));
	    assertEquals(BathCity, sortedLib.get(15));
	    assertEquals(WeaponsWolfhound, sortedLib.get(20));
	}
	
	@Test
	public void testGetOverDueList ()
	{
		LibraryGeneric<String> lib1 = new LibraryGeneric<String>();
	    lib1.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
	    lib1.add(9780330351690L, "Jon Krakauer", "Into the Wild");
	    lib1.add(9780446580342L, "David Baldacci", "Simple Genius");
	    lib1.addAll("Mushroom_Publishing.txt");

	    String person2 = "Steven Rodriguez";
	    String person3 = "Sandy Rodriguez";
	    String person4 = "Lorenzo Rodriguez";
	    
		lib1.checkout(9780446580342L, person3, 12, 9, 2013);
		lib1.checkout(9781843193319L, person2,23, 4, 2013);
		lib1.checkout(9781843192954L, person4, 11, 6, 2013);
		lib1.checkout(9781843192701L, person4, 6, 8, 2012);
		lib1.checkout(9780374292799L, person3, 1, 4, 2014);
		lib1.checkout(9781843190936L, person2, 1, 3, 2016);
		
		ArrayList<LibraryBookGeneric<String>> sortedOverDueList = lib1.getOverdueList(3, 1, 2016);
		
		LibraryBookGeneric<String> Lily = new LibraryBookGeneric<String>(9781843192701L, "Moyra Caldecott", "The Lily and the Bull");
	    LibraryBookGeneric<String> Anxiety = new LibraryBookGeneric<String>(9781843192954L, "Dennis Radha-Rose", "The Anxiety Relief Program");
	    LibraryBookGeneric<String> World = new LibraryBookGeneric<String>(9780374292799L, "Thomas L. Friedman", "The World is Flat");
	    LibraryBookGeneric<String> Machina = new LibraryBookGeneric<String>(9781843190936L, "Carol E. Meacham", "Machina Obscura");

	    System.out.println(sortedOverDueList);
	    
		assertEquals(Lily, sortedOverDueList.get(0));
		assertEquals(Machina, sortedOverDueList.get(5));
		assertEquals(Anxiety, sortedOverDueList.get(1));
		assertEquals(World, sortedOverDueList.get(3));
	}
	
	@Test
	public void testOrderByISBN ()
	{
		LibraryGeneric<String> lib1 = new LibraryGeneric<String>();
	    lib1.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
	    lib1.add(9780330351690L, "Jon Krakauer", "Into the Wild");
	    lib1.add(9780446580342L, "David Baldacci", "Simple Genius");
	    lib1.addAll("Mushroom_Publishing.txt");
	    
	    ArrayList<LibraryBookGeneric<String>> orderedLib = lib1.getInventoryList();
	    
	    LibraryBookGeneric<String> Lily = new LibraryBookGeneric<String>(9781843192701L, "Moyra Caldecott", "The Lily and the Bull");
	    LibraryBookGeneric<String> War = new LibraryBookGeneric<String>(9781843190400L, "Jean Fanelli", "The War Comes to Witham Street");
	    LibraryBookGeneric<String> Herbs = new LibraryBookGeneric<String>(9781843190677L, "Cheryl Jones", "Herbs for Healthy Skin");
	    LibraryBookGeneric<String> Machina = new LibraryBookGeneric<String>(9781843190936L, "Carol E. Meacham", "Machina Obscura");

	    assertEquals(Lily, orderedLib.get(23));
	    assertEquals(War, orderedLib.get(12));
	    assertEquals(Herbs,orderedLib.get(15));
	    assertEquals(Machina, orderedLib.get(18));
	    
	}

}
