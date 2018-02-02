package com.tencent.mm.ay;

import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.px;
import com.tencent.mm.sdk.platformtools.bh;

@Deprecated
public final class c extends b {
    private px hIQ;
    public String username;

    public c(String str) {
        this(str, 0);
        this.username = str;
    }

    public c(String str, int i) {
        super(4);
        this.hIQ = new px();
        this.hIQ.vYI = new bdo().UA(bh.ou(str));
        this.hIQ.vYK = i;
        this.ope = this.hIQ;
    }
}
