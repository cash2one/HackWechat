package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.ae.k;
import com.tencent.mm.protocal.c.bdf;

public abstract class e extends k implements com.tencent.mm.network.k {
    protected boolean qpG = false;
    long qpH = 0;

    public abstract bdf bsf();

    public e(long j) {
        this.qpH = j;
    }

    public final boolean bse() {
        return this.qpG;
    }
}
