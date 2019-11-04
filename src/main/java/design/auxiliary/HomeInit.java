package design.auxiliary;

import design.task.interpreter.TaskDetail;
import design.task.observer.DailyObserver;
import design.task.observer.*;
import design.home.room.*;
public class HomeInit {
    public static FloorTiling floorTiling =new FloorTiling();
    public static HomeDecoration homeDecoration=new HomeDecoration();
    public static MemoBoard memoBoard=new MemoBoard();
    public static Daily daily=new Daily();
    public static DailyObserver dailyObserver = new DailyObserver(daily);
    public static WeekObserver weekObserver=new WeekObserver(daily);
    public static Mission mission=new Mission();
    public static RoomVisitor roomVisitor =new RoomVisitorImpl();
    public static TaskDetail taskDetail=new TaskDetail();
    public static BedRoom bedRoom=new BedRoom();
    public static Furnituring furnituring=new Furnituring();
    public static void main() {
        daily.setState(1);
        (new FloorTiling()).initialize();
        FloorTiling floorTiling =new FloorTiling();
        HomeDecoration homeDecoration=new HomeDecoration();
        HomeInit.mission.setDaily();
        Furnituring.itemFactory.addItem("桌子");
        Furnituring.itemFactory.addItem("椅子");
        Furnituring.itemFactory.addItem("板凳");
        Furnituring.itemFactory.addItem("书柜");

    }
}