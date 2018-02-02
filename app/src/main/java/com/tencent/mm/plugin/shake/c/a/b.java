package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.c.adh;
import com.tencent.mm.protocal.c.adi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class b extends k implements com.tencent.mm.network.k {
    private final com.tencent.mm.ae.b gJQ;
    private e gJT;
    public e qok;

    public b(float f, float f2) {
        a aVar = new a();
        aVar.hmj = new adh();
        aVar.hmk = new adi();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/getlbscard";
        aVar.hmi = 1251;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        adh com_tencent_mm_protocal_c_adh = (adh) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_adh.fzt = f2;
        com_tencent_mm_protocal_c_adh.fBc = f;
    }

    public final int getType() {
        return 1251;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetLbsCard", "onGYNetEnd, getType = 1251" + " errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            adi com_tencent_mm_protocal_c_adi = (adi) this.gJQ.hmh.hmo;
            if (com_tencent_mm_protocal_c_adi != null) {
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (!com_tencent_mm_protocal_c_adi.wlG) {
                    x.e("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is false, no card , don't handle");
                } else if (com_tencent_mm_protocal_c_adi.wlK <= currentTimeMillis) {
                    x.e("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + com_tencent_mm_protocal_c_adi.wlK + " is <= currentTime:" + currentTimeMillis + " , don't handle");
                } else if (TextUtils.isEmpty(com_tencent_mm_protocal_c_adi.kJN)) {
                    x.e("MicroMsg.NetSceneGetLbsCard", "getlbscard card_tp_id is empty , don't handle");
                } else {
                    x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_card is true");
                    if (com_tencent_mm_protocal_c_adi.wlH) {
                        x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is true");
                    } else {
                        x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard have_red_dot is false");
                    }
                    this.qok = new e();
                    this.qok.kLy = 1;
                    this.qok.kJN = com_tencent_mm_protocal_c_adi.kJN;
                    this.qok.fGV = com_tencent_mm_protocal_c_adi.fGV;
                    this.qok.title = com_tencent_mm_protocal_c_adi.title;
                    this.qok.kJQ = com_tencent_mm_protocal_c_adi.kJQ;
                    this.qok.kJR = com_tencent_mm_protocal_c_adi.kJR;
                    this.qok.kLa = com_tencent_mm_protocal_c_adi.kLa;
                    this.qok.kJP = com_tencent_mm_protocal_c_adi.kJP;
                    this.qok.hbM = com_tencent_mm_protocal_c_adi.hbM;
                    this.qok.qol = 0;
                    this.qok.qoo = com_tencent_mm_protocal_c_adi.qoo;
                    this.qok.qop = com_tencent_mm_protocal_c_adi.qop;
                    this.qok.qoq = com_tencent_mm_protocal_c_adi.qoq;
                    this.qok.qor = com_tencent_mm_protocal_c_adi.qor;
                    this.qok.qos = "";
                    this.qok.cey = com_tencent_mm_protocal_c_adi.cey;
                    this.qok.qot = com_tencent_mm_protocal_c_adi.qot;
                    this.qok.qou = com_tencent_mm_protocal_c_adi.qou;
                    m.brI().qon = this.qok.qos;
                    x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard entrance_endtime: " + com_tencent_mm_protocal_c_adi.wlK + " is <= currentTime:" + currentTimeMillis);
                    x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard activity_type: " + com_tencent_mm_protocal_c_adi.wlM);
                    ar.Hg();
                    c.CU().a(w.a.xmR, Integer.valueOf(currentTimeMillis));
                    ar.Hg();
                    c.CU().a(w.a.xmS, Integer.valueOf(com_tencent_mm_protocal_c_adi.wlK));
                    ar.Hg();
                    c.CU().a(w.a.xmT, com_tencent_mm_protocal_c_adi.wlN);
                    ar.Hg();
                    c.CU().a(w.a.xmW, com_tencent_mm_protocal_c_adi.wlL);
                    ar.Hg();
                    c.CU().a(w.a.xmX, Integer.valueOf(com_tencent_mm_protocal_c_adi.wlM));
                    String brZ = com.tencent.mm.plugin.shake.c.c.a.brZ();
                    x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard msg reddotid is " + com_tencent_mm_protocal_c_adi.wlI);
                    x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre reddotid is " + brZ);
                    if (TextUtils.isEmpty(com_tencent_mm_protocal_c_adi.wlI)) {
                        x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard resp.red_dot_id is empty");
                    }
                    if (TextUtils.isEmpty(brZ)) {
                        x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard pre_red_dot_id is empty, resp.red_dot_id is not empty");
                        com.tencent.mm.s.c.Bq().p(262155, true);
                        ar.Hg();
                        c.CU().a(w.a.xnb, com_tencent_mm_protocal_c_adi.wlI);
                        ar.Hg();
                        c.CU().a(w.a.xnc, com_tencent_mm_protocal_c_adi.wlJ);
                    } else if (!brZ.equals(com_tencent_mm_protocal_c_adi.wlI)) {
                        x.i("MicroMsg.NetSceneGetLbsCard", "getlbscard redDotId and msg.reddotid is not empty, but no equals");
                        com.tencent.mm.s.c.Bq().p(262155, true);
                        ar.Hg();
                        c.CU().a(w.a.xnb, com_tencent_mm_protocal_c_adi.wlI);
                        ar.Hg();
                        c.CU().a(w.a.xnc, com_tencent_mm_protocal_c_adi.wlJ);
                    } else if (brZ.equals(com_tencent_mm_protocal_c_adi.wlI)) {
                        x.i("MicroMsg.NetSceneGetLbsCard", "redDotId equals msg.reddotid");
                    }
                    g.pQN.k(11721, com_tencent_mm_protocal_c_adi.kJN);
                }
            } else {
                x.e("MicroMsg.NetSceneGetLbsCard", "getlbscard resp is null");
            }
        }
        this.gJT.a(i2, i3, str, this);
    }
}
