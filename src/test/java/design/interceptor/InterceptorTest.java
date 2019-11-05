package design.interceptor;
import design.home.tile.interceptor.*;

public class InterceptorTest {
    public static void main(String args[]) {
        Business proxy = (Business) JdkProxyExample.bind(new BusinessImpl(), "design.home.tile.interceptor.InterceptorImpl");
        proxy.doBusiness();
    }
}
