package yoocraft.unit.state;

import bwta.Chokepoint;
import yoocraft.CommandUtil;
import yoocraft.manager.InformationManager;

public class MarineState extends State {

    @Override
    public void action() {
        if(currentState == CurrentState.Idle) {
            Chokepoint chokepoint = InformationManager.Instance().getFirstChokePoint(InformationManager.Instance().selfPlayer);
            CommandUtil.Instance().move(unit, chokepoint.getCenter());
        }
    }
}
