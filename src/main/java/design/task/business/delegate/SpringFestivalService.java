package design.task.business.delegate;

import design.home.decorate.MyHomeInterface;
import design.home.decorate.SpringFestival;

public class SpringFestivalService implements TaskService {
    @Override
    public void autoProcessing(MyHomeInterface home) {
        System.out.println("春节的装修工已经接了任务 ");
        (new SpringFestival(home)).show();
    }
}
