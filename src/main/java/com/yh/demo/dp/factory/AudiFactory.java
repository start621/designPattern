package com.yh.demo.dp.factory;

/**
 * Created by yh on 2017/6/19.
 */
public class AudiFactory implements CarFactory {


    public Car generateCar(int type) {

        // switch (type) {
        //     case 7:
        //         System.out.println("生产一辆q7");
        // }
        return new AudiQ7();
    }
}
