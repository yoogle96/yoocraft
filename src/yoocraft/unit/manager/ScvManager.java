package yoocraft.unit.manager;

import bwapi.Player;
import bwapi.TilePosition;
import bwapi.Unit;
import bwapi.UnitType;
import bwta.BWTA;
import bwta.BaseLocation;
import com.sun.xml.internal.rngom.parse.host.Base;
import yoocraft.MyBotModule;
import yoocraft.UnitInfo;
import yoocraft.manager.InformationManager;
import yoocraft.unit.state.ScvState;
import yoocraft.unit.state.State;

import java.util.ArrayList;
import java.util.HashMap;

public class ScvManager {

    private static ScvManager instance = new ScvManager();
    private static InformationManager informationManager = InformationManager.Instance();
    private static Player selfPlayer = informationManager.selfPlayer;
    HashMap<Unit, ArrayList<Unit>> depotMineralMap = new HashMap<>();
    HashMap<Unit, Integer> mineralScvCountMap = new HashMap<Unit, Integer>();

    public static ScvManager Instance() {
        return instance;
    }

    public void update() {

        checkDepot();

        ArrayList<UnitInfo> scvList = InformationManager.Instance().getUnitInfos(UnitType.Terran_SCV, selfPlayer);
        if(scvList == null) {
            return;
        }

        for(UnitInfo unitInfo : scvList) {
            State state = unitInfo.getState();

            if(state == null) {
                unitInfo.setState(new ScvState());
                unitInfo.setStateUnit(unitInfo.getUnit());
                continue;
            }

            State.CurrentState currentState = state.currentState;
            if(currentState == State.CurrentState.New) {
                unitInfo.setCurrentState(State.CurrentState.Idle);
            }else if(currentState == State.CurrentState.Idle) {
                setMineralScv(unitInfo);
            }else {
                unitInfo.action();
            }
        }
    }

    public void onUnitComplete(Unit unit) {
        initMineralsNearDepot(unit);
    }

    void setMineralScv(UnitInfo scv) {
        Unit center = getNearestDepot(scv);
        if(center == null) {

        }else {
            Unit mineral = getBestMineral(center);
            if(mineral != null) {
                scv.setCurrentState(State.CurrentState.Minerals);
                if(scv.getUnit().canReturnCargo()) {
                    scv.getUnit().returnCargo();
                }else {
                    scv.setTarget(mineral);
                    scv.action();
                }
            }
        }
    }

    Unit getNearestDepot(UnitInfo scv) {
        Unit center = null;
        double dist = 10000000;

        ArrayList<UnitInfo> centerList = InformationManager.Instance().getBuildInfos(UnitType.Terran_Command_Center, selfPlayer);
        // 커멘드 센터가 없을 경우 Return
        if(centerList == null) {
            return null;
        }

        for(UnitInfo unitInfo : centerList) {
            // TODO : depotHasEnoughMineralWorkers
            if(unitInfo.getUnit().isFlying() || !unitInfo.isCompleted()) {
                continue;
            }

            double tmpDist = -1;
            tmpDist = BWTA.getGroundDistance(scv.getUnit().getTilePosition(), unitInfo.getUnit().getTilePosition());

            if(tmpDist < dist && tmpDist > 0) {
                dist = tmpDist;
                center = unitInfo.getUnit();
            }
        }

        return center;
    }

    Unit getBestMineral(Unit center) {
//        if(depotMineralMap.get(center).size() == 0) {
//            return null;
//        }

        for(int depth = 0; depth < 2; depth++) {
            for(Unit m : depotMineralMap.get(center)) {
                if(getMineralScvCount(m) == depth) {
                    return m;
                }
            }
        }

        return null;
    }

    int getMineralScvCount(Unit unit) {
        if(mineralScvCountMap.containsKey(unit)) {
            return mineralScvCountMap.get(unit);
        }else {
            mineralScvCountMap.put(unit, 0);
            return 0;
        }
    }

    void initMineralsNearDepot(Unit depot) {
        if(!depotMineralMap.containsKey(depot)) {
            depotMineralMap.put(depot, new ArrayList<>());
        }
        MyBotModule.Broodwar.printf("TEST Execute!");
        BaseLocation baseLocation = InformationManager.Instance().getNearestBaseLocation(depot.getPosition());

        for(Unit mineral : baseLocation.getMinerals()) {
            depotMineralMap.get(depot).add(mineral);
        }
    }

    void checkDepot() {
        ArrayList<UnitInfo> commandCenterList = InformationManager.Instance().getBuildInfos(UnitType.Terran_Command_Center, selfPlayer);
        for(UnitInfo command : commandCenterList) {
            if(!command.getUnit().isFlying() && !command.getUnit().isLifted()) {
                if(!depotMineralMap.containsKey(command)) {
                    initMineralsNearDepot(command.getUnit());
                }
            }
        }
    }
}
