package com.tencent.mm.ay;

import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.qa;
import com.tencent.mm.sdk.platformtools.bh;

@Deprecated
public final class d extends b {
    private qa hIR = new qa();

    public d(String str, long j) {
        super(8);
        this.hIR.vYI = new bdo().UA(bh.ou(str));
        this.hIR.vHe = j;
        this.ope = this.hIR;
    }
}
