package com.tencent.mm.kiss.a;

import android.os.Handler;
import android.os.HandlerThread;

public final class a {
    private static a gSS = new a();
    public HandlerThread gSR = new HandlerThread("InflateThread", 5);
    private Handler mHandler;

    private a() {
        this.gSR.start();
        this.mHandler = new Handler(this.gSR.getLooper());
    }

    public static a DX() {
        return gSS;
    }
}
