package design.template;

import design.mine.backpack.BackpackFacadeImpl;
import design.mine.mine.*;
import design.mine.tool.MiningTool;
import design.mine.tool.MiningToolsBuilderImpl;
import design.mine.tool.MiningToolsDirector;
import org.junit.Before;
import org.junit.Test;

public class TemplateTest {

    private BackpackFacadeImpl backpack = new BackpackFacadeImpl();
    private MiningToolsBuilderImpl builder = new MiningToolsBuilderImpl();
    private MiningToolsDirector director = new MiningToolsDirector(builder);
    private MiningTool iron = director.construct("铁镐");

    @Before
    public void init(){
        backpack.addTool(iron);
    }

    @Test
    public void testMineralIronTemplate(){
        UseToolsServiceMineralImpl mineralIronTm = new UseIronShovel(backpack);
        mineralIronTm.TemplateMethod();
    }

}
