package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bee;
import com.tencent.mm.protocal.c.bef;
import java.util.LinkedList;

public final class u extends k implements com.tencent.mm.network.k {
    public final b gJQ;
    private e gOB;

    public u(int i, String str, String str2, String str3, LinkedList<String> linkedList) {
        a aVar = new a();
        aVar.hmj = new bee();
        aVar.hmk = new bef();
        aVar.uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm ";
        aVar.hmi = 1346;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bee com_tencent_mm_protocal_c_bee = (bee) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bee.wBG = i;
        com_tencent_mm_protocal_c_bee.fFm = str;
        com_tencent_mm_protocal_c_bee.wBH = linkedList;
        com_tencent_mm_protocal_c_bee.state = str2;
        com_tencent_mm_protocal_c_bee.wJS = str3;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gOB.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1346;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gOB = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
