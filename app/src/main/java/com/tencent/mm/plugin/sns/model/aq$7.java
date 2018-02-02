package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.sdk.platformtools.x;

class aq$7 implements Runnable {
    final /* synthetic */ aq qXH;

    aq$7(aq aqVar) {
        this.qXH = aqVar;
    }

    public final void run() {
        boolean z = true;
        if (this.qXH.qXD.isEmpty()) {
            x.i("MicroMsg.SnsVideoService", "download queue is null, do nothing");
            return;
        }
        ax axVar = (ax) this.qXH.qXD.poll();
        if (axVar == null) {
            x.w("MicroMsg.SnsVideoService", "try start download video task is null. queue size %d", new Object[]{Integer.valueOf(this.qXH.qXD.size())});
            return;
        }
        if (this.qXH.qXC == null || !axVar.hTu.equals(this.qXH.qXC.hTu)) {
            z = false;
        }
        this.qXH.a(axVar, z);
    }
}
