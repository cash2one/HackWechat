package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class Vending$f<_Index> {
    AtomicBoolean iHf = new AtomicBoolean(false);
    Handler mVendingHandler;
    HashMap<_Index, b> zBs = new HashMap();
    a<_Index> zBt = null;
    byte[] zBu = new byte[0];

    protected interface a<_Index> {
        void cancel();

        void ck(_Index _Index);
    }

    public enum b {
        NIL,
        PENDING,
        FILLED
    }

    protected Vending$f(Looper looper, a<_Index> aVar) {
        this.zBt = aVar;
        this.mVendingHandler = new 1(this, looper);
    }

    protected final void czL() {
        this.mVendingHandler.removeCallbacksAndMessages(null);
        com.tencent.mm.vending.f.a.i("Vending.Loader", "clear()", new Object[0]);
        synchronized (this.zBu) {
            this.zBs.clear();
        }
        this.zBt.cancel();
    }
}
