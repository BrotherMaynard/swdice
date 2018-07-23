package com.david.swdice.results;

import com.david.swdice.dice.DieType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BadResult extends DieResult {
	private long threat;
	private long failure;
	private long despair;

	public BadResult(long seed) {
		super(DieType.BAD, seed);
	}
}
