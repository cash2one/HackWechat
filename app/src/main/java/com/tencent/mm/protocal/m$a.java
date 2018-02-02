package com.tencent.mm.protocal;

import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.gx;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bh;

public class m$a extends d implements b {
    public gx vBu = new gx();

    public final byte[] Hq() {
        this.vBn = ac.cdL();
        this.vBu.vMi = new bdn().bj(bh.cgp());
        this.vBu.wIV = k.a(this);
        return this.vBu.toByteArray();
    }

    public final int Hr() {
        return c.CTRL_INDEX;
    }
}
