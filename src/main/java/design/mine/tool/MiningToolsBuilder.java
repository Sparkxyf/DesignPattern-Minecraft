<<<<<<< HEAD
package design.mine.tool;

public interface MiningToolsBuilder {
    MiningTool miningTool = new MiningTool();
    void buildName(String n);
    void buildDurability();
    MiningTool getResult();
}
=======
package design.mine.tool;

public interface MiningToolsBuilder {
    void buildName(String n);
    void buildDurability();
    MiningTool getResult();
}
>>>>>>> mine's-branch
