package design.task.business.delegate;

import design.home.decorate.MyHomeInterface;
import lombok.Setter;

public class TaskBusinessDelegate {

    private  TaskServiceLookUp  taskServiceLookUp = new TaskServiceLookUp();

    private TaskService taskService;

    @Setter
    private String type;

    public void doTask(MyHomeInterface home){
        taskService = taskServiceLookUp.getTaskService(type);
        taskService.autoProcessing(home);
    }
}
