package io.github.atealxt.projecteuler;

import io.github.atealxt.projecteuler.Problem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public abstract class TestBase {

	protected long startTime;
	protected long stepTime;
	protected Logger logger = LogManager.getLogger(getClass());
	protected Problem problem = getProblem();

	@Test
	public void test() throws Exception {
		logger.info("Test Start");
		startTime = stepTime = System.currentTimeMillis();
		try {
			System.out.println(problem);
			testGetResult();
			System.out.println("Result: " + problem.getResult() + "\n");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		logger.info("Test End");
		logger.info("Total Time Cost {}s", (float) (System.currentTimeMillis() - startTime) / 1000);
	}

	protected Problem getProblem() {
		String pack = TestBase.class.getPackage().getName();
		String className = getClass().getSimpleName();
		String classPath = pack + ".problem." + className.substring(0, className.length() - 4);
		try {
			Class<?> clazz = Class.forName(classPath);
			Object obj = clazz.newInstance();
			return (Problem) obj;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected abstract void testGetResult() throws Exception;
}
