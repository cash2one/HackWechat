package com.tencent.mm.plugin.soter.b;

import com.tencent.mm.protocal.c.bpr;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public class c$b extends e implements c {
    public bpr rSe = new bpr();

    public final int E(byte[] bArr) {
        this.rSe = (bpr) new bpr().aF(bArr);
        k.a(this, this.rSe.wJr);
        return this.rSe.wJr.vJU;
    }

    public final int getCmdId() {
        return 0;
    }
}
