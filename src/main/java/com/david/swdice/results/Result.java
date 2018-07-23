package com.david.swdice.results;

public enum Result {
	ADVANTAGE("Advantage"),
	SUCCESS("Success"),
	TRIUMPH("Triumph"),

	THREAT("Threat"),
	FAILURE("Failure"),
	DESPAIR("Despair"),

	LIGHT("Light"),
	DARK("Dark");

	private final String name;

	Result(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
