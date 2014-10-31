package projecteuler.problem;

import org.junit.Assert;

import projecteuler.TestBase;

public class Problem50Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertEquals(41, ((Problem50) problem).getPrimeIsMostConsecutive(100));
		Assert.assertEquals(953, ((Problem50) problem).getPrimeIsMostConsecutive(1000));
		Assert.assertEquals("997651", problem.getResult());
	}
}
