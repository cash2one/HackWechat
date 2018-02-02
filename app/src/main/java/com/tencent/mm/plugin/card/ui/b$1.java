package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.plugin.card.b.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements Runnable {
    final /* synthetic */ b kQh;

    b$1(b bVar) {
        this.kQh = bVar;
    }

    public final void run() {
        x.i("MicroMsg.CardAcitivityLifecycleListener", "CardAcitivityLifecycleListener on activity from background to foreground！doUpdateOfflineDynamicCard!");
        am.auQ().a(q.kXK);
    }
}
