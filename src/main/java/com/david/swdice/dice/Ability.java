package com.david.swdice.dice;

import com.david.swdice.results.GoodResult;

public class Ability extends Die {
	@Override
	public GoodResult roll() {
		int roll = random.nextInt(8);
		GoodResult result = new GoodResult();

		switch (roll) {
			case 0: // Blank
				break;
			case 1: // Success
			case 2: // Success
				result.setSuccess(1);
				break;
			case 3: // Two Success
				result.setSuccess(2);
				break;
			case 4: // Advantage
			case 5: // Advantage
				result.setAdvantage(1);
				break;
			case 6: // Success Advantage
				result.setAdvantage(1);
				result.setSuccess(1);
				break;
			default: // Two Advantage
				result.setAdvantage(2);
				break;
		}

		return result;
	}
}
