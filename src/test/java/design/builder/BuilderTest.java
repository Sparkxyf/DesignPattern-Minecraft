package design.builder;

import design.mine.tool.MiningTool;
import design.mine.tool.MiningToolsBuilderImpl;
import design.mine.tool.MiningToolsDirector;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuilderTest {

    private String toolName;

    @Before
    public void init(){
        toolName = "铁镐";
    }

    @Test
    public void buildTest() {
        MiningToolsBuilderImpl miningToolsBuilder = new MiningToolsBuilderImpl();
        MiningToolsDirector miningToolsDirector = new MiningToolsDirector(miningToolsBuilder);
        MiningTool miningTool = miningToolsDirector.construct(toolName);
        miningTool.show();
    }

}