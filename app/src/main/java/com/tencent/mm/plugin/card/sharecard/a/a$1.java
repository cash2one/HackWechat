package com.tencent.mm.plugin.card.sharecard.a;

import com.tencent.mm.plugin.card.sharecard.model.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class a$1 implements Runnable {
    final /* synthetic */ a kMW;

    a$1(a aVar) {
        this.kMW = aVar;
    }

    public final void run() {
        x.i("MicroMsg.ShareCardBatchGetCardMgr", "doShareCardSyncNetScene after 5s");
        ar.CG().a(new h(), 0);
    }
}
