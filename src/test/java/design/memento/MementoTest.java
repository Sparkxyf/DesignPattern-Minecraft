package design.memento;

import design.home.message.Caretaker;
import design.home.message.Originator;
import org.junit.Test;

public class MementoTest {
    @Test
    public void test(){

        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        System.out.println((originator.getRecord()==null)?"Y":"N");
        originator.setRecord("State #1");
        originator.setRecord("State #2");
        caretaker.add(originator.createMemento());
        originator.setRecord("State #3");
        caretaker.add(originator.createMemento());
        originator.setRecord("State #4");

        System.out.println("Current State: " + originator.getRecord());
        originator.restoreMemento(caretaker.get(0));
        System.out.println("First saved State: " + originator.getRecord());
        originator.restoreMemento(caretaker.get(1));
        System.out.println("Second saved State: " + originator.getRecord());
    }
}
