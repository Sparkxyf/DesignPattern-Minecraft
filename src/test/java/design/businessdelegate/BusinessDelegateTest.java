package design.businessdelegate;

import design.home.decorate.MyHomeInterface;
import design.home.decorate.OriginalHome;
import design.task.business.delegate.TaskBusinessDelegate;
import design.task.business.delegate.TaskWorker;
import org.junit.Test;

public class BusinessDelegateTest {
    @Test
    public void test(){
        TaskBusinessDelegate taskBusinessDelegate = new TaskBusinessDelegate();
        taskBusinessDelegate.setType("SpringFestival");


        MyHomeInterface home = new OriginalHome();
        home.show();
        TaskWorker taskWorker =new TaskWorker(taskBusinessDelegate);
        taskWorker.doTask(home);

        taskBusinessDelegate.setType("Christmas");

        taskWorker.doTask(home);

    }
}
