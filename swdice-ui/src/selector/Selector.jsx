import React, { Component } from "react";

import DieSelect from "./DieSelect";

export default class Selector extends Component {
	static types = [
		"boost",
		"ability",
		"proficiency",
		"setback",
		"difficulty",
		"challenge",
		"force"
	];

	render() {
		return (
			<div className="dice-selector">
				{Selector.types.map((type) => <DieSelect key={type} type={type} />)}
			</div>
		);
	}
}
