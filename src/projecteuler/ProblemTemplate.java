package projecteuler;

import org.junit.Test;

public abstract class ProblemTemplate {

	public abstract String getTitle();

	public abstract String getResult();

	@Override
	public String toString() {
		return getClass().getSimpleName().replace("Problem", "#") + ": " + getTitle() + "\nURL: http://projecteuler.net/problem=" + getClass().getSimpleName().substring("Problem".length());
	}

	@Test
	public void execute() {
		System.out.println(this);
		System.out.println("Result: " + getResult() + "\n");
	}
}
