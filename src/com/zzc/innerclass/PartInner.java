package com.zzc.innerclass;

/**
 * 局部内部类
 */
public class PartInner {
    public static void main(String[] args) {
        PartOuter partOuter = new PartOuter();
        partOuter.show(" hello");
    }
}

class PartOuter {
    private String outerName = "outer";

    public void show(final String str) {
        // 该局部内部类只能在方法中被使用，无法再方法外被调用
        class Inner {
            // 局部内部类的成员变量也无法直接让外部方法使用
            public String innerName = "inner";
            public void print() {
                System.out.println(outerName + str);
            }
        }
        Inner inner = new Inner();
        inner.print();
    }
}
