package org.howard.edu.lsp.assignment7;

import java.util.ArrayList;
import java.util.Collections;

/**
 * representation of the polynomial class
 */
public class Polynomial {
	private ArrayList<Term> polynomialList = new ArrayList<Term>();
	
	/**
	 * insert a term into the polynomial
	 */
	public void insertTerm(Term term) {
		int termExponent = term.getExponent();
		for( int i = 0; i < polynomialList.size(); i++) {
			if (termExponent < polynomialList.get(i).getExponent()) {
				polynomialList.add(i, term);
				return;
			}
		}
		polynomialList.add(term);
	}
	
	/**
	 * get the value of the polynomial as a string
	 * @return value of the polynomial as a string
	 */
	public String toString() {
		String polynomialValue = "";
		String termValue = "";
		for( int i = 0; i < polynomialList.size(); i++) {
			termValue = polynomialList.get(i).getValue();
			if( i != 0 && termValue.charAt(0) != '-') {
				polynomialValue += "+ " + termValue + " ";
			}else if( i != 0 && termValue.charAt(0) == '-') {
				polynomialValue += termValue.substring(0,1) + " " + termValue.substring(1) + " ";
			}else{
				polynomialValue += termValue + " ";
			}
		}
		return polynomialValue;
	}
	
	/**
	 * delete a term from a polynomial
	 */
	public void delete(int coefficient, int exponent) {
		String termValue;
		if (exponent == 0) {
			termValue = String.valueOf(coefficient);
		}
		else if (exponent == 1) {
			termValue = String.valueOf(coefficient) + "x";
		}else {
			termValue = String.valueOf(coefficient) + "x^" + String.valueOf(exponent);
		}
		
		for( int i = 0; i< polynomialList.size(); i++) {
			if (polynomialList.get(i).getValue().equals(termValue)) {
				polynomialList.remove(i);
				return;
			}
		}
		System.out.println("This term, " + termValue + ", does not exist in this polynomial");
	}
	
	/**
	 * get the value of the product of the polynomial as string
	 * @return value of the product
	 */
	public String product() {
		String termValue;
		int coefficient = 1;
		int exponent = 0;
		for(int i = 0; i < polynomialList.size(); i++) {
			coefficient *= polynomialList.get(i).getCoefficient();
			if(polynomialList.get(i).getExponent() != 0) {
				exponent += polynomialList.get(i).getExponent();
			}
		}
		
		if (exponent == 0) {
			termValue = String.valueOf(coefficient);
		}
		else if (exponent == 1) {
			termValue = String.valueOf(coefficient) + "x";
		}else {
			termValue = String.valueOf(coefficient) + "x^" + String.valueOf(exponent);
		}
		
		return termValue;
	}
	
	/**
	 * reverse the order of the polynomial
	 * @return reversed polynomial as a string
	 */
	public String reverse() {
	
		Collections.reverse(polynomialList);
		return toString();
		
	}
	
	public static void main(String[] args) {
		Polynomial poly = new Polynomial();
		poly.insertTerm(new Term(0,3));
		poly.insertTerm(new Term(1,0));
		poly.insertTerm(new Term(3,4));
		poly.insertTerm(new Term(-5,2));
		poly.delete(1,0);
		System.out.println(poly.product());
		System.out.println(poly.toString());
		poly.reverse();
	}
}
