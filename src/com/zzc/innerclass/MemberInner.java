package com.zzc.innerclass;

/**
 * 成员内部类
 */
public class MemberInner {
    public static void main(String[] args) {
        MemberOuter memberOuter = new MemberOuter();
        memberOuter.show();

        MemberOuter.Inner inner = memberOuter.new Inner();
        inner.show();
    }
}

class MemberOuter {
    // 内部类可以访问外部类的private成员
    private String outerName = "outerName";

    private Inner inner = new Inner();

    public class Inner {
        // 外部类无法访问内部类的private成员
        private String innerName = "innerName";
        public void show() {
            System.out.println(outerName);
        }
    }

    public void show() {
        System.out.println(inner.innerName);
        inner.show();
    }

}
