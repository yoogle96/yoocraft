package yoocraft.unit.manager;

import bwapi.Player;
import bwapi.UnitType;
import yoocraft.MyBotModule;
import yoocraft.UnitInfo;
import yoocraft.manager.InformationManager;
import yoocraft.unit.state.MarineState;
import yoocraft.unit.state.State;

import java.util.ArrayList;

import static bwapi.UnitType.Terran_Marine;

public class MarineManager {

    private static MarineManager instance = new MarineManager();

    private static InformationManager informationManager = InformationManager.Instance();

    private static Player selfPlayer = informationManager.selfPlayer;

    public static MarineManager Instance() {
        return instance;
    }

    public void update() {
        ArrayList<UnitInfo> marineList = InformationManager.Instance().getUnitInfos(Terran_Marine, selfPlayer);
        if(marineList == null) return;

        for(UnitInfo unitInfo : marineList) {
            State state = unitInfo.getState();

            if(state == null) {
                unitInfo.setState(new MarineState());
                continue;
            }

            State.CurrentState currentState = state.getCurrentState();
            if(currentState == State.CurrentState.New) {
                unitInfo.setCurrentState((State.CurrentState.Idle));
            }
        }
    }
}
