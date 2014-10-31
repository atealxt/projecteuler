package projecteuler.problem;

import org.junit.Assert;

import projecteuler.TestBase;

public class Problem30Test extends TestBase {

	@Override
	public void testGetResult() {

		Assert.assertEquals(19316, ((Problem30) problem).getSumOfNum(4));
		Assert.assertEquals(443839, ((Problem30) problem).getSumOfNum(5));
		Assert.assertArrayEquals(new int[] { 1, 2, 3 }, Problem30.getNumbers(123));
		Assert.assertArrayEquals(new int[] { 1, 3, 2 }, Problem30.getNumbers(132));
		Assert.assertArrayEquals(new int[] { 5 }, Problem30.getNumbers(5));

		Assert.assertEquals("443839", problem.getResult());
	}
}
