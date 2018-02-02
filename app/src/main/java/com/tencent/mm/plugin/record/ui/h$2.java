package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.sdk.platformtools.x;

class h$2 implements Runnable {
    final /* synthetic */ h pGc;

    h$2(h hVar) {
        this.pGc = hVar;
    }

    public final void run() {
        x.d("MicroMsg.RecordMsgBaseAdapter", "refresh adapter");
        this.pGc.notifyDataSetChanged();
    }
}
