package projecteuler.problem;

import org.junit.Assert;

import projecteuler.TestBase;

public class Problem42Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertTrue(((Problem42) problem).isTriangleWord("SKY"));
		Assert.assertTrue(((Problem42) problem).isTriangleWord("A"));
		Assert.assertFalse(((Problem42) problem).isTriangleWord("B"));
		Assert.assertEquals("162", problem.getResult());
	}
}
