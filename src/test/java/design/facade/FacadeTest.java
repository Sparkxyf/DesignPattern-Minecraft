<<<<<<< HEAD
package design.facade;

import design.mine.backpack.BackpackFacadeImpl;
import org.junit.Test;
import design.mine.tool.MiningTool;

import static org.junit.Assert.*;

public class FacadeTest {

    @Test
    public void addToolTest() {
        BackpackFacadeImpl backpackFacade = new BackpackFacadeImpl();
        MiningTool tool = new MiningTool();
        backpackFacade.addTool(tool);
    }

    @Test
    public void removeToolTest() {
        BackpackFacadeImpl backpackFacade = new BackpackFacadeImpl();
        int index = 0;
        backpackFacade.removeTool(index);
    }

    @Test
    public void addMineralTest() {
        BackpackFacadeImpl backpackFacade = new BackpackFacadeImpl();
        backpackFacade.addMineral("铁矿", 1);
    }

    @Test
    public void removeMineralTest() {
        BackpackFacadeImpl backpackFacade = new BackpackFacadeImpl();
        backpackFacade.removeMineral("铁矿", 1);
    }
=======
package design.facade;

import design.mine.backpack.BackpackFacadeImpl;
import org.junit.Test;
import design.mine.tool.MiningTool;

import static org.junit.Assert.*;

public class FacadeTest {

    @Test
    public void addToolTest() {
        BackpackFacadeImpl backpackFacade = new BackpackFacadeImpl();
        MiningTool tool = new MiningTool();
        backpackFacade.addTool(tool);
    }

    @Test
    public void removeToolTest() {
        BackpackFacadeImpl backpackFacade = new BackpackFacadeImpl();
        int index = 0;
        MiningTool tool = new MiningTool();
        backpackFacade.getToolList().add(tool);
        backpackFacade.removeTool(index);
    }

    @Test
    public void addMineralTest() {
        BackpackFacadeImpl backpackFacade = new BackpackFacadeImpl();
        backpackFacade.addMineral("铁矿", 1);
    }

    @Test
    public void removeMineralTest() {
        BackpackFacadeImpl backpackFacade = new BackpackFacadeImpl();
        backpackFacade.removeMineral("铁矿", 1);
    }
>>>>>>> mine's-branch
}