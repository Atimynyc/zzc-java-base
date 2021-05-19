package com.zzc.finalkey;

/**
 * 方法入参使用final关键字测试
 */
public class FinalAsMethodInputParam {

    public static void main(String[] args) {

    }

    public static void checkInt(final int i) {
        // 1. 当基础变量为final时，不能改变其值
        // i = 2;
    }

    public static void checkString(final String s) {
        // 2. 当String为final时，也不能改变其值
        // s = "123";
    }

    public static void checkArray(final String[] strings) {
        // 3. 当数组作为final入参时，不可以改变其地址，但可以改变数组下存储的值
        // strings = new String[]{};
        strings[0] = "123";
    }

    public static void checkObject(final FinalObjectTest finalObjectTest) {
        // 4. 同样的，当对象作为final入参时，不可以改变其地址，但可以改变其字段对应的值
        // finalObjectTest = new FinalObjectTest();
        finalObjectTest.setAge("123");
    }

}

class FinalObjectTest{
    private String age;

    private String name;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


