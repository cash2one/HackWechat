package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bkp;
import com.tencent.mm.protocal.c.bkq;
import com.tencent.mm.protocal.c.bkr;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class u extends k implements com.tencent.mm.network.k {
    private String fqR;
    private int fut;
    private b gJQ;
    public e gJT;
    public int qUA;
    public LinkedList<bkp> qUz = null;

    public u(int i) {
        String str;
        this.fut = i;
        a aVar = new a();
        aVar.hmj = new bkq();
        aVar.hmk = new bkr();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstaglist";
        aVar.hmi = JsApiSetAudioState.CTRL_INDEX;
        aVar.hml = 116;
        aVar.hmm = 1000000116;
        this.gJQ = aVar.JZ();
        String str2 = ae.bvz().Lq("@__weixintsnstag").field_md5;
        if (str2 == null) {
            str = "";
        } else {
            str = str2;
        }
        this.fqR = str;
        bkq com_tencent_mm_protocal_c_bkq = (bkq) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bkq.vDW = i;
        com_tencent_mm_protocal_c_bkq.wOe = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return JsApiSetAudioState.CTRL_INDEX;
    }

    public static s a(s sVar, bkp com_tencent_mm_protocal_c_bkp) {
        sVar.field_tagId = com_tencent_mm_protocal_c_bkp.wOd;
        sVar.field_tagName = bh.az(com_tencent_mm_protocal_c_bkp.niX, "");
        sVar.field_count = com_tencent_mm_protocal_c_bkp.ksO;
        sVar.bS(com_tencent_mm_protocal_c_bkp.ksP);
        x.d("MicroMsg.NetSceneSnsTagList", "tagInfo getList: " + com_tencent_mm_protocal_c_bkp.toString());
        return sVar;
    }

    private static boolean a(List<Long> list, Long l) {
        for (Long longValue : list) {
            if (longValue.longValue() == l.longValue()) {
                return true;
            }
        }
        return false;
    }

    public final List<String> eB(long j) {
        List<String> linkedList = new LinkedList();
        if (this.qUz == null) {
            return linkedList;
        }
        Iterator it = this.qUz.iterator();
        while (it.hasNext()) {
            bkp com_tencent_mm_protocal_c_bkp = (bkp) it.next();
            if (com_tencent_mm_protocal_c_bkp.wOd == j) {
                it = com_tencent_mm_protocal_c_bkp.ksP.iterator();
                while (it.hasNext()) {
                    linkedList.add(((bdo) it.next()).wJF);
                }
                return linkedList;
            }
        }
        return linkedList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSnsTagList", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            bkr com_tencent_mm_protocal_c_bkr = (bkr) ((b) qVar).hmh.hmo;
            x.d("MicroMsg.NetSceneSnsTagList", "[onGYNetEnd]State：%s", Integer.valueOf(this.qUA));
            this.qUA = com_tencent_mm_protocal_c_bkr.qUA;
            this.qUz = com_tencent_mm_protocal_c_bkr.ksP;
            String str2 = com_tencent_mm_protocal_c_bkr.wOe;
            if (this.fqR.equals(str2)) {
                this.gJT.a(i2, i3, str, this);
                return;
            }
            List byR = ae.bvB().byR();
            if (this.fut != 3) {
                Iterator it = byR.iterator();
                while (it.hasNext()) {
                    Object obj;
                    Long l = (Long) it.next();
                    Iterator it2 = com_tencent_mm_protocal_c_bkr.ksP.iterator();
                    while (it2.hasNext()) {
                        if (l.longValue() == ((bkp) it2.next()).wOd) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        it.remove();
                        ae.bvB().eU(l.longValue());
                    }
                }
            }
            Iterator it3 = com_tencent_mm_protocal_c_bkr.ksP.iterator();
            while (it3.hasNext()) {
                bkp com_tencent_mm_protocal_c_bkp = (bkp) it3.next();
                s eT;
                if (a(byR, Long.valueOf(com_tencent_mm_protocal_c_bkp.wOd))) {
                    eT = ae.bvB().eT(com_tencent_mm_protocal_c_bkp.wOd);
                    if ((eT.field_tagName != null && !eT.field_tagName.equals(com_tencent_mm_protocal_c_bkp.niX)) || eT.field_count != com_tencent_mm_protocal_c_bkp.ksO || b(eT, com_tencent_mm_protocal_c_bkp)) {
                        a(eT, com_tencent_mm_protocal_c_bkp);
                        ae.bvB().a(eT);
                    }
                } else {
                    eT = new s();
                    a(eT, com_tencent_mm_protocal_c_bkp);
                    ae.bvB().a(eT);
                }
            }
            com.tencent.mm.plugin.sns.storage.k Lq = ae.bvz().Lq("@__weixintsnstag");
            Lq.field_md5 = str2;
            ae.bvz().a(Lq);
            this.gJT.a(i2, i3, str, this);
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }

    private static boolean b(s sVar, bkp com_tencent_mm_protocal_c_bkp) {
        String[] split = sVar.field_memberList.split(",");
        Iterator it = com_tencent_mm_protocal_c_bkp.ksP.iterator();
        while (it.hasNext()) {
            boolean z;
            bdo com_tencent_mm_protocal_c_bdo = (bdo) it.next();
            for (String equals : split) {
                if (equals.equals(com_tencent_mm_protocal_c_bdo)) {
                    z = true;
                    continue;
                    break;
                }
            }
            z = false;
            continue;
            if (!z) {
                return true;
            }
        }
        return false;
    }
}
