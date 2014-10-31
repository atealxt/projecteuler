package projecteuler.problem;

import org.junit.Assert;

import projecteuler.TestBase;

public class Problem43Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertTrue(((Problem43) problem).hasProperty(1406357289));
		Assert.assertEquals("16695334890", problem.getResult());
	}
}
