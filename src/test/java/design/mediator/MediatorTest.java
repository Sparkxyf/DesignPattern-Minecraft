package design.mediator;

import design.mine.backpack.BackpackMediatorImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class MediatorTest {

    @Test
    public void welcomeTest() {
        BackpackMediatorImpl mediator = new BackpackMediatorImpl();
        System.out.println("test message:");
        mediator.welcome();
    }

    @Test
    public void navigationTest() {
        BackpackMediatorImpl mediator = new BackpackMediatorImpl();
        System.out.println("test message:");
        mediator.navigation();
    }
}