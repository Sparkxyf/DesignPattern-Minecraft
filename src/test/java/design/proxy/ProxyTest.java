package design.proxy;

import design.task.TaskInterface;
import design.task.TaskProxy;
import org.junit.Test;

public class ProxyTest {
    @Test
    public void test(){
        TaskProxy taskProxy =new TaskProxy();
        taskProxy.show();
    }
}
