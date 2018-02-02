package com.tencent.mm.modelcdntran;

import android.os.Looper;
import android.os.Message;
import com.tencent.mars.BaseEvent;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;

class c$1 extends af {
    final /* synthetic */ c hsz;

    c$1(c cVar, Looper looper) {
        this.hsz = cVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (an.isConnected(ac.getContext())) {
            x.i("MicroMsg.CdnTransportService", "cdntra mm on network change to get dns.");
            g.pQN.a(546, 5, 1, true);
            BaseEvent.onNetworkChange();
        }
    }
}
