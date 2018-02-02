package com.tencent.mm.ay;

import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.bag;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.bh;

@Deprecated
public final class p extends b {
    private bag hJd = new bag();

    public p(String str, String str2) {
        super(16);
        this.hJd.vYI = new bdo().UA(bh.ou(str));
        this.hJd.vGG = new bdo().UA(bh.ou(str2));
        this.ope = this.hJd;
    }
}
