package com.david.swdice.dice;

import com.david.swdice.DiceResult;

public class Challenge extends Die {
	@Override
	public DiceResult roll() {
		int roll = random.nextInt(12);
		DiceResult result = new DiceResult();

		switch (roll) {
			case 0: // Blank
				break;
			case 1: // Failure
			case 2: // Failure
				result.setFailure(1);
				break;
			case 3: // Two Failure
			case 4: // Two Failure
				result.setFailure(2);
				break;
			case 5: // Threat
			case 6: // Threat
				result.setThreat(1);
				break;
			case 7: // Failure Threat
			case 8: // Failure Threat
				result.setThreat(1);
				result.setFailure(1);
				break;
			case 9: // Two Threat
			case 10: // Two Threat
				result.setThreat(2);
				break;
			default: // Despair
				result.setDespair(1);
				break;
		}

		return result;
	}
}
