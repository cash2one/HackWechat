package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;

public final class b {
    private static b zCZ = new b();
    private Handler mHandler;
    public HandlerThread zCY = new HandlerThread("Vending-LogicThread");

    private b() {
        this.zCY.start();
        this.mHandler = new Handler(this.zCY.getLooper());
    }

    public static b cAb() {
        return zCZ;
    }
}
