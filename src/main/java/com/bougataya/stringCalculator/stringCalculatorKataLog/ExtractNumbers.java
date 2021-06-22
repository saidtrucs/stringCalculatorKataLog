package com.bougataya.stringCalculator.stringCalculatorKataLog;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ExtractNumbers {
	
	private static final int THE_LARGEST_VALID_NUMBER = 1000;
	private static final String ONE_OR_MORE_DIGIT_REGEX = "-?\\d+";

	public static List<Integer> extractAllNumbers(final String initialNumberList) {
        List<Integer> result = new ArrayList<>();
        if (initialNumberList != null && !initialNumberList.isEmpty()) {
        	Matcher matcher = Pattern.compile(ExtractNumbers.ONE_OR_MORE_DIGIT_REGEX).matcher(initialNumberList);
        	while (matcher.find()) {
                result.add(Integer.parseInt(matcher.group()));
            }
            return result;
        }
        return result;
    }
	
    public static List<Integer> extractNegativeNumbers(final List<Integer> numbers) {
        return numbers
        		.stream()
	            .filter(n -> n < 0)
	            .collect(Collectors.toList());
    }
    
    public static List<Integer> extractValidateNumbers(final List<Integer> numbers) {
        return numbers
        		.stream()
	            .filter(n -> n <= ExtractNumbers.THE_LARGEST_VALID_NUMBER)
	            .collect(Collectors.toList());
    }
}
