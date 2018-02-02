package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.vending.base.Vending.i;

class Vending$5 extends Handler {
    final /* synthetic */ Vending zBp;

    Vending$5(Vending vending, Looper looper) {
        this.zBp = vending;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                i iVar = (i) message.obj;
                Vending.access$900(this.zBp, iVar.zBB, iVar.zBC);
                return;
            default:
                return;
        }
    }
}
