package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.o.b;

final class o$a extends Handler {
    final /* synthetic */ o aLH;

    o$a(o oVar, Looper looper) {
        this.aLH = oVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                o oVar = this.aLH;
                oVar.aKJ.lock();
                try {
                    if (oVar.ot()) {
                        oVar.connect();
                    }
                    oVar.aKJ.unlock();
                    return;
                } catch (Throwable th) {
                    oVar.aKJ.unlock();
                }
            case 2:
                o.a(this.aLH);
                return;
            case 3:
                ((b) message.obj).b(this.aLH);
                return;
            case 4:
                throw ((RuntimeException) message.obj);
            default:
                new StringBuilder("Unknown message id: ").append(message.what);
                return;
        }
    }
}
