package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.vending.f.a;

public final class c {
    private Handler mVendingHandler;
    private Looper mVendingLooper;
    private Looper zBF;
    private Handler zBG;
    byte[] zBH = new byte[0];
    a zBI;

    public c(Looper looper, Looper looper2) {
        this.zBF = looper;
        this.mVendingLooper = looper2;
        this.zBG = new 1(this, this.zBF);
        this.mVendingHandler = new 2(this, this.mVendingLooper);
    }

    public final void k(int i, Object obj) {
        if (Looper.myLooper() == this.zBF) {
            if (this.zBI == null) {
                a.w("Vending.VendingSync", "This call is pointless.", new Object[0]);
                return;
            }
            this.zBI.czJ();
            synchronized (this.zBH) {
                this.mVendingHandler.sendMessageAtFrontOfQueue(this.mVendingHandler.obtainMessage(i, obj));
                try {
                    this.zBH.wait();
                } catch (InterruptedException e) {
                }
            }
            this.zBI.czK();
        } else if (Looper.myLooper() == this.mVendingLooper) {
            this.zBG.sendMessageAtFrontOfQueue(this.zBG.obtainMessage(i, obj));
        }
    }
}
