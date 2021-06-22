package com.bougataya.stringCalculator.stringCalculatorKataLog;

import java.util.List;

import com.bougataya.stringCalculator.stringCalculatorKataLog.exception.NegativeNumbersNotAllowedException;

public class StringCalculator {
	
	public static int add(final String numbers) throws NegativeNumbersNotAllowedException {
		List<Integer> numbersList = ExtractNumbers.extractAllNumbers(numbers);
		
		checkIfListContainsNegativeNumbers(numbersList);
		
		numbersList = ExtractNumbers.extractValidateNumbers(numbersList);
		
		return numbersList.stream()
				  .reduce(0, (a, b) -> a + b);
	}
	
	public static void checkIfListContainsNegativeNumbers(List<Integer> numbers) throws NegativeNumbersNotAllowedException {
		List<Integer> listNumberNehative = ExtractNumbers.extractNegativeNumbers(numbers);
		if(listNumberNehative.size() > 0) {
			throw new NegativeNumbersNotAllowedException(listNumberNehative);
		}
	}

}
