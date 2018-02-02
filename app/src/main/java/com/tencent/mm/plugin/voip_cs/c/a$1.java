package com.tencent.mm.plugin.voip_cs.c;

import com.tencent.mm.sdk.platformtools.ak.a;

class a$1 implements a {
    final /* synthetic */ a sxV;

    a$1(a aVar) {
        this.sxV = aVar;
    }

    public final boolean uF() {
        int i = this.sxV.sqo[this.sxV.sqq % this.sxV.sqo.length];
        if (this.sxV.kO != null) {
            if (-1 == i) {
                this.sxV.kO.setText(null);
            } else {
                this.sxV.kO.setText(i);
            }
        }
        a aVar = this.sxV;
        aVar.sqq++;
        return true;
    }
}
