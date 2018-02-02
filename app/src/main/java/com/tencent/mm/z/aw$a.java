package com.tencent.mm.z;

import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.ahs;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bh;

public class aw$a extends d implements b {
    public ahs hgo = new ahs();

    public final byte[] Hq() {
        this.vBn = ac.cdL();
        this.hgo.vMi = new bdn().bj(bh.cgp());
        this.hgo.wIV = k.a(this);
        return this.hgo.toByteArray();
    }

    public final int Hr() {
        return 618;
    }

    public final int getCmdId() {
        return 0;
    }
}
