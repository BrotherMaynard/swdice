package com.david.swdice.results;

import lombok.Data;

@Data
public class TotalResult {
	// TODO: Use AtomicInteger.getAndIncrement()?
	private long advantage;
	private long success;
	private long triumph;

	private long threat;
	private long failure;
	private long despair;

	private long light;
	private long dark;

	private long seed;
}
