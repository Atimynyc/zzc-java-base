package com.zzc.exception;

public class FinallyTest {

    public static void main(String[] args) {
        System.out.println("result = "+testString2());
        System.out.println("result = "+testFinal1());
    }

    public static StringBuffer testString2() {
        StringBuffer sb = new StringBuffer("Hello");
        try {
            sb.append(" 111 ");
            return sb;
        }
        finally {
            // finally 可以改变具体地址里的值
            sb.append("world!");
            System.out.println("complete work!");
        }
    }

    public static int testFinal1() {
        int result=0;
        try {
            int i = 1/0;
            result =1;
            // 如果有finally，会将result缓存，之后在执行成功后，返回该result；即finally无法改变return的值
            return result;
        }
        catch(Exception e) {
            result=2;
            return result;
        }
        finally {
            // finally不会改变return 的地址
            result=4;
            System.out.println("execute finally");
            // 如果finally中有return，则不会再执行try或catch块中的return
            return 3;
        }
    }

}
