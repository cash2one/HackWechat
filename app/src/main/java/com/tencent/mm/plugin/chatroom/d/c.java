package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ae.a;
import com.tencent.mm.ae.b;
import com.tencent.mm.protocal.c.aaq;
import com.tencent.mm.protocal.c.aar;

public final class c extends a<aar> {
    public c(String str) {
        b.a aVar = new b.a();
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_aaq = new aaq();
        com_tencent_mm_protocal_c_aaq.vYJ = str;
        aVar.hmj = com_tencent_mm_protocal_c_aaq;
        aVar.hmk = new aar();
        aVar.uri = "/cgi-bin/micromsg-bin/getchatroominfodetail";
        aVar.hmi = 223;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }
}
