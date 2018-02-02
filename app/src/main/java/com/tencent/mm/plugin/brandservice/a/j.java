package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.ad.h;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bfb;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.protocal.c.bfd;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class j extends k implements com.tencent.mm.network.k {
    private int fut = 0;
    private b gJQ;
    private e gJT;
    private String kEO;
    private int kEP;
    private bdn kEQ = new bdn().bj(new byte[0]);
    public LinkedList<bfd> kER;

    public j(String str) {
        this.kEO = str;
        this.kEP = 0;
    }

    public final int getType() {
        return 455;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        a aVar = new a();
        aVar.hmj = new bfb();
        aVar.hmk = new bfc();
        aVar.uri = "/cgi-bin/micromsg-bin/searchorrecommendbiz";
        aVar.hmi = 455;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bfb com_tencent_mm_protocal_c_bfb = (bfb) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bfb.wsB = n.os(this.kEO);
        com_tencent_mm_protocal_c_bfb.vDW = this.fut;
        com_tencent_mm_protocal_c_bfb.wKk = this.kEP;
        com_tencent_mm_protocal_c_bfb.vHG = this.kEQ;
        x.d("MicroMsg.BrandService.NetSceneSearchOrRecommendBiz", "doScene:" + this.kEO + "  :" + this.fut + "  entryFlag:" + this.kEP);
        return a(eVar, this.gJQ, this);
    }

    protected final int a(q qVar) {
        return k.b.hmP;
    }

    protected final int Bh() {
        return 50;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.BrandService.NetSceneSearchOrRecommendBiz", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        if (i2 == 0 && i3 == 0) {
            bfc com_tencent_mm_protocal_c_bfc = (bfc) this.gJQ.hmh.hmo;
            this.kEQ = com_tencent_mm_protocal_c_bfc.wJW;
            this.kER = com_tencent_mm_protocal_c_bfc.wKm;
            Iterator it = this.kER.iterator();
            while (it.hasNext()) {
                bfd com_tencent_mm_protocal_c_bfd = (bfd) it.next();
                h hVar = new h();
                hVar.username = n.a(com_tencent_mm_protocal_c_bfd.vYI);
                hVar.hly = com_tencent_mm_protocal_c_bfd.vUU;
                hVar.hlx = com_tencent_mm_protocal_c_bfd.vUV;
                hVar.fDt = -1;
                hVar.fWe = 3;
                hVar.bA(true);
                com.tencent.mm.ad.n.JQ().a(hVar);
            }
        } else {
            this.kER = null;
        }
        this.gJT.a(i2, i3, str, this);
    }
}
