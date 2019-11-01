package design.iterator;

import design.mine.backpack.BackpackFacadeImpl;
import design.mine.backpack.BackpackToolsIteratorImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class IteratorTest {
    private BackpackFacadeImpl backpackFacade = new BackpackFacadeImpl();

    @Test
    public void hasNextTest(){
        BackpackToolsIteratorImpl backpackToolsIterator = new BackpackToolsIteratorImpl(backpackFacade.getToolList());
        if (backpackToolsIterator.hasNext())
            System.out.println("此列表后面还有工具。");
        else
            System.out.println("此列表后面没有工具。");
    }

    @Test
    public void nextTest(){
        BackpackToolsIteratorImpl backpackToolsIterator = new BackpackToolsIteratorImpl(backpackFacade.getToolList());
        if (backpackToolsIterator.next() != null)
            System.out.println("下一个工具的信息正在被整合。");
        else
            System.out.println("不存在下一个工具。");
    }

    @Test
    public void aggregationTest() {
        BackpackToolsIteratorImpl backpackToolsIterator = new BackpackToolsIteratorImpl(backpackFacade.getToolList());
        backpackToolsIterator.aggregation();
    }
}