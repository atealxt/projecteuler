package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.TestBase;
import io.github.atealxt.projecteuler.problem.Problem3;

import org.junit.Assert;

public class Problem3Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertEquals(5, ((Problem3) problem).getLargestPrimeFactor(10));
		Assert.assertEquals(5, ((Problem3) problem).getLargestPrimeFactor(20));
		Assert.assertEquals(11, ((Problem3) problem).getLargestPrimeFactor(66));
		Assert.assertEquals(29, ((Problem3) problem).getLargestPrimeFactor(13195));
		Assert.assertEquals("6857", problem.getResult());
	}
}
