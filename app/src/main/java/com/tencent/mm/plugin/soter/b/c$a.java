package com.tencent.mm.plugin.soter.b;

import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bpq;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bh;

public class c$a extends d implements b {
    public bpq rSd = new bpq();

    public final byte[] Hq() {
        this.vBn = ac.cdL();
        this.rSd.vMi = new bdn().bj(bh.cgp());
        this.rSd.wIV = k.a(this);
        this.vBm = this.rSd.vMi.wJD.toByteArray();
        return this.rSd.toByteArray();
    }

    public final int Hr() {
        return 627;
    }

    public final int getCmdId() {
        return 0;
    }
}
