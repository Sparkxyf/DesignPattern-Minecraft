package design.farm;

import lombok.Getter;

import java.util.ArrayList;


public abstract class Observed<T> {

    private ArrayList<UpdateObserver> observers = new ArrayList<>();

    @Getter protected T state;

    UpdateObserver addOnUpdateObserver(UpdateObserver observer) {
        observers.add(observer);
        return observer;
    }

    public boolean removeOnUpdateObserver(UpdateObserver observer) {
        return observers.remove(observer);
    }

    public abstract <K> boolean updateState(K change);

    protected void update() {
        for(UpdateObserver observer:observers) {
            observer.onUpdate(this);
        }
    }

    public interface UpdateObserver {
        void onUpdate(Observed observed);
    }
}
