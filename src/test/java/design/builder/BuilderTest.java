package design.builder;

import design.mine.tool.MiningToolsBuilderImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuilderTest {

    @Test
    public void buildNameTest() {
        MiningToolsBuilderImpl miningToolsBuilder = new MiningToolsBuilderImpl();
        miningToolsBuilder.buildName("铁镐");
    }

    @Test
    public void buildDurabilityaTest() {
        MiningToolsBuilderImpl miningToolsBuilder = new MiningToolsBuilderImpl();
        miningToolsBuilder.buildDurability();
    }
}