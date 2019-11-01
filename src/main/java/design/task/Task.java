package design.task;

import design.task.observer.Daily;
import design.task.observer.Observer;

//proxy
public class  Task implements TaskInterface {





    @Override
    public void show() {

        System.out.println("我要开始访问了");
    }
}
