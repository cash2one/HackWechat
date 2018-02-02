package com.tencent.c.e.a.a;

public abstract class c implements Runnable {
    public abstract void cDA();

    public abstract void cDz();

    public void run() {
        try {
            cDz();
        } catch (Throwable th) {
            cDA();
        }
    }
}
