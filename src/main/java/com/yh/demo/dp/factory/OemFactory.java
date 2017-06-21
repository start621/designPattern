package com.yh.demo.dp.factory;

/**
 * Created by yh on 2017/6/19.
 */
public class OemFactory {

    public static AudiQ7 generateAudiQ7() {
        return new AudiQ7();
    }

    public static BMWX5 generateBMWX5() {
        return new BMWX5();
    }
}
