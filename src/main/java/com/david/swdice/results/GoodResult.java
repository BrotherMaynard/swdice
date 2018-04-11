package com.david.swdice.results;

import com.david.swdice.dice.DiceType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GoodResult extends DiceResult {
	private long advantage;
	private long success;
	private long triumph;

	public GoodResult() {
		super(DiceType.GOOD);
	}
}
