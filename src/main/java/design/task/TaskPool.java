package design.task;

public interface TaskPool {

    MyTask getTask();

    void returnTask(MyTask myTask);
}
