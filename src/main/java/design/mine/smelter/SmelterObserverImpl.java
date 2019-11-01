package design.mine.smelter;

import design.mine.backpack.BackpackFacadeImpl;

import java.util.HashMap;

public class SmelterObserverImpl extends SmelterObserver{
    private HashMap<String, Integer> mineralList;
    private SmelterCommandImpl smelterCommand;

    public SmelterObserverImpl(BackpackFacadeImpl b){
        mineralList = b.getMineralList();
        smelterCommand = new SmelterCommandImpl(b);
    }

    @Override
    public boolean judgeMineList(HashMap<String, Integer> mine, String  mineName) {
        int number = mine.get(mineName);
        boolean result = false;
        switch (mineName) {
            case "钻石矿石":
                if (number >= 4)
                    result = true;
                break;
            case "铁矿":
                if (number >= 6)
                    result = true;
                break;
            case "铜矿":
                if (number >= 8)
                    result = true;
                break;
            case "铝矿":
                if (number >= 10)
                    result = true;
                break;
            default:
                break;
        }
        if (!result)
            System.out.println("矿石材料不够，无法锻造这类工具。");
        else
            System.out.println("矿石材料足够，开始锻造。");
        return result;
    }

    @Override
    public void operate(String name){
        boolean flag = judgeMineList(mineralList, name);
        if (flag)
            smelterCommand.forgeTools(name);
    }
}