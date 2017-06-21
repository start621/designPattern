package com.yh.demo.dp.factory;

/**
 * Created by yh on 2017/6/19.
 */
public class Customer {

    public static void main(String args[]){
        System.out.println("我才是上帝好吧~");
        System.out.println("来个X5");
        Car x5 = OemFactory.generateBMWX5();
        x5.run();
        x5.showSpeed();

        System.out.println("再来个Q7");
        Car q7 = OemFactory.generateAudiQ7();
        q7.run();
        q7.showSpeed();
    }
}
