package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ato;
import com.tencent.mm.protocal.c.atp;
import java.util.LinkedList;

public final class s extends k implements com.tencent.mm.network.k {
    public final b gJQ;
    private e gOB;
    public Object tag;

    public s(String str, int i, LinkedList<String> linkedList) {
        a aVar = new a();
        aVar.hmj = new ato();
        aVar.hmk = new atp();
        aVar.uri = "/cgi-bin/mmbiz-bin/oauth_authorize_confirm";
        aVar.hmi = 1373;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ato com_tencent_mm_protocal_c_ato = (ato) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_ato.wBF = str;
        com_tencent_mm_protocal_c_ato.wBG = i;
        com_tencent_mm_protocal_c_ato.wBH = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gOB.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1373;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gOB = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
