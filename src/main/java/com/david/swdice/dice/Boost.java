package com.david.swdice.dice;

import com.david.swdice.results.GoodResult;
import com.david.swdice.results.Result;

public class Boost extends Die {
	public Boost() {
		super();
	}

	public Boost(Long seed) {
		super(seed);
	}

	@Override
	public GoodResult roll() {
		int roll = random.nextInt(6);
		GoodResult result = new GoodResult(seed);

		switch (roll) {
			case 0: // Blank
			case 1: // Blank
				break;
			case 2: // Success
				result.setSuccess(1);
				result.getResults().add(Result.SUCCESS);
				break;
			case 3: // Success Advantage
				result.setAdvantage(1);
				result.setSuccess(1);
				result.getResults().add(Result.ADVANTAGE);
				result.getResults().add(Result.SUCCESS);
				break;
			case 4: // Two Advantage
				result.setAdvantage(2);
				result.getResults().add(Result.ADVANTAGE);
				result.getResults().add(Result.ADVANTAGE);
				break;
			default: // Advantage
				result.setAdvantage(1);
				result.getResults().add(Result.ADVANTAGE);
				break;
		}

		return result;
	}
}
