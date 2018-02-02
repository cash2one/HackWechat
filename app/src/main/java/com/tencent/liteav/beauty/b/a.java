package com.tencent.liteav.beauty.b;

public class a {
    private boolean a = false;

    public synchronized void a() {
        this.a = true;
        notify();
    }

    public synchronized void b() {
        while (!this.a) {
            wait();
        }
        this.a = false;
    }
}
