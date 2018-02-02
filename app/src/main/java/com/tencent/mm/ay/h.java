package com.tencent.mm.ay;

import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.all;
import com.tencent.mm.sdk.platformtools.bh;

@Deprecated
public final class h extends b {
    private all hIV = new all();

    public h(String str, int i) {
        super(22);
        this.hIV.ksU = bh.ou(str);
        this.hIV.wsC = i;
        this.ope = this.hIV;
    }
}
