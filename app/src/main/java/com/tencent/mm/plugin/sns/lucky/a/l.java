package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.ae.d;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bbj;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bkj;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bs.a;
import java.math.BigInteger;

public final class l implements a {
    public final void a(d.a aVar) {
        if (aVar == null || aVar.hmq == null || aVar.hmq.vGZ == null) {
            x.i("MicroMsg.SimpleExperimentLsn", "recv null msg");
            return;
        }
        String a = n.a(aVar.hmq.vGZ);
        x.d("MicroMsg.SimpleExperimentLsn", "recv addMsg " + a);
        String Q = Q(a, "<TimelineObject", "</TimelineObject>");
        if (bh.ov(Q)) {
            x.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  timelineObj tag");
            return;
        }
        String Q2 = Q(a, "<RecXml", "</RecXml>");
        if (bh.ov(Q2)) {
            x.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  RecXml tag");
            return;
        }
        a = Q(a, "<ADInfo", "</ADInfo>");
        if (bh.ov(a)) {
            x.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  ADInfo tag");
            return;
        }
        bnp mG = e.mG(Q);
        bbj com_tencent_mm_protocal_c_bbj = new bbj();
        com_tencent_mm_protocal_c_bbj.wHM = n.os(a);
        bkj com_tencent_mm_protocal_c_bkj = new bkj();
        com_tencent_mm_protocal_c_bbj.wHL = com_tencent_mm_protocal_c_bkj;
        com_tencent_mm_protocal_c_bkj.wNP = n.os(Q2);
        bjv com_tencent_mm_protocal_c_bjv = new bjv();
        com_tencent_mm_protocal_c_bjv.vPO = new BigInteger(mG.nGJ).longValue();
        com_tencent_mm_protocal_c_bjv.pbl = mG.pbl;
        com_tencent_mm_protocal_c_bjv.vIy = mG.ksU;
        com_tencent_mm_protocal_c_bjv.wMW = n.N(Q.getBytes());
        com_tencent_mm_protocal_c_bkj.wMm = com_tencent_mm_protocal_c_bjv;
        com.tencent.mm.plugin.sns.model.a.b(com_tencent_mm_protocal_c_bbj);
    }

    private static String Q(String str, String str2, String str3) {
        if (bh.ov(str) || bh.ov(str2) || bh.ov(str3)) {
            return "";
        }
        int indexOf = str.indexOf(str2);
        int indexOf2 = indexOf >= 0 ? str.indexOf(str3) : -1;
        if (indexOf < 0 || indexOf2 <= indexOf) {
            return "";
        }
        return str.substring(indexOf, indexOf2 + str3.length());
    }
}
