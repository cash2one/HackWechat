package com.tencent.mm.ay;

import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.pu;
import com.tencent.mm.sdk.platformtools.bh;

@Deprecated
public final class b extends com.tencent.mm.plugin.messenger.foundation.a.a.e.b {
    private pu hIP = new pu();

    public b(String str) {
        super(7);
        this.hIP.vYI = new bdo().UA(bh.ou(str));
        this.ope = this.hIP;
    }
}
