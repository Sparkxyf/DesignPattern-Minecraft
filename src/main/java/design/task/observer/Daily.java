package design.task.observer;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Daily {

    private List<Observer> observerList = new ArrayList<>();



    @Getter
    private int state;

    public void setState(int state) {
        this.state = state;
    }

    public void updateState() {
        this.state = ++this.state;
    }

    public void attach(Observer observer){
        observerList.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observerList) {
            observer.show();
        }
    }
}
