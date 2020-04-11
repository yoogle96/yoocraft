package yoocraft.strategy.build;

import bwapi.UnitType;
import yoocraft.MyBotModule;

public class BuildUtil {

    public boolean canBuild(UnitType unitType, int supplyCnt) {
        if(MyBotModule.Broodwar.self().supplyUsed() >= supplyCnt) {
            return true;
        }else {
            return false;
        }
    }
}
