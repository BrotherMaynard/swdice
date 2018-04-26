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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Slf4j
public class DiceRollingService {
	private Die buildDie(Class<? extends Die> type, Long seed) {
		try {
			if (seed != null) {
				try {
					return type.getConstructor(Long.class).newInstance(seed);
				} catch (NoSuchMethodException nsme) {
					log.error("Error building die from seed.", nsme);
					return type.newInstance();
				}
			}
			return type.newInstance();
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			log.error("Error building die.", e);
			throw new RuntimeException("Unable to recover.", e);
		}
	}

	public RollResult roll(RollDefinition rollDefinition) {
		List<Die> dice = new ArrayList<>();

		dice.addAll(Stream
				.generate(() -> buildDie(Boost.class, rollDefinition.getSeed()))
				.limit(rollDefinition.getBoost())
				.collect(Collectors.toList()));
		dice.addAll(Stream
				.generate(() -> buildDie(Ability.class, rollDefinition.getSeed()))
				.limit(rollDefinition.getAbility())
				.collect(Collectors.toList()));
		dice.addAll(Stream
				.generate(() -> buildDie(Proficiency.class, rollDefinition.getSeed()))
				.limit(rollDefinition.getProficiency())
				.collect(Collectors.toList()));

		dice.addAll(Stream
				.generate(() -> buildDie(Setback.class, rollDefinition.getSeed()))
				.limit(rollDefinition.getSetback())
				.collect(Collectors.toList()));
		dice.addAll(Stream
				.generate(() -> buildDie(Difficulty.class, rollDefinition.getSeed()))
				.limit(rollDefinition.getDifficulty())
				.collect(Collectors.toList()));
		dice.addAll(Stream
				.generate(() -> buildDie(Challenge.class, rollDefinition.getSeed()))
				.limit(rollDefinition.getChallenge())
				.collect(Collectors.toList()));

		dice.addAll(Stream
				.generate(() -> buildDie(Force.class, rollDefinition.getSeed()))
				.limit(rollDefinition.getForce())
				.collect(Collectors.toList()));

		RollResult result = new RollResult();
		dice.stream().map(Die::roll).forEach(result::addDiceResult);
		return result;
	}
}
