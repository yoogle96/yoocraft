package yoocraft.train;

import bwapi.Player;
import bwapi.UnitType;
import yoocraft.MyBotModule;
import yoocraft.UnitInfo;
import yoocraft.manager.InformationManager;

import java.util.ArrayList;

public class BarracksTrain {

    private int maxMarineCnt = 2;

    public void train() {
        Player player = InformationManager.Instance().selfPlayer;
        ArrayList<UnitInfo> barracks = InformationManager.Instance().getUnitData(player).getBuildingUnitInfos(UnitType.Terran_Barracks);

        int curMarineCnt = InformationManager.Instance().getNumUnits(UnitType.Terran_Marine, player);

        if(barracks != null) {
            for(UnitInfo unitInfo : barracks) {
                if(curMarineCnt < maxMarineCnt) {
                    unitInfo.getUnit().train(UnitType.Terran_Marine);
                }
            }
        }
    }
}
