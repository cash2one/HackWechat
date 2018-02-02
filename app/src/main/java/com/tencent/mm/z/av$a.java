package com.tencent.mm.z;

import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.aho;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bh;

public class av$a extends d implements b {
    public aho hgm = new aho();

    public final byte[] Hq() {
        this.vBn = ac.cdL();
        this.hgm.vMi = new bdn().bj(bh.cgp());
        this.hgm.wIV = k.a(this);
        return this.hgm.toByteArray();
    }

    public final int Hr() {
        return 616;
    }

    public final int getCmdId() {
        return 0;
    }
}
