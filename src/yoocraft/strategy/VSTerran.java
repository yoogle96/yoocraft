package yoocraft.strategy;

import yoocraft.MyBotModule;
import yoocraft.strategy.build.OneFacDouble;

public class VSTerran implements VSRace{
    OneFacDouble oneFacDouble = new OneFacDouble();

    @Override
    public void initBuild() {
        MyBotModule.Broodwar.printf("VSTerran Init");
        System.out.println("VSTerran Init");
        oneFacDouble.initBuild();
    }

    @Override
    public void update() {
        oneFacDouble.update();
    }
}
