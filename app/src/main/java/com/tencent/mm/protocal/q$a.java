package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.nj;
import com.tencent.mm.protocal.c.sp;
import com.tencent.mm.protocal.c.sq;
import com.tencent.mm.protocal.c.sr;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bh;

public class q$a extends d implements b {
    public final sq vBE = new sq();

    public q$a() {
        eE(0);
        this.vBE.wbf = new sp();
        this.vBE.wbf.wbd = new nj();
        this.vBE.wbe = new sr();
    }

    public final byte[] Hq() {
        this.vBn = ac.cdL();
        this.vBE.wbf.wIV = k.a(this);
        this.vBE.wbe.vMi = new bdn().bj(bh.cgp());
        this.vBm = this.vBE.wbe.vMi.wJD.toByteArray();
        this.vBl = new 1(this, this);
        return this.vBE.toByteArray();
    }

    public final int Hr() {
        return 722;
    }
}
