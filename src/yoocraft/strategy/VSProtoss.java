package yoocraft.strategy;

import yoocraft.strategy.build.OneFacDouble;

public class VSProtoss implements VSRace{
    OneFacDouble oneFacDouble = new OneFacDouble();

    @Override
    public void initBuild() {
        oneFacDouble.initBuild();
    }

    @Override
    public void update() {
    }
}
