package com.tencent.mm.ay;

import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.sdk.platformtools.bh;

@Deprecated
public final class e extends b {
    private qg hIS = new qg();

    public e(String str, long j) {
        super(9);
        this.hIS.vYI = new bdo().UA(bh.ou(str));
        this.hIS.vYP.add(Integer.valueOf((int) j));
        this.hIS.ksO = 1;
        this.ope = this.hIS;
    }
}
