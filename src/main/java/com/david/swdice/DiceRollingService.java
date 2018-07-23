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
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Slf4j
public class DiceRollingService {
	private static final Map<Class<? extends Die>, Method> builderMap;

	static {
		builderMap = new HashMap<>();
		try {
			builderMap.put(Boost.class, RollDefinition.class.getDeclaredMethod("getBoost"));
			builderMap.put(Ability.class, RollDefinition.class.getDeclaredMethod("getAbility"));
			builderMap.put(Proficiency.class, RollDefinition.class.getDeclaredMethod("getProficiency"));

			builderMap.put(Setback.class, RollDefinition.class.getDeclaredMethod("getSetback"));
			builderMap.put(Difficulty.class, RollDefinition.class.getDeclaredMethod("getDifficulty"));
			builderMap.put(Challenge.class, RollDefinition.class.getDeclaredMethod("getChallenge"));

			builderMap.put(Force.class, RollDefinition.class.getDeclaredMethod("getForce"));
		} catch (NoSuchMethodException e) {
			log.error("Bad code. Yell at the developer.", e);
		}
	}

	private Die buildDie(Class<? extends Die> type, Long seed) {
		try {
			if (seed != null) {
				try {
					return type.getConstructor(Long.class).newInstance(seed);
				} catch (NoSuchMethodException e) {
					log.error("Error building die from seed.", e);
					return type.newInstance();
				}
			}
			return type.newInstance();
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			log.error("Error building die.", e);
			throw new RuntimeException("Error building die.", e);
		}
	}

	public RollResult roll(RollDefinition rollDefinition) {
		List<Die> dice = new ArrayList<>();
		Long seed = rollDefinition.getSeed();

		builderMap.forEach((type, builder) -> {
			try {
				dice.addAll(Stream
						.generate(() -> buildDie(type, seed))
						.limit((Long) builder.invoke(rollDefinition))
						.collect(Collectors.toList()));
			} catch (IllegalAccessException | InvocationTargetException e) {
				log.error("Failed to get value from roll definition.", e);
			}
		});

		RollResult result = new RollResult();
		dice.stream().map(Die::roll).forEach(result::addDieResult);
		return result;
	}
}
