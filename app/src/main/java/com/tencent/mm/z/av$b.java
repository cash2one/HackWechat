package com.tencent.mm.z;

import com.tencent.mm.protocal.c.ahp;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public class av$b extends e implements c {
    public ahp hgn = new ahp();

    public final int E(byte[] bArr) {
        this.hgn = (ahp) new ahp().aF(bArr);
        k.a(this, this.hgn.wJr);
        return this.hgn.wJr.vJU;
    }

    public final int getCmdId() {
        return 0;
    }
}
