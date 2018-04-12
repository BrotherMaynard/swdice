import React, { Component } from "react";

export default class DiceBox extends Component {
	render() {
		return (
			<div className="dice-box">
				<img alt="" className="dice-box-background" src="" />
				<canvas className="dice-box-render">
				</canvas>
			</div>
		);
	}
}
