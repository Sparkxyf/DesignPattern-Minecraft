package design.mine.tool;

public class MiningToolsBuilderImpl implements MiningToolsBuilder{
    private MiningTool miningTool = new MiningTool();

    @Override
    public void buildName(String n) {
        System.out.println("初始化工具的名字：" + n);
        miningTool.setName(n);
    }

    @Override
    public void buildDurability() {
        System.out.println("初始化工具的耐久度。");
        miningTool.setDurability(100);
    }

    @Override
    public MiningTool getResult() {
        return miningTool;
    }
}
