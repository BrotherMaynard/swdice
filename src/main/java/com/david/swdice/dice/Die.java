package com.david.swdice.dice;

import com.david.swdice.results.DiceResult;

import java.util.Random;

public abstract class Die {
	protected static final Random random = new Random();

	public abstract DiceResult roll();
}
