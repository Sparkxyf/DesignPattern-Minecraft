package design.task;


import design.home.decorate.MyHomeInterface;
import design.home.decorate.SpringFestival;

public class MyTask {

    //一键装饰的功能（因为装饰最简单）又是它

    public void doDecorate(MyHomeInterface home){
        (new SpringFestival(home)).show();
    }
}
