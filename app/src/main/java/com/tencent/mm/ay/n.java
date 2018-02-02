package com.tencent.mm.ay;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.asj;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.bh;

@Deprecated
public final class n extends b {
    private asj hJb = new asj();

    public n(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, String str10) {
        super(1);
        this.hJb.vYI = new bdo().UA(bh.ou(str));
        this.hJb.wsB = new bdo().UA(bh.ou(str2));
        this.hJb.vFr = 0;
        this.hJb.wzT = new bdo().UA(bh.ou(str3));
        this.hJb.wzU = new bdo().UA(bh.ou(str4));
        this.hJb.ktm = 0;
        byte[] d = e.d(bh.ou(str5), 0, -1);
        this.hJb.wzQ = new com.tencent.mm.bq.b(d == null ? new byte[0] : d);
        this.hJb.wzP = d == null ? 0 : d.length;
        this.hJb.hvt = 0;
        this.hJb.hvx = 0;
        this.hJb.hvw = bh.ou(str6);
        this.hJb.hvv = bh.ou(str7);
        this.hJb.hvu = bh.ou(str8);
        this.hJb.vFu = i;
        this.hJb.wvh = bh.ou(str9);
        this.hJb.wzZ = 0;
        this.hJb.hvy = bh.ou(str10);
        this.hJb.wvj = 0;
        this.hJb.wvi = "";
        this.ope = this.hJb;
    }
}
