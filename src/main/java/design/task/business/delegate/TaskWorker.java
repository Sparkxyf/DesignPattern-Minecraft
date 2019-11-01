package design.task.business.delegate;

import design.home.decorate.MyHomeInterface;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TaskWorker {

    TaskBusinessDelegate taskBusinessDelegate;

    public void doTask(MyHomeInterface home){
        taskBusinessDelegate.doTask(home);
    }
}
