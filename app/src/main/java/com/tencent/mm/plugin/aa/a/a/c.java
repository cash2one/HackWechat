package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ae.a;
import com.tencent.mm.ae.b;
import com.tencent.mm.protocal.c.w;
import com.tencent.mm.protocal.c.x;

public final class c extends a<x> {
    public c(int i, int i2, int i3, String str, int i4, int i5, String str2) {
        b.a aVar = new b.a();
        com.tencent.mm.bq.a wVar = new w();
        wVar.asN = i;
        wVar.offset = i2;
        wVar.type = i3;
        wVar.vDK = str;
        wVar.vDL = i4;
        wVar.vDM = i5;
        wVar.vDN = str2;
        aVar.hmj = wVar;
        aVar.hmk = new x();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
        aVar.hmi = 1676;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s, bill_id: %s, trans_id: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, str2});
    }

    public c(int i, int i2, int i3) {
        b.a aVar = new b.a();
        com.tencent.mm.bq.a wVar = new w();
        wVar.asN = i;
        wVar.offset = i2;
        wVar.type = i3;
        aVar.hmj = wVar;
        aVar.hmk = new x();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
        aVar.hmi = 1676;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }
}
