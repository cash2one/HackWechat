package com.tencent.mm.ui.chatting;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class d$2 extends af {
    final /* synthetic */ d yqB;

    d$2(d dVar, Looper looper) {
        this.yqB = dVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        boolean z = true;
        super.handleMessage(message);
        try {
            x.i("MicroMsg.AutoPlay", "reset speaker");
            this.yqB.yqo.setScreenEnable(true);
            d dVar = this.yqB;
            if (this.yqB.yqp.kCV) {
                z = false;
            }
            dVar.kCS = z;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AutoPlay", e, "", new Object[0]);
        }
    }
}
