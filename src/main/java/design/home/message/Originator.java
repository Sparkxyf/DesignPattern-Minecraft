package design.home.message;

import lombok.Getter;
import lombok.Setter;

public class Originator {
    @Getter @Setter
    private String record;

    public Memento createMemento(){
        return new Memento(record);
    }
    public void restoreMemento(Memento memento){
        this.setRecord(memento.getRecord());
    }
}
