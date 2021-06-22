package com.bougataya.stringCalculator.stringCalculatorKataLog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ExtractNumbersTest {
	
	private static final String NUMBERS_LIST_WITH_DIFFERENT_DELIMITERS = "\n|·1,2,3,aaaabbbf4%5&6";
	private static final String STRING_WITHOUT_NUMBERS = "abcdf";

    @Test
    public void sould_return_a_collection_with_the_numbers_extracted() {
        List<Integer> result = ExtractNumbers.extractAllNumbers(ExtractNumbersTest.NUMBERS_LIST_WITH_DIFFERENT_DELIMITERS);
        List<Integer> expectedResult = TestsTools.generateListNumbers(1, 2, 3, 4, 5, 6);
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void should_return_an_empty_collection_if_the_Param_is_null() {
        List<Integer> result = ExtractNumbers.extractAllNumbers(null);
        List<Integer> expectedResult = new ArrayList<Integer>();
        assertEquals(expectedResult, result);
    }

    @Test
    public void should_return_an_empty_collection_if_the_param_is_empty() {
        List<Integer> result = ExtractNumbers.extractAllNumbers("");
        List<Integer> expectedResult = new ArrayList<Integer>();
        assertEquals(expectedResult, result);
    }

    @Test
    public void should_return_an_empty_collection_of_numbers_if_there_is_no_numbers_inside_the_string() {
        List<Integer> result = ExtractNumbers.extractAllNumbers(ExtractNumbersTest.STRING_WITHOUT_NUMBERS);
        List<Integer> expectedResult = new ArrayList<Integer>();
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void should_return_list_of_negative_numbers_from_list_numbers() {
    	List<Integer> initialList = TestsTools.generateListNumbers(1,2,3,-5,-9,-10,8);
    	List<Integer> result = ExtractNumbers.extractNegativeNumbers(initialList);
        List<Integer> expectedResult = TestsTools.generateListNumbers(-5,-9,-10);
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void should_return_empty_list_if_there_are_no_negative_numbers() {
    	List<Integer> initialList = TestsTools.generateListNumbers(1,2,10,8);
    	List<Integer> result = ExtractNumbers.extractNegativeNumbers(initialList);
        assertEquals(0, result.size());
    }
    
    @Test
    public void should_return_list_of_numbers_younger_than_1000_from_list_numbes() {
    	List<Integer> initialList = TestsTools.generateListNumbers(1004,1,998,1000,1001,1005,3000);
    	List<Integer> result = ExtractNumbers.extractValidateNumbers(initialList);
        List<Integer> expectedResult = TestsTools.generateListNumbers(1,998,1000);
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void should_return_empty_list_if_there_are_no_numbers_younger_than_1000() {
    	List<Integer> initialList = TestsTools.generateListNumbers(9981,1020,1001,1005,3000);
    	List<Integer> result = ExtractNumbers.extractValidateNumbers(initialList);
        assertEquals(0, result.size());
    }
}
