package com.david.swdice;

import com.david.swdice.results.BadResult;
import com.david.swdice.results.DieResult;
import com.david.swdice.results.ForceResult;
import com.david.swdice.results.GoodResult;
import com.david.swdice.results.RollResult;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DiceRollingServiceTests {
	private DiceRollingService diceRollingService;

	@Before
	public void setup() {
		diceRollingService = new DiceRollingService();
	}

	@Test
	public void testRollsEachDieType() {
		RollDefinition definition = new RollDefinition();
		definition.setBoost(1);
		definition.setAbility(1);
		definition.setProficiency(1);
		definition.setSetback(1);
		definition.setDifficulty(1);
		definition.setChallenge(1);
		definition.setForce(1);

		RollResult result = diceRollingService.roll(definition);

		List<DieResult> results = result.getResults();
		assertEquals(7, results.size());
		assertEquals(3, results.stream().filter(r -> r instanceof GoodResult).count());
		assertEquals(3, results.stream().filter(r -> r instanceof BadResult).count());
		assertEquals(1, results.stream().filter(r -> r instanceof ForceResult).count());
	}
}
