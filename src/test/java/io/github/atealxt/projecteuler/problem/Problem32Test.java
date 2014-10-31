package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.TestBase;
import io.github.atealxt.projecteuler.problem.Problem32;

import org.junit.Assert;

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
