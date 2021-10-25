package org.howard.edu.lsp.assignment3.implementation;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Integer set is a class that contains a set of integer variables
 * @author adewalefolorunsho
 *
 */
public class IntegerSet {
	
	private ArrayList<Integer> set = new ArrayList<Integer>();

	// Default Constructor
	public IntegerSet() {
	}

	/**
	 * Clears the internal representation of the set
	 */
	public void clear() {
		set.clear();
	};
	
	/**
	 * its a getter function that gets the value of set
	 * @return set value
	 */
	public ArrayList<Integer> getSet() {
	    return set;
	  }

	/**
	 * Returns the length of the set
	 * @return the length of the set
	 */
	public int length() {
		return set.size();
	}; // returns the length

	/**
	 * Returns true if the set is empty, false otherwise
	 * @return true if the set is empty, false otherwise
	 */
	public boolean isEmpty() {
		return set.size() == 0;
	}; 
	
	/**
	 * Returns true if the 2 sets are equal, false otherwise;
	 * Two sets are equal if they contain all of the same values in ANY order.
	 * @param b -> the IntegerSet to be compared
	 * @return a bool that says if they are equal or not
	 */
	public boolean equals(IntegerSet b) {
		ArrayList<Integer> bSet = new ArrayList(b.getSet());
		Collections.sort(bSet);
		ArrayList<Integer> setDuplicate = new ArrayList(set);
		Collections.sort(setDuplicate);
		return setDuplicate.equals(bSet);
	}; 

	/**
	 * Returns true if the set contains the value, otherwise false
	 * @param value-> the value to check if in set
	 * @return if value is in set
	 */
	public boolean contains(int value) {
		return set.contains(value);
	};    

	/**
	 * Returns the largest item in the set; Throws a IntegerSetException if the set is empty 
	 * @return the largest value in set
	 * @throws IntegerSetException if set is empty
	 */
	public int largest() throws IntegerSetException {
		if(isEmpty()) {
			throw new IntegerSetException("The integer set is empty");
		}
		Integer largestVal = set.get(0);
		for(Integer element : set) {
			if(element > largestVal) largestVal = element;
		}
		
		return largestVal;
	}; 

	/**
	 * Returns the smallest item in the set; Throws a IntegerSetException if the set is empty
	 * @return the smallest value in set
	 * @throws IntegerSetException if set is empty
	 */
	public int smallest() throws IntegerSetException{
		if(isEmpty()) {
			throw new IntegerSetException("The integer set is empty");
		}
		Integer smallestVal = set.get(0);
		for(Integer element : set) {
			if(element < smallestVal) smallestVal = element;
		}
		
		return smallestVal;
	};

	/**
	 * Adds an item to the set or does nothing it already there	
	 * @param item-> item to be added to set
	 */
	public void add(int item) {
		if(!set.contains(item)) set.add(item);
	}; // adds item to s or does nothing if it is in set

	/**
	 *  Removes an item from the set or does nothing if not there
	 * @param item -> to be removed from set
	 * @throws IntegerSetException -> if set is empty
	 */
	public void remove(int item) throws IntegerSetException {
		if(isEmpty()) {
			throw new IntegerSetException("The integer set is empty");
		}else if(!set.contains(item)) {
			throw new IntegerSetException("This does not exist in this set");
		}
		set.remove(Integer.valueOf(item));
	};  //Throws aIntegerSetException of the set is empty

	/**
	 * Finds the union of two sets and makes the set that calls the function the value of the union
	 * @param b -> IntegerSet
	 */
	public void union(IntegerSet b) {
		ArrayList<Integer> bSet = new ArrayList(b.getSet());
		for(Integer element: bSet) {
			if(!set.contains(element)) set.add(element);
		}
		
	};

	/**
	 * Finds the intersection of two sets and makes the set that calls the function the value of the operation
	 * @param b -> IntegerSet
	 */
	public void intersect(IntegerSet b) {
		ArrayList<Integer> bSet = new ArrayList(b.set);
		ArrayList<Integer> setIntersection = new ArrayList();
		
		for (Integer element : bSet) {
			if(!setIntersection.contains(element)) {
				if(set.contains(element)) {
					setIntersection.add(element);
				}
			}
		}
		
		set.clear();
		for (Integer item : setIntersection) {
		      set.add(item);
		    }
	}; 

	/**
	 * Set difference, i.e., s1 –s2
	 * @param b -> IntegerSet that contains the set to be operated on
	 */
	public void diff(IntegerSet b) {
		ArrayList<Integer> bSet = new ArrayList(b.getSet());
		ArrayList<Integer> setDifference = new ArrayList();
		
		for (Integer element : set) {
			if(!bSet.contains(element)) setDifference.add(element);
		}
		
		set.clear();
		for (Integer item : setDifference) {
		      set.add(item);
		    }
	} // set difference, i.e. s1 - s2

	

	/**
	 * Return String representation of your set
	 */
	public String toString() {
		ArrayList<String> stringRep = new ArrayList<String>();
	    for (Integer item : set) {
	    	stringRep.add(String.valueOf(item));
	    }
	    return String.join(" ", stringRep);
	};	// return String representation of your set
	
}
