package yoocraft.unit.state;

import bwapi.Unit;

public abstract class State {

    public enum CurrentState {
        New,
        Idle,
        Move,
        Attack,
        Minerals,
        Gas,
    }

    public Unit unit;
    public Unit target;
    public CurrentState currentState = CurrentState.New;

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public CurrentState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(CurrentState currentState) {
        this.currentState = currentState;
    }

    public Unit getTarget() {
        return target;
    }

    public void setTarget(Unit target) {
        this.target = target;
    }

    abstract public void action();
}
