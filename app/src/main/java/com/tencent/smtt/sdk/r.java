package com.tencent.smtt.sdk;

import android.os.HandlerThread;

final class r extends HandlerThread {
    private static r zXD;

    private r(String str) {
        super(str);
    }

    public static synchronized r cEE() {
        r rVar;
        synchronized (r.class) {
            if (zXD == null) {
                rVar = new r("TbsHandlerThread");
                zXD = rVar;
                rVar.start();
            }
            rVar = zXD;
        }
        return rVar;
    }
}
