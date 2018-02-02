package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.bfp;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;

public class z$a extends d implements b {
    public bfp vBU = new bfp();

    public final byte[] Hq() {
        this.vBU.wIV = k.a(this);
        return this.vBU.toByteArray();
    }

    public final int getCmdId() {
        return 42;
    }

    public final int Hr() {
        return 131;
    }
}
