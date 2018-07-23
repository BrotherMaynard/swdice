package com.david.swdice.dice;

import com.david.swdice.results.DieResult;

import java.util.Random;

public abstract class Die {
	protected final Random random;
	protected final long seed;

	public Die() {
		random = new Random();
		seed = random.nextLong();
		random.setSeed(seed);
	}

	public Die(long seed) {
		this.seed = seed;
		this.random = new Random(seed);
	}

	public abstract DieResult roll();
}
