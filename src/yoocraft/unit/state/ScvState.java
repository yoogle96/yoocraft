package yoocraft.unit.state;

import bwapi.Unit;
import bwapi.UnitCommand;
import bwapi.UnitCommandType;
import yoocraft.CommandUtil;
import yoocraft.MyBotModule;

public class ScvState extends State {

    @Override
    public void action() {
        if(currentState == CurrentState.Idle) {

        }else if(currentState == CurrentState.Minerals) {
            UnitCommand currentCommand = unit.getLastCommand();
            if(unit.canReturnCargo() && currentCommand.getUnitCommandType() != UnitCommandType.Return_Cargo) {
                unit.returnCargo();
            }else if(!unit.isCarryingGas() && !unit.isCarryingMinerals()) {
                CommandUtil.Instance().rightClick(unit, target);
            }
        }
    }
}
