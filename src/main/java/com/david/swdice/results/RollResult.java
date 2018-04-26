package com.david.swdice.results;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RollResult {
	private List<DiceResult> results = new ArrayList<>();
	private TotalResult totals = new TotalResult();

	public void addDiceResult(DiceResult result) {
		results.add(result);

		switch (result.getType()) {
			case GOOD:
				totals.setAdvantage(totals.getAdvantage() + ((GoodResult) result).getAdvantage());
				totals.setSuccess(totals.getSuccess() + ((GoodResult) result).getSuccess());
				totals.setTriumph(totals.getTriumph() + ((GoodResult) result).getTriumph());
				break;
			case BAD:
				totals.setThreat(totals.getThreat() + ((BadResult) result).getThreat());
				totals.setFailure(totals.getFailure() + ((BadResult) result).getFailure());
				totals.setDespair(totals.getDespair() + ((BadResult) result).getDespair());
				break;
			case FORCE:
				totals.setLight(totals.getLight() + ((ForceResult) result).getLight());
				totals.setDark(totals.getDark() + ((ForceResult) result).getDark());
				break;
			default:
				break;
		}
	}
}
