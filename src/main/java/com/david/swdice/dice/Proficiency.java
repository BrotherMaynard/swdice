package com.david.swdice.dice;

import com.david.swdice.DiceResult;

public class Proficiency extends Die {
	@Override
	public DiceResult roll() {
		int roll = random.nextInt(12);
		DiceResult result = new DiceResult();

		switch (roll) {
			case 0: // Blank
				break;
			case 1: // Success
			case 2: // Success
				result.setSuccess(1);
				break;
			case 3: // Two Success
			case 4: // Two Success
				result.setSuccess(2);
				break;
			case 5: // Advantage
				result.setAdvantage(1);
				break;
			case 6: // Success Advantage
			case 7: // Success Advantage
			case 8: // Success Advantage
				result.setAdvantage(1);
				result.setSuccess(1);
				break;
			case 9: // Two Advantage
			case 10: // Two Advantage
				result.setAdvantage(2);
				break;
			default: // Triumph
				result.setTriumph(1);
				break;
		}

		return result;
	}
}
