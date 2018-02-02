package com.tencent.mm.ui.chatting;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class d$3 extends af {
    final /* synthetic */ d yqB;

    d$3(d dVar, Looper looper) {
        this.yqB = dVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        try {
            x.i("MicroMsg.AutoPlay", "startPlayHandler start Play");
            this.yqB.crf();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AutoPlay", e, "", new Object[0]);
        }
    }
}
