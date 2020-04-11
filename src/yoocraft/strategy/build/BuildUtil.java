package yoocraft.strategy.build;

import bwapi.UnitType;
import yoocraft.MyBotModule;
import yoocraft.manager.BuildManager;
import yoocraft.manager.InformationManager;

public class BuildUtil {

    public boolean canBuild(UnitType unitType, int supplyCnt) {

        // 이미 빌드오더 큐에 존재하거나 건물이 있는경우 false 반환
        if(isExistOrUnderConstruction(unitType)) {
            return false;
        }

        if(MyBotModule.Broodwar.self().supplyUsed() >= supplyCnt) {
            return true;
        }else {
            return false;
        }
    }

    public boolean isExistOrUnderConstruction(UnitType unitType) {
        if (BuildManager.Instance().buildQueue.getItemCount(unitType) >= 1 ||
                InformationManager.Instance().getUnitData(MyBotModule.Broodwar.self()).getBuildingUnitInfos(unitType) != null) {
            return true;
        }else {
            return false;
        }
    }
}
