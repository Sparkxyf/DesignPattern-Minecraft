package design.home.tile.interceptor;
import java.lang.reflect.Method;
//含有4个参数，除了我们的invoke方法有3个参数之外，还有一个目标对象的参数。
public interface Interceptor {
    public boolean before(Object proxy, Object target, Method method, Object[] args);
    public void after(Object proxy, Object target, Method method, Object[] args);
    public void around(Object proxy, Object target, Method method, Object[] args);
}
