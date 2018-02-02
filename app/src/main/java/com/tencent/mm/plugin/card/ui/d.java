package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;

public final class d implements a {
    private c kQm;

    public final /* synthetic */ b nD(int i) {
        return this.kQm != null ? (CardInfo) this.kQm.getItem(i) : null;
    }

    public d(c cVar) {
        this.kQm = cVar;
    }

    public final void onCreate() {
        if (this.kQm != null) {
            am.auA().c(this.kQm);
        }
    }

    public final void onDestroy() {
        if (this.kQm != null) {
            am.auA().j(this.kQm);
            this.kQm.release();
            this.kQm = null;
        }
    }

    public final void Hv() {
        if (this.kQm != null) {
            this.kQm.a(null, null);
        }
    }
}
