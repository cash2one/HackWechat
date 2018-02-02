package com.tencent.smtt.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.sdk.v.b;

class v$1 extends Handler {
    final /* synthetic */ v zYe;

    v$1(v vVar, Looper looper) {
        this.zYe = vVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what == 600) {
            if (message.obj instanceof b) {
                b bVar = (b) message.obj;
                v.a(this.zYe, message.arg1, bVar);
            }
        } else if (message.what == 601) {
            v.a(this.zYe);
        }
    }
}
