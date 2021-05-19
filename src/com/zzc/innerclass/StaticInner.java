package com.zzc.innerclass;

/**
 * 静态内部类
 */
public class StaticInner {
    public static void main(String[] args) {
        StaticOuter staticOuter = new StaticOuter();
        staticOuter.show();
        StaticOuter.Inner.print2();
    }
}

class StaticOuter {
    private String outerName = "outerName";
    private static int id = 123;
    private Inner inner = new Inner();

    public static class Inner {
        public void print1() {
            // System.out.println(outerName); 无法访问外部非静态成员
            // 可以访问外部静态成员
            System.out.println(id);
        }

        public static void print2() {
            System.out.println(id);
        }
    }

    public void show() {
        inner.print1();
    }

}
