package com.example.common.基础.异步编程;

public class DOSomthing {

    public Data aa() {
        FutureData ff = new FutureData();
        new Thread(() -> {
            // 我先点一个外卖先,大概需要10S
            try {
                Thread.sleep(10000);

                RealData rr = new RealData("测试");
                ff.setRealData(rr);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        });
        return ff;
    }
}
