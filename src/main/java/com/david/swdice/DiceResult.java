package com.david.swdice;

import lombok.Data;

@Data
public class DiceResult {
	private long advantage;
	private long success;
	private long triumph;

	private long threat;
	private long failure;
	private long despair;

	private long light;
	private long dark;

	public DiceResult combine(DiceResult other) {
		this.advantage += other.advantage;
		this.success += other.success;
		this.triumph += other.triumph;

		this.threat += other.threat;
		this.failure += other.failure;
		this.despair += other.despair;

		this.light += other.light;
		this.dark += other.dark;

		return this;
	}
}
