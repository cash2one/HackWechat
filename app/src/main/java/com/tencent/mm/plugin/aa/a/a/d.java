package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ae.a;
import com.tencent.mm.ae.b;
import com.tencent.mm.protocal.c.c;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends a<c> {
    public d(String str, String str2) {
        b.a aVar = new b.a();
        com.tencent.mm.bq.a bVar = new com.tencent.mm.protocal.c.b();
        bVar.vCW = str;
        bVar.vCX = str2;
        aVar.hmj = bVar;
        aVar.hmk = new c();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaclosenotify";
        aVar.hmi = 1672;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        x.i("MicroMsg.CgiCloseAAUrgeNotify", "CgiCloseAAUrgeNotify, billNo: %s, chatroom: %s", new Object[]{str, str2});
    }
}
