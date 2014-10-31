package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.TestBase;
import io.github.atealxt.projecteuler.problem.Problem36;

import org.junit.Assert;

public class Problem36Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertTrue(((Problem36) problem).isDoubleBasePalindrome(585));
		Assert.assertFalse(((Problem36) problem).isDoubleBasePalindrome(123));
		Assert.assertFalse(((Problem36) problem).isDoubleBasePalindrome(131));
		Assert.assertEquals("872187", problem.getResult());
	}
}
