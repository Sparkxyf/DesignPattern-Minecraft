package design.interceptor;
import design.home.tile.interceptor.*;
import org.junit.Test;

public class InterceptorTest {

    @Test
    public void test() {
        Business proxy = (Business) JdkProxyExample.bind(new BusinessImpl(), "design.home.tile.interceptor.InterceptorImpl");
        proxy.doBusiness();
    }
}
