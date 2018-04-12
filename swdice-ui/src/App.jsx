import React, { Component } from "react";

import Selector from "./selector/Selector";
import RollArea from "./roll-area/RollArea";
import Results from "./results/Results";
import Help from "Help";

import "./App.css";

export default class App extends Component {
	render() {
		return (
			<div className="sw-dice-app">
				<header className="header">
					<h1 className="title">Star Wars Dice Roller</h1>
				</header>
				<div className="content">
					<Help />
					<Selector />
					<RollArea />
					<Results />
				</div>
				<footer className="footer">
					Brought to you by <a href="https://start.spring.io/">start.spring.io</a>, <a href="https://github.com/facebook/create-react-app">Create React App</a>, and David. <a href="https://www.fantasyflightgames.com/">Fantasy Flight Games</a> made the awesome Star Wars game for which you are about to roll dice. Star Wars now finds itself a vassal of the almighty Mouse.
				</footer>
			</div>
		);
	}
}
