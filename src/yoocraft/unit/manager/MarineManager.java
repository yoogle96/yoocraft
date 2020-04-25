package yoocraft.unit.manager;

import bwapi.Player;
import bwapi.UnitType;
import yoocraft.MyBotModule;
import yoocraft.UnitInfo;
import yoocraft.manager.InformationManager;

public class MarineManager {

    private static MarineManager instance = new MarineManager();

    private static InformationManager informationManager = InformationManager.Instance();

    private static Player selfPlayer = informationManager.selfPlayer;

    public static MarineManager Instance() {
        return instance;
    }

    public void update() {
        if (informationManager.getUnitData(selfPlayer).getNumCreatedUnits(UnitType.Terran_Marine.toString()) >= 2) {
            for (UnitInfo unitInfo : InformationManager.Instance().getUnitData(MyBotModule.Broodwar.self()).getUnitInfos(UnitType.Terran_Marine)) {
                if (InformationManager.Instance().getUnitData(MyBotModule.Broodwar.self()).getNumCreatedUnits(UnitType.Terran_Bunker.toString()) == 1) {
                    UnitInfo bunkerInfo = InformationManager.Instance().getUnitData(MyBotModule.Broodwar.self()).getBuildingUnitInfos(UnitType.Terran_Bunker).get(0);
                    unitInfo.getUnit().rightClick(bunkerInfo.getUnit());
                }
            }
        }
    }
}
