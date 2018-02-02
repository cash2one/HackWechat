package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.afi;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bh;

public class s$a extends d implements b {
    public afi vBK = new afi();

    public final byte[] Hq() {
        this.vBn = ac.cdN();
        this.vBK.vMi = new bdn().bj(bh.cgp());
        this.vBK.wIV = k.a(this);
        return this.vBK.toByteArray();
    }

    public final int Hr() {
        return 572;
    }
}
