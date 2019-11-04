package design.mine.mine;

import design.mine.backpack.BackpackFacadeImpl;
import design.mine.tool.*;
import design.mine.trolley.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UseDiamondShovel extends UseToolsServiceGemImpl {

    private BackpackFacadeImpl backpack;
    private HashMap<String, Integer> mineralList;
    private MiningToolsCompositeImpl tools;
    private MiningTool tool;
    private int index = -1;

    public UseDiamondShovel(BackpackFacadeImpl b){
        backpack = b;
        mineralList = backpack.getMineralList();
        tools = backpack.getToolList();
    }

    /**
     * 模板模式抽象方法实现
     */

    public void useDurability(){

        tool = findTool(tools.getMiningToolsList());
        if(tool != null) {
            int durability = tool.getDurability();
            if (durability - 20 >= 0) {
                tool.setDurability(durability - 20);
                System.out.println("当前工具耐久度为：" + tool.getDurability());
            }
            if(tool.getDurability() == 0){
                System.out.println("该工具使用过度，已经损坏。");
                backpack.removeTool(index);
            }
        }else{
            System.out.println("没有可用的钻石镐！");
        }
    }

    @Override
    public void useTrolleys(String size){
        System.out.println("欢迎使用矿区小车");
        if(size.equals("大车")){
            Trolley trolley = useBigTrolley();
            String name = trolley.getSize();
            System.out.println("您正在使用钻石用车" + name);
        }
        if(size.equals("小车")){
            Trolley trolley = useSmallTrolley();
            String name = trolley.getSize();
            System.out.println("您正在使用钻石用车" + name);
        }
    }

    public void generate(){

        if(tool != null) {
            int addDiamond = 1;
            Iterator iter = mineralList.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Object key = entry.getKey();
                if (key.equals("钻石矿石")) {
                    System.out.println("生成矿石中.....");
                    backpack.addMineral("钻石矿石", addDiamond);
                }
            }
            System.out.println("成功生成" + addDiamond + "单位钻石矿石！");
        }
    }

    @Override
    public boolean chooseMineral(String mineral){
        if(mineral.equals("钻石矿区")){
            System.out.println("欢迎进入钻石矿区！");
            return true;
        }else {
            System.out.println("该矿区不存在这类矿物,该矿区只有钻石。");
            return false;
        }
    }

    /**
     * 策略模式方法实现
     */
    @Override
    public void mineKind(){
        boolean isDiamond = chooseMineral("钻石矿区");
        tool = findTool(tools.getMiningToolsList());
        if (tool == null) {
            System.out.println("没有可用的钻石镐，自动离开。");
            return;
        }

        System.out.println("当前工具耐久度为：" + tool.getDurability());
        if(tool.getDurability() > 0 && isDiamond) {
            System.out.println("使用钻石镐中......");
            System.out.println("工具使用完毕！");
            useDurability();
            useTrolleys("小车");
            generate();
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
            if (t.getName().equals("钻石镐")) {
                System.out.println("找到一只可用的钻石镐了！");
                break;
            }
        }
        if (i == toolList.size())
            i = -1;
        return i;
    }

    private Trolley useBigTrolley(){
        Type type = new DiamondType();
        Trolley trolley = new BigTrolley();
        trolley.setType(type);
        return trolley;
    }

    private Trolley useSmallTrolley(){
        Type type = new DiamondType();
        Trolley trolley = new BigTrolley();
        trolley.setType(type);
        return trolley;
    }

}
