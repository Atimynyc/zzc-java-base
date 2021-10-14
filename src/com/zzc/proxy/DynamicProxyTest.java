package com.zzc.proxy;

import java.lang.reflect.Proxy;

/**
 * @Description: JDK动态代理测试类
 * JDK的动态代理也存在不足，即被代理类必须要有实现的接口，如没有接口则无法使用JDK动态代理（从newProxyInstance方法的第二个参数可得知，
 * 必须传入被代理类的实现接口），那么需要使用CGLib动态代理。
 * @Version: 1.0
 * @Author: Zheng Zhenchao
 * @Create Date: 2021/10/15
 * @Copyright: SwiftPass Technologies Co., LTD. Rights Reserved
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        UserDao ud=new UserDao();

        JdkDynamicProxy jdkDynamicProxy = new JdkDynamicProxy(ud);

        IUserDao iud=(IUserDao) Proxy.newProxyInstance(ud.getClass().getClassLoader(), ud.getClass().getInterfaces(), jdkDynamicProxy);

        iud.save();
        System.out.println("--------------");
        iud.find();

    }

}
