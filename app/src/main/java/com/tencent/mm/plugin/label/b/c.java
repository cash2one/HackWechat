package com.tencent.mm.plugin.label.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.abc;
import com.tencent.mm.protocal.c.abd;
import com.tencent.mm.protocal.c.anu;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.z;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public c() {
        a aVar = new a();
        aVar.hmj = new abc();
        aVar.hmk = new abd();
        aVar.uri = "/cgi-bin/micromsg-bin/getcontactlabellist";
        aVar.hmi = 639;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        int i4 = 0;
        x.d("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            ar.Hg();
            com.tencent.mm.z.c.CU().set(209408, Long.valueOf(System.currentTimeMillis()));
            abd com_tencent_mm_protocal_c_abd = (abd) this.gJQ.hmh.hmo;
            if (!(com_tencent_mm_protocal_c_abd == null || com_tencent_mm_protocal_c_abd.vGK == null)) {
                LinkedList linkedList = com_tencent_mm_protocal_c_abd.vGK;
                List arrayList = new ArrayList();
                int size = linkedList.size();
                while (i4 < size) {
                    anu com_tencent_mm_protocal_c_anu = (anu) linkedList.get(i4);
                    z zVar = new z();
                    zVar.field_labelID = com_tencent_mm_protocal_c_anu.wuI;
                    zVar.field_labelName = com_tencent_mm_protocal_c_anu.wuH;
                    zVar.field_labelPYFull = com.tencent.mm.platformtools.c.ol(com_tencent_mm_protocal_c_anu.wuH);
                    zVar.field_labelPYShort = com.tencent.mm.platformtools.c.om(com_tencent_mm_protocal_c_anu.wuH);
                    arrayList.add(zVar);
                    i4++;
                }
                com.tencent.mm.plugin.label.e.aUW().cF(arrayList);
                com.tencent.mm.plugin.label.e.aUW().cG(com.tencent.mm.plugin.label.e.aUW().cH(arrayList));
            }
        } else {
            x.w("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] getcontactlabellist fail.");
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 639;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
