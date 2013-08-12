package com.jbehave.test.steps;

import java.util.*;

import junit.framework.Assert;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.steps.Steps;

public class MathSteps extends Steps {
	List<List<String>> numbers = new ArrayList<List<String>>();
	List<Double> actualResults = new ArrayList<Double>();
	List<Double> expectedResults = new ArrayList<Double>();
	
	@Given("this table of numbers $numbersTable")
	public void setNumbersTable(ExamplesTable numbersTable) {
		for (Map<String, String> row : numbersTable.getRows()) {
			numbers.add( new ArrayList<String> (row.values()));
		}		
	}

	@When("the math operation 'Num1' to the power of 'Num2' is performed on each row")
	public void performMathPow() {
		for (int i = 0; i < numbers.size(); i++) {
			List<String> numbersInRow = numbers.get(i);
			double result = 0;
			double x = Double.parseDouble(numbersInRow.get(0));
			double y = Double.parseDouble(numbersInRow.get(1));
			result = Math.pow(x, y);
			actualResults.add(result);
		};
	}

	@Then("the results should match this table $resultsTable")
	public void verifyResults(ExamplesTable expectedResultsTable) {
		int i=0;
		for (Map<String, String> row : expectedResultsTable.getRows()) {
			double expectedNumber = Double.parseDouble(row.get("Result"));
			double actualNumber = actualResults.get(i);
			Assert.assertEquals(expectedNumber, actualNumber);
			i++;
		}
	}
	
}
