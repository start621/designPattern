package com.yh.demo.dp.base;

/**
 * Created by yh on 2017/6/21.
 */
public class TestClass {

    static {
        System.out.println("[运行静态区块]");
    }

    public final int var1 = 3;
    protected String var2 ="var 2";
    private  String[] var3 = {"fdas", "3qwer"};

    public int method1(int a, int b) {
        return a + b;
    }

    protected int method2(int a, int b) {
        return a + b;
    }

    private int method3(int a, int b) {
        return a + b;
    }
}