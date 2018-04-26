package com.david.swdice.results;

import com.david.swdice.dice.DiceType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BadResult extends DiceResult {
	private long threat;
	private long failure;
	private long despair;

	public BadResult(long seed) {
		super(DiceType.BAD, seed);
	}
}
