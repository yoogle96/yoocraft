package yoocraft.unit.manager;

import bwapi.Player;
import bwapi.UnitType;
import yoocraft.MyBotModule;
import yoocraft.UnitInfo;
import yoocraft.manager.InformationManager;
import yoocraft.unit.state.ScvState;
import yoocraft.unit.state.State;

import java.util.ArrayList;

public class ScvManager {

    private static ScvManager instance = new ScvManager();
    private static InformationManager informationManager = InformationManager.Instance();
    private static Player selfPlayer = informationManager.selfPlayer;

    public static ScvManager Instance() {
        return instance;
    }

    public void update() {
        ArrayList<UnitInfo> scvList = InformationManager.Instance().getUnitInfos(UnitType.Terran_SCV, selfPlayer);
        if(scvList == null) {
            return;
        }

        for(UnitInfo unitInfo : scvList) {
            State state = unitInfo.getState();

            if(state == null) {
                unitInfo.setState(new ScvState());
                unitInfo.setUnit(unitInfo.getUnit());
                continue;
            }
        }
    }
}
