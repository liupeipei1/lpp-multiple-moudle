package com.example.common.基础.异步编程;

public class RealData implements Data {
    protected final String result;

    public RealData(String para) {
        System.out.println("RealData start " + System.currentTimeMillis());

        StringBuffer sb = new StringBuffer();
        //假设这里很慢很慢，构造RealData不是一个容易的事
        for (int i = 0; i < 10; i++) {
            sb.append(para);
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("RealData end " + System.currentTimeMillis());
        result = sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }  //将realData给赋值

}
