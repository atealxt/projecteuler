package projecteuler.problem;

import org.junit.Assert;

import projecteuler.TestBase;

public class Problem51Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertEquals(13, ((Problem51) problem).getFirstMember(6));
		Assert.assertEquals(56003, ((Problem51) problem).getFirstMember(7));
		Assert.assertEquals("121313", problem.getResult());
	}
}
