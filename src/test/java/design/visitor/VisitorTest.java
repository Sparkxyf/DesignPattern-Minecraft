package design.visitor;

import design.home.room.*;
import org.junit.Test;

public class VisitorTest {
    @Test
    public void test(){
       RoomVisitor roomVisitor =new RoomVisitorImpl();
       roomVisitor.visit(new Bedroom());

       roomVisitor.visit(new LivingRoom());
    }



}
