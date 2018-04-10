package com.david.swdice.dice;

import com.david.swdice.DiceResult;

public class Boost extends Die {
	@Override
	public DiceResult roll() {
		int roll = random.nextInt(6);
		DiceResult result = new DiceResult();

		switch (roll) {
			case 0: // Blank
			case 1: // Blank
				break;
			case 2: // Success
				result.setSuccess(1);
				break;
			case 3: // Success Advantage
				result.setAdvantage(1);
				result.setSuccess(1);
				break;
			case 4: // Two Advantage
				result.setAdvantage(2);
				break;
			default: // Advantage
				result.setAdvantage(1);
				break;
		}

		return result;
	}
}
