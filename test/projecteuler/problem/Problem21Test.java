package projecteuler.problem;

import static projecteuler.problem.Problem21.getSumOfDivisors;

import org.junit.Assert;

import projecteuler.TestBase;

public class Problem21Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertEquals(220, getSumOfDivisors(getSumOfDivisors(220)));
		Assert.assertEquals(284, getSumOfDivisors(getSumOfDivisors(284)));
		Assert.assertEquals("31626", problem.getResult());
	}
}
