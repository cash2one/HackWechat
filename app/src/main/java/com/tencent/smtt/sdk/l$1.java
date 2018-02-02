package com.tencent.smtt.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class l$1 extends Handler {
    final /* synthetic */ l zXa;

    l$1(l lVar, Looper looper) {
        this.zXa = lVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what == 150) {
            l.a(this.zXa);
        }
    }
}
