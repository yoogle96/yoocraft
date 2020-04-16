package yoocraft.strategy.build;

import bwapi.Race;
import bwapi.TilePosition;
import bwapi.UnitType;
import yoocraft.BuildOrderItem;
import yoocraft.ConstructionPlaceFinder;
import yoocraft.MyBotModule;
import yoocraft.manager.BuildManager;
import yoocraft.manager.InformationManager;

import javax.sound.sampled.Line;

public class OneFacDouble extends BuildMaxCount implements BuildOrder {

    BuildUtil buildUtil = new BuildUtil();

    @Override
    public void initBuild() {
        if(InformationManager.Instance().enemyRace == Race.Zerg) {
            maxFactoryCnt = 5;
        }else if(InformationManager.Instance().enemyRace == Race.Protoss) {
            maxFactoryCnt = 6;
        }else if(InformationManager.Instance().enemyRace == Race.Terran) {
            maxFactoryCnt = 6;
        }
    }

    @Override
    public void update() {
        // 12프레임에 한번씩 실행
        if(MyBotModule.Broodwar.getFrameCount() % 12 != 0) {
            return;
        }

        if(buildUtil.canFirstBuild(UnitType.Terran_Barracks, 22)) {
            BuildManager.Instance().buildQueue.queueAsHighestPriority(UnitType.Terran_Barracks, false);
        };

        if(buildUtil.canFirstBuild(UnitType.Terran_Refinery, 24)) {
            TilePosition refineryPosition = ConstructionPlaceFinder.Instance().getRefineryPositionNear(BuildOrderItem.SeedPositionStrategy.MainBaseLocation);

            if(refineryPosition.isValid()) {
                BuildManager.Instance().buildQueue.queueAsHighestPriority(UnitType.Terran_Refinery, refineryPosition, false);
            }
        }

        if(buildUtil.canFirstBuild(UnitType.Terran_Factory, 32)) {
            BuildManager.Instance().buildQueue.queueAsHighestPriority(UnitType.Terran_Factory, false);
        }

        if(buildUtil.canExtensionBuild(UnitType.Terran_Command_Center, 40)) {
            BuildManager.Instance().buildQueue.queueAsHighestPriority(UnitType.Terran_Command_Center, BuildOrderItem.SeedPositionStrategy.FirstExpansionLocation, false);
        }

        // 추가 팩토리 건설
        if(buildUtil.canBuildAddFactory(UnitType.Terran_Factory, maxFactoryCnt)) {
            BuildManager.Instance().buildQueue.queueAsHighestPriority(UnitType.Terran_Factory, false);
        }
    }
}
