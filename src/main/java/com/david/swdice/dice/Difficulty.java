package com.david.swdice.dice;

import com.david.swdice.results.BadResult;

public class Difficulty extends Die {
	@Override
	public BadResult roll() {
		int roll = random.nextInt(8);
		BadResult result = new BadResult();

		switch (roll) {
			case 0: // Blank
				break;
			case 1: // Failure
				result.setFailure(1);
				break;
			case 2: // Two Failure
				result.setFailure(2);
				break;
			case 3: // Threat
			case 4: // Threat
			case 5: // Threat
				result.setThreat(1);
				break;
			case 6: // Two Threat
				result.setThreat(2);
				break;
			default: // Failure Threat
				result.setFailure(1);
				result.setThreat(1);
				break;
		}

		return result;
	}
}
