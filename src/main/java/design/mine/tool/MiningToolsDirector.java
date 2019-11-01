package design.mine.tool;

public class MiningToolsDirector {
    private MiningToolsBuilder toolBuilder;

    public MiningToolsDirector(MiningToolsBuilder builder){
        toolBuilder = builder;
    }

    public MiningTool construct(String name){
        toolBuilder.buildName(name);
        toolBuilder.buildDurability();
        return toolBuilder.getResult();
    }
}
