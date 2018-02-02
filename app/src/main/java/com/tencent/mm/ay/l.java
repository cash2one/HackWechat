package com.tencent.mm.ay;

import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.arr;
import com.tencent.mm.protocal.c.rd;
import com.tencent.mm.protocal.c.re;

@Deprecated
public final class l extends b {
    private arr hIZ;

    public l(boolean z, int i, int i2) {
        int i3 = 1;
        super(31);
        this.hIZ = new arr();
        rd rdVar = new rd();
        rdVar.vZf = z ? 1 : 0;
        if (z) {
            i3 = 0;
        }
        rdVar.vZh = i3;
        re reVar = new re();
        reVar.vZj = i;
        reVar.vZk = i2;
        rdVar.vZg = reVar;
        reVar.vZj = 0;
        reVar.vZk = 0;
        rdVar.vZi = reVar;
        this.hIZ.wzy = rdVar;
        this.ope = this.hIZ;
    }

    public l() {
        this(false, 22, 8);
    }
}
