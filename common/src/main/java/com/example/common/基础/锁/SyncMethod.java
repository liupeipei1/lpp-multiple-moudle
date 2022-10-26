package com.example.common.基础.锁;

public class SyncMethod {
    public int i;
    private static int aa;

    public synchronized void syncTask() {
        i++;
    }
}
