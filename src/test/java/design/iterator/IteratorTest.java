package design.iterator;

import design.mine.backpack.BackpackFacadeImpl;
import design.mine.backpack.BackpackToolsIteratorImpl;
import design.mine.tool.MiningTool;
import org.junit.Test;

import static org.junit.Assert.*;

public class IteratorTest {
    private BackpackFacadeImpl backpackFacade = new BackpackFacadeImpl();

    @Test
    public void test(){
        System.out.println("==========初始时没有工具==========");
        BackpackToolsIteratorImpl backpackToolsIterator = new BackpackToolsIteratorImpl(backpackFacade.getToolList());
        if (backpackToolsIterator.hasNext())
            System.out.println("此列表后面还有工具。");
        else
            System.out.println("此列表后面没有工具。");
        if (backpackToolsIterator.next() != null) {
            System.out.println("下一个工具的信息正在被整合。");
        }
        else
            System.out.println("不存在下一个工具。");
        System.out.println("==========添加两个工具==========");
        MiningTool tool1 = new MiningTool();
        backpackFacade.addTool(tool1);

        MiningTool tool2 = new MiningTool();
        backpackFacade.addTool(tool2);
        BackpackToolsIteratorImpl backpackToolsIterator2 = new BackpackToolsIteratorImpl(backpackFacade.getToolList());

        if (backpackToolsIterator2.hasNext())
            System.out.println("此列表后面还有工具。");
        else
            System.out.println("此列表后面没有工具。");

        if (backpackToolsIterator.next() != null) {
            System.out.println("存在下一个工具");
        }
        else
            System.out.println("不存在下一个工具。");
    }
}