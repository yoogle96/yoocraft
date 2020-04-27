package yoocraft.unit.manager;

import bwapi.Player;
import bwapi.UnitType;
import yoocraft.UnitInfo;
import yoocraft.manager.InformationManager;

import java.util.ArrayList;

public class ScvManager {

    private static ScvManager intance = new ScvManager();
    private static InformationManager informationManager = InformationManager.Instance();
    private static Player selfPlayer = informationManager.selfPlayer;

    public void update() {
        ArrayList<UnitInfo> scvList = InformationManager.Instance().getUnitInfos(UnitType.Terran_SCV, selfPlayer);
        if(scvList == null) {
            return;
        }

        for(UnitInfo unitInfo : scvList) {
            // TODO : action
        }
    }
}
