package design.composite;

import design.mine.tool.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompositeTest {

    @Test
    public void addTest() {
        MiningToolsCompositeImpl miningToolsComposite = new MiningToolsCompositeImpl();
        MiningTool miningTool = new MiningTool();
        miningToolsComposite.add(miningTool);
    }

    @Test
    public void removeTest() {
        MiningToolsCompositeImpl miningToolsComposite = new MiningToolsCompositeImpl();
        MiningToolsBuilder builder = new MiningToolsBuilderImpl();
        MiningToolsDirector director = new MiningToolsDirector(builder);
        MiningTool tool = director.construct("铁镐");
        miningToolsComposite.add(tool);

        int index = 0;
        miningToolsComposite.remove(index);
    }
}