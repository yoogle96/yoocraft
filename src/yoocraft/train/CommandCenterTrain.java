package yoocraft.train;

import bwapi.Unit;
import bwapi.UnitType;
import yoocraft.manager.InformationManager;

public class CommandCenterTrain {

    public void train() {
        for(Unit unit : InformationManager.Instance().selfPlayer.getUnits()) {
            if(unit.getType() == UnitType.Terran_Command_Center) {
                unit.train(UnitType.Terran_SCV);
            }
        }
    }
}
