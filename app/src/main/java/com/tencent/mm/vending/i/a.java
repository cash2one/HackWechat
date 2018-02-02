package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;

public final class a {
    private static a zCX = new a();
    private Handler mHandler;
    public HandlerThread zCW = new HandlerThread("Vending-HeavyWorkThread", 10);

    private a() {
        this.zCW.start();
        this.mHandler = new Handler(this.zCW.getLooper());
    }

    public static a cAa() {
        return zCX;
    }
}
