package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.g.a.tl;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

public abstract class c extends d {
    public abstract void send();

    protected final void execute() {
        if (a.bOt().thH.bOy()) {
            b tlVar = new tl();
            tlVar.fMa.fpr = 11;
            com.tencent.mm.sdk.b.a.xef.m(tlVar);
            send();
            return;
        }
        x.i("MicroMsg.WearBaseSendTask", "can not send message to wear");
    }
}
