package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.storage.k;

class ag$3 implements Runnable {
    final /* synthetic */ ag qWV;
    final /* synthetic */ k qWW;

    ag$3(ag agVar, k kVar) {
        this.qWV = agVar;
        this.qWW = kVar;
    }

    public final void run() {
        this.qWV.qWU.put(this.qWW.field_userName, this.qWW);
    }
}
