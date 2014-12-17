package io.github.atealxt.projecteuler.problem;

import io.github.atealxt.projecteuler.TestBase;

import org.junit.Assert;

public class Problem4Test extends TestBase {

	@Override
	public void testGetResult() {

		Assert.assertEquals(true, Problem4.isPalindrome("1"));
		Assert.assertEquals(true, Problem4.isPalindrome("11"));
		Assert.assertEquals(false, Problem4.isPalindrome("12"));
		Assert.assertEquals(true, Problem4.isPalindrome("12321"));
		Assert.assertEquals(true, Problem4.isPalindrome("abba"));
		Assert.assertEquals(true, Problem4.isPalindrome("abbba"));
		Assert.assertEquals(false, Problem4.isPalindrome("abbcba"));
		Assert.assertEquals(false, Problem4.isPalindrome(""));
		Assert.assertEquals(true, Problem4.isPalindrome(" "));
		Assert.assertEquals(false, Problem4.isPalindrome(null));

		Assert.assertEquals("906609", problem.getResult());
	}
}
