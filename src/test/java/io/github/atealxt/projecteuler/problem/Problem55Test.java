package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.TestBase;

import org.junit.Assert;

public class Problem55Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertFalse(((Problem55) problem).isLychrel(47));
		Assert.assertFalse(((Problem55) problem).isLychrel(74));
		Assert.assertFalse(((Problem55) problem).isLychrel(349));
		Assert.assertFalse(((Problem55) problem).isLychrel(943));
		Assert.assertFalse(((Problem55) problem).isLychrel(1292));
		Assert.assertFalse(((Problem55) problem).isLychrel(2921));
		Assert.assertFalse(((Problem55) problem).isLychrel(4213));
		Assert.assertFalse(((Problem55) problem).isLychrel(3124));
		Assert.assertFalse(((Problem55) problem).isLychrel(7337));
		Assert.assertTrue(((Problem55) problem).isLychrel(196));
		Assert.assertTrue(((Problem55) problem).isLychrel(4994));
		Assert.assertEquals("249", problem.getResult());
	}
}
