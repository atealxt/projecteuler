package projecteuler.problem;

import org.junit.Assert;

import projecteuler.TestBase;

public class Problem36Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertTrue(((Problem36) problem).isDoubleBasePalindrome(585));
		Assert.assertFalse(((Problem36) problem).isDoubleBasePalindrome(123));
		Assert.assertFalse(((Problem36) problem).isDoubleBasePalindrome(131));
		Assert.assertEquals("872187", problem.getResult());
	}
}
