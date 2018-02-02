package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.ad.h;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.b.af;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.protocal.c.bhq;
import com.tencent.mm.protocal.c.bhr;
import com.tencent.mm.protocal.c.pq;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.LinkedList;
import java.util.List;

public final class a extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    private String kNs;
    List<d> qnB;
    private int qnC;
    int ret;

    public a(byte[] bArr) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new bhq();
        aVar.hmk = new bhr();
        aVar.uri = "/cgi-bin/micromsg-bin/shakeget";
        this.gJQ = aVar.JZ();
        bhq com_tencent_mm_protocal_c_bhq = (bhq) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bhq.vKf = new bdn().bj(bArr);
        com_tencent_mm_protocal_c_bhq.wLi = 1;
        com_tencent_mm_protocal_c_bhq.wvs = new bdn().bj(d.oSu.bfJ());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneShakeGet", "doScene");
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 162;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneShakeGet", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        bhr com_tencent_mm_protocal_c_bhr = (bhr) this.gJQ.hmh.hmo;
        this.qnB = new LinkedList();
        this.qnC = com_tencent_mm_protocal_c_bhr.wLk;
        this.ret = com_tencent_mm_protocal_c_bhr.vJU;
        this.kNs = com_tencent_mm_protocal_c_bhr.pew;
        int i4 = com_tencent_mm_protocal_c_bhr.ksO;
        x.d("MicroMsg.NetSceneShakeGet", "size:" + i4);
        ar.Hg();
        com.tencent.mm.storage.ar EY = c.EY();
        if (i4 > 0) {
            e brC = m.brC();
            brC.bru();
            x.i("MicroMsg.NewShakeItemStorage", "delOldRecord count:" + i4);
            if (brC.gJP.fx("shakeitem1", "DELETE FROM shakeitem1 WHERE shakeItemID NOT IN ( SELECT shakeItemID FROM shakeitem1 ORDER BY shakeItemID DESC LIMIT " + (100 > i4 ? 100 - i4 : 0) + " )")) {
                x.i("MicroMsg.NewShakeItemStorage", "delOldRecord success count:" + i4);
                brC.doNotify();
            }
            for (i4--; i4 >= 0; i4--) {
                if (!com.tencent.mm.z.q.FS().equals(((bhp) com_tencent_mm_protocal_c_bhr.wLj.get(i4)).ksU)) {
                    com.tencent.mm.ag.d jK = y.Mf().jK(((bhp) com_tencent_mm_protocal_c_bhr.wLj.get(i4)).ksU);
                    jK.field_username = ((bhp) com_tencent_mm_protocal_c_bhr.wLj.get(i4)).ksU;
                    jK.field_brandList = ((bhp) com_tencent_mm_protocal_c_bhr.wLj.get(i4)).hvD;
                    pq pqVar = ((bhp) com_tencent_mm_protocal_c_bhr.wLj.get(i4)).wvm;
                    if (pqVar != null) {
                        jK.field_brandFlag = pqVar.hvH;
                        jK.field_brandInfo = pqVar.hvJ;
                        jK.field_brandIconURL = pqVar.hvK;
                        jK.field_extInfo = pqVar.hvI;
                    }
                    if (!y.Mf().e(jK)) {
                        y.Mf().d(jK);
                    }
                }
                d dVar = new d((bhp) com_tencent_mm_protocal_c_bhr.wLj.get(i4));
                h hVar = new h();
                hVar.username = dVar.field_username;
                hVar.bA(dVar.field_hasHDImg > 0);
                hVar.fWe = dVar.field_imgstatus;
                hVar.hly = ((bhp) com_tencent_mm_protocal_c_bhr.wLj.get(i4)).vUU;
                hVar.hlx = ((bhp) com_tencent_mm_protocal_c_bhr.wLj.get(i4)).vUV;
                n.JQ().a(hVar);
                hVar.fDt = -1;
                x.d("MicroMsg.NetSceneShakeGet", "dkhurl search %s b[%s] s[%s]", hVar.getUsername(), hVar.JG(), hVar.JH());
                dVar.field_reserved2 = EY.WK(dVar.field_username) ? 1 : 0;
                af WO = EY.WO(dVar.field_username);
                if (WO != null && ((int) WO.gJd) > 0) {
                    brC.Je(WO.field_username);
                    brC.Je(WO.field_encryptUsername);
                }
                brC.a(dVar, false);
                ar.Hg();
                c.FI().x(dVar.field_username, this.qnC, ((bhp) com_tencent_mm_protocal_c_bhr.wLj.get(i4)).whR);
                dVar.scene = this.qnC;
                this.qnB.add(dVar);
                x.v("MicroMsg.NetSceneShakeGet", "item info: " + dVar.field_username + " " + dVar.field_nickname);
            }
        }
        this.gJT.a(i2, i3, str, this);
    }
}
