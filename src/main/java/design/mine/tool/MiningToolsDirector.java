package design.mine.tool;

public class MiningToolsDirector {
    private MiningToolsBuilderImpl builder;

    public MiningToolsDirector(MiningToolsBuilderImpl b){
        builder = b;
    }

    public MiningTool construct(String n){
        System.out.println("确认工具为" + n + "，开始锻造。");
        builder.buildName(n);
        builder.buildDurability();
        return builder.getResult();
    }
}
