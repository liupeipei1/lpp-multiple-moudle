package com.example.common.基础.single;

public class RunableRun {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            SynchronizedMain synchronizedMain = new SynchronizedMain();
            synchronizedMain.run();

        }

        for (int i = 0; i < 2; i++) {
            NOSynchronized synchronizedMain1 = new NOSynchronized();
            synchronizedMain1.run();
        }

        for (int i = 0; i < 2; i++) {
            NOSynchronized synchronizedMain2 = new NOSynchronized();
            synchronizedMain2.run();
        }


        for (int i = 0; i < 2; i++) {
            Singleton5 ss = Singleton5.getInstance();
            System.out.printf("ss" + ss);
        }
    }
}
