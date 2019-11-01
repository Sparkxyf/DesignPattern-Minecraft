package design.task.observer;

public class DailyObserver  extends Observer{

    public DailyObserver(Daily daily){
        this.daily =daily;
        this.daily.attach(this);
    }

    @Override
    public void show() {
        System.out.println("这是你来到村庄的第"+daily.getState()+"天");
    }
}
