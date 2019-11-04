package design.objectpool;

import design.home.decorate.MyHomeInterface;
import design.home.decorate.OriginalHome;
import design.task.MyTask;
import design.task.MyTaskPoolImpl;
import design.task.TaskPool;
import org.junit.Test;

public class ObjectPoolTest {
    @Test
    public void test(){
        MyHomeInterface home = new OriginalHome();
        home.show();
        TaskPool taskPool =new MyTaskPoolImpl();

        MyTask myTask = taskPool.getTask();


        myTask.doDecorate(home);
        taskPool.returnTask(myTask);
    }
}
