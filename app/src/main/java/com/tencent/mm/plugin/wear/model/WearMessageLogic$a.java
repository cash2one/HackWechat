package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.plugin.wear.model.e.a;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.sdk.platformtools.x;

class WearMessageLogic$a extends d {
    public int pSO;
    public int tio;
    public int tip;
    public byte[] tiq;
    final /* synthetic */ WearMessageLogic tir;

    private WearMessageLogic$a(WearMessageLogic wearMessageLogic) {
        this.tir = wearMessageLogic;
    }

    protected final void execute() {
        x.i("MicroMsg.Wear.WearMessageLogic", "handle message %s", new Object[]{toString()});
        a zE = a.bOt().thF.zE(this.tip);
        if (zE != null) {
            zE.b(this.tio, this.pSO, this.tip, this.tiq);
        }
    }

    public final String getName() {
        return "HttpMessageTask";
    }

    public final String toString() {
        return String.format("connectType=%d funId=%d sessionId=%d", new Object[]{Integer.valueOf(this.tio), Integer.valueOf(this.tip), Integer.valueOf(this.pSO)});
    }
}
