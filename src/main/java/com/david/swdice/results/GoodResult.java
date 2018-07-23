package com.david.swdice.results;

import com.david.swdice.dice.DieType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GoodResult extends DieResult {
	private long advantage;
	private long success;
	private long triumph;

	public GoodResult(long seed) {
		super(DieType.GOOD, seed);
	}
}
