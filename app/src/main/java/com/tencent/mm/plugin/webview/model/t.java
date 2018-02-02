package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.beg;
import com.tencent.mm.protocal.c.beh;

public final class t extends k implements com.tencent.mm.network.k {
    public final b gJQ;
    private e gOB;

    public t(String str, String str2, String str3, String str4, String str5) {
        a aVar = new a();
        aVar.hmj = new beg();
        aVar.hmk = new beh();
        aVar.uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize";
        aVar.hmi = 1388;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        beg com_tencent_mm_protocal_c_beg = (beg) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_beg.fFm = str;
        com_tencent_mm_protocal_c_beg.scope = str2;
        com_tencent_mm_protocal_c_beg.state = str3;
        com_tencent_mm_protocal_c_beg.wJT = str4;
        com_tencent_mm_protocal_c_beg.wJU = str5;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gOB.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1388;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gOB = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
