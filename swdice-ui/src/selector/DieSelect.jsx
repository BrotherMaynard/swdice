import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";

import * as ACTIONS from "../actions";

import "./DieSelect.css";

class DieSelect extends Component {
	static propTypes = {
		counts: PropTypes.object.isRequired,
		type: PropTypes.string.isRequired,
		updateCount: PropTypes.func.isRequired
	}

	constructor(props) {
		super(props);

		this.handleDirectInput = this.handleDirectInput.bind(this);
	}

	handleDirectInput(e) {
		this.props.updateCount(this.props.type, parseInt(e.target.value, 10));
	}

	render() {
		const { counts, type } = this.props;
		const count = counts[type];

		return (
			<div className={`die-select select-${type}`}>
				<canvas className={`die die-${type}`} title={type}>
				</canvas>
				<div className="selector-controls">
					<button
						aria-label={`Add ${type} die`}
						className="button-increase"
						title={`Add ${type} die`}
						onClick={() => this.props.updateCount(type, count + 1)}>
						+
					</button>
					<input
						className="count"
						onChange={this.handleDirectInput}
						value={count}/>
					<button
						aria-label={`Remove ${type} die`}
						className="button-decrease"
						title={`Remove ${type} die`}
						onClick={() => this.props.updateCount(type, Math.max(0, count - 1))}>
						-
					</button>
				</div>
			</div>
		);
	}
}

/*const mapStateToProps = (state) => ({
	counts: state.counts
});*/
const mapStateToProps = (state) => {
	console.log("mapStateToProps", state);
	return {
		counts: state.get("counts")
	};
};

/*const mapDispatchToProps = (dispatch) => ({
	updateCount: (type, count) => dispatch({
		count,
		dieType: type,
		type: ACTIONS.UPDATE_DIE_COUNT
	})
});*/
const mapDispatchToProps = (dispatch) => {
	console.log("mapDispatchToProps");
	return {
		updateCount: (type, count) => dispatch({
			count,
			dieType: type,
			type: ACTIONS.UPDATE_DIE_COUNT
		})
	};
}

export default connect(mapStateToProps, mapDispatchToProps)(DieSelect);
