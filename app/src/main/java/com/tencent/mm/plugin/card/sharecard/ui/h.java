package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;

public final class h implements a {
    private g kON;

    public h(g gVar) {
        this.kON = gVar;
    }

    public final void onCreate() {
        this.kON.notifyDataSetChanged();
    }

    public final void onDestroy() {
        if (this.kON != null) {
            g gVar = this.kON;
            gVar.kOB.release();
            gVar.kOB = null;
            gVar.kOM.clear();
            gVar.mContext = null;
            this.kON = null;
        }
    }

    public final void Hv() {
        if (this.kON != null) {
            this.kON.notifyDataSetChanged();
        }
    }

    public final b nD(int i) {
        if (this.kON != null) {
            return this.kON.nD(i);
        }
        return null;
    }
}
