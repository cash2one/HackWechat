package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.protocal.c.bsa;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public class k$b extends e implements c {
    public bsa mfh = new bsa();

    public final int E(byte[] bArr) {
        this.mfh = (bsa) new bsa().aF(bArr);
        k.a(this, this.mfh.wJr);
        return this.mfh.wJr.vJU;
    }

    public final int getCmdId() {
        return 0;
    }
}
