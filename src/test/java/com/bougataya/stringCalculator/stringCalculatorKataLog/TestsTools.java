package com.bougataya.stringCalculator.stringCalculatorKataLog;

import java.util.ArrayList;
import java.util.List;

public class TestsTools {
	
	public static List<Integer> generateListNumbers(Integer... nums) {
        List<Integer> result = new ArrayList<Integer>();
        for (Integer num : nums) {
            result.add(num);
        }
        return result;
    }
}
