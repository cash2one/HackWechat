package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.vending.base.Vending.f;
import com.tencent.mm.vending.base.Vending.f.b;

class Vending$f$1 extends Handler {
    final /* synthetic */ f zBv;

    Vending$f$1(f fVar, Looper looper) {
        this.zBv = fVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (this.zBv.iHf.get()) {
            this.zBv.zBt.cancel();
            return;
        }
        Object obj = message.obj;
        this.zBv.zBt.ck(obj);
        synchronized (this.zBv.zBu) {
            this.zBv.zBs.put(obj, b.zBy);
        }
    }
}
