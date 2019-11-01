package design.command;

import design.mine.backpack.BackpackFacadeImpl;
import design.mine.smelter.SmelterCommandImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandTest {
    private BackpackFacadeImpl backpackFacade = new BackpackFacadeImpl();

    @Test
    public void forgeToolsTest() {
        SmelterCommandImpl smelterCommand = new SmelterCommandImpl(backpackFacade);
        smelterCommand.forgeTools("铁矿");
    }
}