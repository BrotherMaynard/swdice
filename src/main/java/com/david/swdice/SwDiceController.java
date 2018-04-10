package com.david.swdice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SwDiceController {
	private final DiceRollingService diceRollingService;

	@PostMapping("/roll")
	public DiceResult roll(@RequestBody RollDefinition rollDefinition) {
		return diceRollingService.roll(rollDefinition);
	}
}
