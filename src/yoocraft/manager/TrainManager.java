package yoocraft.manager;

import bwapi.Unit;
import bwapi.UnitType;
import org.omg.CORBA.CODESET_INCOMPATIBLE;
import yoocraft.train.CommandCenterTrain;
import yoocraft.train.FactoryTrain;

public class TrainManager {

    private static TrainManager instance = new TrainManager();
    private CommandCenterTrain commandCenterTrain = new CommandCenterTrain();
    private FactoryTrain factoryTrain = new FactoryTrain();

    public static TrainManager Instance() {
        return instance;
    }

    public void update() {
        commandCenterTrain.train();
        factoryTrain.train();
    }

}
