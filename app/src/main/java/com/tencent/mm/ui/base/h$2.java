package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.p.c;
import java.util.List;

class h$2 implements c {
    final /* synthetic */ String icx;
    final /* synthetic */ List rsK;
    final /* synthetic */ List rto;
    final /* synthetic */ String xYO;

    h$2(String str, List list, List list2, String str2) {
        this.icx = str;
        this.rto = list;
        this.rsK = list2;
        this.xYO = str2;
    }

    public final void a(n nVar) {
        if (!bh.ov(this.icx)) {
            nVar.setHeaderTitle(this.icx);
        }
        for (int i = 0; i < this.rto.size(); i++) {
            nVar.f(((Integer) this.rsK.get(i)).intValue(), (CharSequence) this.rto.get(i));
        }
        if (!bh.ov(this.xYO)) {
            nVar.f(-1, this.xYO);
        }
    }
}
