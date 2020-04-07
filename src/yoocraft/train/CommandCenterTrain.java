package yoocraft.train;

import bwapi.Unit;
import bwapi.UnitType;
import yoocraft.MyBotModule;
import yoocraft.UnitInfo;
import yoocraft.manager.InformationManager;


public class CommandCenterTrain {

    public void train() {
        for(UnitInfo unitInfo : InformationManager.Instance().getUnitData(MyBotModule.Broodwar.self()).getBuildingUnitInfos(UnitType.Terran_Command_Center)) {
            if(!unitInfo.getUnit().isTraining()) {
                unitInfo.getUnit().train(UnitType.Terran_SCV);
            }
        }
    }
}
