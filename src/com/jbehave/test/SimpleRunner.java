package com.jbehave.test;
import java.util.Arrays;
import java.util.List;

import org.jbehave.core.embedder.Embedder;

import com.jbehave.test.steps.MathSteps;

public class SimpleRunner {
 
	private static Embedder embedder = new Embedder();
	private static List<String> storyPaths = Arrays.asList("com/jbehave/test/math_test.story");
 
	public static void main(String[] args) {
		//Add the steps
		embedder.candidateSteps().add(new MathSteps());
		
		//Specify the story paths to run
		embedder.runStoriesAsPaths(storyPaths);
	}
}