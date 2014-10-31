package projecteuler.problem;

import org.junit.Assert;

import projecteuler.TestBase;

public class Problem52Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertEquals("142857", problem.getResult());
	}
}
