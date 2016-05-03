package assignment01;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTester {

	Matrix M1 =  new Matrix(new int[][] {{1, 6}, {3, 17}});
	
	Matrix M2 = new Matrix(new int[][] {{4, 5, 1}, {4, 1, 5}, {12, 41, 52}});
	
	Matrix M3 = new Matrix(new int[][] {{56, 62, 12, 4}, {14, 12, 5, 7}, {1, 4, 5, 7}});
	
	Matrix M4 = new Matrix(new int [][] {{2, 3, 1 , 0}, {0, 0, 0, 0}, {1, 5, 6, 7}});
	
	Matrix M5 = new Matrix(new int[][] {{2, 4, 1}, {4, 2, 6}});
	
	Matrix M6 = new Matrix(new int[][] {{3, 1, 5}, {5, 1, 6}, {74, 35, 76}});
	
	Matrix M7 = new Matrix(new int[][] {{2, 4, 1}, {4, 2, 6}, {23, 45, 56}});
	
	Matrix M8 =  new Matrix(new int[][] {{12, 7}, {6, 3}});
	
	@Test
	public void testTimes () 
	{
		assertEquals(new Matrix(new int[][]{{26,16,37},{74,46,105}}), M1.times(M5));
		assertEquals(new Matrix(new int[][]{{295, 312, 78, 58},{243, 280, 78, 58}, {1298, 1444, 609, 699}}), M2.times(M3));
		assertEquals(new Matrix(new int[][]{{100, 41, 110}, {466, 216, 488}}), M5.times(M6));
		assertEquals(new Matrix(new int[][]{{9, 17, 10, 7}, {13, 37, 34, 35}, {76, 296, 324, 364}}), M2.times(M4));
		assertEquals(null, M2.times(M8));
		assertEquals(null, M4.times(M3));
		assertEquals(null, M8.times(M2));
		assertEquals(null, M6.times(M5));
	}
	@Test
	public void testAddition ()
	{
		assertEquals(new Matrix(new int[][]{{7, 6, 6}, {9, 2, 11}, {86, 76, 128}}), M2.plus(M6));
		assertEquals(new Matrix(new int[][]{{5, 5, 6}, {9, 3, 12}, {97, 80, 132}}), M6.plus(M7));
		assertEquals(new Matrix(new int[][]{{13, 13}, {9, 20}}), M1.plus(M8));
		assertEquals(new Matrix(new int[][]{{6, 9, 2}, {8, 3, 11}, {35, 86, 108}}), M2.plus(M7));
		assertEquals(null, M3.plus(M5));
		assertEquals(null, M7.plus(M8));
		assertEquals(null, M6.plus(M1));
		assertEquals(null, M4.plus(M2));
	}
	
	@Test
	public void testToString ()
	{
		assertEquals("1 6 \n3 17 \n",M1.toString());
		assertEquals("56 62 12 4 \n14 12 5 7 \n1 4 5 7 \n", M3.toString());
		assertEquals("3 1 5 \n5 1 6 \n74 35 76 \n", M6.toString());
		assertEquals("2 4 1 \n4 2 6 \n23 45 56 \n", M7.toString());
		assertEquals("2 3 1 0 \n0 0 0 0 \n1 5 6 7 \n", M4.toString());
	}
	
	@Test
	public void testEquals ()
	{
		Matrix M9 = new Matrix(new int[][] {{2, 3, 1, 0}, {0, 0, 0, 0}, {1, 5, 6, 7}});
		
		Matrix M10 = new Matrix(new int[][] {{56, 62, 12, 4}, {14, 12, 5, 7}, {1, 4, 7, 7}});
		
		assertEquals(true, M1.equals(M1));
		assertEquals(true, M9.equals(M4));
		assertEquals(false, M7.equals(M3));
		assertEquals(false, M6.equals(M9));
		assertEquals(false, M3.equals(M10));
	}

}
