package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class c$1 extends Handler {
    final /* synthetic */ c zBJ;

    c$1(c cVar, Looper looper) {
        this.zBJ = cVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        this.zBJ.k(message.what, message.obj);
    }
}
