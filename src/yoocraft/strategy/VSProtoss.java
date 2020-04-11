package yoocraft.strategy;

import yoocraft.MyBotModule;
import yoocraft.strategy.build.OneFacDouble;

public class VSProtoss implements VSRace{
    OneFacDouble oneFacDouble = new OneFacDouble();

    @Override
    public void initBuild() {
        MyBotModule.Broodwar.printf("VSProtoss Init");
        System.out.println("VSProtoss Init");
        oneFacDouble.initBuild();
    }

    @Override
    public void update() {
        oneFacDouble.update();
    }
}
