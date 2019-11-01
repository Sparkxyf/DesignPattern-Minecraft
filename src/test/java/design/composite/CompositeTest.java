package design.composite;

import design.mine.tool.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompositeTest {

    @Test
    public void compositeTest() {
        MiningToolsCompositeImpl miningToolsComposite = new MiningToolsCompositeImpl();
        MiningTool miningTool = new MiningTool();
        miningToolsComposite.add(miningTool);

        int index = 0;
        miningToolsComposite.remove(index);
    }

}