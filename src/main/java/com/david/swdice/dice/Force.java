package com.david.swdice.dice;

import com.david.swdice.results.ForceResult;

public class Force extends Die {
	public Force() {
		super();
	}

	public Force(Long seed) {
		super(seed);
	}

	@Override
	public ForceResult roll() {
		int roll = random.nextInt(12);
		ForceResult result = new ForceResult(seed);

		switch (roll) {
			case 0: // Dark
			case 1: // Dark
			case 2: // Dark
			case 3: // Dark
			case 4: // Dark
			case 5: // Dark
				result.setDark(1);
				break;
			case 6: // Two Dark
				result.setDark(2);
				break;
			case 7: // Light
			case 8: // Light
				result.setLight(1);
				break;
			case 9: // Two Light
			case 10: // Two Light
			default: // Two Light
				result.setLight(2);
				break;
		}

		return result;
	}
}
