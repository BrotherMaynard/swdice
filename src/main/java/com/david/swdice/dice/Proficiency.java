package com.david.swdice.dice;

import com.david.swdice.results.GoodResult;
import com.david.swdice.results.Result;

public class Proficiency extends Die {
	public Proficiency() {
	}

	public Proficiency(Long seed) {
		super(seed);
	}

	@Override
	public GoodResult roll() {
		int roll = random.nextInt(12);
		GoodResult result = new GoodResult(seed);

		switch (roll) {
			case 0: // Blank
				break;
			case 1: // Success
			case 2: // Success
				result.setSuccess(1);
				result.getResults().add(Result.SUCCESS);
				break;
			case 3: // Two Success
			case 4: // Two Success
				result.setSuccess(2);
				result.getResults().add(Result.SUCCESS);
				result.getResults().add(Result.SUCCESS);
				break;
			case 5: // Advantage
				result.setAdvantage(1);
				result.getResults().add(Result.ADVANTAGE);
				break;
			case 6: // Success Advantage
			case 7: // Success Advantage
			case 8: // Success Advantage
				result.setAdvantage(1);
				result.setSuccess(1);
				result.getResults().add(Result.ADVANTAGE);
				result.getResults().add(Result.SUCCESS);
				break;
			case 9: // Two Advantage
			case 10: // Two Advantage
				result.setAdvantage(2);
				result.getResults().add(Result.ADVANTAGE);
				result.getResults().add(Result.ADVANTAGE);
				break;
			default: // Triumph
				result.setTriumph(1);
				result.getResults().add(Result.TRIUMPH);
				break;
		}

		return result;
	}
}
