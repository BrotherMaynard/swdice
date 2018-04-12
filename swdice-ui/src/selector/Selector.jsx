import React, { Component } from "react";

import DieSelect from "./DieSelect";

export default class Selector extends Component {
	render() {
		return (
			<div className="dice-selector">
				<DieSelect />
			</div>
		);
	}
}
