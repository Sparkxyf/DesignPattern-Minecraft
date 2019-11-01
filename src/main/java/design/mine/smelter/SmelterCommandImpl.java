package design.mine.smelter;

import design.mine.backpack.BackpackFacadeImpl;
import design.mine.tool.*;

public class SmelterCommandImpl extends SmelterCommand{
    private BackpackFacadeImpl backpack;

    public SmelterCommandImpl(BackpackFacadeImpl b){
        backpack = b;
    }

    public void forgeTools(String mineName){
        System.out.println("接到指令开始处理。");

        //矿石列表减少矿石
        String toolName = "";
        switch (mineName){
            case "钻石矿石":
                backpack.removeMineral(mineName, 4);
                toolName = "钻石镐";
                break;
            case "铁矿":
                backpack.removeMineral(mineName, 6);
                toolName = "铁镐";
                break;
            case "铜矿":
                backpack.removeMineral(mineName, 8);
                toolName = "铜镐";
                break;
            case "铝矿":
                backpack.removeMineral(mineName, 10);
                toolName = "铝镐";
                break;
            default:
                break;
        }

        //工具列表增添工具
        MiningToolsBuilderImpl builder = new MiningToolsBuilderImpl();
        MiningToolsDirector director = new MiningToolsDirector(builder);
        MiningTool tool = director.construct(toolName);
        backpack.addTool(tool);

        System.out.println("制造成功！");
    }
}