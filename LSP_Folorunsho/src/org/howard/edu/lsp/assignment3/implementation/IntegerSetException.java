package org.howard.edu.lsp.assignment3.implementation;

/**
 * used to direct to an exception with a customized message
 * @author adewalefolorunsho
 *
 */
public class IntegerSetException extends Exception {

	  /**
	   * @param e -> thrown exception object/message
	   */
	  public IntegerSetException(String e) {
	    super(e);
	  }
}