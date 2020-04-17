package yoocraft.manager;

import bwapi.Unit;
import bwapi.UnitType;
import org.omg.CORBA.CODESET_INCOMPATIBLE;
import yoocraft.train.BarracksTrain;
import yoocraft.train.CommandCenterTrain;
import yoocraft.train.FactoryTrain;

import java.util.concurrent.BrokenBarrierException;

public class TrainManager {

    private static TrainManager instance = new TrainManager();
    private CommandCenterTrain commandCenterTrain = new CommandCenterTrain();
    private FactoryTrain factoryTrain = new FactoryTrain();
    private BarracksTrain barracksTrain = new BarracksTrain();

    public static TrainManager Instance() {
        return instance;
    }

    public void update() {
        commandCenterTrain.train();
        factoryTrain.train();
        barracksTrain.train();
    }

}
