package projecteuler.problem;

import org.junit.Assert;

import projecteuler.TestBase;

public class Problem49Test extends TestBase {

	@Override
	public void testGetResult() {
		Assert.assertEquals("148748178147", ((Problem49) problem).getConcatenatingSequence2(0));
		Assert.assertEquals("296962999629", problem.getResult());
	}
}
