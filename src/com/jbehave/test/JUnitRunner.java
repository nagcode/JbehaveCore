package com.jbehave.test;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import com.jbehave.test.steps.MathSteps;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWith(JUnitReportingRunner.class)
public class JUnitRunner extends JUnitStories {
 
	public JUnitRunner() {
		super();
	}
 
	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new MathSteps());
	}
 
	@Override
	protected List<String> storyPaths() {
		return Arrays.asList("com/jbehave/test/math_test.story");
	}
}