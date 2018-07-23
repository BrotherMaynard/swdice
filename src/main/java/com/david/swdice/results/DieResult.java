package com.david.swdice.results;

import com.david.swdice.dice.DieType;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class DieResult {
	private final DieType type;
	private final long seed;
	private final List<Result> results = new ArrayList<>();
}
