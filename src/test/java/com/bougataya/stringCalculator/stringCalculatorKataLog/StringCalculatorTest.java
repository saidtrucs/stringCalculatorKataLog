package com.bougataya.stringCalculator.stringCalculatorKataLog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bougataya.stringCalculator.stringCalculatorKataLog.exception.NegativeNumbersNotAllowedException;

class StringCalculatorTest {

	@Test
	public void should_return_zero_when_the_argument_is_empty() throws NegativeNumbersNotAllowedException {
		assertEquals(0, StringCalculator.add(""));
	}

	@Test
	public void sould_return_the_number_given_in_the_string_argument() throws NegativeNumbersNotAllowedException {
		assertEquals(1, StringCalculator.add("1"));
	}
	
	@Test
	public void should_return_the_sum_of_two_numbers_separated_by_commas_in_the_string_argument() throws NegativeNumbersNotAllowedException {
		assertEquals(5, StringCalculator.add("3,2"));
	}
	
	@Test
	public void should_accept_new_lines_between_numbers() throws NegativeNumbersNotAllowedException {
		assertEquals(6, StringCalculator.add("1\n2,3"));
	}
	
	@Test
	public void should_accept_custom_delimiter_between_numbers() throws NegativeNumbersNotAllowedException {
		assertEquals(3, StringCalculator.add("//;\n1;2"));
	}
	
	@Test
	public void should_accept_any_delimiter_between_numbers() throws NegativeNumbersNotAllowedException {
		assertEquals(3, StringCalculator.add("//$\n1$2"));
	}
	
	@Test
	public void should_throw_NegativeNumbersNotAllowedException_if_we_have_negative_number() {
		Assertions.assertThrows(NegativeNumbersNotAllowedException.class, () -> StringCalculator.add("1,-222,222,55"));
	}
	
	@Test
	public void should_throw_exception_if_we_have_negative_number_with_negative_numbers_in_message_exception() {
		Exception expectedEx = assertThrows(NegativeNumbersNotAllowedException.class, () ->
		StringCalculator.add("1,-222,222,-55"));
		assertEquals(expectedEx.getMessage(),"Negatives numbers not allowed: [-222, -55]");
	}
	
	@Test
	public void should_return_the_sum_of_multiple_numbers_separated_by_commas_in_the_string_argument() throws NegativeNumbersNotAllowedException {
		assertEquals(500, StringCalculator.add("1,222,222,55"));
	}
	
	@Test
	public void should_ignore_numbers_bigger_than_1000() throws NegativeNumbersNotAllowedException {
		assertEquals(5, StringCalculator.add("1,4,1222,1001"));
	}
	
	@Test
	public void should_accept_any_delimiter_with_any_length_between_numbers() throws NegativeNumbersNotAllowedException {
		assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
	}
	
	@Test
	public void should_accept_mulitpe_delimiters_between_numbers() throws NegativeNumbersNotAllowedException {
		assertEquals(6, StringCalculator.add("//[*][%]\n1*2%3"));
	}
	
	@Test
	public void should_accept_mulitpe_delimiters_with_length_longer_than_one_charbetween_numbers() throws NegativeNumbersNotAllowedException {
		assertEquals(6, StringCalculator.add("//[***][%%%]\n1***2%%%3"));
	}
	
	@Test
	public void should_return_zero_when_the_argument_is_null() throws NegativeNumbersNotAllowedException {
		assertEquals(0, StringCalculator.add("aaaaa"));
	}
	
	@Test
	public void should_return_zero_when_there_ar_character_that_are_not_numbers() throws NegativeNumbersNotAllowedException {

		assertEquals(0, StringCalculator.add("aaaaa"));
	}
	
	@Test
	public void should_by_throw_Exception_if_list_contains_negative_numbers() throws NegativeNumbersNotAllowedException {
		Assertions.assertThrows(NegativeNumbersNotAllowedException.class, () -> StringCalculator.checkIfListContainsNegativeNumbers(TestsTools.generateListNumbers(1, -52, 3, 4, 5, 6)));
	}


}
