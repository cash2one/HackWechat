package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class e$1 extends Handler {
    final /* synthetic */ e zMn;

    e$1(e eVar, Looper looper) {
        this.zMn = eVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        this.zMn.a((d) message.obj);
    }
}
