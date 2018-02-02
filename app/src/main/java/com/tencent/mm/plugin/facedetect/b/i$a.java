package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.zb;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bh;

public class i$a extends d implements b {
    public zb mfc = new zb();

    public final byte[] Hq() {
        this.vBn = ac.cdL();
        this.mfc.vMi = new bdn().bj(bh.cgp());
        this.mfc.wIV = k.a(this);
        this.vBm = this.mfc.vMi.wJD.toByteArray();
        return this.mfc.toByteArray();
    }

    public final int Hr() {
        return 733;
    }

    public final int getCmdId() {
        return 0;
    }
}
