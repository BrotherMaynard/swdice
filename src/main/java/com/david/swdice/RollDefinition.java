package com.david.swdice;

import lombok.Data;

@Data
public class RollDefinition {
	private long boost;
	private long ability;
	private long proficiency;

	private long setback;
	private long difficulty;
	private long challenge;

	private long force;
}
