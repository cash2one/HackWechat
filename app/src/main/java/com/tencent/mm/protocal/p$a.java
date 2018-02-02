package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bh;

public class p$a extends d implements b {
    public ru vBC = new ru();

    public final byte[] Hq() {
        this.vBn = ac.cdN();
        this.vBC.vMi = new bdn().bj(bh.cgp());
        this.vBC.wIV = k.a(this);
        return this.vBC.toByteArray();
    }

    public final int Hr() {
        return 481;
    }
}
