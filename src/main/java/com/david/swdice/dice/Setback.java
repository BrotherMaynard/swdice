package com.david.swdice.dice;

import com.david.swdice.DiceResult;

public class Setback extends Die {
	@Override
	public DiceResult roll() {
		int roll = random.nextInt(6);
		DiceResult result = new DiceResult();

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
