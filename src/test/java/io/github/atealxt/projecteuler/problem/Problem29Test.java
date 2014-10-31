package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.TestBase;
import io.github.atealxt.projecteuler.problem.Problem29;

import org.junit.Assert;

public class Problem29Test extends TestBase {

	@Override
	public void testGetResult() {

		Assert.assertEquals(15, ((Problem29) problem).getNumOfTerms(5));
		Assert.assertEquals(9183, ((Problem29) problem).getNumOfTerms(100));

		Assert.assertEquals(-1, ((Problem29) problem).logn(2, 6));
		Assert.assertEquals(2, ((Problem29) problem).logn(2, 4));
		Assert.assertEquals(3, ((Problem29) problem).logn(2, 8));
		Assert.assertEquals(2, ((Problem29) problem).logn(4, 16));
		Assert.assertEquals(15, ((Problem29) problem).getNumOfTerms2(5));

		Assert.assertEquals("9183", problem.getResult());
	}
}
