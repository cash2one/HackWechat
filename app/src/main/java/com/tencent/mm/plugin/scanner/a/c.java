package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.hs;
import com.tencent.mm.protocal.c.ht;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class c extends k implements com.tencent.mm.network.k {
    public b gJQ;
    private e gJT;

    public c(String str, LinkedList<String> linkedList, int i, String str2, double d, double d2) {
        a aVar = new a();
        aVar.hmj = new hs();
        aVar.hmk = new ht();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetactioninfo";
        aVar.hmi = 1068;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        hs hsVar = (hs) this.gJQ.hmg.hmo;
        hsVar.vIR = str;
        hsVar.rYW = i;
        hsVar.vNN = str2;
        hsVar.vNM = linkedList;
        hsVar.vNP = d2;
        hsVar.vNO = d;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetActionInfo", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1068;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
