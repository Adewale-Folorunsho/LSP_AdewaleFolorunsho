package org.howard.edu.lsp.assignment7;

public class Term {
	private int coefficient, exponent;
	private String termValue;
	public Term(int coefficient, int exponent){
		this.coefficient = coefficient;
		this.exponent = exponent;
		calcTerm();
	}
	
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
	
	public int getCoefficient() {
		return coefficient;
	}
	
	public int getExponent() {
		return exponent;
	}
	
	public String getValue() {
		return termValue;
	}
	
	public String toString() {
		Object[] table = {"Coefficient","Exponent", "Returns"};
		System.out.format("%15s%15s%15s%n", table);
		
		Object[] table1 = {coefficient, exponent, termValue};
		System.out.format("%15s%15s%15s%n", table1);
		
		return null;
	}
	
	
}
