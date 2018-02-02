package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class Vending$6 extends Handler {
    final /* synthetic */ Vending zBp;

    Vending$6(Vending vending, Looper looper) {
        this.zBp = vending;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                Vending.access$1000(this.zBp);
                return;
            case 2:
                this.zBp.destroyAsynchronous();
                return;
            default:
                return;
        }
    }
}
