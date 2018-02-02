package com.tencent.mm.plugin.api.recordView;

import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;

class f$4 implements Runnable {
    final /* synthetic */ f ipN;
    final /* synthetic */ e ipP;
    final /* synthetic */ boolean ipQ;

    f$4(f fVar, e eVar, boolean z) {
        this.ipN = fVar;
        this.ipP = eVar;
        this.ipQ = z;
    }

    public final void run() {
        this.ipN.b(this.ipP, this.ipQ);
    }
}
