package yoocraft.strategy.build;

import bwapi.UnitType;
import yoocraft.BuildOrderItem;
import yoocraft.manager.BuildManager;
import yoocraft.manager.InformationManager;

public class OneFacDouble implements BuildOrder{

    @Override
    public void initBuild() {
        System.out.println("원팩 더블 설정");

        BuildManager.Instance().buildQueue.queueAsLowestPriority(
                InformationManager.Instance().getBasicSupplyProviderUnitType(),
                BuildOrderItem.SeedPositionStrategy.MainBaseLocation, true);

        BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Terran_Barracks,
                BuildOrderItem.SeedPositionStrategy.MainBaseLocation, true);

        BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Terran_Barracks,
                BuildOrderItem.SeedPositionStrategy.MainBaseLocation, true);

        BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Terran_Barracks,
                BuildOrderItem.SeedPositionStrategy.MainBaseLocation, true);

        BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Terran_Barracks,
                BuildOrderItem.SeedPositionStrategy.MainBaseLocation, true);

        BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Terran_Barracks,
                BuildOrderItem.SeedPositionStrategy.MainBaseLocation, true);
    }

    @Override
    public void update() {

    }
}
