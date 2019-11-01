package design.chainofresponsibility;

import design.mine.backpack.BackpackFacadeImpl;
import design.mine.mine.*;
import org.junit.Before;
import org.junit.Test;

public class ChainOfResponsibilityTest {
    private BackpackFacadeImpl backpack = new BackpackFacadeImpl();

    private String chooseMine;
    @Before
    public void init(){
        chooseMine = "铝矿区";
    }

    @Test
    public void testMineralChain(){
        UseToolsServiceMineralImpl iron = new UseIronShovel(backpack);
        UseToolsServiceMineralImpl copper = new UseCopperShovel(backpack);
        UseToolsServiceMineralImpl aluminum = new UseAluminumShovel(backpack);
        iron.setNext(copper);
        copper.setNext(aluminum);
        iron.chooseMineral(chooseMine);
    }
}
