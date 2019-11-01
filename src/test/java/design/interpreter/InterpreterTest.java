package design.interpreter;

import design.task.interpreter.TaskDetail;
import org.junit.Test;

public class InterpreterTest {
    @Test
    public void test(){
        TaskDetail taskDetail=new TaskDetail();
        taskDetail.free("晴朗的星期一");
        taskDetail.free("多云的星期二");

        taskDetail.free("下雨的星期一");
        taskDetail.free("多云的星期天");
    }
}
