package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.atq;
import com.tencent.mm.protocal.c.atr;

public final class r extends k implements com.tencent.mm.network.k {
    public final b gJQ;
    private e gOB;
    public Object tag;
    public String tsi;

    public r(String str, String str2, int i) {
        a aVar = new a();
        aVar.hmj = new atq();
        aVar.hmk = new atr();
        aVar.uri = "/cgi-bin/mmbiz-bin/oauth_authorize";
        aVar.hmi = 1254;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.tsi = str;
        this.gJQ = aVar.JZ();
        atq com_tencent_mm_protocal_c_atq = (atq) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_atq.wBF = str;
        com_tencent_mm_protocal_c_atq.wBI = str2;
        com_tencent_mm_protocal_c_atq.scene = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gOB.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1254;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gOB = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
