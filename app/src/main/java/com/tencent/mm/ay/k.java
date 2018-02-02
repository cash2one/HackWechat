package com.tencent.mm.ay;

import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.arn;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.bh;

@Deprecated
public final class k extends b {
    private arn hIY = new arn();

    public k(String str, int i) {
        super(20);
        this.hIY.vGG = new bdo().UA(bh.ou(str));
        this.hIY.ktm = i;
        this.ope = this.hIY;
    }
}
