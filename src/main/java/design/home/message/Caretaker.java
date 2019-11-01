package design.home.message;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class Caretaker {
    private List<Memento> mementoList =new ArrayList<>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);

    }
    public int count(){
        return mementoList.size();
    }

}
