package design.task.business.delegate;

public class TaskServiceLookUp {

    public TaskService getTaskService(String type){
        if (type.equalsIgnoreCase("SpringFestival")){
            return  new SpringFestivalService();
        }
        else {
            return new ChristmasService();
        }
    }
}
