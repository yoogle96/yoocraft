package yoocraft.strategy.build;

import bwapi.TilePosition;
import bwapi.UnitType;
import yoocraft.BuildOrderItem;
import yoocraft.ConstructionPlaceFinder;
import yoocraft.manager.BuildManager;
import yoocraft.manager.InformationManager;

public class OneFacDouble implements BuildOrder{

    BuildUtil buildUtil = new BuildUtil();

    @Override
    public void initBuild() {
        System.out.println("원팩 더블 설정");
//
//        BuildManager.Instance().buildQueue.queueAsLowestPriority(
//                InformationManager.Instance().getBasicSupplyProviderUnitType(),
//                BuildOrderItem.SeedPositionStrategy.MainBaseLocation, true);
//
//        BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Terran_Barracks,
//                BuildOrderItem.SeedPositionStrategy.MainBaseLocation, true);
//
//        BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Terran_Barracks,
//                BuildOrderItem.SeedPositionStrategy.MainBaseLocation, true);
//
//        BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Terran_Barracks,
//                BuildOrderItem.SeedPositionStrategy.MainBaseLocation, true);
//
//        BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Terran_Barracks,
//                BuildOrderItem.SeedPositionStrategy.MainBaseLocation, true);
//
//        BuildManager.Instance().buildQueue.queueAsLowestPriority(UnitType.Terran_Barracks,
//                BuildOrderItem.SeedPositionStrategy.MainBaseLocation, true);
    }

    @Override
    public void update() {
        if(buildUtil.canBuild(UnitType.Terran_Barracks, 22)) {
            BuildManager.Instance().buildQueue.queueAsHighestPriority(UnitType.Terran_Barracks, false);
        };

        if(buildUtil.canBuild(UnitType.Terran_Refinery, 24)) {
            TilePosition refineryPostiion = ConstructionPlaceFinder.Instance().getRefineryPositionNear(BuildOrderItem.SeedPositionStrategy.MainBaseLocation);

            if(refineryPostiion.isValid()) {
                BuildManager.Instance().buildQueue.queueAsHighestPriority(UnitType.Terran_Refinery, refineryPostiion, false);
            }
        }
    }
}
