package com.david.swdice.dice;

import com.david.swdice.results.GoodResult;
import com.david.swdice.results.Result;

public class Ability extends Die {
	public Ability() {
		super();
	}

	public Ability(Long seed) {
		super(seed);
	}

	@Override
	public GoodResult roll() {
		int roll = random.nextInt(8);
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
				result.setSuccess(2);
				result.getResults().add(Result.SUCCESS);
				result.getResults().add(Result.SUCCESS);
				break;
			case 4: // Advantage
			case 5: // Advantage
				result.setAdvantage(1);
				result.getResults().add(Result.ADVANTAGE);
				break;
			case 6: // Success Advantage
				result.setAdvantage(1);
				result.setSuccess(1);
				result.getResults().add(Result.ADVANTAGE);
				result.getResults().add(Result.SUCCESS);
				break;
			default: // Two Advantage
				result.setAdvantage(2);
				result.getResults().add(Result.ADVANTAGE);
				result.getResults().add(Result.ADVANTAGE);
				break;
		}

		return result;
	}
}
