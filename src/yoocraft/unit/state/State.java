package yoocraft.unit.state;

import bwapi.Unit;

public abstract class State {

    public enum CurrentState {
        New,
        Idle,
        Move,
        Attack,
    }

    public Unit unit;
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

    abstract public void action();
}
