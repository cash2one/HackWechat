package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.protocal.c.ck;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public class d$b extends e implements c {
    public ck nys = new ck();

    public final int E(byte[] bArr) {
        this.nys = (ck) new ck().aF(bArr);
        k.a(this, this.nys.wJr);
        return this.nys.wJr.vJU;
    }

    public final int getCmdId() {
        return 1000000241;
    }
}
