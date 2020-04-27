package yoocraft.manager;

import yoocraft.unit.manager.MarineManager;
import yoocraft.unit.manager.ScvManager;

public class UnitManager {

    private static UnitManager instance = new UnitManager();

    public static UnitManager Instance() {
        return instance;
    }

    public void update() {
        MarineManager.Instance().update();
        ScvManager.Instance().update();
    }
}
