package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd;
import com.tencent.mm.protocal.c.ara;
import com.tencent.mm.protocal.c.arb;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bfx;
import com.tencent.mm.protocal.c.bfy;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.bc;
import com.tencent.mm.z.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class c extends k implements com.tencent.mm.network.k {
    private static final List<Object> hFz = new ArrayList();
    private static final Set<Long> sju = new HashSet();
    private long fqm;
    private b gJQ;
    private e gJT;
    private final List<au> hFA = new LinkedList();

    public c(String str, String str2, int i) {
        boolean z = true;
        x.d("MicroMsg.NetSceneSendMsg", "dktext :" + bh.cgy());
        if (!bh.ov(str)) {
            au auVar = new au();
            auVar.eQ(1);
            auVar.dS(str);
            auVar.aq(ba.hR(str));
            auVar.eR(1);
            auVar.setContent(str2);
            auVar.setType(i);
            ar.Hg();
            this.fqm = com.tencent.mm.z.c.Fa().Q(auVar);
            if (this.fqm == -1) {
                z = false;
            }
            Assert.assertTrue(z);
            x.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.fqm);
        }
    }

    public c() {
        x.d("MicroMsg.NetSceneSendMsg", "dktext :" + bh.cgy());
        x.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    }

    protected final int Bh() {
        return 10;
    }

    protected final int a(q qVar) {
        return this.hFA.size() > 0 ? k.b.hmP : k.b.hmQ;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        a aVar = new a();
        aVar.hmj = new bfx();
        aVar.hmk = new bfy();
        aVar.uri = "/cgi-bin/micromsg-bin/newsendmsg";
        aVar.hmi = 522;
        aVar.hml = bd.CTRL_BYTE;
        aVar.hmm = 1000000237;
        this.gJQ = aVar.JZ();
        bfx com_tencent_mm_protocal_c_bfx = (bfx) this.gJQ.hmg.hmo;
        ar.Hg();
        List aZq = com.tencent.mm.z.c.Fa().aZq();
        if (aZq.size() == 0) {
            x.i("MicroMsg.NetSceneSendMsg", "no sending message");
            return -2;
        }
        this.hFA.clear();
        for (int i = 0; i < aZq.size(); i++) {
            au auVar = (au) aZq.get(i);
            if (auVar.field_isSend == 1) {
                ara com_tencent_mm_protocal_c_ara = new ara();
                com_tencent_mm_protocal_c_ara.vGY = new bdo().UA(auVar.field_talker);
                com_tencent_mm_protocal_c_ara.pbl = (int) (auVar.field_createTime / 1000);
                com_tencent_mm_protocal_c_ara.ktN = auVar.getType();
                com_tencent_mm_protocal_c_ara.nje = auVar.field_content;
                com_tencent_mm_protocal_c_ara.wyU = o.k(com.tencent.mm.z.q.FS(), auVar.field_createTime).hashCode();
                com_tencent_mm_protocal_c_ara.vHc = bc.HE();
                com_tencent_mm_protocal_c_bfx.ksP.add(com_tencent_mm_protocal_c_ara);
                com_tencent_mm_protocal_c_bfx.ksO = com_tencent_mm_protocal_c_bfx.ksP.size();
                this.hFA.add(auVar);
            }
        }
        int a = a(eVar, this.gJQ, this);
        if (a >= 0) {
            return a;
        }
        PW();
        return a;
    }

    public final int getType() {
        return 522;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            List list = ((bfy) this.gJQ.hmh.hmo).ksP;
            if (this.hFA.size() == list.size()) {
                int i4 = 0;
                while (i4 < list.size()) {
                    arb com_tencent_mm_protocal_c_arb = (arb) list.get(i4);
                    if (com_tencent_mm_protocal_c_arb.vJU != 0) {
                        x.e("MicroMsg.NetSceneSendMsg", "send msg failed: item ret code=" + com_tencent_mm_protocal_c_arb.vJU);
                        ic(i4);
                        this.gJT.a(4, com_tencent_mm_protocal_c_arb.vJU, str, this);
                        return;
                    }
                    long j = ((au) this.hFA.get(i4)).field_msgId;
                    x.i("MicroMsg.NetSceneSendMsg", "msg local id = " + j + ", SvrId = " + com_tencent_mm_protocal_c_arb.vHe + " sent successfully!");
                    ar.Hg();
                    au dH = com.tencent.mm.z.c.Fa().dH(j);
                    dH.ap(com_tencent_mm_protocal_c_arb.vHe);
                    dH.eQ(2);
                    ar.Hg();
                    com.tencent.mm.z.c.Fa().a(j, dH);
                    i4++;
                }
                x.i("MicroMsg.NetSceneSendMsg", "total " + i4 + " msgs sent successfully");
            }
            int a = a(this.hmA, this.gJT);
            if (a == -2) {
                this.gJT.a(0, 0, str, this);
                return;
            } else if (a < 0) {
                this.gJT.a(3, -1, str, this);
                return;
            } else {
                return;
            }
        }
        PW();
        this.gJT.a(i2, i3, str, this);
    }

    private void PW() {
        for (int i = 0; i < this.hFA.size(); i++) {
            ic(i);
        }
    }

    private void ic(int i) {
        au auVar = (au) this.hFA.get(i);
        auVar.eQ(5);
        ar.Hg();
        com.tencent.mm.z.c.Fa().a(auVar.field_msgId, auVar);
        Iterator it = hFz.iterator();
        while (it.hasNext()) {
            it.next();
            String str = auVar.field_talker;
            str = auVar.field_content;
        }
    }
}
