package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.R;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.ui.l.2;
import com.tencent.mm.plugin.location.ui.l.9;
import com.tencent.mm.plugin.location.ui.l.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.q;

class h$5 implements a {
    final /* synthetic */ h nYk;

    h$5(h hVar) {
        this.nYk = hVar;
    }

    public final void go(boolean z) {
        if (l.aVv().de(this.nYk.nRR, q.FS()) || z || this.nYk.d(this.nYk.nVS)) {
            h.a(this.nYk);
            return;
        }
        com.tencent.mm.plugin.location.ui.l lVar = this.nYk.nXQ;
        if (lVar.iRs == null) {
            lVar.iRs = h.a(lVar.mContext, lVar.mResources.getString(R.l.esZ), "", false, new 9(lVar), new 2(lVar));
        }
    }

    public final void aWi() {
    }

    public final void rQ(int i) {
    }

    public final void aWj() {
    }

    public final void aWk() {
        h.a(this.nYk);
    }
}
