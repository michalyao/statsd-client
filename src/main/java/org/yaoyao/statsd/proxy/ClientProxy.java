package org.yaoyao.statsd.proxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.yaoyao.statsd.client.StatsdClient;

import java.lang.reflect.Method;

public class ClientProxy {

    public static StatsdClient create(Object target, Class[] classes, Object[] objects) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(StatsdClient.class);
        Callback callback = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                return method.invoke(target, objects);
            }
        };
        enhancer.setCallback(callback);
        return (StatsdClient) enhancer.create(classes, objects);
    }
}
