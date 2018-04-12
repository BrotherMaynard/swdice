import React, { Component } from "react";

export default class DieSelect extends Component {
	render() {
		return (
			<div className="die-select select-boost">
				<canvas className="die die-boost">
				</canvas>
				<div className="selector-controls">
					<button aria-label="Add boost die" className="button-increase">+</button>
					<input className="count" />
					<button aria-label="Remove boost die" className="button-decrease">-</button>
				</div>
			</div>
		);
	}
}
