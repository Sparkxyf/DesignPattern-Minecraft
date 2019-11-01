package design.task.business.delegate;

import design.home.decorate.Christmas;
import design.home.decorate.MyHomeInterface;
import design.home.decorate.SpringFestival;

public class ChristmasService implements TaskService {
    @Override
    public void autoProcessing(MyHomeInterface home) {
        System.out.println("圣诞节的装修工已经接了任务 ");
        (new Christmas(home)).show();
    }
}
