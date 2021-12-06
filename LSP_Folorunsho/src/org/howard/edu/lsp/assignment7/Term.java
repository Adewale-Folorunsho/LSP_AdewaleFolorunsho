package org.howard.edu.lsp.assignment7;

/**
 * Representation of the Term class
 */
public class Term {
	private int coefficient, exponent;
	private String termValue;
	
	/**
	 * term Constructor
	 * @param coefficient - the coefficient for the term
	 * @param  exponent - exponent for the term
	 */
	public Term(int coefficient, int exponent){
		this.coefficient = coefficient;
		this.exponent = exponent;
		calcTerm();
	}
	
	/**
	 * calculate the string value of the term
	 */
	private void calcTerm() {
		if (exponent == 0) {
			termValue = String.valueOf(coefficient);
			return;
		}
		else if (exponent == 1) {
			termValue = String.valueOf(coefficient) + "x";
			return;
		}
		else if (coefficient == 1) {
			termValue = "x^" + String.valueOf(exponent);
			return;
		}else if (coefficient == 0) {
			termValue = "0";
			return;
		};
		termValue = String.valueOf(coefficient) + "x^" + String.valueOf(exponent);
	}
	
	/**
	 * get the coefficient value
	 * @return coefficient value
	 */
	public int getCoefficient() {
		return coefficient;
	}
	
	/**
	 * get the exponent value
	 * @return exponent value
	 */
	public int getExponent() {
		return exponent;
	}
	
	/**
	 * return the term value
	 * @return term value
	 */
	public String getValue() {
		return termValue;
	}
	
	/**
	 * print the term in specified format
	 * @return null
	 */
	public String toString() {
		Object[] table = {"Coefficient","Exponent", "Returns"};
		System.out.format("%15s%15s%15s%n", table);
		
		Object[] table1 = {coefficient, exponent, termValue};
		System.out.format("%15s%15s%15s%n", table1);
		
		return null;
	}
	
	
}
