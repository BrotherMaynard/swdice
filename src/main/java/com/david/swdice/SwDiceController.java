package com.david.swdice;

import com.david.swdice.results.RollResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class SwDiceController {
	private final DiceRollingService diceRollingService;

	@PostMapping("/roll")
	public RollResult roll(@RequestBody RollDefinition rollDefinition) {
		log.debug("Rolling dice with definition {}", rollDefinition);
		return diceRollingService.roll(rollDefinition);
	}
}
