package com.tencent.mm.z;

import com.tencent.mm.protocal.c.aht;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public class aw$b extends e implements c {
    public aht hgp = new aht();

    public final int E(byte[] bArr) {
        this.hgp = (aht) new aht().aF(bArr);
        k.a(this, this.hgp.wJr);
        return this.hgp.wJr.vJU;
    }

    public final int getCmdId() {
        return 0;
    }
}
