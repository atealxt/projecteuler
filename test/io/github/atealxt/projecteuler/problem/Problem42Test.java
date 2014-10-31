package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.TestBase;
import io.github.atealxt.projecteuler.problem.Problem42;

import org.junit.Assert;

public class Problem42Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertTrue(((Problem42) problem).isTriangleWord("SKY"));
		Assert.assertTrue(((Problem42) problem).isTriangleWord("A"));
		Assert.assertFalse(((Problem42) problem).isTriangleWord("B"));
		Assert.assertEquals("162", problem.getResult());
	}
}
