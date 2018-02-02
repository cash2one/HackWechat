package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.agh;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bh;

public class t$a extends d implements b {
    public agh vBL = new agh();

    public final byte[] Hq() {
        this.vBn = ac.cdL();
        this.vBL.vMi = new bdn().bj(bh.cgp());
        this.vBL.wIV = k.a(this);
        return this.vBL.toByteArray();
    }

    public final int Hr() {
        return 429;
    }
}
