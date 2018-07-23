package com.david.swdice.dice;

import com.david.swdice.results.BadResult;
import com.david.swdice.results.Result;

public class Difficulty extends Die {
	public Difficulty() {
		super();
	}

	public Difficulty(Long seed) {
		super(seed);
	}

	@Override
	public BadResult roll() {
		int roll = random.nextInt(8);
		BadResult result = new BadResult(seed);

		switch (roll) {
			case 0: // Blank
				break;
			case 1: // Failure
				result.setFailure(1);
				result.getResults().add(Result.FAILURE);
				break;
			case 2: // Two Failure
				result.setFailure(2);
				result.getResults().add(Result.FAILURE);
				result.getResults().add(Result.FAILURE);
				break;
			case 3: // Threat
			case 4: // Threat
			case 5: // Threat
				result.setThreat(1);
				result.getResults().add(Result.THREAT);
				break;
			case 6: // Two Threat
				result.setThreat(2);
				result.getResults().add(Result.THREAT);
				result.getResults().add(Result.THREAT);
				break;
			default: // Failure Threat
				result.setFailure(1);
				result.setThreat(1);
				result.getResults().add(Result.THREAT);
				result.getResults().add(Result.FAILURE);
				break;
		}

		return result;
	}
}
