package com.tencent.mm.plugin.voip.model;

import java.util.concurrent.locks.ReentrantLock;

public final class f {
    private static f skw = new f();
    private ReentrantLock fcD = new ReentrantLock();
    private e skx;

    private f() {
    }

    public static e bGC() {
        if (skw.skx == null) {
            skw.fcD.lock();
            try {
                if (skw.skx == null) {
                    skw.skx = new e();
                }
                skw.fcD.unlock();
            } catch (Throwable th) {
                skw.fcD.unlock();
            }
        }
        return skw.skx;
    }
}
