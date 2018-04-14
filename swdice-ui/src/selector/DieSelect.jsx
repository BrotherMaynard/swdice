import React, { Component } from "react";
import PropTypes from "prop-types";

import "./DieSelect.css";

export default class DieSelect extends Component {
	static propTypes = {
		type: PropTypes.string.isRequired
	}

	constructor(props) {
		super(props);

		this.state = {
			count: 0
		};

		this.handleDirectInput = this.handleDirectInput.bind(this);
	}

	handleDirectInput(e) {
		this.setState({
			count: parseInt(e.target.value, 10)
		});
	}

	render() {
		const { type } = this.props;

		return (
			<div className={`die-select select-${type}`}>
				<canvas className={`die die-${type}`} title={type}>
				</canvas>
				<div className="selector-controls">
					<button
						aria-label={`Add ${type} die`}
						className="button-increase"
						title={`Add ${type} die`}
						onClick={() => this.setState({ count: this.state.count + 1})}>
						+
					</button>
					<input
						className="count"
						onChange={this.handleDirectInput}
						value={this.state.count}/>
					<button
						aria-label={`Remove ${type} die`}
						className="button-decrease"
						title={`Remove ${type} die`}
						onClick={() => this.setState({ count: Math.max(0, this.state.count - 1)})}>
						-
					</button>
				</div>
			</div>
		);
	}
}
