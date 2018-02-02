package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.os.Message;
import com.tencent.mm.bi.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

class n$2 extends af {
    final /* synthetic */ n tYN;

    n$2(n nVar) {
        this.tYN = nVar;
    }

    public final void handleMessage(Message message) {
        if (n.a(this.tYN).tRQ) {
            n.b(this.tYN).removeMessages(Downloads.RECV_BUFFER_SIZE);
            return;
        }
        n.c(this.tYN).setText(" " + b.v(ac.getContext(), n.a(this.tYN).tSe).toString());
        sendEmptyMessageDelayed(Downloads.RECV_BUFFER_SIZE, 500);
    }
}
