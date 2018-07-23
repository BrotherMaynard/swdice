package com.david.swdice.results;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RollResult {
	private final TotalResult totals = new TotalResult();
	private final List<DieResult> results = new ArrayList<>();

	public RollResult() {
	}

	// TODO: Find a fancy way to simulate the cancellation logic of a human dice-roller.
	/*public RollResult(List<DieResult> input) {
		// TODO: Make this all synchronized so we can do parallel streams.
		List<Result> faces = new ArrayList<>();
		input.forEach(dieResult -> {
			results.add(dieResult);
			faces.addAll(dieResult.getResults());
		});
		Map<Result, Long> faceMap = faces.stream().reduce(new HashMap<>(), (map, res) -> {
			map.put(res, map.getOrDefault(res, 0L) + 1);
			return map;
		}, (a, b) -> {
			a.putAll(b);
			return a;
		});
	}*/

	public void addDieResult(DieResult result) {
		results.add(result);

		switch (result.getType()) {
			case GOOD:
				GoodResult goodResult = (GoodResult) result;
				totals.setAdvantage(totals.getAdvantage() + goodResult.getAdvantage());
				totals.setSuccess(totals.getSuccess() + goodResult.getSuccess());
				totals.setTriumph(totals.getTriumph() + goodResult.getTriumph());
				break;
			case BAD:
				BadResult badResult = (BadResult) result;
				totals.setThreat(totals.getThreat() + badResult.getThreat());
				totals.setFailure(totals.getFailure() + badResult.getFailure());
				totals.setDespair(totals.getDespair() + badResult.getDespair());
				break;
			case FORCE:
				ForceResult forceResult = (ForceResult) result;
				totals.setLight(totals.getLight() + forceResult.getLight());
				totals.setDark(totals.getDark() + forceResult.getDark());
				break;
			default:
				break;
		}
	}
}
