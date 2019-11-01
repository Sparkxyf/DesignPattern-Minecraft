package design.mine;

import design.mine.mine.UseAluminumShovel;
import design.mine.mine.UseCopperShovel;
import design.mine.mine.UseDiamondShovel;
import design.mine.mine.UseIronShovel;
import design.mine.tool.*;
import design.mine.backpack.*;
import design.mine.smelter.*;
//import useTools.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MiningArea {
    private BackpackFacadeImpl backpack;

    public MiningArea(){
        //创建角色的背包，其中应该有初始矿石、应该没有工具
        backpack = new BackpackFacadeImpl();
    }

    public void exec() {
        //其它初始化
        HashMap<String, Integer> mineral = backpack.getMineralList();
        MiningToolsCompositeImpl miningTools = backpack.getToolList();
        UseDiamondShovel diamondShovel = new UseDiamondShovel(backpack);
        UseIronShovel ironShovel = new UseIronShovel(backpack);
        UseCopperShovel copperShovel = new UseCopperShovel(backpack);
        UseAluminumShovel aluminumShovel = new UseAluminumShovel(backpack);

        BackpackMediatorImpl robot = new BackpackMediatorImpl();
        robot.welcome();

        //使用者交互
        while (true) {
            int actionCode = robot.navigation();
            if (actionCode == 0)
                break;

            //矿山，使用工具开采矿石
            switch (actionCode){
                case 1:
                    diamondShovel.mineKind();
                    break;
                case 2:
                    ironShovel.mineKind();
                    break;
                case 3:
                    copperShovel.mineKind();
                    break;
                case 4:
                    aluminumShovel.mineKind();
                    break;
                default:
                    break;
            }

            //熔炉室，消耗矿石制造工具
            if(actionCode == 5) {
                int toolCode = -1;
                while (toolCode != 0) {
                    System.out.println("进入熔炉室，要制造工具吗？\n1-确认  2-离开");
                    Scanner scanner = new Scanner(System.in);
                    int cmd = scanner.nextInt();
                    if (cmd == 1) {
                        SmelterObserverImpl smelterObserver = new SmelterObserverImpl(backpack);

                        System.out.println("消耗矿石制造哪种工具？\n1-钻石镐（4钻石）  2-铁镐（6铁）  3-铜镐（8铜）  4-铝镐（10铝）");
                        Scanner scanner3 = new Scanner(System.in);
                        toolCode = scanner3.nextInt();
                        switch (toolCode) {
                            case 1:
                                smelterObserver.operate("钻石矿石");
                                break;
                            case 2:
                                smelterObserver.operate("铁矿");
                                break;
                            case 3:
                                smelterObserver.operate("铜矿");
                                break;
                            case 4:
                                smelterObserver.operate("铝矿");
                                break;
                            default:
                                break;
                        }
                    } else {
                        System.out.println("离开了熔炉室。");
                        break;
                    }
                }
            }
            //显示背包里的东西
            else if (actionCode == 6){
                System.out.println("你的背包里有这些东西：");
                for (Map.Entry<String, Integer> entry : mineral.entrySet()) {
                    System.out.println(entry.getKey() + "-------------" + entry.getValue() + "单位");
                }
                BackpackToolsIteratorImpl toolsIterator = new BackpackToolsIteratorImpl(miningTools);
                HashMap<String, Integer> miningToolsSummary = toolsIterator.aggregation();
                for (Map.Entry<String, Integer> entry : miningToolsSummary.entrySet()) {
                    System.out.println(entry.getKey() + "-------------" + entry.getValue() + "把");
                }
            }
        }
        System.out.println("离开了矿区。");
    }
}
