package projecteuler.problem;

import org.junit.Assert;

import projecteuler.TestBase;

public class Problem47Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertTrue(((Problem47) problem).isConsecutive(new int[] { 644, 0, 0 }, 645));
		Assert.assertEquals(14, ((Problem47) problem).getFirstNumOfConsecutive(2));
		Assert.assertEquals(644, ((Problem47) problem).getFirstNumOfConsecutive(3));
		Assert.assertEquals("134043", problem.getResult());
	}
}
