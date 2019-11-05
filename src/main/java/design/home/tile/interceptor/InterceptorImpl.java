package design.home.tile.interceptor;

import java.lang.reflect.Method;

public class InterceptorImpl implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("准备结束今天……");
        return true;
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("新的一天");
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("出错！");
    }
}