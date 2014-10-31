package io.github.atealxt.projecteuler;

public abstract class Problem {

	public abstract String getTitle();

	public abstract String getResult();

	@Override
	public String toString() {
		return getClass().getSimpleName().replace("Problem", "#") + ": " + getTitle() + "\nURL: http://projecteuler.net/problem="
				+ getClass().getSimpleName().substring("Problem".length());
	}
}
