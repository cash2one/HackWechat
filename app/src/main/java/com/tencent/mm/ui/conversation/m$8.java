package com.tencent.mm.ui.conversation;

import com.tencent.mm.g.a.gg;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class m$8 implements Runnable {
    final /* synthetic */ m zab;

    m$8(m mVar) {
        this.zab = mVar;
    }

    public final void run() {
        b ggVar = new gg();
        ggVar.fwr.data = "MAIN_UI_EVENT_UPDATE_VIEW";
        a.xef.m(ggVar);
    }
}
