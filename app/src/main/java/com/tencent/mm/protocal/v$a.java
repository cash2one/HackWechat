package com.tencent.mm.protocal;

import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.protocal.c.atc;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;

public class v$a extends d implements b {
    public atc vBO = new atc();

    public final byte[] Hq() {
        this.vBO.wIV = k.a(this);
        return this.vBO.toByteArray();
    }

    public final int Hr() {
        return v.CTRL_INDEX;
    }

    public final int getCmdId() {
        return 27;
    }
}
