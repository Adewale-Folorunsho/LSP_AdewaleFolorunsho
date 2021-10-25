package org.howard.edu.lsp.assignment3.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.howard.edu.lsp.assignment3.implementation.IntegerSet;
import org.howard.edu.lsp.assignment3.implementation.IntegerSetException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntegerSetTest {
	
	static IntegerSet set1 = new IntegerSet();
	static IntegerSet set2 = new IntegerSet();
	
	@Test
	@DisplayName("Test the clear function")
	void testClear() {
		
		set1.clear();
		set2.clear();
		
		int set1Len = set1.length();
		int set2Len = set2.length();
		
		assertEquals(0, set1Len);
		assertEquals(0, set2Len);
	}
	
	@BeforeEach
	@Test
	@DisplayName("Test the add function")
	void testAdd() {
		
		set1.add(1);
		set1.add(12);
		set1.add(53);
		set1.add(46);
		set1.add(46);
		
		set2.add(90);
		set2.add(0);
		set2.add(76);
		set2.add(79);
		set2.add(30);
		set2.add(20);
		set2.add(79);
		
		String set1Str = set1.toString();
		String set2Str = set2.toString();
		
		assertEquals("1 12 53 46", set1Str);
		assertEquals("90 0 76 79 30 20", set2Str);
	}
	
	@Test
	@DisplayName("Test the remove function")
	void testRemove(){
		
		String set1Str = new String();
		String set2Str = new String();
		String set3Str = new String();
		
		IntegerSet set3 = new IntegerSet();
		
		try {
			
			set1.remove(10);
			set1Str = set1.toString();
			
		} catch (IntegerSetException e) {
			
			set1Str = e.getLocalizedMessage();
			
		}
		
		try {
			
			set2.remove(0);
			
			set2Str = set2.toString();
			
		} catch (IntegerSetException e) {
			
			set2Str = e.getLocalizedMessage();
			
		}
		
		try {
			
			set3.remove(10);
			
			set3Str = set3.toString();
			
		} catch (IntegerSetException e) {
			
			set3Str = e.getLocalizedMessage();
			
		}
		
		assertEquals("This does not exist in this set", set1Str);
		assertEquals("90 76 79 30 20", set2Str);
		assertEquals("The integer set is empty", set3Str);
	}
	
	@Test
	@DisplayName("Test length function")
	void testLength() {
		
		int set1Len = set1.length();
		int set2Len = set2.length();
		
		assertEquals(4, set1Len);
		assertEquals(6, set2Len);
	}
	
	@Test
	@DisplayName("Test equals function")
	void testEquals() {
		
		IntegerSet set3 = new IntegerSet();
		IntegerSet set4 = new IntegerSet();
		IntegerSet set5 = new IntegerSet();
		
		set3.add(1);
		set3.add(12);
		set3.add(53);
		set3.add(46);
		
		set4.add(21);
		
		set5.add(53);
		set5.add(1);
		set5.add(46);
		set5.add(12);
		
		assertTrue(set1.equals(set3));
		assertFalse(set1.equals(set4));
		assertTrue(set1.equals(set5));
	}
	
	@Test
	@DisplayName("Test contains function")
	void testContains() {
		
		assertTrue(set1.contains(53));
		assertFalse(set1.contains(88));
	}
	
	@Test
	@DisplayName("Test largest function")
	void testLargest() {
		
		IntegerSet set3 = new IntegerSet();
		
		String set1Largest = new String();
		String set3Largest = new String();
		
		try {
			
			set1Largest = String.valueOf(set1.largest());
			
		} catch (IntegerSetException e) {
			
			set1Largest = e.getLocalizedMessage();
			
		}
		
		try {
			
			set3Largest = String.valueOf(set3.largest());
			
		} catch (IntegerSetException e) {
			
			set3Largest = e.getLocalizedMessage();
			
		}
		
		assertEquals("53", set1Largest);
		assertEquals("The integer set is empty", set3Largest);
	}

	@Test
	@DisplayName("Test smallest function")
	void testSmallest() {
		
		IntegerSet set3 = new IntegerSet();
		
		String set1Smallest = new String();
		String set3Smallest = new String();
		
		try {
			
			set1Smallest = String.valueOf(set1.smallest());
			
		} catch (IntegerSetException e) {
			
			set1Smallest = e.getLocalizedMessage();
			
		}
		
		try {
			
			set3Smallest = String.valueOf(set3.smallest());
			
		} catch (IntegerSetException e) {
			
			set3Smallest = e.getLocalizedMessage();
			
		}
		
		assertEquals("1", set1Smallest);
		assertEquals("The integer set is empty", set3Smallest);
	}

	@Test
	@DisplayName("Test union function")
	void testUnion() {
		
		IntegerSet set3 = new IntegerSet();
		
		set3.add(90);
		set3.add(65);
		
		set3.union(set1);
		
		String set3Str = set3.toString();
		
		assertEquals("90 65 1 12 53 46", set3Str);
		
	}

	@Test
	@DisplayName("Test intersection function")
	void testIntersect() {
		
		IntegerSet set3 = new IntegerSet();
		
		set3.add(90);
		set3.add(65);
		set3.add(53);
		set3.add(46);
		
		set3.intersect(set1);
		
		String set3Str = set3.toString();
		
		assertEquals("53 46", set3Str);
		
	}

	@Test
	@DisplayName("Test difference function")
	void testDifference() {
		
		IntegerSet set3 = new IntegerSet();
		
		set3.add(90);
		set3.add(65);
		set3.add(53);
		set3.add(46);
		
		set3.diff(set1);
		
		String set3Str = set3.toString();
		
		assertEquals("90 65", set3Str);
		
	}

	@Test
	@DisplayName("Test empty function")
	void testEmpty() {
		
		IntegerSet set3 = new IntegerSet();
		
		set3.add(90);
		set3.add(65);
		set3.add(53);
		set3.add(46);
		
		set3.clear();
		
		boolean set3IsEmpty = set3.isEmpty();
		
		assertTrue(set3IsEmpty);
		
	}

	@Test
	@DisplayName("Test toString function")
	void testToString() {
		
		String set1Str = set1.toString();
		
		assertEquals("1 12 53 46", set1Str );
	}
}
