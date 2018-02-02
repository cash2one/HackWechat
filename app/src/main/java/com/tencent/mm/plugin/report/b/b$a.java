package com.tencent.mm.plugin.report.b;

import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.anl;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bh;

public class b$a extends d implements b {
    public anl pPT = new anl();

    public final byte[] Hq() {
        this.vBn = ac.cdM();
        this.pPT.vMi = new bdn().bj(bh.cgp());
        this.pPT.wIV = k.a(this);
        return this.pPT.toByteArray();
    }

    public final int Hr() {
        return 694;
    }

    public final int getCmdId() {
        return 0;
    }
}
