import React, { Component } from "react";

export default class Controls extends Component {
	render() {
		return (
			<div className="roll-controls">
				<button className="button-roll">Roll it!</button>
				<button className="button-add">I forgot to add something...</button>
			</div>
		);
	}
}
