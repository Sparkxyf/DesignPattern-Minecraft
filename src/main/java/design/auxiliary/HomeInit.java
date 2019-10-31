package design.auxiliary;

import design.task.interpreter.TaskDetail;
import design.task.observer.DailyObserver;
import design.task.observer.*;
public class HomeInit {
    public static FloorTiling floorTiling =new FloorTiling();
    public static HomeDecoration homeDecoration=new HomeDecoration();
    public static MemoBoard memoBoard=new MemoBoard();
    public static Daily daily=new Daily();
    public static DailyObserver dailyObserver = new DailyObserver(daily);
    public static WeekObserver weekObserver=new WeekObserver(daily);
    public static Mission mission=new Mission();
    public static TaskDetail taskDetail=new TaskDetail();
    public static void main() {
        daily.setState(1);
        (new FloorTiling()).initialize();
        FloorTiling floorTiling =new FloorTiling();
        HomeDecoration homeDecoration=new HomeDecoration();
        HomeInit.mission.setDaily();

    }
}
