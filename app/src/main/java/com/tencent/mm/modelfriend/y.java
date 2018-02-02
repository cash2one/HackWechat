package com.tencent.mm.modelfriend;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.g.d;
import com.tencent.mm.protocal.c.aou;
import com.tencent.mm.protocal.c.aov;
import com.tencent.mm.protocal.c.aow;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class y extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT = null;

    public y(String str, List<String[]> list) {
        int i = 0;
        a aVar = new a();
        aVar.hmj = new aov();
        aVar.hmk = new aow();
        aVar.uri = "/cgi-bin/micromsg-bin/listmfriend";
        aVar.hmi = d.CTRL_INDEX;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        aov com_tencent_mm_protocal_c_aov = (aov) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aov.vZK = str;
        com_tencent_mm_protocal_c_aov.wvC = 0;
        if (list != null) {
            i = list.size();
        }
        com_tencent_mm_protocal_c_aov.wvA = i;
        com_tencent_mm_protocal_c_aov.wvD = new LinkedList();
        com_tencent_mm_protocal_c_aov.wvB = new LinkedList();
        if (list != null) {
            for (String[] strArr : list) {
                if (!bh.ov(strArr[2])) {
                    com_tencent_mm_protocal_c_aov.wvB.add(new bdo().UA(strArr[2]));
                }
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final LinkedList<aou> Oq() {
        LinkedList linkedList = ((aow) this.gJQ.hmh.hmo).wvE;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                aou com_tencent_mm_protocal_c_aou = (aou) it.next();
                ar.Hg();
                c.FI().fB(com_tencent_mm_protocal_c_aou.ksU, com_tencent_mm_protocal_c_aou.whR);
            }
        }
        return ((aow) this.gJQ.hmh.hmo).wvE;
    }

    public final int getType() {
        return d.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        ar.Dm().a(new 1(this, (aow) this.gJQ.hmh.hmo));
        this.gJT.a(i2, i3, str, this);
    }
}
