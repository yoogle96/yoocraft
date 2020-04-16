package yoocraft.strategy.build;

import bwapi.UnitType;
import yoocraft.MyBotModule;
import yoocraft.manager.BuildManager;
import yoocraft.manager.ConstructionManager;
import yoocraft.manager.InformationManager;

import javax.sound.sampled.Line;

public class BuildUtil {

    public boolean canFirstBuild(UnitType unitType, int supplyCnt) {

        // 이미 빌드오더 큐에 존재하거나 건물이 있는경우 false 반환
        if(isExistOrUnderConstruction(unitType)) {
            return false;
        }

        return isCanSupplyUsed(supplyCnt);
    }

    public boolean canExtensionBuild(UnitType unitType, int supplyCnt) {
        int maxExtensionCnt = 3;
        // 자신의 유닛중 커멘드센터의 갯수 조건
        if(BuildManager.Instance().buildQueue.getItemCount(unitType) >= 1 ||
                InformationManager.Instance().getUnitData(MyBotModule.Broodwar.self()).getNumCreatedUnits(UnitType.Terran_Command_Center.toString()) > maxExtensionCnt ||
                ConstructionManager.Instance().getConstructionQueueItemCount(unitType, null) >= 1) {
            return false;
        }

        return isCanSupplyUsed(supplyCnt);
    }

    public boolean canBuildAddFactory(UnitType unitType, int maxCnt) {
        if(BuildManager.Instance().buildQueue.getItemCount(unitType) +
                InformationManager.Instance().getUnitData(MyBotModule.Broodwar.self()).getNumCreatedUnits(unitType.toString()) +
                ConstructionManager.Instance().getConstructionQueueItemCount(unitType, null) >= maxCnt ||
                BuildManager.Instance().buildQueue.getItemCount(unitType) >= 1 ) {
            return false;
        }

        return true;
    }

    public boolean hasBuild(UnitType unitType, int hasCnt) {
        if(InformationManager.Instance().getUnitData(MyBotModule.Broodwar.self()).getNumCreatedUnits(unitType.toString()) >= hasCnt) {
            return true;
        }else{
            return false;
        }
    }

    // 빌드오더 큐, 자신의 유닛, 건설중인 건물에서 하나라도 존재하는지 여부
    public boolean isExistOrUnderConstruction(UnitType unitType) {
        if (BuildManager.Instance().buildQueue.getItemCount(unitType) >= 1 ||
                InformationManager.Instance().getUnitData(MyBotModule.Broodwar.self()).getBuildingUnitInfos(unitType) != null ||
                ConstructionManager.Instance().getConstructionQueueItemCount(unitType, null) >= 1) {
            return true;
        }else {
            return false;
        }
    }

    public boolean isCanSupplyUsed(int supplyCnt) {
        return MyBotModule.Broodwar.self().supplyUsed() >= supplyCnt;
    }
}
