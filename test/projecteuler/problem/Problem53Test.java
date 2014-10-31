package projecteuler.problem;

import org.junit.Assert;

import projecteuler.TestBase;

public class Problem53Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertEquals(2, ((Problem53) problem).getPI(1, 2));
		Assert.assertEquals(20, ((Problem53) problem).getPI(4, 5));
		Assert.assertEquals(90, ((Problem53) problem).getPI(9, 10));
		Assert.assertEquals(24, ((Problem53) problem).getPI(1, 4));
		Assert.assertEquals(10, ((Problem53) problem).getC(10, 9));
		Assert.assertEquals(45, ((Problem53) problem).getC(10, 8));
		Assert.assertEquals(120, ((Problem53) problem).getC(10, 7));
		Assert.assertEquals(210, ((Problem53) problem).getC(10, 6));
		Assert.assertEquals(252, ((Problem53) problem).getC(10, 5));
		Assert.assertEquals("4075", problem.getResult());
	}
}
