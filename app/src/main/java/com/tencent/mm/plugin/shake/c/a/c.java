package com.tencent.mm.plugin.shake.c.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.c.bhn;
import com.tencent.mm.protocal.c.bho;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    e qok;

    public c(float f, float f2, int i, String str) {
        a aVar = new a();
        aVar.hmj = new bhn();
        aVar.hmk = new bho();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/shakecard";
        aVar.hmi = 1250;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bhn com_tencent_mm_protocal_c_bhn = (bhn) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bhn.fzt = f2;
        com_tencent_mm_protocal_c_bhn.fBc = f;
        com_tencent_mm_protocal_c_bhn.scene = i;
        com_tencent_mm_protocal_c_bhn.wLe = str;
    }

    public final int getType() {
        return 1250;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneShakeCard", "onGYNetEnd, getType = 1250" + " errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            bho com_tencent_mm_protocal_c_bho = (bho) this.gJQ.hmh.hmo;
            if (com_tencent_mm_protocal_c_bho != null) {
                this.qok = new e();
                this.qok.kLy = com_tencent_mm_protocal_c_bho.kLy;
                this.qok.kJN = com_tencent_mm_protocal_c_bho.kJN;
                this.qok.fGV = com_tencent_mm_protocal_c_bho.fGV;
                this.qok.title = com_tencent_mm_protocal_c_bho.title;
                this.qok.kJQ = com_tencent_mm_protocal_c_bho.kJQ;
                this.qok.kJR = com_tencent_mm_protocal_c_bho.kJR;
                this.qok.kLa = com_tencent_mm_protocal_c_bho.kLa;
                this.qok.kJP = com_tencent_mm_protocal_c_bho.kJP;
                this.qok.hbM = com_tencent_mm_protocal_c_bho.hbM;
                this.qok.qol = com_tencent_mm_protocal_c_bho.qol;
                this.qok.qoo = com_tencent_mm_protocal_c_bho.qoo;
                this.qok.qop = com_tencent_mm_protocal_c_bho.qop;
                this.qok.qoq = com_tencent_mm_protocal_c_bho.qoq;
                this.qok.qor = com_tencent_mm_protocal_c_bho.qor;
                this.qok.qos = com_tencent_mm_protocal_c_bho.qos;
                this.qok.cey = com_tencent_mm_protocal_c_bho.cey;
                this.qok.qot = com_tencent_mm_protocal_c_bho.qot;
                this.qok.qou = com_tencent_mm_protocal_c_bho.qou;
                m.brI().qon = this.qok.qos;
            } else {
                this.qok = new e();
                this.qok.kLy = 3;
                this.qok.qos = m.brI().qon;
            }
        } else {
            this.qok = new e();
            this.qok.kLy = 3;
            this.qok.qos = m.brI().qon;
        }
        this.gJT.a(i2, i3, str, this);
    }
}
