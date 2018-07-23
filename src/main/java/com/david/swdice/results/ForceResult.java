package com.david.swdice.results;

import com.david.swdice.dice.DieType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ForceResult extends DieResult {
	private long light;
	private long dark;

	public ForceResult(long seed) {
		super(DieType.FORCE, seed);
	}
}
