package design.task;

import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.List;

public class MyTaskPoolImpl  implements TaskPool{

    private List<MyTask> myTaskList;

   public MyTaskPoolImpl(){
        myTaskList =new ArrayList<>();
        myTaskList.add(new MyTask());
    }
    @Override
    public MyTask getTask() {
        return myTaskList.get(0);
    }

    @Override
    public void returnTask(MyTask myTask) {
        myTaskList.add(myTask);
    }
}
