package design.mine.smelter;

import java.util.HashMap;

abstract class SmelterObserver {
    abstract void operate(String name);
    //观察MineList
    abstract boolean judgeMineList(HashMap<String, Integer> mine, String mineName);
}
