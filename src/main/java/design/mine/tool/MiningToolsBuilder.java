package design.mine.tool;

public interface MiningToolsBuilder {
    void buildName(String n);
    void buildDurability();
    MiningTool getResult();
}
