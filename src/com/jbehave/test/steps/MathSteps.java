package com.jbehave.test.steps;

import java.util.*;

import junit.framework.Assert;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

public class MathSteps {
	List<List<String>> numbers = new ArrayList<List<String>>();
	List<Integer> actualResults = new ArrayList<Integer>();
	List<String> expectedResults = new ArrayList<String>();
	
	@Given("this table of numbers $numbersTable")
	public void setNumbersTable(ExamplesTable numbersTable) {
		for (Map<String, String> row : numbersTable.getRows()) {
			numbers.add( new ArrayList<String> (row.values()));
		}
		System.out.println("Given");
	}

	@When("I add numbers in each row")
	public void addNumbersInRow() {
		for (int i = 0; i < numbers.size(); i++) {
			List<String> numbersInRow = numbers.get(i);
			int result = 0;
			for (int j=0; j < numbersInRow.size() ; j++) {
				result = result + Integer.parseInt(numbersInRow.get(j));
			}
			actualResults.add(result);
		};
		System.out.println("When");
	}

	@Then("the results should match this table $resultsTable")
	public void assertElementCount(ExamplesTable expectedResultsTable) {
		int i=0;
		for (Map<String, String> row : expectedResultsTable.getRows()) {
			int expectedNumber = Integer.parseInt(row.get("Result"));
			int actualNumber = actualResults.get(i);
			Assert.assertEquals(expectedNumber, actualNumber);
			i++;
		}
		System.out.println("Then");
	}
	
}
