package com.david.swdice;

import lombok.Data;

@Data
public class TotalResult {
	private long advantage;
	private long success;
	private long triumph;

	private long threat;
	private long failure;
	private long despair;

	private long light;
	private long dark;
}
