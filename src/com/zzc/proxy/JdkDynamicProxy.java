package com.zzc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkDynamicProxy implements InvocationHandler {

    //被代理类的实例
    private IUserDao iud=null;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO Auto-generated method stub
        Object result=null;
        System.out.println("开始JDK动态代理");
        method.invoke(iud, args);
        System.out.println("结束JDK动态代理");
        return result;
    }

    //构造方法
    public JdkDynamicProxy(IUserDao iud){
        this.iud=iud;
    }

}
