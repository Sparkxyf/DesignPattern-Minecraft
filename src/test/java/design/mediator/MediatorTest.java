package design.mediator;

import design.mine.backpack.BackpackMediatorImpl;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class MediatorTest {

    BackpackMediatorImpl robot=new BackpackMediatorImpl();


    @Test
    public void test() throws IOException {
        System.out.println("了解熔炉室");
        robot.displaySmelter();
        System.out.println("了解矿山");
        robot.displayMine();
    }
}