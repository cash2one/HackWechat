package com.tencent.mm.z;

import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.plugin.report.b.b;
import com.tencent.mm.plugin.report.b.c$a;
import com.tencent.mm.plugin.zero.a.e;
import com.tencent.mm.protocal.c.aay;
import com.tencent.mm.protocal.c.oa;
import com.tencent.mm.protocal.j$a;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.m;
import com.tencent.mm.protocal.p;
import com.tencent.mm.protocal.q;
import com.tencent.mm.protocal.s;
import com.tencent.mm.protocal.t$a;
import com.tencent.mm.protocal.u.a;
import com.tencent.smtt.utils.TbsLog;

class ar$2 implements e {
    final /* synthetic */ ar hgf;

    ar$2(ar arVar) {
        this.hgf = arVar;
    }

    public final byte[] a(d dVar, int i) {
        switch (i) {
            case 107:
                return ((a) dVar).vBN.vMi.wJD.toByteArray();
            case c.CTRL_INDEX /*145*/:
                return ((m.a) dVar).vBu.vMi.wJD.toByteArray();
            case 429:
                return ((t$a) dVar).vBL.vMi.wJD.toByteArray();
            case 481:
                return ((p.a) dVar).vBC.vMi.wJD.toByteArray();
            case 499:
                return ((c$a) dVar).pPT.vMi.wJD.toByteArray();
            case 572:
                return ((s.a) dVar).vBK.vMi.wJD.toByteArray();
            case 616:
                return ((av$a) dVar).hgm.vMi.wJD.toByteArray();
            case 617:
                return ((ax.a) dVar).hgq.vMi.wJD.toByteArray();
            case 618:
                return ((aw.a) dVar).hgo.vMi.wJD.toByteArray();
            case 694:
                return ((b.a) dVar).pPT.vMi.wJD.toByteArray();
            case 722:
                return ((q.a) dVar).vBE.wbe.vMi.wJD.toByteArray();
            case 987:
            case TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR /*997*/:
                return ((oa) ((com.tencent.mm.ae.b.b) dVar).hmo).vWP.toByteArray();
            case 989:
                return ((aay) ((com.tencent.mm.ae.b.b) dVar).hmo).vWP.toByteArray();
            case 1000:
                return ((j$a) dVar).vBd;
            default:
                return null;
        }
    }
}
