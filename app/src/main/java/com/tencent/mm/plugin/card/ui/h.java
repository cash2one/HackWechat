package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;

public final class h implements a {
    private g kTR;

    public final /* synthetic */ b nD(int i) {
        return this.kTR != null ? this.kTR.nP(i) : null;
    }

    public h(g gVar) {
        this.kTR = gVar;
    }

    public final void onCreate() {
        this.kTR.notifyDataSetChanged();
    }

    public final void onDestroy() {
        if (this.kTR != null) {
            g gVar = this.kTR;
            gVar.kOB.release();
            gVar.kOB = null;
            gVar.kOM.clear();
            gVar.mContext = null;
            gVar.kTP = null;
            this.kTR = null;
        }
    }

    public final void Hv() {
        if (this.kTR != null) {
            this.kTR.notifyDataSetChanged();
        }
    }
}
