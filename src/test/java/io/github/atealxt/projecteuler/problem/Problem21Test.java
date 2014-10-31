package io.github.atealxt.projecteuler.problem;

import static io.github.atealxt.projecteuler.problem.Problem21.getSumOfDivisors;
import io.github.atealxt.projecteuler.TestBase;

import org.junit.Assert;

public class Problem21Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertEquals(220, getSumOfDivisors(getSumOfDivisors(220)));
		Assert.assertEquals(284, getSumOfDivisors(getSumOfDivisors(284)));
		Assert.assertEquals("31626", problem.getResult());
	}
}
