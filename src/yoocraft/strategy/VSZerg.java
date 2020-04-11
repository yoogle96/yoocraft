package yoocraft.strategy;

import yoocraft.MyBotModule;
import yoocraft.strategy.build.OneFacDouble;

public class VSZerg implements VSRace{
    OneFacDouble oneFacDouble = new OneFacDouble();

    @Override
    public void initBuild() {
        MyBotModule.Broodwar.printf("VSZerg Init");
        System.out.println("VSZerg Init");
        oneFacDouble.initBuild();
    }

    @Override
    public void update() {
        oneFacDouble.update();
    }
}
