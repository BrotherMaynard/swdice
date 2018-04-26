package com.david.swdice.results;

import com.david.swdice.dice.DiceType;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DiceResult {
	private final DiceType type;
	private final long seed;
}
