package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.atd;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public class v$b extends e implements c {
    public atd vBP = new atd();

    public final int E(byte[] bArr) {
        this.vBP = (atd) new atd().aF(bArr);
        k.a(this, this.vBP.wJr);
        return this.vBP.wJr.vJU;
    }

    public final int getCmdId() {
        return 1000000027;
    }
}
