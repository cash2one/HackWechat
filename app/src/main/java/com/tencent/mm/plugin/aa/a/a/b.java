package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ae.a;
import com.tencent.mm.protocal.c.r;
import com.tencent.mm.protocal.c.s;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends a<s> {
    public b(String str, String str2, int i) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        com.tencent.mm.bq.a rVar = new r();
        rVar.vCW = str;
        rVar.vCX = str2;
        rVar.scene = i;
        aVar.hmj = rVar;
        aVar.hmk = new s();
        aVar.uri = "/cgi-bin/mmpay-bin/newaapayurge";
        aVar.hmi = 1644;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        x.i("MicroMsg.CgiAAPayUrge", "CgiAAPayUrge, billNo: %s, chatroom: %s, scene: %s", new Object[]{str, str2, Integer.valueOf(i)});
    }
}
