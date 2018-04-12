import React, { Component } from "react";

import Controls from "./Controls";
import DiceBox from "./DiceBox";

export default class RollArea extends Component {
	render() {
		return (
			<div className="rolling-area">
				<Controls />
				<DiceBox />
				<button className="button-reroll">Well, that was crap. Reroll?</button>
			</div>
		);
	}
}
