import * as ACTIONS from "./actions";

const initialState = () => {
	const state = new Map();
	state.set("counts", new Map());
	console.log("initialState", state);
	return state;
};

const reducers = (state = initialState(), action) => {
	switch (action.type) {
		case ACTIONS.UPDATE_DIE_COUNT:
			state.get("counts").set(action.dieType, action.count);
			return state;
		default:
			return state;
	}
};

export default reducers;
