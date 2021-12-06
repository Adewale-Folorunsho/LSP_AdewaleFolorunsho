package org.howard.edu.lsp.assignment7.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.howard.edu.lsp.assignment7.Polynomial;
import org.howard.edu.lsp.assignment7.Term;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


class PolynomialTest {
	Polynomial poly1 = new Polynomial();
	Scanner myReader;
	String some = "";
	
	/**
	 * get the data.txt file
	 */
	PolynomialTest(){
		File myObj = new File("src/org/howard/edu/lsp/assignment7/junit/data/data.txt");
		try {
			myReader = new Scanner(myObj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * test for all the functions in the polynomial class
	 */
	
	@Test
	@DisplayName("Test for all functions")
	void testPolyClass() {
		int length = 0;
		int track = 0;
		String[] arrOfStr;
		String data;
		String coefficient = "", exponent = "";
		some = "this";
    	data = myReader.nextLine();
		arrOfStr = data.split(";");
		length = arrOfStr.length / 2;
		track = 0;
		for(int j = 0; j < length; j++) {
			coefficient = arrOfStr[track];
			track += 1;
			exponent = arrOfStr[track];
			track += 1;
			poly1.insertTerm(new Term(Integer.parseInt(coefficient), Integer.parseInt(exponent)));
		}
		assertEquals("8 - 4x + 5x^2 ", poly1.toString());
		
		data = myReader.nextLine();
		arrOfStr = data.split(";");
		length = arrOfStr.length / 2;
		track = 0;
		for(int j = 0; j < length; j++) {
			coefficient = arrOfStr[track];
			track += 1;
			exponent = arrOfStr[track];
			track += 1;
			poly1.delete(Integer.parseInt(coefficient), Integer.parseInt(exponent));
		}
		assertEquals("8 + 5x^2 ", poly1.toString());
		assertEquals("40x^2", poly1.product());
		assertEquals("5x^2 + 8 ", poly1.reverse());
		
	}
	


}