package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.brz;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bh;

public class k$a extends d implements b {
    public brz mfg = new brz();

    public final byte[] Hq() {
        this.vBn = ac.cdL();
        this.mfg.vMi = new bdn().bj(bh.cgp());
        this.mfg.wIV = k.a(this);
        this.vBm = this.mfg.vMi.wJD.toByteArray();
        return this.mfg.toByteArray();
    }

    public final int Hr() {
        return 930;
    }

    public final int getCmdId() {
        return 0;
    }
}
