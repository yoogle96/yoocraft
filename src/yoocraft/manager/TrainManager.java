package yoocraft.manager;

import bwapi.Unit;
import bwapi.UnitType;
import org.omg.CORBA.CODESET_INCOMPATIBLE;
import yoocraft.train.CommandCenterTrain;

public class TrainManager {

    private static TrainManager instance = new TrainManager();

    public static TrainManager Instance() {
        return instance;
    }

    private CommandCenterTrain commandCenterTrain = new CommandCenterTrain();

    public void update() {
        commandCenterTrain.train();
    }


}
