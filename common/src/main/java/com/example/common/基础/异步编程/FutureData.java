package com.example.common.基础.异步编程;

public class FutureData implements Data {

    protected RealData realdata = null;
    protected boolean isReady = false;
    public synchronized void setRealData(RealData realdata) {
        if (isReady) {
            return;
        }
        this.realdata = realdata;
        isReady = true;
        //RealData已经被注入，通知getResult()
        notifyAll();
    }
    //会等待RealData构造完成
    @Override
    public synchronized String getResult() {
        while (!isReady) {
            try {
                //一直等待，直到RealData被注入
                System.out.println("wait start " + System.currentTimeMillis());
                wait();
            } catch (InterruptedException e) {
            }
        }
        //真正需要的数据从RealData获取
        System.out.println("wait end " + System.currentTimeMillis());
        return realdata.result;
    }

}
