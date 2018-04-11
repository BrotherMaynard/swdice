package com.david.swdice.results;

import com.david.swdice.dice.DiceType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ForceResult extends DiceResult {
	private long light;
	private long dark;

	public ForceResult() {
		super(DiceType.FORCE);
	}
}
