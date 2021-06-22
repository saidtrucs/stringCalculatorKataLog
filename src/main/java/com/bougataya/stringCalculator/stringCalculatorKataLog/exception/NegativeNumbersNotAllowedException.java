package com.bougataya.stringCalculator.stringCalculatorKataLog.exception;

import java.util.List;

public class NegativeNumbersNotAllowedException extends Exception {

	private static final String EXCEPTION_MESSAGE = "Negatives numbers not allowed: ";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Integer> listOfNegativeNumbers;
	
	
	
	public NegativeNumbersNotAllowedException(List<Integer> listOfNegativeNumbers) {
		super();
		this.listOfNegativeNumbers = listOfNegativeNumbers;
	}


	@Override
    public String getMessage() {
        return EXCEPTION_MESSAGE + listOfNegativeNumbers.toString();
    }
}
