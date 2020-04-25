package yoocraft.unit.state;

public abstract class State {

    public enum CurrentState {
        New,
        Idle,
        Move,
        Attack,
    }
    public CurrentState currentState = CurrentState.New;

    public CurrentState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(CurrentState currentState) {
        this.currentState = currentState;
    }
}
