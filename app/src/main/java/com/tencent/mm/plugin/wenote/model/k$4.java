package com.tencent.mm.plugin.wenote.model;

import android.os.Message;
import com.tencent.mm.bi.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

class k$4 extends af {
    final /* synthetic */ k tRs;

    k$4(k kVar) {
        this.tRs = kVar;
    }

    public final void handleMessage(Message message) {
        if (k.c(this.tRs).tRI.booleanValue()) {
            k.d(this.tRs).bVW();
            k.c(this.tRs).tRI = Boolean.valueOf(false);
        }
        k.c(this.tRs).tSe = (int) b.bv(k.e(this.tRs));
        sendEmptyMessageDelayed(Downloads.RECV_BUFFER_SIZE, 250);
    }
}
