package yoocraft.manager.unit;

import bwapi.Unit;
import bwapi.UnitType;
import yoocraft.MyBotModule;
import yoocraft.UnitInfo;
import yoocraft.manager.InformationManager;

public class MarineManager {

    private static MarineManager instance = new MarineManager();

    public static MarineManager Instance() {
        return instance;
    }

    public void update() {
        if (InformationManager.Instance().getUnitData(MyBotModule.Broodwar.self()).getNumCreatedUnits(UnitType.Terran_Marine.toString()) >= 2) {
            for (UnitInfo unitInfo : InformationManager.Instance().getUnitData(MyBotModule.Broodwar.self()).getUnitInfos(UnitType.Terran_Marine)) {
                MyBotModule.Broodwar.printf(unitInfo.toString());

                if (InformationManager.Instance().getUnitData(MyBotModule.Broodwar.self()).getNumCreatedUnits(UnitType.Terran_Bunker.toString()) == 1) {
                    UnitInfo bunkerInfo = InformationManager.Instance().getUnitData(MyBotModule.Broodwar.self()).getBuildingUnitInfos(UnitType.Terran_Bunker).get(0);
                    unitInfo.getUnit().rightClick(bunkerInfo.getUnit());
                }
            }
        }
    }
}
