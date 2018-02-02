package com.tencent.mm.plugin.record.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class h$1 extends af {
    final /* synthetic */ h pGc;

    h$1(h hVar, Looper looper) {
        this.pGc = hVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what == 1) {
            x.d("MicroMsg.RecordMsgBaseAdapter", "do play music");
            this.pGc.notifyDataSetChanged();
        }
    }
}
