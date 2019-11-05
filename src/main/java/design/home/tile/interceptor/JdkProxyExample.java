package design.home.tile.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyExample implements InvocationHandler {

    private Object target = null;
    private String interceptorClass = null;

    public JdkProxyExample(Object target, String interceptorClass) {
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    public static Object bind(Object target, String interceptorClass) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new JdkProxyExample(target, interceptorClass));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(interceptorClass == null) {
            return method.invoke(target, args);
        }
        Object returnObj = null;
        Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).newInstance();
        if(interceptor.before(proxy, target, method, args)) {
            returnObj = method.invoke(target, args);
        }else {
            interceptor.around(proxy, target, method, args);
        }
        interceptor.after(proxy, target, method, args);
        return returnObj;
    }
}
