package projecteuler.problem;

import org.junit.Assert;

import projecteuler.TestBase;

public class Problem32Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertTrue(Problem32.isPandigital("123456789"));
		Assert.assertTrue(Problem32.isPandigital("567891234"));
		Assert.assertFalse(Problem32.isPandigital("1234567890"));
		Assert.assertFalse(Problem32.isPandigital("1234567899"));
		Assert.assertFalse(Problem32.isPandigital("1"));
		Assert.assertFalse(Problem32.isPandigital("123356789"));
		Assert.assertEquals("45228", problem.getResult());
	}
}
