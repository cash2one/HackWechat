package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class c$2 extends Handler {
    final /* synthetic */ c zBJ;

    c$2(c cVar, Looper looper) {
        this.zBJ = cVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        synchronized (this.zBJ.zBH) {
            if (this.zBJ.zBI != null) {
                this.zBJ.zBI.synchronizing(message.what, message.obj);
            }
            this.zBJ.zBH.notify();
        }
    }
}
