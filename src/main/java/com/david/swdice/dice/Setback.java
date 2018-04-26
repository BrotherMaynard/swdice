package com.david.swdice.dice;

import com.david.swdice.results.BadResult;

public class Setback extends Die {
	public Setback() {
		super();
	}

	public Setback(Long seed) {
		super(seed);
	}

	@Override
	public BadResult roll() {
		int roll = random.nextInt(6);
		BadResult result = new BadResult(seed);

		switch (roll) {
			case 0: // Blank
			case 1: // Blank
				break;
			case 2: // Failure
			case 3: // Failure
				result.setFailure(1);
				break;
			case 4: // Threat
			default: // Threat
				result.setThreat(1);
				break;
		}

		return result;
	}
}
