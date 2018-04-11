package com.david.swdice;

import com.david.swdice.dice.Ability;
import com.david.swdice.dice.Boost;
import com.david.swdice.dice.Challenge;
import com.david.swdice.dice.Die;
import com.david.swdice.dice.Difficulty;
import com.david.swdice.dice.Force;
import com.david.swdice.dice.Proficiency;
import com.david.swdice.dice.Setback;
import com.david.swdice.results.RollResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DiceRollingService {
	public RollResult roll(RollDefinition rollDefinition) {
		List<Die> dice = new ArrayList<>();

		dice.addAll(Stream.generate(Boost::new).limit(rollDefinition.getBoost()).collect(Collectors.toList()));
		dice.addAll(Stream.generate(Ability::new).limit(rollDefinition.getAbility()).collect(Collectors.toList()));
		dice.addAll(Stream.generate(Proficiency::new).limit(rollDefinition.getProficiency()).collect(Collectors.toList()));

		dice.addAll(Stream.generate(Setback::new).limit(rollDefinition.getSetback()).collect(Collectors.toList()));
		dice.addAll(Stream.generate(Difficulty::new).limit(rollDefinition.getDifficulty()).collect(Collectors.toList()));
		dice.addAll(Stream.generate(Challenge::new).limit(rollDefinition.getChallenge()).collect(Collectors.toList()));

		dice.addAll(Stream.generate(Force::new).limit(rollDefinition.getForce()).collect(Collectors.toList()));

		RollResult result = new RollResult();
		dice.stream().map(Die::roll).forEach(result::addDiceResult);
		return result;
	}
}
