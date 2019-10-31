package design.mine.mine;

import design.mine.backpack.BackpackFacadeImpl;
import design.mine.tool.*;
import design.mine.trolley.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UseCopperShovel extends UseToolsServiceMineralImpl {

    private BackpackFacadeImpl backpack;
    private HashMap<String, Integer> mineralList;
    private MiningToolsCompositeImpl tools;
    private MiningTool tool;
    private int index = -1;

    public UseCopperShovel(BackpackFacadeImpl b){
        backpack = b;
        mineralList = backpack.getMineralList();
        tools = backpack.getToolList();
    }
    /**
     * 模板模式抽象方法实现
     */
//    public void usePh(){
//
//    }

    public void useDurability(){
        if(tool != null) {
            int durability = tool.getDurability();
            if (durability - 10 >= 0) {
                tool.setDurability(durability - 10);
                System.out.println("当前工具耐久度为：" + tool.getDurability());
            }
            if(tool.getDurability() == 0){
                System.out.println("该工具使用过度，已经损坏。");
                backpack.removeTool(index);
            }
        }else{
            System.out.println("没有可用的铜镐！");
        }
    }

    @Override
    public void useTrolleys(String size){
        System.out.println("欢迎使用矿区小车");
        if(size.equals("大车")){
            Trolley trolley = useBigTrolley();
            String name = trolley.getSize();
            System.out.println("您正在使用铜用车" + name);
        }
        if(size.equals("小车")){
            Trolley trolley = useSmallTrolley();
            String name = trolley.getSize();
            System.out.println("您正在使用铜用车" + name);
        }
    }

    public void generate(){
        if(tool != null) {
            int addCopper  =3;
            Iterator iter = mineralList.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Object key = entry.getKey();
                if (key.equals("铜矿")) {
                    System.out.println("生成矿石中.....");
                    backpack.addMineral("铜矿", addCopper);
                }
            }
            System.out.println("成功生成" + addCopper + "单位铜矿石！");
        }
    }

    /**
     * 策略模式方法实现
     */
    @Override
    public void mineKind(){
        boolean isIron = chooseMineral("铜矿区");
        tool = findTool(tools.getMiningToolsList());
        if (tool == null) {
            System.out.println("没有可用的工具，自动离开。");
            return;
        }
        System.out.println("当前工具耐久度为：" + tool.getDurability());
        if(tool.getDurability() > 0 && isIron) {
            System.out.println("使用工具中......");
            System.out.println("工具使用完毕！");
            useDurability();
            useTrolleys("小车");
            generate();
        }
    }

    /**
     * 责任链模式方法实现
     */
    public boolean chooseMineral(String mineral){
        if(mineral.equals("铜矿区")){
            System.out.println("欢迎进入铜矿区!");
            return true;
        }
        else{
            if(getNext() != null){
                System.out.println("这里是铜矿区，传送你到指定矿区");
                getNext().chooseMineral(mineral);
                return true;
            }
            else{
                System.out.println("该矿区不存在这类矿物，请选择" +
                        "'铁矿区', '铜矿区', '铝矿区'其中的一种！");
                return false;

            }
        }
    }

    /**
     * =================private methods==============================
     */
    private MiningTool findTool(ArrayList<MiningTool> toolList){
        if (toolList != null) {
            index = findUsableIndex(toolList);
            if (index >= 0)
                return toolList.get(index);
        }
        return null;
    }

    private int findUsableIndex(ArrayList<MiningTool> toolList) {
        int i;
        for (i = 0; i < toolList.size(); i++) {
            MiningTool t = toolList.get(i);
            if (t.getName().equals("铜镐")) {
                System.out.println("找到一只可用的铜镐了！");
                break;
            }
        }
        if (i == toolList.size())
            i = -1;
        return i;
    }

    private Trolley useBigTrolley(){
        Type type = new CopperType();
        Trolley trolley = new BigTrolley();
        trolley.setType(type);
        return trolley;
    }

    private Trolley useSmallTrolley(){
        Type type = new CopperType();
        Trolley trolley = new BigTrolley();
        trolley.setType(type);
        return trolley;
    }
}
