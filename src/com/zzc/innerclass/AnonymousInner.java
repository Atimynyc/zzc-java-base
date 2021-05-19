package com.zzc.innerclass;

/**
 * 匿名内部类
 */
public class AnonymousInner {
    public static void main(String[] args) {
        AnonymousOuter anonymousOuter = new AnonymousOuter();
        anonymousOuter.show(":hello");
    }
}

class AnonymousOuter {
    private String outerName = "outerName";
    public void show(final String str) {
        // 不能声明静态成员变量
        // private static String innerName = "innerName";
        new AnonymousInnerInterface() {
            public void print() {
                System.out.println(outerName + str);
            }
            public void show() {
                System.out.println(outerName + "show");
            }
        }.print();
    }
}

// 该接口用于匿名内部类的实现
interface AnonymousInnerInterface {
    void print();
    void show();
}
