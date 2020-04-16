package yoocraft.train;

import bwapi.UnitType;
import yoocraft.MyBotModule;
import yoocraft.UnitInfo;
import yoocraft.manager.InformationManager;

public class FactoryTrain {

    public void train() {
        // TODO: 더 깔끔한 방식 찾아야함
        if(InformationManager.Instance().getUnitData(MyBotModule.Broodwar.self()).getNumCreatedUnits(UnitType.Terran_Factory.toString()) >= 1) {
            for(UnitInfo unitInfo : InformationManager.Instance().getUnitData(MyBotModule.Broodwar.self()).getBuildingUnitInfos(UnitType.Terran_Factory)) {
                if(!unitInfo.getUnit().isTraining()) {
                    unitInfo.getUnit().train(UnitType.Terran_Vulture);
                }
            }
        }
    }
}
