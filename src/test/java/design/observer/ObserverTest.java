
package design.observer;

import design.mine.backpack.BackpackFacadeImpl;
import design.mine.smelter.SmelterObserverImpl;
import org.junit.Test;

import design.farm.*;

import design.task.observer.Daily;
import design.task.observer.DailyObserver;
import design.task.observer.WeekObserver;


public class ObserverTest {
    @Test
    public void test(){
        Daily daily=new Daily();

        DailyObserver dailyObserver = new DailyObserver(daily);
        WeekObserver weekObserver =new WeekObserver(daily);
        daily.setState(1);


        dailyObserver.show();
        weekObserver.show();

        daily.updateState();

        dailyObserver.show();
        weekObserver.show();

    }
    private BackpackFacadeImpl backpackFacade = new BackpackFacadeImpl();

    @Test
    public void judgeMineListTest() {
        SmelterObserverImpl smelterObserver = new SmelterObserverImpl(backpackFacade);
        smelterObserver.judgeMineList(backpackFacade.getMineralList(), "铁矿");
    }

    @Test
    public void operateTest() {
        SmelterObserverImpl smelterObserver = new SmelterObserverImpl(backpackFacade);
        smelterObserver.operate("铁矿");
    }

    @Test
    public void clockTest(){
        System.out.println("现在是第"+Clock.getInstance().getState()+"天。");
        Chicken chicken = new Chicken();
        Cow cow = new Cow();
        System.out.println("鸡的生日为"+"第"+chicken.getBirthDate()+"天。");
        System.out.println("鸡的年龄为"+chicken.getBirthDate()+"天。");
        System.out.println("牛的生日为"+"第"+cow.getBirthDate()+"天。");
        System.out.println("牛的年龄为"+cow.getBirthDate()+"天。");
        System.out.println();
        
        Clock.getInstance().updateState(1);
        System.out.println("现在是第"+Clock.getInstance().getState()+"天。");
        System.out.println("鸡的年龄为"+(Clock.getInstance().getState()-chicken.getBirthDate())+"天。");
        System.out.println("牛的年龄为"+(Clock.getInstance().getState()-cow.getBirthDate())+"天。");
        System.out.println();

        Clock.getInstance().updateState(1);
        System.out.println("现在是第"+Clock.getInstance().getState()+"天。");
        System.out.println("鸡的年龄为"+(Clock.getInstance().getState()-chicken.getBirthDate())+"天。");
        System.out.println("牛的年龄为"+(Clock.getInstance().getState()-cow.getBirthDate())+"天。");
    }
}





