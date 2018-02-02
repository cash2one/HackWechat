package com.tencent.mm.ui.base;

import java.util.ArrayList;

class h$8 implements p$c {
    final /* synthetic */ ArrayList gIq;
    final /* synthetic */ String icx;

    h$8(String str, ArrayList arrayList) {
        this.icx = str;
        this.gIq = arrayList;
    }

    public final void a(n nVar) {
        nVar.setHeaderTitle(this.icx);
        for (int i = 0; i < this.gIq.size(); i++) {
            nVar.f(i, (CharSequence) this.gIq.get(i));
        }
    }
}
