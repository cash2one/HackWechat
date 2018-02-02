package com.tencent.mm.modelfriend;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bgf;
import com.tencent.mm.protocal.c.bgg;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.LinkedList;
import java.util.List;

public final class z extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT = null;

    public z(String str, List<String> list) {
        a aVar = new a();
        aVar.hmj = new bgf();
        aVar.hmk = new bgg();
        aVar.uri = "/cgi-bin/micromsg-bin/sendsmstomfriend";
        aVar.hmi = 432;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bgf com_tencent_mm_protocal_c_bgf = (bgf) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bgf.vZK = str;
        com_tencent_mm_protocal_c_bgf.wvB = new LinkedList();
        com_tencent_mm_protocal_c_bgf.wvA = list.size();
        for (String str2 : list) {
            if (!bh.ov(str2)) {
                com_tencent_mm_protocal_c_bgf.wvB.add(new bdo().UA(str2));
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 432;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gJT.a(i2, i3, str, this);
    }
}
