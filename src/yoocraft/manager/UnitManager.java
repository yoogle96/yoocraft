package yoocraft.manager;

import yoocraft.unit.manager.MarineManager;

public class UnitManager {

    private static UnitManager instance = new UnitManager();

    public static UnitManager Instance() {
        return instance;
    }

    public void update() {
        MarineManager.Instance().update();
    }
}
